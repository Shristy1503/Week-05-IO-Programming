package com.ioprogramming.json.practiceproblems.convertjavafiletojasonobject;

public class Car {
    private String name;
    private String manufactureDate;
    private double price;
    //constructor
    public Car(String name, String manufactureDate, double price){
        this.name = name;
        this.manufactureDate = manufactureDate;
        this.price = price;
    }
    //getter method
    public String getName(){
      return name;
    }
    public String getManufactureDate(){
        return manufactureDate;
    }
    public double getPrice(){
        return price;
    }
}
