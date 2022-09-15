import java.io.*;
import java.util.*;

public class solution{

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String s = scn.next();
        printSS(s, "",0);
    }

    public static void printSS(String s, String ans, int idx) {
        if(idx == s.length()){
            System.out.println(ans);
            return;
        }
        
        printSS(s,ans + s.charAt(idx), idx+1);
        printSS(s,ans, idx+1);
    }

}