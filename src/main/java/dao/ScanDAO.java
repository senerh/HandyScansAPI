package dao;

import dto.*;

import javax.ejb.Local;
import java.io.IOException;
import java.util.List;

@Local
public interface ScanDAO {

    List<MangaDTO> getMangaDtoList() throws IOException;

    List<FullMangaDTO> getFullMangaDtoList() throws IOException;

    List<ScanDTO> getScanDtoList(MangaDTO mangaDTO) throws IOException;

    ScanDTO getLastScanDto(MangaDTO mangaDTO) throws IOException;

    List<PageDTO> getPageDtoList(MangaDTO mangaDTO, ScanDTO scanDTO) throws IOException;
}
