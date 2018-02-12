package endpoint;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dto.ScanDTO;
import service.ScanServiceLocal;

@Path("/mangas/{manga}/scans")
public class ScanEndpoint {

    @EJB
    private ScanServiceLocal scanService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ScanDTO> getScanDTOList(@PathParam("manga") String manga) {
        return scanService.getScanDTOList(manga);
    }
}
