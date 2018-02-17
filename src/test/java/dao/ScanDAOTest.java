package dao;

import dto.MangaDTO;
import dto.PageDTO;
import dto.ScanDTO;
import org.junit.Test;
import util.ConstantUtil;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class ScanDAOTest {

    private ScanDAO scanDAO;

    public ScanDAOTest() {
        scanDAO = new LirescanDAO();
    }

    @Test
    public void testGetMangaDTOList() {
        List<MangaDTO> mangaDTOList = scanDAO.getMangaDtoList();
        Optional<MangaDTO> mangaDTO = mangaDTOList.stream().filter(m -> ConstantUtil.MANGA_DTO.getName().equals(m.getName())).findAny();
        if (!mangaDTO.isPresent()) {
            fail("The manga list must contains '" + ConstantUtil.MANGA_DTO + "'.");
        }
    }

    @Test
    public void testGetScanDTOList() {
        List<ScanDTO> scanDTOList = scanDAO.getScanDtoList(ConstantUtil.MANGA_SLUG);
        Optional<ScanDTO> scanDTO = scanDTOList.stream().filter(s -> ConstantUtil.SCAN.equals(s.getNum())).findAny();
        if (!scanDTO.isPresent()) {
            fail(String.format(
                    "The manga '%s' list must contains the scan '%s'.",
                    ConstantUtil.MANGA_DTO,
                    ConstantUtil.SCAN
            ));
        }
    }

    @Test
    public void testGetPageDTOList() {
        List<PageDTO> pageDTOList = scanDAO.getPageDtoList(ConstantUtil.MANGA_SLUG, ConstantUtil.SCAN);
        assertThat(pageDTOList.size(), is(equalTo(18)));
    }
}
