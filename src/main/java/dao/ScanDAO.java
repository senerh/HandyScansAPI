package dao;

import dto.*;

import java.io.IOException;
import java.util.List;

public interface ScanDAO {

    public List<MangaDTO> getMangaDtoList() throws IOException;

    public List<MangaLastScanDTO> getMangaLastScanDtoList() throws IOException;

    public List<ScanDTO> getScanDtoList(MangaDTO mangaDTO) throws IOException;

    public ScanDTO getLastScanDto(MangaDTO mangaDTO) throws IOException;

    public List<PageDTO> getPageDtoList(MangaDTO mangaDTO, ScanDTO scanDTO) throws IOException;

    public ImageDTO getImageDto(MangaDTO mangaDTO, ScanDTO scanDTO, PageDTO pageDTO) throws IOException;
}
