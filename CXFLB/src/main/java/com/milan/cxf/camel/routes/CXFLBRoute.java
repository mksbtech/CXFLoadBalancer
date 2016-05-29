package com.milan.cxf.camel.routes;

import org.apache.camel.builder.RouteBuilder;

public class CXFLBRoute extends RouteBuilder{
	@Override
	public void configure() throws Exception
	{

		from("cxfrs:bean:LBRSServer").routeId("CXFLBRoute").autoStartup(true).log("${body}").to("cxfrs:bean:personRSServiceClient");
	}

}