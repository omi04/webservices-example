package com.omthacker.controller;

import com.omthacker.model.MenuCard;
import com.omthacker.model.Restaurant;
import com.omthacker.services.RestaurantService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    Logger logger = LoggerFactory.getLogger(RestaurantController.class);

    @PostMapping("/restaurants")
    public List<Restaurant> createRestaurant(@RequestBody Restaurant restaurant){

        logger.info("restaurant-"+restaurant);
        boolean flag = restaurantService.createRestaurant(restaurant);
        return restaurantService.getAllRestaurants();

    }

    @GetMapping("/restaurants/{location}/{status}")
    public List<Restaurant> getRestaurantsByLocationAndStatus(@PathVariable String location, @PathVariable String status ){

        logger.info("location-"+location+"-- status--"+status);
        Restaurant restaurant = new Restaurant();
        restaurant.setLocation(location);
        restaurant.setStatus(status);
        return restaurantService.getRestaurantByLocationAndStatus(restaurant);

    }

    @GetMapping("/restaurants")
    public List<Restaurant> getRestaurantsByStatusAndLocation(@RequestParam String location, @RequestParam String status ){

        logger.info("location-"+location+"-- status--"+status);
        Restaurant restaurant = new Restaurant();
        restaurant.setLocation(location);
        restaurant.setStatus(status);
        return restaurantService.getRestaurantByLocationAndStatus(restaurant);

    }

    @GetMapping("/restaurants/{location}/{restaurantName}/menu-card")
    public Optional<MenuCard> getRestaurantMenuCardByLocation(@PathVariable String location, @PathVariable String restaurantName){

        logger.info("location-"+location+"-- restaurantName--"+restaurantName);
        Restaurant restaurant = new Restaurant();
        restaurant.setLocation(location);
        restaurant.setRestaurantName(restaurantName);
        return restaurantService.getMenuCardByRestaurantAndLocation(restaurant);
    }

    @GetMapping("/restaurants/menu-card")
    public Optional<MenuCard> getRestaurantMenuCard(@RequestParam String location, @RequestParam String restaurantName){

        logger.info("location-"+location+"-- restaurantName--"+restaurantName);
        Restaurant restaurant = new Restaurant();
        restaurant.setLocation(location);
        restaurant.setRestaurantName(restaurantName);
        return restaurantService.getMenuCardByRestaurantAndLocation(restaurant);
    }
}
