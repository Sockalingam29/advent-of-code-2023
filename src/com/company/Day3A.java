package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day3A {
    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("C:\\Users\\kanna\\Desktop\\GitHub\\advent-of-code\\src\\com\\company\\input\\Day3.txt");
        Scanner text = new Scanner(file);
        int tot=0;
        int c=0;
        int j=0;
        char [][] vals=new char[140][140];
        int [][] times = new int[140][140];
        int [][] total = new int[140][140];

        while (text.hasNextLine()) {
            String line = text.nextLine();
            for (int i = 0; i < line.length(); i++) {
                vals[j][i]=line.charAt(i);
            }
            j++;
        }
        int sum=0;
        for (int i = 0; i < vals.length; i++) {
            for ( j = 0; j < vals[i].length; j++) {
                int num=0;
                boolean flag=false;
                while(j<vals[i].length && Character.isDigit(vals[i][j])){
                    num=(num*10)+Character.getNumericValue(vals[i][j]);

                    if((i-1>=0 && vals[i-1][j]!='.' && !Character.isDigit(vals[i-1][j])) ||
                            (i-1>=0 && j-1>=0 && vals[i-1][j-1]!='.' && !Character.isDigit(vals[i-1][j-1])) ||
                            (j-1>=0 && vals[i][j-1]!='.' && !Character.isDigit(vals[i][j-1])) ||
                            (i+1<vals.length && j-1>=0 && vals[i+1][j-1]!='.' && !Character.isDigit(vals[i+1][j-1])) ||
                            (i+1<vals.length && vals[i+1][j]!='.' && !Character.isDigit(vals[i+1][j])) ||
                            (i+1<vals.length && j+1<vals[i].length && vals[i+1][j+1]!='.' && !Character.isDigit(vals[1+i][j+1])) ||
                            (j+1<vals[i].length && vals[i][j+1]!='.' && !Character.isDigit(vals[i][j+1])) ||
                            (j+1<vals[i].length && i-1>=0 && vals[i-1][j+1]!='.' && !Character.isDigit(vals[i-1][j+1])) ){
                    flag=true;

                    }
                    j++;
                }
                if(flag && num>0) {
                    System.out.println(num);
                    sum+=num;
                }
            }
        }
        System.out.println(sum);
    }

}
