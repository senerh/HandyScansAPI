package dao;

import dto.MangaDTO;
import dto.PageDTO;
import dto.ScanDTO;

import javax.ejb.Local;
import java.util.List;

@Local
public interface ScanDAO {

    List<MangaDTO> getMangaDtoList();

    List<ScanDTO> getScanDtoList(String mangaSlug);

    List<PageDTO> getPageDtoList(String mangaSlug, String numScan);
}
