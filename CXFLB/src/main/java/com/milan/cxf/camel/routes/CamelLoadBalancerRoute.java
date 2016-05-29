package com.milan.cxf.camel.routes;

import java.io.InputStream;
import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

public class CamelLoadBalancerRoute extends RouteBuilder{
	@Override
	public void configure() throws Exception
	{
		/*from("cxfrs:bean:LBRSServer").routeId("CamelLBRoute").autoStartup(true).log("${body}").process(new Processor(){
			public void process(Exchange exchange)
			{
				Map<String,Object> headerMap = exchange.getIn().getHeaders();
				String camelHttpPath = headerMap.get("CamelHttpPath").toString();
				Message message = exchange.getOut();
				message.setHeader(Exchange.HTTP_PATH, camelHttpPath);
			}
		}).convertBodyTo(InputStream.class)
		.loadBalance().roundRobin().to("{{server1}}","{{server2}}");*/
	}

}
