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
        int randum = (int) Math.floor(Math.random() * 1000 + 1);
            System.out.print( "rand num = " + randum);
            this.leaveTime = arrivalTime.plusSeconds(randum);
            totalTime = Duration.between( leaveTime , arrivalTime).toSeconds();


            Duration diference = Duration.between(arrivalTime, leaveTime);
            String durationString = diference.toString().replace("PT", " ").replace("H", " horas, ").replace("M", " minutos, ").replace("S", " segundos.");
            
            System.out.println(durationString);

            System.out.println( leaveTime  + " - " + arrivalTime  );
            System.out.print( "tiempo total: " + totalTime);
    }

/*     public int calculateParkedSeconds() {
        return (departueTime).getMinutesSince(arrivalTime);
    } */

    /* public double calculateFee() {
        return calculateParkedSeconds() * 2.00;
    } */

    @Override
    public String toString() {
        return "License Plate: " + licensePlate + "\n owner:" + owner  + "\n Arrival Time: " + arrivalTime  +   "\n departure time:" + leaveTime + "\n to pay: $" + ( Math.abs(totalTime)  * 2) + ".00" + "]\n \n";
    }
}