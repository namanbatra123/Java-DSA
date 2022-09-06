import java.io.*;
import java.util.*;

public class solution{

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String n = scn.next();
        String[] map = {".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};
        ArrayList<String> ans = getKPC(n, map);
        System.out.println(ans);
    }

    public static ArrayList<String> getKPC(String str, String[] map) {
        if(str.length() == 0){
            ArrayList<String> bcase = new ArrayList<>();
            bcase.add("");
            return bcase;
        }

        int key = str.charAt(0) - '0';
        String op = map[key];
        ArrayList<String> recAns = getKPC(str.substring(1), map); 
        ArrayList<String> finalAns = new ArrayList<>(); 

        for(int i = 0; i < op.length(); i++){
            for(int j = 0; j < recAns.size(); j++){
                finalAns.add(op.charAt(i) + recAns.get(j));
            }
        }

        return finalAns;
    }

}