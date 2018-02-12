package dao;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Optional;

import dto.MangaDTO;
import dto.ScanDTO;
import org.junit.Test;
import util.ConstantUtil;

public class ScanDAOTest {

    private ScanDAO scanDAO;

    public ScanDAOTest() {
        scanDAO = new LirescanDAO();
    }

    @Test
    public void getMangaDtoList() {
        List<MangaDTO> mangaDTOList = scanDAO.getMangaDtoList();
        Optional<MangaDTO> mangaDTO = mangaDTOList.stream().filter(m -> ConstantUtil.MANGA_DTO.getName().equals(m.getName())).findAny();
        if (!mangaDTO.isPresent()) {
            fail("The manga list must contains <~" + ConstantUtil.MANGA_DTO + "~>.");
        }
    }

    @Test
    public void getLastScanDTO() {
        ScanDTO scanDTO = scanDAO.getLastScanDto(ConstantUtil.MANGA_SLUG);
        if (scanDTO.compareTo(ConstantUtil.SCAN_DTO) < 0) {
            fail("<~" + scanDTO + "~> should be greater than <~" + ConstantUtil.MANGA_DTO + "~>.");
        }
    }

    @Test
    public void getPageDtoList() {
        scanDAO.getPageDtoList(ConstantUtil.MANGA_SLUG, ConstantUtil.SCAN);
    }
}
