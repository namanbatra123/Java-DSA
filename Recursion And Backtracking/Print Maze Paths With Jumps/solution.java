import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in); 
        int n = scn.nextInt(); 
        int m = scn.nextInt(); 
        printMazePaths(1, 1, n, m, "");
    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static void printMazePaths(int sr, int sc, int dr, int dc, String psf) {
        if(sr == dr && sc == dc){
            System.out.println(psf);
            return;
        }
        
        // horizontal moves
        for(int hz = 1; hz <= dc - sc; hz++){
            printMazePaths(sr, sc + hz, dr, dc, psf + 'h' + hz);
        }
        
        // vertical moves
        for(int vc = 1; vc <= dr - sr; vc++){
            printMazePaths(sr + vc, sc, dr, dc, psf + 'v' + vc);
        }
        
        //diagonal moves
        for(int dg = 1; dg <= dc - sc && dg <= dr - sr; dg++){
            printMazePaths(sr + dg, sc + dg, dr, dc, psf + 'd' + dg);
        }
    }
    

}