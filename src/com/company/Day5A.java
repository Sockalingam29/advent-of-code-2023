package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Day5A {
    static Scanner in = new Scanner(System.in);

    static void mapping(ArrayList<ArrayList<Long>> hm, long dest, long src, long range){
        while(true){
            dest=in.nextLong();
            if(dest==-1) break;
            src=in.nextLong();
            range=in.nextLong();

            ArrayList<Long> inner = new ArrayList<>();
            inner.add(dest);
            inner.add(src);
            inner.add(range);

            hm.add(inner);
        }

    }

    static long helper(long seed, ArrayList<ArrayList<Long>> arr){
        boolean flag;
        for (int i = 0; i < arr.size(); i++) {
            long dest=arr.get(i).get(0);
            long src=arr.get(i).get(1);
            long range=arr.get(i).get(2);

            if(seed>=src && seed<=src+range){
                flag=true;
                return seed+(dest-src);
            }
        }
        return seed;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Long>> seedsoil = new ArrayList<>();
        ArrayList<ArrayList<Long>> soilfert = new ArrayList<>();
        ArrayList<ArrayList<Long>> fertwater = new ArrayList<>();
        ArrayList<ArrayList<Long>> waterlight = new ArrayList<>();
        ArrayList<ArrayList<Long>> lighttemp = new ArrayList<>();
        ArrayList<ArrayList<Long>> temphum = new ArrayList<>();
        ArrayList<ArrayList<Long>> humloc = new ArrayList<>();

        long dest=-1;
        long src=-1;
        long range=0;
        System.out.println("Seed soil");
        mapping(seedsoil,dest,src,range);

        System.out.println("Soil fert");
        mapping(soilfert,dest,src,range);

        System.out.println("fert water");
        mapping(fertwater,dest,src,range);

        System.out.println("waterlight");
        mapping(waterlight,dest,src,range);

        System.out.println("lighttemp");
        mapping(lighttemp,dest,src,range);

        System.out.println("temphum");
        mapping(temphum,dest,src,range);

        System.out.println("humloc");
        mapping(humloc,dest,src,range);

        long min=Long.MAX_VALUE;
        while(true){
            long seed=in.nextLong();

            if(seed==-1) break;

            long soil = helper(seed,seedsoil);
            long fert = helper(soil,soilfert);
            long water = helper(fert,fertwater);
            long light = helper(water,waterlight);
            long temp = helper(light,lighttemp);
            long hum = helper(temp,temphum);
            long loc = helper(hum,humloc);


//            long fert = soilfert.get(soil)!=null ? soilfert.get(soil) : soil;
//            long water = fertwater.get(fert)!=null ? fertwater.get(fert) : fert;
//            long light = waterlight.get(water)!=null ? waterlight.get(water) : water;
//            long temp = lighttemp.get(light)!=null ? lighttemp.get(light) :light;
//            long hum = temphum.get(temp)!=null ? temphum.get(temp) : temp;
//            long loc = humloc.get(hum)!=null ? humloc.get(hum) : hum;

            System.out.println(loc);
            min=Math.min(min,loc);

        }
        System.out.println(min);

    }
}
