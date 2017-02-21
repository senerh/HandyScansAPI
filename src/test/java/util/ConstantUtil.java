package util;

import dto.MangaDTO;
import dto.MangaLastScanDTO;
import dto.PageDTO;
import dto.ScanDTO;

public class ConstantUtil {
    public static final String MANGA_SLUG = "one-piece";
    public static final String MANGA_NAME = "One Piece";
    public static final String SCAN = "849";
    public static final String PAGE = "1";

    public static final MangaDTO MANGA_DTO = new MangaDTO(MANGA_SLUG, MANGA_NAME);
    public static final ScanDTO SCAN_DTO = new ScanDTO(SCAN);
    public static final PageDTO PAGE_DTO = new PageDTO(PAGE);
    public static final MangaLastScanDTO MANGA_LAST_SCAN_DTO = new MangaLastScanDTO(MANGA_DTO, SCAN_DTO);
}
