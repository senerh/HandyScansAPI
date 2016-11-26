package service;

import dto.MangaDTO;
import dto.ScanDTO;

import java.io.IOException;
import java.util.List;

public class ScanService extends AbstractService {

    public List<ScanDTO> getScanDTOList(String manga) throws IOException {
        MangaDTO mangaDTO = new MangaDTO(manga, "");
        return scanDAO.getScanDtoList(mangaDTO);
    }
}
