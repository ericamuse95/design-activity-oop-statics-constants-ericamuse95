package com.kenzie.library;

public class Wagon {

    private int capacity;
    private Traveler[] passengers;

    public Wagon(int capacity) {
        this.capacity = capacity;
        this.passengers = new Traveler[this.capacity];
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Traveler[] getPassengers() {
        return passengers;
    }

    public void setPassengers(Traveler[] passengers) {
        this.passengers = passengers;
    }

    public int getAvailableSeatCount() {
        int seatCount = 0;
        for (Traveler passenger : this.passengers) {
            if (passenger == null) {
                seatCount++;
            }
        }
        return seatCount;
    }

    public void join(Traveler traveler) {
        if (this.getAvailableSeatCount() > 0) {
            this.passengers[this.capacity - getAvailableSeatCount()] = traveler;
        }
    }

    public boolean shouldQuarantine() {
        for (Traveler passenger : this.passengers) {
            if (passenger != null && !passenger.getIsHealthy()) {
                return true;
            }
        }
        return false;
    }
    public int totalFood() {
        int foodCount = 0;
        for (Traveler passenger : this.passengers) {
            if (passenger != null) {
                foodCount += passenger.getFood();
            }
        }
        return foodCount;
    }

    public void loadWagon(int numTravelers, int numHunters, int numDoctors) {
        for (int i = 0; i < numTravelers; i++) {
            Traveler traveler = new Traveler();
            this.join(traveler);
        }
        for (int i = 0; i < numHunters; i++) {
            Hunter hunter = new Hunter();
            this.join(hunter);
        }
        for (int i = 0; i < numDoctors; i++) {
            Doctor doctor = new Doctor();
            this.join(doctor);
        }
    }
}