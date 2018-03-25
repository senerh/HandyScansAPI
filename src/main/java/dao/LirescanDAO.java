package dao;

import dto.MangaDTO;
import dto.PageDTO;
import dto.ScanDTO;
import exception.ShonenTouchGenericException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import util.SlugUtil;

import javax.ejb.Stateless;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class LirescanDAO implements ScanDAO {

    private static final String LIRE_SCAN_URL = "http://www.lirescan.net";

    @Override
    public List<MangaDTO> getMangaDtoList() {
        List<MangaDTO> mangaDTOList = new ArrayList<>();

        Document document = getDocument("ace-of-diamond-lecture-en-ligne/");
        Elements elements = document.select("div#images div");

        Elements aceOfDiamondElements = document.select("select#chapitres option[selected]");
        String lastScanString = aceOfDiamondElements.get(0).text();
        MangaDTO aceOfDiamond = new MangaDTO(
                "ace-of-diamond",
                "Ace Of Diamond",
                lastScanString,
                "http://www.lirescan.net/assets/images/mangas/ace-of-diamond.jpg");
        mangaDTOList.add(aceOfDiamond);

        for (Element element : elements) {
            Element e1 = element.child(0);

            String scanSlug = e1.attr("href").split("/")[1];
            String slug = SlugUtil.scanSlugToSlug(scanSlug);
            String name = e1.child(0).attr("alt");
            String url = LIRE_SCAN_URL + e1.child(0).attr("src");
            String lastScan = getLastScanNum(slug);

            MangaDTO fullMangaDTO = new MangaDTO(slug, name, lastScan, url);
            mangaDTOList.add(fullMangaDTO);
        }

        return mangaDTOList;
    }

    @Override
    public List<ScanDTO> getScanDtoList(String mangaSlug) {
        List<ScanDTO> scanDTOList = new ArrayList<>();

        String path = String.format("%s/", SlugUtil.slugToScanSlug(mangaSlug));
        Document document = getDocument(path);
        Elements elements = document.select("select#chapitres option");

        for (Element element : elements) {
            ScanDTO scanDTO = new ScanDTO(element.text());
            scanDTOList.add(scanDTO);
        }

        return scanDTOList;
    }

    @Override
    public List<PageDTO> getPageDtoList(String mangaSlug, String scanNum) {
        List<PageDTO> pageDTOList = new ArrayList<>();

        String path = String.format("%s/%s/", SlugUtil.slugToScanSlug(mangaSlug), scanNum);
        Document document = getDocument(path);
        Elements elements = document.select("nav#pagination a:not([id],[style])");

        String pageNum = "1";
        String pageUrl = getPageUrl(mangaSlug, scanNum, pageNum);
        pageDTOList.add(new PageDTO(pageNum, pageUrl));
        for (Element element : elements) {
            pageNum = element.text();
            pageUrl = getPageUrl(mangaSlug, scanNum, pageNum);
            if (!pageUrl.contains("__")) {
                PageDTO pageDTO = new PageDTO(pageNum, pageUrl);
                pageDTOList.add(pageDTO);
            }
        }
        return pageDTOList;
    }

    private String getLastScanNum(String mangaSlug) {
        String path = String.format("%s/", SlugUtil.slugToScanSlug(mangaSlug));
        Document document = getDocument(path);
        String lastScanNum = document.select("select#chapitres option[selected]").text();
        if (lastScanNum == null || lastScanNum.equals("")) {
            throw new ShonenTouchGenericException(String.format("Cannot get the last scan for '%s'.", mangaSlug));
        }
        return lastScanNum;
    }

    private String getPageUrl(String mangaSlug, String scanNum, String pageNum) {
        String path = String.format("%s/%s/%s", SlugUtil.slugToScanSlug(mangaSlug), scanNum, pageNum);
        Document document = getDocument(path);
        return LIRE_SCAN_URL + document.select("a#imglink img").attr("src");
    }

    private Document getDocument(String path) {
        String url = LIRE_SCAN_URL + "/" + path;
        try {
            return Jsoup.connect(url).userAgent("Mozilla").get();
        } catch (IOException e) {
            throw new ShonenTouchGenericException(String.format("Error while retrieving the following url '%s'.", url), e);
        }
    }
}
