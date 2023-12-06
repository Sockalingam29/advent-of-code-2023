package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Day6B {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("C:\\Users\\kanna\\Desktop\\GitHub\\advent-of-code\\src\\com\\company\\input\\Day6.txt");
        Scanner text = new Scanner(file);
        while(text.hasNextLine()){
            String[] time=text.nextLine().split(":")[1].stripLeading().split("\s+");
            String[] dist=text.nextLine().split(":")[1].stripLeading().split("\s+");
            String strtime="",strdist="";
            for (int i = 0; i < time.length; i++) {
                strtime+=time[i];
                strdist+=dist[i];
            }
            long t=Long.parseLong(strtime);
            long d=Long.parseLong(strdist);
            System.out.println(t+" "+d);
            int tot=1;
            int c=0;
            for (int j = 0; j <= t; j++) {
                if(j*(t-j)>d) c++;
            }
            System.out.println(c);
        }

    }
}
