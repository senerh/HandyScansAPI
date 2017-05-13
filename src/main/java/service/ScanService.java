package service;

import dao.ScanDAO;
import dto.MangaDTO;
import dto.ScanDTO;
import util.SlugUtil;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.io.IOException;
import java.util.List;

@Stateless
public class ScanService implements ScanServiceLocal {

    @EJB
    private ScanDAO scanDAO ;

    public List<ScanDTO> getScanDTOList(String manga) throws IOException {
        MangaDTO mangaDTO = new MangaDTO(manga, SlugUtil.slugToName(manga));
        return scanDAO.getScanDtoList(mangaDTO);
    }

    public ScanDTO getLastScanDTO(String manga) throws IOException {
        MangaDTO mangaDTO = new MangaDTO(manga, SlugUtil.slugToName(manga));
        return scanDAO.getLastScanDto(mangaDTO);
    }
}
