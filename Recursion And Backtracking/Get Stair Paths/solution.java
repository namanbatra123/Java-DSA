import java.io.*;
import java.util.*;

public class solution{

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in); 
        int n = scn.nextInt(); 
        ArrayList<String> ans = getStairPaths(n); 
        System.out.print(ans);
    }

    public static ArrayList<String> getStairPaths(int n) {
        if(n == 0){
            ArrayList<String> bcase = new ArrayList<>(); 
            bcase.add(""); 
            return bcase;
        }
        else if(n < 0){
            ArrayList<String> negcase = new ArrayList<>(); 
            return negcase;
        }

        ArrayList<String> ans = new ArrayList<>(); 

        ArrayList<String> path1 = getStairPaths(n-1);
        ArrayList<String> path2 = getStairPaths(n-2);
        ArrayList<String> path3 = getStairPaths(n-3);

        for(String path: path1){
            ans.add('1' + path);
        }
        
        for(String path: path2){
            ans.add('2' + path);
        }

        for(String path: path3){
            ans.add('3' + path);
        }

        return ans;
    }

}