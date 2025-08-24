package com.example.model;

public class Restaurant {
    private int restaurantId;
    private String name;
    private String address;
    private String phoneNumber;
    private String cuisineType;
    private String deliveryTime;      // in minutes
    private int adminUserId;
    private String rating;         // Changed to String
    private String isActive;
    private String imagePath;

    // Zero-parameter constructor
    public Restaurant() {
    }

    // Parameterized constructor
    

    // Getters and Setters
    public Restaurant(String name, String address, String phoneNumber, String cuisineType, String deliveryTime,
			int adminUserId, String rating, String isActive, String imagePath) {
		super();
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.cuisineType = cuisineType;
		this.deliveryTime = deliveryTime;
		this.adminUserId = adminUserId;
		this.rating = rating;
		this.isActive = isActive;
		this.imagePath = imagePath;
	}

	
    public Restaurant(int restaurantId, String name, String address, String phoneNumber, String cuisineType,
			String deliveryTime, int adminUserId, String rating, String isActive, String imagePath) {
		super();
		this.restaurantId = restaurantId;
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.cuisineType = cuisineType;
		this.deliveryTime = deliveryTime;
		this.adminUserId = adminUserId;
		this.rating = rating;
		this.isActive = isActive;
		this.imagePath = imagePath;
	}
    
    

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getCuisineType() {
		return cuisineType;
	}

	public void setCuisineType(String cuisineType) {
		this.cuisineType = cuisineType;
	}

	public String getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(String deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	public int getAdminUserId() {
		return adminUserId;
	}

	public void setAdminUserId(int adminUserId) {
		this.adminUserId = adminUserId;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}
	public int getRestaurantId() {
		return restaurantId;
	}

	@Override
    public String toString() {
        return "Restaurant{" +
                "restaurantId=" + restaurantId +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", cuisineType='" + cuisineType + '\'' +
                ", deliveryTime=" + deliveryTime +
                ", adminUserId=" + adminUserId +
                ", rating='" + rating + '\'' +
                ", isActive=" + isActive +
                ", imagePath='" + imagePath + '\'' +
                '}';
    }
}