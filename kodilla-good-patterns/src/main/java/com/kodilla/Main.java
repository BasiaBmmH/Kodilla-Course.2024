package com.kodilla;

public class Main {
    public static void main(String[] args) {

        double ALGpoints = 12 + 7 + 10;
        double ALGmax = 4 * 25;

        double SKJpoints = 200 + 150 + 160 + 160 + 40 + 650  ;
        double SKJmax = 200 + 200 + 400 + 200 + 1000 + 200 + 200 + 300 + 500 + 400 + 400;
//        points - x
//        max - 100


        System.out.println(ALGpoints*100/ALGmax);
        System.out.println(ALGmax/2);
        System.out.println(ALGpoints);
        System.out.println("ASD brakuje: " + (ALGmax/2 - ALGpoints));

        System.out.println();

        System.out.println(SKJpoints*100/SKJmax);
        System.out.println(SKJmax/2);
        System.out.println(SKJpoints);
        System.out.println("SKJ brakuje: " + (SKJmax/2 - SKJpoints));
    }
}