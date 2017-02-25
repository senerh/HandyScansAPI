package service;

import dto.FullMangaDTO;
import dto.MangaDTO;

import java.io.IOException;
import java.util.List;

public class MangaService extends AbstractService {

    public List<MangaDTO> getMangaDTOList() throws IOException {
        return scanDAO.getMangaDtoList();
    }

    public List<FullMangaDTO> getFullMangaDTOList() throws IOException {
        return scanDAO.getFullMangaDtoList();
    }
}
