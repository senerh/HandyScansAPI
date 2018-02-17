package dao;

import dto.MangaDTO;
import org.junit.Test;
import util.ConstantUtil;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.fail;

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
            fail("The manga list must contains '" + ConstantUtil.MANGA_DTO + "'.");
        }
    }

    @Test
    public void getPageDtoList() {
        scanDAO.getPageDtoList(ConstantUtil.MANGA_SLUG, ConstantUtil.SCAN);
    }
}
