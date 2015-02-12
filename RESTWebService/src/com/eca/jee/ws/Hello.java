package com.eca.jee.ws;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

// POJO, no interface no extends

// The class registers its methods for the HTTP GET request using the @GET annotation. 
// Using the @Produces annotation, it defines that it can deliver several MIME types,
// text, XML and HTML. 

// The browser requests per default the HTML MIME type.

//Sets the path to base URL + /hello
@Path("/hello")
public class Hello {
	// This method is called if TEXT_PLAIN is request
	@GET
	@Path("/token={token}")
	@Produces(MediaType.TEXT_PLAIN)
	public String sayPlainTextHello() {
		System.out.println("Hello Jersey");
		return "Hello Jersey";
	}

	// This method is called if XML is request
	@GET
	@Produces(MediaType.TEXT_XML)
	public String sayXMLHello(@PathParam("token") String token) {
		if (AuthenticationService.authenticate(token)) {
			System.out.println("Hello Jersey - XML");
			return "<?xml version=\"1.0\"?>" + "<hello> Hello Jersey"
					+ "</hello>";
		} else {
			throw new WebApplicationException(401);
		}
	}

	// This method is called if HTML is request
	@GET
	@Path("/token={token}")
	@Produces(MediaType.TEXT_HTML)
	public String sayHtmlHello() {
		System.out.println("Hello Jersey - HTML");
		return "<html> " + "<title>" + "Hello Jersey" + "</title>"
				+ "<body><h1>" + "Hello Jersey" + "</h1></body>" + "</html> ";
	}

} // class