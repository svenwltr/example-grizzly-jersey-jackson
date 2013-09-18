package eu.wltr.test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.ws.rs.ProcessingException;

import org.glassfish.grizzly.http.server.HttpHandler;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.grizzly.http.server.ServerConfiguration;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpContainer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ContainerFactory;
import org.glassfish.jersey.server.ResourceConfig;

public class Main {
	public static void main(String[] args) {
		try {
			ResourceConfig rc = new ResourceConfig();
			rc.register(ExampleResource.class);
			rc.register(ObjectMapperResolver.class);

			HttpHandler handler = ContainerFactory.createContainer(
					GrizzlyHttpContainer.class, rc);

			URI uri = new URI("http://0.0.0.0:8080/");

			HttpServer server = GrizzlyHttpServerFactory.createHttpServer(uri);

			ServerConfiguration config = server.getServerConfiguration();
			config.addHttpHandler(handler, "/");

			server.start();
			System.in.read();

		} catch (ProcessingException | URISyntaxException | IOException e) {
			throw new Error("Unable to create HTTP server.", e);
		}
	}
}
