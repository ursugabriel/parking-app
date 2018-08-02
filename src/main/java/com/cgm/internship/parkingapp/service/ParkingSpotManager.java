package com.cgm.internship.parkingapp.service;

import com.cgm.internship.parkingapp.module.ParkingSpot;

import java.util.*;

public class ParkingSpotManager {

    Map<ParkingSpot.ParkingSpotCategory, List<ParkingSpot>> allParkingSpots;

    public ParkingSpotManager(int numberOfFloor, int numberOfSpotsPerFloor) {
        ArrayList<ParkingSpot> spotsList = new ArrayList<ParkingSpot>();
        List<String>  parkingNames = generateParkingSpotName(numberOfSpotsPerFloor*numberOfFloor);
        Random randomCateg = new Random();

        for(int indexNoOfFloors=1;indexNoOfFloors<=numberOfFloor;indexNoOfFloors++){
            for(int indexNoOfSpots=1;indexNoOfSpots<=numberOfSpotsPerFloor;indexNoOfSpots++ ){
                ParkingSpot parkingSpot = new ParkingSpot(indexNoOfFloors,parkingNames.iterator().next(),randomCateg.,true);
                spotsList.add(parkingSpot);
            }
        }

    }


    public List<String> generateParkingSpotName(int numberOfSpots){
        List<String> listOfParkingName =new ArrayList<>();
        String parkingSpotName="";
        String nameLatters="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int noOfSpotsPerLetter=numberOfSpots/nameLatters.length();
        if(numberOfSpots%nameLatters.length()==0){
            for(int indexNoOfLetters=0;indexNoOfLetters<nameLatters.length();indexNoOfLetters++){
                for(int indexNoSpotsPerLetter=0;indexNoSpotsPerLetter<noOfSpotsPerLetter;indexNoSpotsPerLetter++){
                    parkingSpotName=""+nameLatters.charAt(indexNoOfLetters)+indexNoSpotsPerLetter;
                    listOfParkingName.add(parkingSpotName);
                }
            }
        }
        else {
            int spotsNameUnassigned = numberOfSpots%nameLatters.length();
            int spotsNameAssigned = numberOfSpots - spotsNameUnassigned;

        }

        return listOfParkingName;
    }


    public ParkingSpot assignateParkingSpot(ParkingSpot.ParkingSpotCategory typeOfSpotNeeded) {
        ParkingSpot assignedParkingSpot = null;
        for (ParkingSpot parkingSpot : allParkingSpots.get(typeOfSpotNeeded)) {
            if (isParkingSpotAvailable(parkingSpot) == true) {
                assignedParkingSpot = parkingSpot;
                break;
            } else if(!(typeOfSpotNeeded).equals(ParkingSpot.ParkingSpotCategory.LARGE)){
                assignedParkingSpot=null;
            } else if (areThereAnySpotsFreeInUpperCateg() == true) {
                if (doYouWantAnUpperCategOfSpot() == true) {
                    assignedParkingSpot = getFirstEmptyParkingSpot();
                }
            }
        }
        return assignedParkingSpot;
    }

    public boolean isParkingSpotAvailable(ParkingSpot parkingSpot) {
        if (parkingSpot.isAvailable()) {
            return true;
        } else return false;
    }

    public ParkingSpot getFirstEmptyParkingSpot() {
        ParkingSpot firstEmptySpot = null;
        for (Map.Entry<ParkingSpot.ParkingSpotCategory, List<ParkingSpot>> allCategParkingSpots : allParkingSpots.entrySet()) {
            List<ParkingSpot> parkingSpotList = allCategParkingSpots.getValue();
            for (ParkingSpot parkingSpot : parkingSpotList) {
                if (isParkingSpotAvailable(parkingSpot) == true) {
                    firstEmptySpot = parkingSpot;
                    break;
                }
            }
        }
        return firstEmptySpot;
    }

    public boolean areThereAnySpotsFreeInUpperCateg() {
        if (!(getFirstEmptyParkingSpot() == null)) {
            return true;
        } else return false;
    }

    public boolean doYouWantAnUpperCategOfSpot() {
        boolean userDesire = false;
        try {
            Scanner scanOption = new Scanner(System.in);
            int userChoice;
            System.out.println("There are no empty spots for your car category! Do you want a spot from an upper category?");
            System.out.println("1.Yes");
            System.out.println("2.No");
            userChoice = scanOption.nextInt();
            while (userChoice > 2 || userChoice < 1) {
                userChoice = scanOption.nextInt();
            }
            if (userChoice == 1) {
                userDesire = true;
            } else userDesire = false;
        } catch (IllegalArgumentException invalidFormatException) {
            System.out.println("Please insert a number!");
        }

        return userDesire;
    }


}
