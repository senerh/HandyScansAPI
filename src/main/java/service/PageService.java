package service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import dao.ScanDAO;
import dto.PageDTO;

@Stateless
public class PageService implements PageServiceLocal {

    @EJB
    private ScanDAO scanDAO;

    public List<PageDTO> getPageDTOList(String manga, String scan) {
        return scanDAO.getPageDtoList(manga, scan);
    }
}
