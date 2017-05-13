package service;

import dao.ScanDAO;
import dto.ImageDTO;
import dto.MangaDTO;
import dto.PageDTO;
import dto.ScanDTO;
import util.SlugUtil;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.io.IOException;

@Stateless
public class ImageService implements ImageServiceLocal {

    @EJB
    private ScanDAO scanDAO;

    public ImageDTO getImageDTO(String manga, String scan, String page) throws IOException {
        MangaDTO mangaDTO = new MangaDTO(manga, SlugUtil.slugToName(manga));
        ScanDTO scanDTO = new ScanDTO(scan);
        PageDTO pageDTO = new PageDTO(page);
        return scanDAO.getImageDto(mangaDTO, scanDTO, pageDTO);
    }
}
