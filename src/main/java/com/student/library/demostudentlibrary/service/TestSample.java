package com.student.library.demostudentlibrary.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestSample {
    public static void main(String[] args) throws ParseException {
        Date currentDate = new Date();//Mon Apr 17 23:06:07 PDT 2023
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd hh:mm:ss");
        String formattedDate = formatter.format(currentDate);
        System.out.println(formattedDate);
        currentDate = formatter.parse(formattedDate);
        System.out.println(currentDate);//Mon Apr 17 11:06:40 PDT 2023
    }
}
