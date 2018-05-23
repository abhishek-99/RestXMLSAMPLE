package com.restsample.client;

import java.util.Map;
import java.util.Set;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class ConversionServiceClient {

	static final String REST_URI= "http://localhost:8080/RestXMLSample";
	static final String InchToFeet="/ConversionService/inchtofeet/";
	static final String FeetToInch="/ConversionService/feettoinch/";
	public static void main(String[]args) {
		int inch=12;
		int feet=2;
		ClientConfig config =  new DefaultClientConfig();
		Client client = Client.create(config);
		WebResource service = client.resource(REST_URI);
		WebResource addService= service.path("rest").path(InchToFeet+inch);
		System.out.println("INCH_TO_FEET Response:"+getRespone(addService));
		System.out.println("INCH_TO_FEET Output as XML:"+getOutPutAsXML(addService));	
		 System.out.println("---------------------------------------------------");
		WebResource subservice = service.path("rest").path(FeetToInch+feet);
		System.out.println("FEET_TO_INCH Response:"+getRespone(subservice));
		System.out.println("FEET_TO_INCH Output as XML:"+getOutPutAsXML(subservice));	
		 System.out.println("---------------------------------------------------");		
}
	private static String getOutPutAsXML(WebResource service) {
		return service.accept(MediaType.TEXT_XML).get(String.class);
	}
	private static String getRespone(WebResource service) {
		return service.accept(MediaType.TEXT_XML).get(ClientResponse.class).toString();
	}
}	
