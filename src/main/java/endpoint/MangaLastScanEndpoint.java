package endpoint;

import dto.MangaLastScanDTO;
import service.MangaService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.List;

@Path("/mangalastscans")
public class MangaLastScanEndpoint {

    private MangaService mangaService;

    public MangaLastScanEndpoint() {
        mangaService = new MangaService();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<MangaLastScanDTO> getMangaLastScanDTOList() throws IOException {
        return mangaService.getMangaLastScanDTOList();
    }
}
