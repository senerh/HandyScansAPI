package endpoint;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dto.PageDTO;
import service.PageServiceLocal;

@Path("/mangas/{manga}/scans/{scan}/pages")
public class PageEndpoint {

    @EJB
    private PageServiceLocal pageService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<PageDTO> getPageDTOList(
            @PathParam("manga") String manga,
            @PathParam("scan") String scan) {
        return pageService.getPageDTOList(manga, scan);
    }

    @GET
    @Path("/{page}")
    @Produces(MediaType.APPLICATION_JSON)
    public PageDTO getPageDTO(
            @PathParam("manga") String manga,
            @PathParam("scan") String scan,
            @PathParam("page") String page) {
        return pageService.getPageDTO(manga, scan, page);
    }
}
