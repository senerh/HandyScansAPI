package dao;

import dto.MangaDTO;
import org.junit.Test;

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
            MangaDTO mangaDTO = new MangaDTO("one-piece", "One Piece");
            assertTrue("The manga list must contains <~" + mangaDTO + "~>", mangaDTOList.contains(mangaDTO));
        } catch (IOException e) {
            assertTrue("Unexpected exception, the website is maybe unavailable.", false);
        }
    }
}
