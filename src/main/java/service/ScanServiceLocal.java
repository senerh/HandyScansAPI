package service;

import java.util.List;

import javax.ejb.Local;

import dto.ScanDTO;

@Local
public interface ScanServiceLocal {

    List<ScanDTO> getScanDTOList(String manga);

    ScanDTO getLastScanDTO(String manga);
}
