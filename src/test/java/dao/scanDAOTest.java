package dao;

import dto.MangaDTO;
import dto.PageDTO;
import dto.ScanDTO;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

public class scanDAOTest {

    private ScanDAO scanDAO;
    private MangaDTO mangaDTO;
    private ScanDTO scanDTO;
    private PageDTO pageDTO;

    public scanDAOTest() {
        scanDAO = new LirescanDAO();
        mangaDTO = new MangaDTO("one-piece", "One Piece");
        scanDTO = new ScanDTO("849");
        pageDTO = new PageDTO("1");
    }

    @Test
    public void getMangaDtoList() {
        try {
            List<MangaDTO> mangaDTOList = scanDAO.getMangaDtoList();
            assertTrue("" + mangaDTOList.size(), true);
            assertTrue("The manga list must contains <~" + mangaDTO + "~>", mangaDTOList.contains(mangaDTO));
        } catch (IOException e) {
            fail("The website '" + LirescanDAO.LIRE_SCAN_URL + "' is probably done.");
        }
    }

    @Test
    public void getScanDtoList() {
        try {
            scanDAO.getScanDtoList(mangaDTO);
        } catch (IOException e) {
            fail("The scan for <~" + mangaDTO + "~> is unreachable.");
        }
    }

    @Test
    public void getPageDtoList() {
        try {
            scanDAO.getPageDtoList(mangaDTO, scanDTO);
        } catch (IOException e) {
            fail("The page for <~" + scanDTO + "~> in <~" + mangaDTO + "~> is unreachable.");
        }
    }

    @Test
    public void getImageDto() {
        try {
            scanDAO.getImageDto(mangaDTO, scanDTO, pageDTO);
        } catch (IOException e) {
            fail("The image for <~" + pageDTO + "~> in <~" + scanDTO + "~> in <~" + mangaDTO + "~> is unreachable.");
        }
    }
}
