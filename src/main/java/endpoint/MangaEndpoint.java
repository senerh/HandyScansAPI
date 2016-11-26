package endpoint;

import dto.MangaDTO;
import service.MangaService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.List;

@Path("/mangas")
public class MangaEndpoint {

    private MangaService mangaService;

    public MangaEndpoint() {
        mangaService = new MangaService();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<MangaDTO> getMangaDTOList() throws IOException {
        return mangaService.getMangaDTOList();
    }

}
