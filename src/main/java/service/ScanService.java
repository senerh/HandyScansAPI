package service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import dao.ScanDAO;
import dto.ScanDTO;

@Stateless
public class ScanService implements ScanServiceLocal {

    @EJB
    private ScanDAO scanDAO;

    public List<ScanDTO> getScanDTOList(String manga) {
        return scanDAO.getScanDtoList(manga);
    }

    public ScanDTO getLastScanDTO(String manga) {
        return scanDAO.getLastScanDto(manga);
    }
}
