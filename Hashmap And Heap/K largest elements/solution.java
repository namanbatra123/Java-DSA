import java.util.*;
import java.lang.*;
import java.io.*;

class solution {
    public static void main(String[] args) throws IOException {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = scn.nextInt();
        }
        int k = scn.nextInt();
        solve(n, num, k);
    }

    public static void solve(int n, int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            pq.add(arr[i]);
        }

        for (int i = k; i < n; i++) {
            int val = arr[i];
            if (val > pq.peek()) {
                pq.remove();
                pq.add(val);
            }
        }

        while (pq.size() > 0) {
            System.out.print(pq.peek() + " ");
            pq.remove();
        }
    }
}
