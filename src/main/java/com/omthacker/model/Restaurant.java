package com.omthacker.model;

public class Restaurant {
     private int restaurantId;
     private String restaurantName;
     private int locationId;
     private String location;
     private String pincode;
     private String status;
     private String restaurantType;
     private String cusine;

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

     public String getPincode() {
          return pincode;
     }

     public void setPincode(String pincode) {
          this.pincode = pincode;
     }

     public String getStatus() {
          return status;
     }

     public void setStatus(String status) {
          this.status = status;
     }

     public String getRestaurantType() {
          return restaurantType;
     }

     public void setRestaurantType(String restaurantType) {
          this.restaurantType = restaurantType;
     }

     public String getCusine() {
          return cusine;
     }

     public void setCusine(String cusine) {
          this.cusine = cusine;
     }

     public Restaurant() {
     }
     public Restaurant(int restaurantId, String restaurantName, int locationId, String location, String pincode, String status, String restaurantType, String cusine) {
          this.restaurantId = restaurantId;
          this.restaurantName = restaurantName;
          this.locationId = locationId;
          this.location = location;
          this.pincode = pincode;
          this.status = status;
          this.restaurantType = restaurantType;
          this.cusine = cusine;
     }

     @Override
     public String toString() {
          return "Restaurant{" +
                  "restaurantId=" + restaurantId +
                  ", restaurantName='" + restaurantName + '\'' +
                  ", locationId=" + locationId +
                  ", location='" + location + '\'' +
                  ", pincode='" + pincode + '\'' +
                  ", status='" + status + '\'' +
                  ", restaurantType='" + restaurantType + '\'' +
                  ", cusine='" + cusine + '\'' +
                  '}';
     }
}
