package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
class Day2B {
    public static void main(String[] args) throws FileNotFoundException {
        HashMap<String, Integer> hm = new HashMap<>();

        File file = new File("C:\\Users\\kanna\\Desktop\\GitHub\\advent-of-code\\src\\com\\company\\input\\Day2.txt");
        Scanner text = new Scanner(file);
        int tot=0;
        while (text.hasNextLine()) {
            String line = text.nextLine();
            String[] split = line.split(":");
            int id=Integer.parseInt(split[0].split(" ")[1]);

            String valStr=split[1].stripLeading();

            String[] set = valStr.split("; ");

            int minRed =0,minBlue=0,minGreen=0;


            for (int i = 0; i < set.length; i++) {
                String[] ball = set[i].split(", ");
                for (int j = 0; j < ball.length; j++) {
                    String[] color = ball[j].split(" ");
                    String colorVal = color[1];
                    int count = Integer.parseInt(color[0]);
                    if(colorVal.equals("red")){
                        minRed=Math.max(count,minRed);
                    }
                    else if(colorVal.equals("green")){
                        minGreen=Math.max(count,minGreen);
                    }
                    else{
                        minBlue=Math.max(count,minBlue);
                    }
                }

            }
            tot+=(minRed*minBlue*minGreen);
            System.out.println(tot);
        }
    }
}