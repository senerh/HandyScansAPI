package cache;

import dao.ScanDAO;
import dto.MangaDTO;

import javax.ejb.EJB;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

@Singleton
public class MangaCache {

    private Map<String, MangaDTO> mangaBySlug;

    @EJB
    private ScanDAO scanDAO;

    @Lock(LockType.READ)
    public List<MangaDTO> getMangaDTOList() {
        return mangaBySlug.values().stream()
                .sorted((m1, m2) -> m1.getName().compareTo(m2.getName()))
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
