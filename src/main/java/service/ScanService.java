package service;

import dto.MangaDTO;
import dto.ScanDTO;
import util.SlugUtil;

import java.io.IOException;
import java.util.List;

public class ScanService extends AbstractService {

    public List<ScanDTO> getScanDTOList(String manga) throws IOException {
        MangaDTO mangaDTO = new MangaDTO(SlugUtil.slugToLirescanSlug(manga), SlugUtil.slugToName(manga));
        return scanDAO.getScanDtoList(mangaDTO);
    }
}