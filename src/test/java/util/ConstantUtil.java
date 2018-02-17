package util;

import dto.MangaDTO;
import dto.ScanDTO;

public class ConstantUtil {
    public static final String MANGA_SLUG = "one-piece";
    public static final String MANGA_NAME = "One Piece";
    public static final String SCAN = "849";
    public static final String MANGA_URL = "http://www.lirescan.net/assets/images/mangas/one-piece.jpg";

    public static final MangaDTO MANGA_DTO = new MangaDTO(MANGA_SLUG, MANGA_NAME, SCAN, MANGA_URL);
}
