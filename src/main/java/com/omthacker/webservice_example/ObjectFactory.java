//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.06.24 at 12:04:35 PM IST 
//


package com.omthacker.webservice_example;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.omthacker.webservice_example package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetRestaurantRequest_QNAME = new QName("http://omthacker.com/webservice-example", "GetRestaurantRequest");
    private final static QName _GetRestaurantResponse_QNAME = new QName("http://omthacker.com/webservice-example", "GetRestaurantResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.omthacker.webservice_example
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetRestaurantRequest }
     * 
     */
    public GetRestaurantRequest createGetRestaurantRequest() {
        return new GetRestaurantRequest();
    }

    /**
     * Create an instance of {@link GetRestaurantResponse }
     * 
     */
    public GetRestaurantResponse createGetRestaurantResponse() {
        return new GetRestaurantResponse();
    }

    /**
     * Create an instance of {@link RestaurantDetails }
     * 
     */
    public RestaurantDetails createRestaurantDetails() {
        return new RestaurantDetails();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRestaurantRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://omthacker.com/webservice-example", name = "GetRestaurantRequest")
    public JAXBElement<GetRestaurantRequest> createGetRestaurantRequest(GetRestaurantRequest value) {
        return new JAXBElement<GetRestaurantRequest>(_GetRestaurantRequest_QNAME, GetRestaurantRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRestaurantResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://omthacker.com/webservice-example", name = "GetRestaurantResponse")
    public JAXBElement<GetRestaurantResponse> createGetRestaurantResponse(GetRestaurantResponse value) {
        return new JAXBElement<GetRestaurantResponse>(_GetRestaurantResponse_QNAME, GetRestaurantResponse.class, null, value);
    }

}
