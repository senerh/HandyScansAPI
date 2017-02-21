package service;

import dto.MangaDTO;
import dto.MangaLastScanDTO;

import java.io.IOException;
import java.util.List;

public class MangaService extends AbstractService {

    public List<MangaDTO> getMangaDTOList() throws IOException {
        return scanDAO.getMangaDtoList();
    }

    public List<MangaLastScanDTO> getMangaLastScanDTOList() throws IOException {
        return scanDAO.getMangaLastScanDtoList();
    }
}
