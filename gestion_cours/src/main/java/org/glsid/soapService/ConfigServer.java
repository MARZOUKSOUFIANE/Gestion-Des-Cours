package org.glsid.soapService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.jaxws.SimpleJaxWsServiceExporter;

@Configuration
public class ConfigServer {

	@Bean
	public SimpleJaxWsServiceExporter getService() {
		SimpleJaxWsServiceExporter exporter=new SimpleJaxWsServiceExporter();
		exporter.setBaseAddress("http://localhost:9095/");
		return exporter;
	}
}
