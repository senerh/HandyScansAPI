package service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import dao.ScanDAO;
import dto.MangaDTO;

@Stateless
public class MangaService implements MangaServiceLocal {

    @EJB
    private ScanDAO scanDAO;

    public List<MangaDTO> getMangaDTOList() {
        return scanDAO.getMangaDtoList();
    }
}
