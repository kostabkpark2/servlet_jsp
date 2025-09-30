package ch08;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/tests")
public class RestApiExample {
  @GET
  @Path("/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public TestObject get(@PathParam("id") int id) {
    TestObject to = new TestObject();
    to.setMsg("id");
    to.setText(String.valueOf(id));
    return to;
  }

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public TestObject post(TestObject to) {
    System.out.println(to.getText());
    return to;
  }
}
