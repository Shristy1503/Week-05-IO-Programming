package com.ioprogramming.json.practiceproblems.createjsonobject;
import org.json.JSONArray;
import org.json.JSONObject;
public class CreateJsonObject {
    public static void main(String[] args) {
       //create json object variable and call it
        JSONObject student = createObject("Shristy mishra", 21, new String[]{"go", "java", "c++"});
        System.out.println(student.toString(4));
    }
    //method to create object of json
    public static JSONObject createObject(String name, int age, String[] subjects){
        //create json object
        JSONObject students = new JSONObject();
        //jason array
        students.put("subjects", new JSONArray(subjects));
        students.put("name", name);
        students.put("age", age);

        return students;
    }
}
