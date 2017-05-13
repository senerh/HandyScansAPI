package service;

import dto.ImageDTO;

import javax.ejb.Local;
import java.io.IOException;

@Local
public interface ImageServiceLocal {

    ImageDTO getImageDTO(String manga, String scan, String page) throws IOException;
}
