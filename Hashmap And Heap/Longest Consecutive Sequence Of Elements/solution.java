import java.io.*;
import java.util.*;

public class solution{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn = new Scanner(System.in); 
    int n = scn.nextInt(); 
    int[] a = new int[n];
    for(int i = 0; i < n; i++){
        a[i] = scn.nextInt();
    }

    HashMap<Integer, Boolean> map = new HashMap<>();
    for(int i = 0; i < n; i++){
        map.put(a[i], true);
    }

    for(int val: a){
        if(map.containsKey(val - 1) == true){
            map.put(val, false);
        }
    }

    int mlen = 0; 
    int msp = 0; 
    for(int val: a){
        if(map.get(val) == true){
            int tsp = val; 
            int tlen = 1;

            while(map.containsKey(tsp+tlen) == true){
                tlen++; 
            }

            if(tlen > mlen){
                msp = tsp; 
                mlen = tlen;
            }
        }
    }

    for(int i = 0; i < mlen; i++){
        System.out.println(msp + i);
    }


 }

}