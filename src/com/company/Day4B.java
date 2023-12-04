package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Day4B {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("C:\\Users\\kanna\\Desktop\\GitHub\\advent-of-code\\src\\com\\company\\input\\Day4.txt");
        Scanner input = new Scanner(file);
        int sum=0;
        int[] arr= new int[210];
        int lineNum=1;
        while(input.hasNextLine()){
            arr[lineNum]++;
            String line = input.nextLine();
            String[] split = line.split(":");

            String[] valStr=split[1].split("\\|");

            String[] win = valStr[0].stripLeading().split("\\s{1,2}");
            String[] vals = valStr[1].stripLeading().split("\\s{1,2}");
            int[] winarr= new int[win.length];
            int[] valsarr= new int[vals.length];
            for (int i = 0; i < win.length; i++) {
                winarr[i]=Integer.parseInt(win[i]);
            }
            for (int i = 0; i < vals.length; i++) {
                valsarr[i]=Integer.parseInt(vals[i]);
            }
            int pts=0;
            for (int i = 0; i < winarr.length; i++) {
                for (int j = 0; j < valsarr.length; j++) {
                    if(winarr[i]==valsarr[j]){
                        pts++;
                    }
                }
            }
            for(int i=lineNum+1;i<=lineNum+pts;i++)
                arr[i]+=arr[lineNum];
            lineNum++;

        }
        for (int i = 0; i < arr.length; i++) {
            sum+=arr[i];
        }
        System.out.println(sum);

    }
}
