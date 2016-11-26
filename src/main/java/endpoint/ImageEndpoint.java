package endpoint;

import dto.ImageDTO;
import service.ImageService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

@Path("/mangas/{manga}/scans/{scan}/pages/{page}/image")
public class ImageEndpoint {

    private ImageService imageService;

    public ImageEndpoint() {
        imageService = new ImageService();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ImageDTO getImageDTO(
            @PathParam("manga") String manga,
            @PathParam("scan") String scan,
            @PathParam("page") String page) throws IOException {
        return imageService.getImageDTO(manga, scan, page);
    }
}
