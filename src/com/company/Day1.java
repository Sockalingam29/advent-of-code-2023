package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
class Day1 {
    public static void main(String[] args) throws FileNotFoundException {
        HashMap<String, Integer> hm = new HashMap<>();

        hm.put("zero", 0);
        hm.put("one", 1);
        hm.put("two", 2);
        hm.put("three", 3);
        hm.put("four", 4);
        hm.put("five", 5);
        hm.put("six", 6);
        hm.put("seven", 7);
        hm.put("eight", 8);
        hm.put("nine", 9);

        File file = new File("C:\\Users\\kanna\\AppData\\Roaming\\JetBrains\\IdeaIC2021.2\\scratches\\input.txt");
        Scanner text = new Scanner(file);
        int tot=0;
        while (text.hasNextLine()) {
            String data = text.nextLine();
            int num=0;
            for (int i = 0; i < data.length(); i++) {
                if(data.charAt(i)>='0' && data.charAt(i)<='9'){
                    num=Character.getNumericValue(data.charAt(i));
                    break;
                }
                else if((data.length()-i)>=3 && hm.get(data.substring(i,i+3))!=null){
                    num+=hm.get(data.substring(i,i+3));
                    break;
                }
                else if((data.length()-i)>=4 && hm.get(data.substring(i,i+4))!=null){
                    num+=hm.get(data.substring(i,i+4));
                    break;
                }
                else if((data.length()-i)>=5 && hm.get(data.substring(i,i+5))!=null){
                    num+=hm.get(data.substring(i,i+5));
                    break;
                }
            }
            num*=10;
            for (int i=data.length()-1; i>=0; i--) {
                if(data.charAt(i)>='0' && data.charAt(i)<='9'){
                    num+=Character.getNumericValue(data.charAt(i));
                    break;
                }
                else if((i-2)>=0 && hm.get(data.substring(i-2,i+1))!=null){
                    num+=hm.get(data.substring(i-2,i+1));
                    break;
                }
                else if((i-3)>=0 && hm.get(data.substring(i-3,i+1))!=null){
                    num+=hm.get(data.substring(i-3,i+1));
                    break;
                }
                else if((i-4)>=0 && hm.get(data.substring(i-4,i+1))!=null){
                    num+=hm.get(data.substring(i-4,i+1));
                    break;
                }
            }
            tot+=num;
        }
        System.out.println(tot);

    }
}