import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in); 
        String str = scn.next(); 

        HashMap<Character, Integer> map = new HashMap<>(); 

        for(int i = 0; i < str.length(); i++){
            if(map.containsKey(str.charAt(i)) == false){
                map.put(str.charAt(i), 1);
            }
            else{
                int freq = map.get(str.charAt(i)) + 1;
                map.put(str.charAt(i), freq);
            }
        }
        
        char temp = str.charAt(0); 
        for(int i = 0; i < str.length(); i++){
            if(map.get(str.charAt(i)) > map.get(temp)){
                temp = str.charAt(i);
            }
        }

        System.out.println(temp);
    }

}