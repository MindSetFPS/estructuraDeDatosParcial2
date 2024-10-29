package com.example.practica12;

import java.time.temporal.ChronoUnit;
import java.time.*;


class Car {
    private String licensePlate;
    public String owner;
    private LocalTime arrivalTime = LocalTime.now();
    public LocalTime leaveTime;
    public long totalTime;

    public Car(String licensePlate, String owner) {
        this.licensePlate = licensePlate;
        this.owner = owner;
        this.leaveTime = arrivalTime.plusSeconds((int) Math.floor(Math.random() * 1000000 + 1));
        totalTime = Duration.between(arrivalTime, leaveTime).toSeconds();
    }

/*     public int calculateParkedSeconds() {
        return (departueTime).getMinutesSince(arrivalTime);
    } */

    /* public double calculateFee() {
        return calculateParkedSeconds() * 2.00;
    } */

    @Override
    public String toString() {
        return "Car [License Plate: " + licensePlate + "owner:" + owner  + ", Arrival Time: " + arrivalTime  +   "departure time:" + leaveTime + "to pay: $" + (totalTime * 2) + ".00" + "]";
    }
}