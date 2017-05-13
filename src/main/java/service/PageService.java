package service;

import dao.ScanDAO;
import dto.MangaDTO;
import dto.PageDTO;
import dto.ScanDTO;
import util.SlugUtil;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.io.IOException;
import java.util.List;

@Stateless
public class PageService implements PageServiceLocal {

    @EJB
    private ScanDAO scanDAO;

    public List<PageDTO> getPageDTOList(String manga, String scan) throws IOException {
        MangaDTO mangaDTO = new MangaDTO(manga, SlugUtil.slugToName(manga));
        ScanDTO scanDTO = new ScanDTO(scan);
        return scanDAO.getPageDtoList(mangaDTO, scanDTO);
    }
}
