package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Day4A {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("C:\\Users\\kanna\\Desktop\\GitHub\\advent-of-code\\src\\com\\company\\input\\Day4.txt");
        Scanner input = new Scanner(file);
        int sum=0;
        while(input.hasNextLine()){
            String line = input.nextLine();
            String[] split = line.split(":");

            String[] valStr=split[1].split("\\|");
//            System.out.println;
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
                        if(pts==0) pts++;
                        else pts*=2;
                    }
                }
            }
//            Arrays.sort(winarr);
//            Arrays.sort(valsarr);
//            System.out.println(pts);
            sum+=pts;
        }
        System.out.println(sum);

    }
}
