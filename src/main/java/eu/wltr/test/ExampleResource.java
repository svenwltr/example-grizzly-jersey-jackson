package eu.wltr.test;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/test/")
@Produces(MediaType.APPLICATION_JSON)
public class ExampleResource {
	@GET
	public Map<Object, Object> get()
	{
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("foo", "bar");
		return map;
	}
}
