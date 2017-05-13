package service;

import dao.ScanDAO;
import dto.FullMangaDTO;
import dto.MangaDTO;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.io.IOException;
import java.util.List;

@Stateless
public class MangaService implements MangaServiceLocal {

    @EJB
    protected ScanDAO scanDAO;

    public List<MangaDTO> getMangaDTOList() throws IOException {
        return scanDAO.getMangaDtoList();
    }

    public List<FullMangaDTO> getFullMangaDTOList() throws IOException {
        return scanDAO.getFullMangaDtoList();
    }
}
