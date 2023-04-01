package com.spring.familymanagement.parte1;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ListsService {

    public Student[] invertArray(Student[] studentList) {
        int listSize = studentList.length;
        Student[] invertedList = new Student[listSize];
        for (int i = 0; i < listSize; i++) {
            invertedList[i] = studentList[listSize - 1 - i];
        }
        return invertedList;
    }

    public Student[] invertArrayInPlace(Student[] studentList) {
        int listSize = studentList.length;
        int halfListSize = listSize/2;
        for (int i = 0; i < halfListSize; i++) {
            Student student = studentList[i];
            studentList[i] = studentList[listSize - 1 - i];
            studentList[listSize - 1 - i] = student;
        }
        return studentList;
    }

    public List<Student> invertListInPlace(List<Student> studentList) {
        Collections.reverse(studentList);
        return studentList;
    }

    public List<String[]> convertCSV() {
        List<String[]> records = new ArrayList<>();
        String file = "mmsa-icu-beds.csv";
        String line = "";
        String comma = ",";

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));

            while ((line = br.readLine()) != null) {
                String[] values = line.split(comma);
                records.add(values);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return records;
    }
}
