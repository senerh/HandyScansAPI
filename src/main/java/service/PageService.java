package service;

import java.util.List;
import java.util.Optional;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import dao.ScanDAO;
import dto.PageDTO;
import exception.ShonenTouchResourceNotFoundException;

@Stateless
public class PageService implements PageServiceLocal {

    @EJB
    private ScanDAO scanDAO;

    public List<PageDTO> getPageDTOList(String manga, String scan) {
        return scanDAO.getPageDtoList(manga, scan);
    }

    @Override
    public PageDTO getPageDTO(String manga, String scan, String page) {
        Optional<PageDTO> pageDTO = scanDAO.getPageDtoList(manga, scan).stream().filter(s -> s.getNum().equals(page)).findAny();
        if (pageDTO.isPresent()) {
            return pageDTO.get();
        } else {
            throw new ShonenTouchResourceNotFoundException(String.format("The page '%s' for manga '%s' and scan '%s' cannot be found.", page, manga, scan));
        }
    }
}
