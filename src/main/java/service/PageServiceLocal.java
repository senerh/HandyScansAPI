package service;

import java.util.List;

import javax.ejb.Local;

import dto.PageDTO;

@Local
public interface PageServiceLocal {

    List<PageDTO> getPageDTOList(String manga, String scan);

    PageDTO getPageDTO(String manga, String scan, String page);
}
