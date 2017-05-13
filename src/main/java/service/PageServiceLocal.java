package service;

import dto.PageDTO;

import javax.ejb.Local;
import java.io.IOException;
import java.util.List;

@Local
public interface PageServiceLocal {

    List<PageDTO> getPageDTOList(String manga, String scan) throws IOException;
}
