package cache;

import static java.util.stream.Collectors.*;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

import javax.ejb.EJB;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;

import dao.ScanDAO;
import dto.MangaDTO;

@Singleton
public class MangaCache {

    private Map<String, MangaDTO> mangaBySlug;

    @EJB
    private ScanDAO scanDAO;

    @Lock(LockType.READ)
    public List<MangaDTO> getMangaDTOList() {
        return mangaBySlug.values().stream()
                .sorted(Comparator.comparing(MangaDTO::getName))
                .collect(toList());
    }

    @Lock(LockType.READ)
    public Optional<MangaDTO> getMangaDTO(String slug) {
        return Optional.ofNullable(mangaBySlug.get(slug));
    }

    @Lock(LockType.READ)
    public Map<String, MangaDTO> loadFreshCache() {
        return scanDAO.getMangaDtoList().stream().collect(toMap(MangaDTO::getSlug, Function.identity()));
    }

    @Lock(LockType.WRITE)
    public void setCache(Map<String, MangaDTO> cache) {
        mangaBySlug = cache;
    }
}
