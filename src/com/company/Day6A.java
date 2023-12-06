package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Day6A {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("C:\\Users\\kanna\\Desktop\\GitHub\\advent-of-code\\src\\com\\company\\input\\Day6.txt");
        Scanner text = new Scanner(file);
        while(text.hasNextLine()){
            String[] time=text.nextLine().split(":")[1].stripLeading().split("\s+");
            String[] dist=text.nextLine().split(":")[1].stripLeading().split("\s+");
            int tot=1;
            for (int i = 0; i < time.length; i++) {
                int c=0;
                int t=Integer.parseInt(time[i]);
                int d=Integer.parseInt(dist[i]);
                for (int j = 0; j <= t; j++) {
                    if(j*(t-j)>d) c++;
                }
                tot*=c;
            }
            System.out.println(tot);
        }

    }
}
