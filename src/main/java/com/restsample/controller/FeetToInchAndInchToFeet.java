package com.restsample.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
@Path("ConversionService")
public class FeetToInchAndInchToFeet {
@GET
@Path("/inchtofeet/{i}")
@Produces(MediaType.TEXT_XML)
public String convertInchToFeet(@PathParam("i")int i)
{
	int inch=i;
	double feet=0;
	feet = (double) inch /12;
	
	return "<InchToFeetService>"
    + "<Inch>" + inch + "</Inch>"
      + "<Feet>" + feet + "</Feet>"
     + "</InchToFeetService>";
	}
@Path("/feettoinch/{i}")
@GET
@Produces(MediaType.TEXT_XML)
public String convertFeetToInch(@PathParam("i") double i) {
	int feet;
	feet = (int) (12 * i);
	
	return "<FeetToInchService>"
    + "<Feet>" + feet + "</Feet>"
    + "<Inch>" +i+ "</Inch>"
    + "</FeetToInchService>";
	
}


	
	
}
