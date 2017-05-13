package service;

import dto.FullMangaDTO;
import dto.MangaDTO;

import javax.ejb.Local;
import java.io.IOException;
import java.util.List;

@Local
public interface MangaServiceLocal {

    List<MangaDTO> getMangaDTOList() throws IOException;

    List<FullMangaDTO> getFullMangaDTOList() throws IOException;
}
