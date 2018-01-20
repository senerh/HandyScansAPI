package util;

import dto.MangaDTO;
import dto.FullMangaDTO;
import dto.PageDTO;
import dto.ScanDTO;

public class ConstantUtil {
    public static final String MANGA_SLUG = "one-piece";
    public static final String MANGA_NAME = "One Piece";
    public static final String SCAN = "849";
    public static final String PAGE_NUM = "1";
    public static final String PAGE_URL = "http://www.lirescan.net/assets/lecture-en-ligne/One-Piece/849/00.jpg";
    public static final String MANGA_URL = "http://www.lirescan.net/assets/images/mangas/one-piece.jpg";

    public static final MangaDTO MANGA_DTO = new MangaDTO(MANGA_SLUG, MANGA_NAME);
    public static final ScanDTO SCAN_DTO = new ScanDTO(SCAN);
    public static final PageDTO PAGE_DTO = new PageDTO(PAGE_NUM, PAGE_URL);
    public static final FullMangaDTO MANGA_LAST_SCAN_DTO = new FullMangaDTO(MANGA_SLUG, MANGA_NAME, SCAN, MANGA_URL);
}
