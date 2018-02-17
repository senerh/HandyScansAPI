package service;

import java.util.List;

import javax.ejb.Local;

import dto.MangaDTO;

@Local
public interface MangaServiceLocal {

    List<MangaDTO> getMangaDTOList();
    
    MangaDTO getMangaDTO(String manga);
}
