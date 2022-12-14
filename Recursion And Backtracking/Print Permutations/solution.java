import java.io.*;
import java.util.*;

public class solution{

    public static void main(String[] args) throws Exception{
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        printPermutations(str, "");
    }

    public static void printPermutations(String ques, String ans) {
        if(ques.length() == 0){
            System.out.println(ans);
            return;
        }
        
        for(int i = 0; i < ques.length(); i++){
            char ch = ques.charAt(i); 
            printPermutations(ques.substring(0, i) + ques.substring(i + 1), ans + ch);
            
        }
    }

}