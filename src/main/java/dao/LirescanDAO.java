package dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import dto.FullMangaDTO;
import dto.ImageDTO;
import dto.MangaDTO;
import dto.PageDTO;
import dto.ScanDTO;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import util.SlugUtil;

@Stateless
public class LirescanDAO implements ScanDAO {

    public static final String LIRE_SCAN_URL = "http://www.lirescan.net";

    public List<MangaDTO> getMangaDtoList() throws IOException {
        List<MangaDTO> mangaDTOList = new ArrayList<MangaDTO>();

        Document document = Jsoup.connect(LIRE_SCAN_URL).userAgent("Mozilla").get();
        Elements elements = document.select("select#mangas option");

        for (Element element : elements) {
            String scanSlug = element.attr("value");
            scanSlug = scanSlug.split("/")[1];
            String slug = SlugUtil.scanSlugToSlug(scanSlug);
            MangaDTO mangaDTO = SlugUtil.slugToMangaDTO(slug);
            mangaDTOList.add(mangaDTO);
        }

        return mangaDTOList;
    }

    public List<FullMangaDTO> getFullMangaDtoList() throws IOException {
        List<FullMangaDTO> fullMangaDTOList = new ArrayList<FullMangaDTO>();

        Document document = Jsoup.connect(LIRE_SCAN_URL + "/ace-of-diamond-lecture-en-ligne/").userAgent("Mozilla").get();
        Elements elements = document.select("div#images div");

        Elements aceOfDiamondElements = document.select("select#chapitres option[selected]");
        String lastScanString = aceOfDiamondElements.get(0).text();
        FullMangaDTO aceOfDiamond = new FullMangaDTO(
                "ace-of-diamond",
                "Ace Of Diamond",
                lastScanString,
                "http://www.lirescan.net/images/mangas/ace-of-diamond.jpg");
        fullMangaDTOList.add(aceOfDiamond);

        for (Element element : elements) {
            Element e1 = element.child(0);

            String scanSlug = e1.attr("href").split("/")[1];
            String slug = SlugUtil.scanSlugToSlug(scanSlug);
            String name = e1.child(0).attr("alt");
            String url = LIRE_SCAN_URL + e1.child(0).attr("src");

            Element e2 = element.child(1).child(0);
            String[] tString = e2.text().split(" ");
            String lastScan = tString[tString.length - 1];

            FullMangaDTO fullMangaDTO = new FullMangaDTO(slug, name, lastScan, url);
            fullMangaDTOList.add(fullMangaDTO);
        }

        return fullMangaDTOList;
    }

    public List<ScanDTO> getScanDtoList(MangaDTO mangaDTO) throws IOException {
        List<ScanDTO> scanDTOList = new ArrayList<ScanDTO>();

        Document document = Jsoup.connect(LIRE_SCAN_URL + "/" + SlugUtil.slugToScanSlug(mangaDTO.getSlug()) + "/").userAgent("Mozilla").get();
        Elements elements = document.select("select#chapitres option");

        for (Element element : elements) {
            ScanDTO scanDTO = new ScanDTO(element.text());
            scanDTOList.add(scanDTO);
        }

        return scanDTOList;
    }

    public ScanDTO getLastScanDto(MangaDTO mangaDTO) throws IOException {
        Document document = Jsoup.connect(LIRE_SCAN_URL + "/" + SlugUtil.slugToScanSlug(mangaDTO.getSlug()) + "/").userAgent("Mozilla").get();
        String string = document.select("select#chapitres option[selected]").text();
        if (string == null || string.equals("")) {
            throw new IOException("Cannot get the last scan for <~" + mangaDTO + "~>. The selected string is empty.");
        }
        return new ScanDTO(string);
    }

    public List<PageDTO> getPageDtoList(MangaDTO mangaDTO, ScanDTO scanDTO) throws IOException {
        List<PageDTO> pageDTOList = new ArrayList<PageDTO>();

        Document document = Jsoup.connect(LIRE_SCAN_URL + "/" + SlugUtil.slugToScanSlug(mangaDTO.getSlug()) + "/" + scanDTO.getNum() + "/").userAgent("Mozilla").get();
        Elements elements = document.select("nav#pagination a:not([id],[style])");

        pageDTOList.add(new PageDTO("1"));
        for (Element element : elements) {
            PageDTO pageDTO = new PageDTO(element.text());
            if (!getImageDto(mangaDTO, scanDTO, pageDTO).getUrl().contains("__Add__")) {
                pageDTOList.add(pageDTO);
            }
        }

        return pageDTOList;
    }

    public ImageDTO getImageDto(MangaDTO mangaDTO, ScanDTO scanDTO, PageDTO pageDTO) throws IOException {
        Document document = Jsoup.connect(LIRE_SCAN_URL + "/" + SlugUtil.slugToScanSlug(mangaDTO.getSlug()) + "/" + scanDTO.getNum() + "/" + pageDTO.getNum()).userAgent("Mozilla").get();
        String url = LIRE_SCAN_URL + document.select("a#imglink img").attr("src");
        ImageDTO imageDTO = new ImageDTO(url);
        return imageDTO;
    }
}
