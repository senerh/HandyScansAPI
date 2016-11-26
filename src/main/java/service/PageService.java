package service;

import dto.MangaDTO;
import dto.PageDTO;
import dto.ScanDTO;

import java.io.IOException;
import java.util.List;

public class PageService extends AbstractService {

    public List<PageDTO> getPageDTOList(String manga, String scan) throws IOException {
        MangaDTO mangaDTO = new MangaDTO(manga, "");
        ScanDTO scanDTO = new ScanDTO(scan);
        return scanDAO.getPageDtoList(mangaDTO, scanDTO);
    }
}
