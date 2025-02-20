package com.ioprogramming.json.handsonpracticeproblem.converttojasonarray;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Arrays;
import java.util.List;

public class ConvertJavaObjectsListInJsonArray  {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Alice", 25),
                new Person("Bob", 30)
        );
        //method call
        String jsonArray = convertListToJson(people);
        System.out.println(jsonArray);
    }

    public static String convertListToJson(List<?> list) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            //convert list to json
            return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(list);
        } catch (Exception e) {
            e.printStackTrace();
            return "[]";
        }
    }
}

