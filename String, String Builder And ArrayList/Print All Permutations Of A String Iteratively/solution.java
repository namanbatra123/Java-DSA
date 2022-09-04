import java.io.*;
import java.util.*;

public class solution {

	public static void printPermutations(String str){
		// write your code here
		int n = str.length(); 
		int f = factorial(n);

		for(int i = 0; i < f; i++){
			int temp = i; 

			StringBuilder sb = new StringBuilder(str);
			for(int div = n; div >= 1; div--){
				int q = temp / div; 
				int rem = temp % div; 

				System.out.print(sb.charAt(rem));
				sb.deleteCharAt(rem);
				temp = q;	
			}

			System.out.println();
		}
				
	}

	public static int factorial(int n){
		int ans = 1;
		for(int i = 2; i <= n; i++){
			ans *= i; 
		}
		return ans;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		printPermutations(str);
	}

}