package com.ioprogramming.json.practiceproblems.convertjavafiletojasonobject;
import org.json.JSONObject;

public class ConvertJavaObjectToJson {
    public static void main(String[] args) {
        //create object of car
        Car car = new Car("Mustang", "14/02/2027", 40000 );
        //convert the java object to jason format
        JSONObject jsonCar = convertToJson(car);
        System.out.println(jsonCar);

    }
    //method to convert to json format
    public static JSONObject convertToJson(Car car){
        //creste json object
        JSONObject object = new JSONObject();
        //add the car details value
        object.put("brand ", car.getName());
        object.put("date", car.getManufactureDate());
        object.put("price", car.getPrice());
        return object;
    }
}
