package service;

import dto.ImageDTO;
import dto.MangaDTO;
import dto.PageDTO;
import dto.ScanDTO;
import util.SlugUtil;

import java.io.IOException;

public class ImageService extends AbstractService {

    public ImageDTO getImageDTO(String manga, String scan, String page) throws IOException {
        MangaDTO mangaDTO = new MangaDTO(SlugUtil.slugToLirescanSlug(manga), SlugUtil.slugToName(manga));
        ScanDTO scanDTO = new ScanDTO(scan);
        PageDTO pageDTO = new PageDTO(page);
        return scanDAO.getImageDto(mangaDTO, scanDTO, pageDTO);
    }
}
