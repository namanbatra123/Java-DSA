import java.io.*;
import java.util.*;

public class solution{

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in); 
        String str = scn.next();
        printEncodings(str, ""); 
    }

    public static void printEncodings(String str, String psf) {
        if(str.length() == 0){
            System.out.println(psf); 
            return; 
        }

        if(str.charAt(0) == '0'){
            return; 
        }

        char ch = (char)((str.charAt(0) - '1') + 'a');
        printEncodings(str.substring(1), psf + ch);

        if(str.length() > 1){
            int num = ((str.charAt(0) - '0') * 10 + str.charAt(1) - '1');
            if(num <= 26){
                char ch1 = (char)(num + 'a');
                printEncodings(str.substring(2), psf + ch1);
            }
            return;
        }
    }

}