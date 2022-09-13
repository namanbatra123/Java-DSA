import java.io.*;
import java.util.*;

public class solution_1{

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int x = scn.nextInt();
        int ans = lastIndex(arr, 0, x);
        System.out.println(ans);
    }

    public static int lastIndex(int[] arr, int idx, int x) {
        if (idx == arr.length) {
            return -1;
        }

        int lidx = lastIndex(arr, idx + 1, x);
        if (lidx == -1) {
            if (arr[idx] == x) {
                return idx;
            } else {
                return -1;
            }
        }

        else {
            return lidx;
        }
    }

}