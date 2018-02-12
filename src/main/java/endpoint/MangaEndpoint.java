package endpoint;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dto.MangaDTO;
import service.MangaServiceLocal;

@Path("/mangas")
public class MangaEndpoint {

    @EJB
    private MangaServiceLocal mangaService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<MangaDTO> getMangaDTOList() {
        return mangaService.getMangaDTOList();
    }
}
