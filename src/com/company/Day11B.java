package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Day11B {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("C:\\Users\\kanna\\Desktop\\GitHub\\advent-of-code\\src\\com\\company\\input\\Day11.txt");
        Scanner text = new Scanner(file);
        ArrayList<ArrayList<Character>> outer = new ArrayList<>();
        int row = 0;
        boolean[] isRowNotEmpty = new boolean[140];
        boolean[] isColNotEmpty = new boolean[140];
        HashMap<Integer,ArrayList<Integer>> galaxy = new HashMap<>();
        int n=0;
        while(text.hasNextLine()){
            String line = text.nextLine();
            ArrayList<Character> innner = new ArrayList<>();
            for (int i = 0; i < line.length(); i++) {
                innner.add(line.charAt(i));
                if(line.charAt(i)=='#') {
                    n++;
                    galaxy.put(n,new ArrayList<>());
                    galaxy.get(n).add(row);
                    galaxy.get(n).add(i);
                    isRowNotEmpty[row] = true;
                    isColNotEmpty[i] = true;
                }
            }
            outer.add(innner);
            row++;
        }
        System.out.println(galaxy);
        System.out.println(Arrays.toString(isRowNotEmpty));
        System.out.println(Arrays.toString(isColNotEmpty));
        System.out.println(outer);

        long totaldist = 0;
        for (int i = 1; i < n; i++) {
            for (int j = i+1; j <=n ; j++) {
                int row1 = galaxy.get(i).get(0);
                int col1 = galaxy.get(i).get(1);
                int row2 = galaxy.get(j).get(0);
                int col2 = galaxy.get(j).get(1);

                int minrow = Math.min(row1,row2);
                int maxrow = Math.max(row1,row2);
                int mincol = Math.min(col1,col2);
                int maxcol = Math.max(col1,col2);

                int dist = maxrow - minrow + maxcol - mincol;
                for (int k = minrow; k <= maxrow ; k++) {
                    if(!isRowNotEmpty[k]) dist+=1000000-1;
                }
                for (int k = mincol; k <= maxcol ; k++) {
                    if(!isColNotEmpty[k]) dist+=1000000-1;
                }
                System.out.println(i+" "+j+" "+dist);
                totaldist+=dist;
            }
        }
        System.out.println("The sum of the distance between all pairs of stars is "+totaldist);
    }
}
