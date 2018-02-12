package dao;

import java.util.List;

import javax.ejb.Local;

import dto.MangaDTO;
import dto.PageDTO;
import dto.ScanDTO;

@Local
public interface ScanDAO {

    List<MangaDTO> getMangaDtoList();

    List<ScanDTO> getScanDtoList(String mangaSlug);

    ScanDTO getLastScanDto(String mangaSlug);

    List<PageDTO> getPageDtoList(String mangaSlug, String numScan);
}
