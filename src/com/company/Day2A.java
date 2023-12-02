package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
class Day2A {
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

            boolean flag = false;
            for (int i = 0; i < set.length; i++) {
                String[] ball = set[i].split(", ");
                for (int j = 0; j < ball.length; j++) {
                    String[] color = ball[j].split(" ");
                    String colorVal = color[1];
                    int count = Integer.parseInt(color[0]);
                    //12 red cubes, 13 green cubes, and 14 blue cubes
//                    System.out.println(colorVal);
                    if((colorVal.equals("red") && count>12) || (colorVal.equals("green") && count>13) || (colorVal.equals("blue") && count>14) ) {
                        flag = true;
                        break;
                    }
                }

            }
            if(!flag) tot+=id;
            System.out.println(tot);
        }
    }
}