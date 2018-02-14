package service;

import java.util.List;
import java.util.Optional;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import dao.ScanDAO;
import dto.MangaDTO;
import exception.ShonenTouchResourceNotFoundException;

@Stateless
public class MangaService implements MangaServiceLocal {

    @EJB
    private ScanDAO scanDAO;

    public List<MangaDTO> getMangaDTOList() {
        return scanDAO.getMangaDtoList();
    }

    @Override
    public MangaDTO getMangaDTO(String manga) {
        Optional<MangaDTO> mangaDTO = scanDAO.getMangaDtoList().stream().filter(m -> m.getSlug().equals(manga)).findAny();
        if (mangaDTO.isPresent()) {
            return mangaDTO.get();
        } else {
            throw new ShonenTouchResourceNotFoundException(String.format("The manga '%s' cannot be found.", manga));
        }
    }
}
