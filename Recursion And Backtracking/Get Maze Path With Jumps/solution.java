import java.io.*;
import java.util.*;

public class solution{

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in); 
        int n = scn.nextInt(); 
        int m = scn.nextInt(); 
        ArrayList<String> ans = getMazePaths(1, 1 , n, m); 
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

        ArrayList<String> ans = new ArrayList<>(); 

        // Horizontal moves 
        for(int h = 1; h <= dc - sc; h++){
            ArrayList<String> hpath = getMazePaths(sr, sc + h, dr, dc);
            for(String path: hpath){
                ans.add("h" + h + path);
            }
        }

        // Vertical moves
        for(int v = 1; v <= dr - sr; v++){
            ArrayList<String> vpath = getMazePaths(sr + v, sc, dr, dc);
            for(String path: vpath){
                ans.add("v" + v + path);
            }
        }

        // Diagonal moves 
        for(int d = 1; d <= dc - sc  && d <= dr - sr; d++){
            ArrayList<String> dpath = getMazePaths(sr + d, sc + d, dr, dc);
            for(String path: dpath){
                ans.add("d" + d + path);
            }
        }

        return ans;

                
    }

}