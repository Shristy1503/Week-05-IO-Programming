package com.ioprogramming.json.practiceproblems.convertlistofjavaobjecttojson;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Arrays;
import java.util.List;

public class ConvertJavaObjectsListToJsonArray {
    public static void main(String[] args) {
        // create a list of objects
        List<Person> people = createPersonList();

        // convert list to JSON array
        String jsonArray = convertListToJson(people);

        //display
        System.out.println(jsonArray);
    }
    //method to creare list of person
    public static List<Person> createPersonList() {
        return Arrays.asList(
                new Person("Shristy", 25),
                new Person("Arjun", 30),
                new Person("Nancy", 28)
        );
    }

    // Method to convert a list of objects to JSON
    public static String convertListToJson(List<Person> list) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(list);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
