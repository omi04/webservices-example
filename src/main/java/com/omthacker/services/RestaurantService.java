package com.omthacker.services;

import com.omthacker.model.MenuCard;
import com.omthacker.model.Restaurant;
import com.omthacker.repository.OfflineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Component
public class RestaurantService {

    @Autowired
    private OfflineRepository offlineRepository;

    List<Restaurant> listOfRestaurants = offlineRepository.getRestaurants();
    public Restaurant getRestaurant(int restaurantId) {
        Optional<Restaurant> restaurant = listOfRestaurants.stream()
                .filter(rest -> rest.getRestaurantId() == restaurantId)
                .findFirst();
        return restaurant.get();
    }


    public List<Restaurant> getAllRestaurants() {
        return listOfRestaurants;
    }

    public boolean removeRestaurant(int restaurantId) {
        Iterator<Restaurant> iterator = listOfRestaurants.iterator();
        while (iterator.hasNext()) {
            Restaurant restaurant = iterator.next();
            if (restaurantId == restaurant.getRestaurantId()) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    public List<Restaurant> getRestaurantByLocationAndStatus(Restaurant restaurant) {
        return offlineRepository.getRestaurantByLocationAndStatus(restaurant);
    }

    public Optional<MenuCard> getMenuCardByRestaurantAndLocation(Restaurant restaurant) {
        return offlineRepository.getMenuCardByRestaurantAndLocation(restaurant);
    }

    public boolean createRestaurant(Restaurant restaurant) {
        return offlineRepository.save(restaurant);
    }

}
