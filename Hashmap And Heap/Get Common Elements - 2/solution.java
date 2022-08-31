import java.io.*;

import java.util.*;

public class solution {

  public static void main(String[] args) throws Exception {
	  //Write your code here
    Scanner scn = new Scanner(System.in);
    int n1 = scn.nextInt();
    int[] arr1 = new int[n1]; 
    for(int i = 0; i < n1; i++){
      arr1[i] = scn.nextInt();
    }

    int n2 = scn.nextInt(); 
    int[] arr2 = new int[n2];
    for(int i = 0; i < n2; i++){
      arr2[i] = scn.nextInt(); 
    }

    HashMap<Integer, Integer> map = new HashMap<>();
    for(int i = 0; i < n1; i++){
        if(map.containsKey(arr1[i]) == false){
            map.put(arr1[i], 1);
        }
        else{
            int nfreq = map.get(arr1[i]) + 1;
            map.put(arr1[i], nfreq);
        }
    }

    for(int val: arr2){
      if(map.containsKey(val) == true && map.get(val) > 0){
        System.out.println(val);

        int freq = map.get(val) - 1; 
        map.put(val, freq);
      }
    }

  }

}