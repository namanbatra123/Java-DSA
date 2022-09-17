import java.util.*;

public class optimized_concept{
    public static class MyPriorityQueue {
        ArrayList<Integer> data;

        public MyPriorityQueue() {
            data = new ArrayList<>();
        }

        public MyPriorityQueue(int[] arr) {
            data = new ArrayList<>();
            for(int val: arr){
                data.add(val);
            }

            for(int i = data.size() / 2 - 1; i >= 0; i--){
                downheapify(i);
            }
        }

        public void add(int val) {
            data.add(val);
            upheapify(data.size() - 1);
        }

        public void upheapify(int i) {
            if (i == 0)
                return;
            int pi = (i - 1) / 2;
            if (data.get(pi) > data.get(i)) {
                Collections.swap(data, pi, i);
                upheapify(pi);
            }
        }

        public int remove() {
            if (data.size() == 0) {
                System.out.println("Underflow");
                return -1;
            }
            Collections.swap(data, 0, data.size() - 1); // swaping first and last
            int val = data.remove(data.size() - 1);
            downheapify(0);
            return val;
        }

        public void downheapify(int i) {
            int min = i;

            int lci = 2 * i + 1;
            if (lci < data.size() && data.get(lci) < data.get(min))
                min = lci;

            int rci = 2 * i + 2;
            if (rci < data.size() && data.get(rci) < data.get(min))
                min = rci;

            if (min != i) {
                Collections.swap(data, i, min);
                downheapify(min);
            }
        }

        public int peek() {
            if (data.size() == 0) {
                System.out.println("Underflow");
                return -1;
            }
            return data.get(0);
        }

        public int size() {
            return data.size();
        }
    }

    public static void main(String[] args) throws Exception {
        int[] arr = {5, 15, 2, 22, 37, 92, 81, 47};

        MyPriorityQueue pq = new MyPriorityQueue(arr);

        while (pq.size() > 0) {
            int val = pq.peek();
            System.out.print(val + " ");
            pq.remove();
        }
    }
}