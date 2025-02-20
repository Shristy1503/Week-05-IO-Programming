package com.ioprogramming.json.practiceproblems.mergejsonobjects;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class MergeTwoJsonObjects {
    public static void main(String[] args) {
    // call method
        mergeObjects();
    }
    //method to create json object and merge them
    public static void mergeObjects(){
        //create first object
        JSONObject object1 = new JSONObject();
        object1.put("name", "shristy");
        object1.put("age", "21");
        object1.put("subject", "java");
        //create object 2
        //create first object
        JSONObject object2 = new JSONObject();
        object2.put("subject", "c++");
        object2.put("email", "shriimishra14@gmail.com");
        //merge the objects into one
        Map<String, Object> merged = new HashMap<>(object1.toMap());
        merged.putAll(object2.toMap());
        //create new object of json
        JSONObject mergedObject = new JSONObject(merged);
        System.out.println(mergedObject.toString());

    }
}
