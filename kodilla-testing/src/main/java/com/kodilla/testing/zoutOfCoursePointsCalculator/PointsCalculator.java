package com.kodilla.testing.zoutOfCoursePointsCalculator;

import java.util.ArrayList;
import java.util.List;

public class PointsCalculator {
    public static void main(String[] args) {
        List<Integer> pointAll = new ArrayList<>();
        List<Integer> myPints = new ArrayList<>();

        //http
        pointAll.add(200);
        myPints.add(160);

        //dns
        pointAll.add(200);
        myPints.add(160);

        //zad1
        pointAll.add(400);
        myPints.add(0);

        //tcp
        pointAll.add(200);
        myPints.add(0);

        //dijkstra
        pointAll.add(200);
        myPints.add(200);
//
//        //teoria
//        pointAll.add(1000);
//        myPints.add();
//
//        //icmp
//        pointAll.add(200);
//        myPints.add();
//
//        //adresacjaIP
//        pointAll.add(300);
//        myPints.add();
//
//        //cross
//        pointAll.add(500);
//        myPints.add();
//
//        //project1
//        pointAll.add(400);
//        myPints.add();
//
//        //project2
//        pointAll.add(400);
//        myPints.add();

        int allPoints = 0;
        int myPoints = 0;

        for (int i = 0; i < pointAll.size(); i++) {
            allPoints += pointAll.get(i);
        }

        for (int i = 0; i < myPints.size(); i++) {
            myPoints += myPints.get(i);
        }

        int percent;
        percent = myPoints * 100 / allPoints;


        System.out.println("U got: " + myPoints + " out of: " + allPoints);
        System.out.println("so u got: " + percent + "%");


        if(myPoints >= allPoints/2){
            System.out.println("u pass^^");
        }else{
            int need;
            need = allPoints/2 - myPoints;
            System.out.println("u need: " + need + " points more to pass this shit");
            System.out.println("good luck");

        }


    }
}
