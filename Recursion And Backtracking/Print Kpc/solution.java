import java.io.*;
import java.util.*;

public class solution{

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in); 
        String str = scn.nextLine(); 
        String[] map = {".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};
        
        printKPC(str, "", map);
    }

    public static void printKPC(String str, String asf, String[] map) {
        if(str.length() == 0){
            System.out.println(asf);
            return;
        }
        int key = str.charAt(0) - '0';
        String opt = map[key]; 
        for(int i = 0; i < opt.length(); i++){
            char ch = opt.charAt(i);
            printKPC(str.substring(1), asf + ch, map);
        }
    }

}