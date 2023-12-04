package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day3B {
    public static void main(String[] args) throws FileNotFoundException {
        Map<String, List<Integer>> hm = new HashMap<>();
        File file = new File("C:\\Users\\kanna\\Desktop\\GitHub\\advent-of-code\\src\\com\\company\\input\\Day3.txt");
        Scanner text = new Scanner(file);
        int tot=0;
        int c=0;
        int j=0;
        char [][] vals=new char[140][140];
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
                int l=-1,r=-1;
                while(j<vals[i].length && Character.isDigit(vals[i][j])){
                    num=(num*10)+Character.getNumericValue(vals[i][j]);


                    if(i-1>=0 && vals[i-1][j]=='*'){
                        l=i-1; r=j;
                    }
                    else if(i-1>=0 && j-1>=0 && vals[i-1][j-1]=='*'){
                        l=i-1; r=j-1;
                    }
                    else if(j-1>=0 && vals[i][j-1]=='*'){
                        l=i;r=j-1;
                    }
                    else if(i+1<vals.length && j-1>=0 && vals[i+1][j-1]=='*'){
                        l=i+1;r=j-1;
                    }
                    else if(i+1<vals.length && vals[i+1][j]=='*'){
                        l=i+1;r=j;
                    }
                    else if (i+1<vals.length && j+1<vals[i].length && vals[i+1][j+1]=='*'){
                        l=i+1;r=j+1;
                    }
                    else if(j+1<vals[i].length && vals[i][j+1]=='*'){
                        l=i;r=j+1;
                    }
                    else if(j+1<vals[i].length && i-1>=0 && vals[i-1][j+1]=='*' ){
                        l=i-1;r=j+1;
                    }
                    j++;
                }

                if(l!=-1){
                    String key=l+"."+r;
                    if(hm.get(key)==null){
                        List<Integer> ls = new ArrayList<>();
                        ls.add(num);
                        hm.put(key,ls);
                    }
                    else hm.get(key).add(num);
                }

            }
        }

        for (String key: hm.keySet()){
            if(hm.get(key).size()==2){
                sum+=(hm.get(key).get(0) * hm.get(key).get(1));
            }
        }
        System.out.println(sum);
    }
}
