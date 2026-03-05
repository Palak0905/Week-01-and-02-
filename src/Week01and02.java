import java.util.*;

class Spot{
    String plate;
    long entry;
}

public class Week01and02 {

    static Spot[] table=new Spot[500];

    static int hash(String s){
        return Math.abs(s.hashCode())%500;
    }

    static int parkVehicle(String plate){
        int h=hash(plate);
        int probes=0;
        while(table[h]!=null){
            h=(h+1)%500;
            probes++;
        }
        table[h]=new Spot();
        table[h].plate=plate;
        table[h].entry=System.currentTimeMillis();
        System.out.println("Assigned "+h+" probes "+probes);
        return h;
    }

    static void exitVehicle(String plate){
        for(int i=0;i<500;i++){
            if(table[i]!=null && table[i].plate.equals(plate)){
                long t=(System.currentTimeMillis()-table[i].entry)/1000;
                table[i]=null;
                System.out.println("Freed "+i+" duration "+t);
                return;
            }
        }
    }

    public static void main(String[] args){
        parkVehicle("ABC1234");
        parkVehicle("ABC1235");
        exitVehicle("ABC1234");
    }
}