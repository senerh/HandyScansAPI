package service;

import dto.ScanDTO;

import javax.ejb.Local;
import java.io.IOException;
import java.util.List;

@Local
public interface ScanServiceLocal {

    List<ScanDTO> getScanDTOList(String manga) throws IOException;

    ScanDTO getLastScanDTO(String manga) throws IOException;
}
