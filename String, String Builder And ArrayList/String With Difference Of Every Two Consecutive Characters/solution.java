import java.io.*;
import java.util.*;

public class solution{

	public static String difference(String str){
		// write your code here
		StringBuilder sb = new StringBuilder();
		sb.append(str.charAt(0));
		for(int i = 1; i < str.length(); i++){
			char prev = str.charAt(i - 1);
			char curr = str.charAt(i); 
			int diff = curr - prev; 

			sb.append(diff); 
			sb.append(curr);
		}

		return sb.toString();
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(difference(str));
	}

}