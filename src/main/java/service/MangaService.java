package service;

import dao.LirescanDAO;
import dao.ScanDAO;
import dto.MangaDTO;

import java.io.IOException;
import java.util.List;

public class MangaService extends AbstractService {

    public List<MangaDTO> getMangaDTOList() throws IOException {
        return scanDAO.getMangaDtoList();
    }
}
