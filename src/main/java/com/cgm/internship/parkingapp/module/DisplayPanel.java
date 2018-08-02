package com.cgm.internship.parkingapp.module;

public class DisplayPanel {
    private int occupiedParkingSpotsNumber;
    private int availableParkingSpotsNumber;

    public DisplayPanel() {
    }

    public DisplayPanel(int occupiedParkingSpotsNumber, int availableParkingSpotsNumber) {
        this.occupiedParkingSpotsNumber = occupiedParkingSpotsNumber;
        this.availableParkingSpotsNumber = availableParkingSpotsNumber;
    }

    public int getOccupiedParkingSpotsNumber() {
        return occupiedParkingSpotsNumber;
    }

    public void setOccupiedParkingSpotsNumber(int occupiedParkingSpotsNumber) {
        this.occupiedParkingSpotsNumber = occupiedParkingSpotsNumber;
    }
}
