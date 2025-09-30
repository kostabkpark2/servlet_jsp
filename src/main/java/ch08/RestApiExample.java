package ch08;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/test")
public class RestApiExample {
  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String get() {
    return "Hello API service";
  }

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public TestObject post(TestObject to) {
    return to;
  }
}
