package com.kev.demosoapsw;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {
    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext appContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(appContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(servlet, "/ws/*");
    }

    @Bean(name = "countries")
    public DefaultWsdl11Definition defaultWsDefinition(){
        DefaultWsdl11Definition wsDefinition = new DefaultWsdl11Definition();
        wsDefinition.setPortTypeName("CountriesPort");
        wsDefinition.setLocationUri("/ws/");
        wsDefinition.setTargetNamespace("http://spring.io/guides/gs-producing-web-service");
        wsDefinition.setSchema(countriesSchema());

        return wsDefinition;
    }

    @Bean
    public XsdSchema countriesSchema () {
        return new SimpleXsdSchema(new ClassPathResource("countries.xsd"));
    }
}
