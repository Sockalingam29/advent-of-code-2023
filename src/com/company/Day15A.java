package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day15A {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("C:\\Users\\kanna\\Desktop\\GitHub\\advent-of-code\\src\\com\\company\\input\\Day15.txt");
        Scanner text = new Scanner(file);
        String[] input = text.nextLine().split(",");
        int sum=0;
        for (int i = 0; i < input.length; i++) {
            int curr=0;
            for(int j=0;j<input[i].length();j++){
                curr+=(int)input[i].charAt(j);
                curr=(curr*17)%256;
            }
//            System.out.println(curr);
            sum+=curr;
        }
        System.out.println(sum);
    }
}
