import java.io.*;
import java.util.*;

public class solution{

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in); 
        int n = scn.nextInt(); 
        int m = scn.nextInt(); 
        ArrayList<String> ans = getMazePaths(0, 0, n-1, m-1); 
        System.out.print(ans);        
    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {
        if(sr == dr && sc == dc){
            ArrayList<String> bcase = new ArrayList<>(); 
            bcase.add("");
            return bcase;
        }   

        ArrayList<String> hpath = new ArrayList<>(); 
        ArrayList<String> vpath = new ArrayList<>(); 
        ArrayList<String> ans = new ArrayList<>(); 

        if(sc < dc){
            hpath = getMazePaths(sr, sc + 1, dr, dc);
        }
        
        if(sr < dr){
            vpath = getMazePaths(sr + 1, sc, dr, dc);
        }

        for(String path: hpath){
            ans.add('h' + path);
        }
        
        for(String path: vpath){
            ans.add('v' + path);
        }

        return ans; 
    }

}