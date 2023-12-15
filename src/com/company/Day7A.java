package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Day7A {
    static HashMap<Character, Integer> hashMap = new HashMap<>();



    static int findRank(HashMap<Character,Integer> h){
        if(h.size()==1) return 7;
        if(h.size()==2){
            for(Character c:h.keySet()){
                if(h.get(c)==1 || h.get(c)==4) return 6;
                else return 5;
            }
        }
        if(h.size()==3){
            for(Character c:h.keySet()){
                if(h.get(c)==3) return 4;
            }
            return 3;
        }
        if(h.size()==4) return 2;
        return 1;
    }
    static boolean isRankLesser(String s1, String s2){
        HashMap<Character,Integer> h1=new HashMap<>();
        HashMap<Character,Integer> h2=new HashMap<>();
        int r1=0,r2=0;
        for (int i = 0; i < s1.length(); i++) {
            h1.put(s1.charAt(i),h1.getOrDefault(s1.charAt(i),0)+1);
        }
        for (int i = 0; i < s2.length(); i++) {
            h2.put(s2.charAt(i),h2.getOrDefault(s2.charAt(i),0)+1);
        }
        r1=findRank(h1);
        r2=findRank(h2);

        if(r1>r2) return true;
        if(r1<r2) return false;
        if(r1==r2){
            for (int i = 0; i < s1.length(); i++) {
                if(hashMap.get(s1.charAt(i))>hashMap.get(s2.charAt(i))) return true;
                if(hashMap.get(s1.charAt(i))<hashMap.get(s2.charAt(i))) return false;

            }
        }
        return false;
    }
    public static void main(String[] args) throws FileNotFoundException {
        hashMap.put('A', 14);
        hashMap.put('K', 13);
        hashMap.put('Q', 12);
        hashMap.put('J', 11);
        hashMap.put('T', 10);
        hashMap.put('9', 9);
        hashMap.put('8', 8);
        hashMap.put('7', 7);
        hashMap.put('6', 6);
        hashMap.put('5', 5);
        hashMap.put('4', 4);
        hashMap.put('3', 3);
        hashMap.put('2', 2);

        File file = new File("C:\\Users\\kanna\\Desktop\\GitHub\\advent-of-code\\src\\com\\company\\input\\Day7.txt");
        Scanner text = new Scanner(file);
        ArrayList<String> hands = new ArrayList<>();
        ArrayList<Integer> bid = new ArrayList<>();
        while (text.hasNextLine()) {
            String[] line = text.nextLine().split(" ");
            hands.add(line[0]);
            bid.add(Integer.parseInt(line[1]));
        }
        for(int i=0;i<hands.size();i++){
            for(int j=i+1;j<hands.size();j++){
                if(isRankLesser(hands.get(i),hands.get(j))){
                    String temp=hands.get(i);
                    hands.set(i,hands.get(j));
                    hands.set(j,temp);
                    int temp2=bid.get(i);
                    bid.set(i,bid.get(j));
                    bid.set(j,temp2);
                }

            }
        }
        long winnings=0;
        for(int i=0;i<hands.size();i++){
            winnings+=(long)bid.get(i)*(i+1);
        }
        System.out.println(winnings);
    }
}
