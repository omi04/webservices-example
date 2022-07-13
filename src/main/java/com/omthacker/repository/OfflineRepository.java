package com.omthacker.repository;

import com.omthacker.model.MenuCard;
import com.omthacker.model.MenuItem;
import com.omthacker.model.Restaurant;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class OfflineRepository {

    public static List<Restaurant> restaurantList = new ArrayList<>();

    public static List<MenuItem> menuList = new ArrayList<>();

    public static List<MenuCard> menuCardList = new ArrayList<>();

    {
        restaurantList.add(new Restaurant(1, "Indian Tadka", 1,"Powai", "12345","open","All","Indian"));
        restaurantList.add(new Restaurant(2, "McDonalds", 1,"Powai", "12345","open","All","Continental"));
        restaurantList.add(new Restaurant(7, "Burger King", 1,"Powai", "12345","open","All","Continental"));
        restaurantList.add(new Restaurant(8, "Burger Wala", 1,"Powai", "12345","open","All","Continental"));
        restaurantList.add(new Restaurant(3, "Garam Masala", 2,"Pune", "15545","open","Non-veg","Indian"));
        restaurantList.add(new Restaurant(4, "Pauls Kitchen",3, "Airoli", "17345","open","Non-veg","Italian"));
        restaurantList.add(new Restaurant(5, "Wok Express",4, "Dadar", "19345","open","veg","Chinese"));
        restaurantList.add(new Restaurant(6, "Bhagat Tarachand", 5,"Vashi", "23453","open","veg","Indian"));


        menuList.add(new MenuItem(1,"McAlooTiki",new BigDecimal(40.00),"Burger",true));
        menuList.add(new MenuItem(2,"McVeggie",new BigDecimal(60.00),"Burger",true));
        menuList.add(new MenuItem(3,"McMaharaja",new BigDecimal(100.00),"Burger",true));

        menuCardList.add(new MenuCard(1,"Powai-McDonalds",menuList,2,"McDonalds",1,"Powai"));


    }
    public static List<Restaurant> getRestaurants() {
       return restaurantList;
    }

    public List<Restaurant> getRestaurantByLocationAndStatus(Restaurant restaurant) {
        List<Restaurant> restaurants =  restaurantList.stream()
                .filter(rest -> Objects.nonNull(rest))
                .filter(rest -> Objects.nonNull(rest.getLocation()))
                .filter(rest -> Objects.nonNull(rest.getStatus()))
                .filter(rest -> rest.getLocation().equals(restaurant.getLocation())
                        && rest.getStatus().equals(restaurant.getStatus()))
                .collect(Collectors.toList());
        return restaurants;
    }

    public Optional<MenuCard> getMenuCardByRestaurantAndLocation(Restaurant restaurant) {
        Optional<MenuCard> menuCard =  menuCardList.stream()
                .filter(menu -> Objects.nonNull(menu))
                .filter(menu -> Objects.nonNull(menu.getLocation()))
                .filter(menu -> Objects.nonNull(menu.getRestaurantName()))
                .filter(menu -> menu.getLocation().equals(restaurant.getLocation())
                        && menu.getRestaurantName().equals(restaurant.getRestaurantName()))
                .findFirst();
        return menuCard;
    }

    public boolean save(Restaurant restaurant) {
        return restaurantList.add(restaurant);
    }


}
