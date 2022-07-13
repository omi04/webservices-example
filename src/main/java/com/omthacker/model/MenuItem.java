package com.omthacker.model;

import java.math.BigDecimal;

public class MenuItem {

    private int menuItemId;

    private String menuName;

    private BigDecimal menuPrice;

    private String menuType;

    private boolean available;

    public int getMenuItemId() {
        return menuItemId;
    }

    public void setMenuItemId(int menuItemId) {
        this.menuItemId = menuItemId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public BigDecimal getMenuPrice() {
        return menuPrice;
    }

    public void setMenuPrice(BigDecimal menuPrice) {
        this.menuPrice = menuPrice;
    }

    public String getMenuType() {
        return menuType;
    }

    public void setMenuType(String menuType) {
        this.menuType = menuType;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public MenuItem(int menuItemId, String menuName, BigDecimal menuPrice, String menuType, boolean available) {
        this.menuItemId = menuItemId;
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.menuType = menuType;
        this.available = available;
    }

    public MenuItem() {
    }
}
