package com.cgm.internship.parkingapp.module;

public class ParkingSpot {
    private int parkingSpotFloor;
    private String parkingSpotName;
    private ParkingSpotCategory parkingSpotCategory;
    private boolean isAvailable=true;
    public enum ParkingSpotCategory{
        SMALL(7),
        MEDIUM(9),
        LARGE(12);

        private int pricePerHour;
        ParkingSpotCategory(int price){
            this.pricePerHour=price;
        }
        public int getPricePerHour(){return pricePerHour;}
    }

    public ParkingSpot() {

    }

    public ParkingSpot(int parkingSpotFloor, String parkingSpotName, boolean isAvailable) {
        this.parkingSpotFloor = parkingSpotFloor;
        this.parkingSpotName = parkingSpotName;
        this.isAvailable = isAvailable;
    }

    public ParkingSpot(int parkingSpotFloor, String parkingSpotName, ParkingSpotCategory parkingSpotCategory, boolean isAvailable) {
        this.parkingSpotFloor = parkingSpotFloor;
        this.parkingSpotName = parkingSpotName;
        this.parkingSpotCategory = parkingSpotCategory;
        this.isAvailable = isAvailable;
    }

    public int getParkingSpotFloor() {
        return parkingSpotFloor;
    }

    public void setParkingSpotFloor(int parkingSpotFloor) {
        this.parkingSpotFloor = parkingSpotFloor;
    }

    public String getParkingSpotName() {
        return parkingSpotName;
    }

    public void setParkingSpotName(String parkingSpotName) {
        this.parkingSpotName = parkingSpotName;
    }

    public ParkingSpotCategory getParkingSpotCategory() {
        return parkingSpotCategory;
    }

    public void setParkingSpotCategory(ParkingSpotCategory parkingSpotCategory) {
        this.parkingSpotCategory = parkingSpotCategory;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}