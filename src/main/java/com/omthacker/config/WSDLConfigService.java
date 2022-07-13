package com.omthacker.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.server.EndpointInterceptor;
import org.springframework.ws.soap.security.xwss.XwsSecurityInterceptor;
import org.springframework.ws.soap.security.xwss.callback.SimplePasswordValidationCallbackHandler;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

import java.util.Collections;
import java.util.List;

@EnableWs
@Configuration
public class WSDLConfigService extends WsConfigurerAdapter {

    // Request Handler - Servlet -> ServletRegistration Bean -> MessageServelt
    // URL /soap/*

    @Bean
    public ServletRegistrationBean requestDispatcher(ApplicationContext applicationContext){
        MessageDispatcherServlet mds = new MessageDispatcherServlet();
        mds.setApplicationContext(applicationContext);
        mds.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(mds,"/soap/*");
    }

    @Bean
    public XsdSchema restaurantXsdSchema(){
        return new SimpleXsdSchema(new ClassPathResource("restaurant.xsd"));
    }

    @Bean(name="restaurantservice")
    public DefaultWsdl11Definition createWsdl(XsdSchema xsdSchema){
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("RestaurantPort");
        wsdl11Definition.setLocationUri("/soap");
        wsdl11Definition.setTargetNamespace("http://omthacker.com/webservice-example");
        wsdl11Definition.setSchema(xsdSchema);
        return wsdl11Definition;
    }

    // Implement Security
    @Bean
    public XwsSecurityInterceptor requestInterceptor(){
        XwsSecurityInterceptor interceptor= new XwsSecurityInterceptor();
        interceptor.setCallbackHandler(callbackHandler());
        interceptor.setPolicyConfiguration(new ClassPathResource("securityPolicy.xml"));
        return interceptor;
    }

    @Bean
    public SimplePasswordValidationCallbackHandler callbackHandler() {
        SimplePasswordValidationCallbackHandler handler = new SimplePasswordValidationCallbackHandler();
        handler.setUsersMap(Collections.singletonMap("admin","password"));
        return handler;
    }

    @Override
    public void addInterceptors(List<EndpointInterceptor> interceptors) {
        interceptors.add(requestInterceptor());
    }

}
