package dao;

import dto.ImageDTO;
import dto.MangaDTO;
import dto.PageDTO;
import dto.ScanDTO;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import util.SlugUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
            pageDTOList.add(pageDTO);
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
