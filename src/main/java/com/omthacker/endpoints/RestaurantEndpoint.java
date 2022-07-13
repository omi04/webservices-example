package com.omthacker.endpoints;

import com.omthacker.model.Restaurant;
import com.omthacker.services.RestaurantService;
import com.omthacker.webservice_example.GetRestaurantRequest;
import com.omthacker.webservice_example.GetRestaurantResponse;
import com.omthacker.webservice_example.ObjectFactory;
import com.omthacker.webservice_example.RestaurantDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import javax.xml.bind.JAXBElement;

@Endpoint
public class RestaurantEndpoint {
    @Autowired

    RestaurantService services;

    @PayloadRoot(namespace = "http://omthacker.com/webservice-example", localPart = "GetRestaurantRequest")
    @ResponsePayload
    public JAXBElement<GetRestaurantResponse> getEmployee(@RequestPayload GetRestaurantRequest request) {
        GetRestaurantResponse response = new GetRestaurantResponse();
        Restaurant restaurant = services.getRestaurant(request.getRestaurantId());
        response.setRestaurantDetails(mapRestaurant(restaurant));
        return new ObjectFactory().createGetRestaurantResponse(response);
    }

    private RestaurantDetails mapRestaurant(Restaurant restaurant) {
        RestaurantDetails restaurantDetails = new RestaurantDetails();
        restaurantDetails.setLocationId(restaurant.getRestaurantId());
        restaurantDetails.setRestaurantName(restaurant.getRestaurantName());
        restaurantDetails.setLocation(restaurant.getLocation());
        restaurantDetails.setPincode(String.valueOf(restaurant.getPincode()));
        return restaurantDetails;
    }
}
