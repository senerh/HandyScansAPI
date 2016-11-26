package endpoint;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/test")
public class TestEndpoint {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getTest() {
        return "Hello world !";
    }
}
