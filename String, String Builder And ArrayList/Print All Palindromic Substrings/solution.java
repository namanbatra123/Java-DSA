import java.io.*;
import java.util.*;

public class solution {

	public static void solution(String str){
		for(int i = 0; i < str.length(); i++){
		    for(int j = i + 1; j <= str.length(); j++){
		        String sub = str.substring(i, j); 
		        
		        boolean ispalindrome = IsPalindrome(sub); 
		        if(ispalindrome){
		            System.out.println(sub);   
		        }
		    }
		}
		
	}
	
	public static boolean IsPalindrome(String sub){
	    boolean flag = true; 
	    int left = 0; 
	    int right = sub.length() - 1;  
	    while(left < right){
	        if(sub.charAt(left) != sub.charAt(right)){
	            flag = false; 
	            break;
	        }
	        
	        left++; 
	        right--; 
	    }
	    return flag; 
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		solution(str);
	}

}