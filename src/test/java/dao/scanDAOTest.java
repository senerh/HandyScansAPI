package dao;

import dto.MangaDTO;
import org.junit.Test;
import util.ConstantUtil;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

public class scanDAOTest {

    private ScanDAO scanDAO;

    public scanDAOTest() {
        scanDAO = new LirescanDAO();
    }

    @Test
    public void getMangaDtoList() {
        try {
            List<MangaDTO> mangaDTOList = scanDAO.getMangaDtoList();
            assertTrue("" + mangaDTOList.size(), true);
            assertTrue("The manga list must contains <~" + ConstantUtil.MANGA_DTO + "~>", mangaDTOList.contains(ConstantUtil.MANGA_DTO));
        } catch (IOException e) {
            fail("The website '" + LirescanDAO.LIRE_SCAN_URL + "' is probably down.");
        }
    }

    @Test
    public void getScanDtoList() {
        try {
            scanDAO.getScanDtoList(ConstantUtil.MANGA_DTO);
        } catch (IOException e) {
            fail("The scan for <~" + ConstantUtil.MANGA_DTO + "~> is unreachable.");
        }
    }

    @Test
    public void getPageDtoList() {
        try {
            scanDAO.getPageDtoList(ConstantUtil.MANGA_DTO, ConstantUtil.SCAN_DTO);
        } catch (IOException e) {
            fail("The page for <~" + ConstantUtil.SCAN_DTO + "~> in <~" + ConstantUtil.MANGA_DTO + "~> is unreachable.");
        }
    }

    @Test
    public void getImageDto() {
        try {
            scanDAO.getImageDto(ConstantUtil.MANGA_DTO, ConstantUtil.SCAN_DTO, ConstantUtil.PAGE_DTO);
        } catch (IOException e) {
            fail("The image for <~" + ConstantUtil.PAGE_DTO + "~> in <~" + ConstantUtil.SCAN_DTO + "~> in <~" + ConstantUtil.MANGA_DTO + "~> is unreachable.");
        }
    }
}