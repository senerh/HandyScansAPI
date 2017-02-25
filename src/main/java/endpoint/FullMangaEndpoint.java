package endpoint;

import dto.FullMangaDTO;
import service.MangaService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.List;

@Path("/fullmangas")
public class FullMangaEndpoint {

    private MangaService mangaService;

    public FullMangaEndpoint() {
        mangaService = new MangaService();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<FullMangaDTO> getFullMangaDTOList() throws IOException {
        return mangaService.getFullMangaDTOList();
    }
}
