import java.io.*;
import java.util.*;

public class solution_2{

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scn.nextInt();
        }
        int x = scn.nextInt();
        System.out.print(lastIndex(a, a.length - 1, x));
    }

    public static int lastIndex(int[] arr, int idx, int x) {
        if (idx == 0) {
            return -1;
        }

        if (arr[idx] == x) {
            int li = idx;
            return li;
        }

        int li = lastIndex(arr, idx - 1, x);
        return li;

    }

}