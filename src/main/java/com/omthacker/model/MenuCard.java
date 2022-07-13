package com.omthacker.model;

import java.util.List;

public class MenuCard {

    private int menuCardId;

    private String menuCardCode;

    private List<MenuItem> menuItems;

    private int restaurantId;

    private String restaurantName;

    private int locationId;

    private String location;

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getMenuCardId() {
        return menuCardId;
    }

    public void setMenuCardId(int menuCardId) {
        this.menuCardId = menuCardId;
    }

    public String getMenuCardCode() {
        return menuCardCode;
    }

    public void setMenuCardCode(String menuCardCode) {
        this.menuCardCode = menuCardCode;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public MenuCard() {
    }

    public MenuCard(int menuCardId, String menuCardCode, List<MenuItem> menuItems, int restaurantId, String restaurantName, int locationId, String location) {
        this.menuCardId = menuCardId;
        this.menuCardCode = menuCardCode;
        this.menuItems = menuItems;
        this.restaurantId = restaurantId;
        this.restaurantName = restaurantName;
        this.locationId = locationId;
        this.location = location;
    }
}
