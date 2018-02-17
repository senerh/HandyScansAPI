package service;

import cache.MangaCache;
import dto.MangaDTO;
import exception.ShonenTouchResourceNotFoundException;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;
import java.util.Optional;

@Stateless
public class MangaService implements MangaServiceLocal {

    @EJB
    private MangaCache mangaCache;

    public List<MangaDTO> getMangaDTOList() {
        return mangaCache.getMangaDTOList();
    }

    @Override
    public MangaDTO getMangaDTO(String manga) {
        Optional<MangaDTO> mangaDTO = mangaCache.getMangaDTO(manga);
        if (mangaDTO.isPresent()) {
            return mangaDTO.get();
        } else {
            throw new ShonenTouchResourceNotFoundException(String.format("The manga '%s' cannot be found.", manga));
        }
    }
}
