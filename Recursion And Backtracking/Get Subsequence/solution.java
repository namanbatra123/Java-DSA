import java.io.*;
import java.util.*;

public class solution{

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in); 
        String str = scn.next(); 
        ArrayList<String> res = gss(str);
        System.out.println(res);
    }

    public static ArrayList<String> gss(String str) {
        if(str.length() == 0){
            ArrayList<String> bcase = new ArrayList<>();
            bcase.add(""); 
            return bcase;
        }

        char ch = str.charAt(0); 
        String rest = str.substring(1); 

        ArrayList<String> rres = gss(rest); // [--, -c, -b, bc]

        ArrayList<String> mres = new ArrayList<>();

        for(String st: rres){
            mres.add("" + st);
        }

        for(String st: rres){
            mres.add(ch + st);
        }
        return mres;
    }

}