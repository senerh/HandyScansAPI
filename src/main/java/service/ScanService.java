package service;

import java.util.List;
import java.util.Optional;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import dao.ScanDAO;
import dto.ScanDTO;
import exception.ShonenTouchResourceNotFoundException;

@Stateless
public class ScanService implements ScanServiceLocal {

    @EJB
    private ScanDAO scanDAO;

    public List<ScanDTO> getScanDTOList(String manga) {
        return scanDAO.getScanDtoList(manga);
    }

    @Override
    public ScanDTO getScanDTO(String manga, String scan) {
        Optional<ScanDTO> scanDTO = scanDAO.getScanDtoList(manga).stream().filter(s -> s.getNum().equals(scan)).findAny();
        if (scanDTO.isPresent()) {
            return scanDTO.get();
        } else {
            throw new ShonenTouchResourceNotFoundException(String.format("The scan '%s' for manga '%s' cannot be found.", scan, manga));
        }
    }
}
