package com.interswitch.customer.convertToJson;

//public class ConvertJavaToJason {
//}

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class ConvertJavaToJason {
    public static void main(String[] args) throws IOException {
//        convertJsonToObj();
        convertJsonToObjs();

    }

    public static void convertJsonToObj() throws IOException {
        File f = new File("OneJavaToJson.json");
        ObjectMapper mapper= new ObjectMapper();
        Student students= mapper.readValue(f, Student.class);
        System.out.println(students);
    }
    public static void convertJsonToObjs() throws IOException {
        File f = new File("JavaToJson.json");
        ObjectMapper mapper= new ObjectMapper();
        Student[] students = mapper.readValue(f, Student[].class);
        for (Student s: students) {
            System.out.println(s);
        }
    }
}