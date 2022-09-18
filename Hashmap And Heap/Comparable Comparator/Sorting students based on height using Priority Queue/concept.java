import java.util.*;

public class concept{
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

    static class Student implements Comparable<Student>{
        String name; 
        int ht; 
        int wt; 

        Student(String name, int ht, int wt){
            this.name = name; 
            this.ht = ht; 
            this.wt = wt; 
        }

        public String toString(){
            return this.name + "-> " + this.ht + "," + this.wt;
        }

        public int compareTo(Student other){
            return this.ht - other.ht;
        }
    }

    public static void main(String[] args) throws Exception {
        Student[] students = new Student[5];
        students[0] = new Student("A", 180, 75);
        students[1] = new Student("B", 150, 85);
        students[2] = new Student("C", 185, 72);
        students[3] = new Student("D", 165, 65);
        students[4] = new Student("E", 177, 55);

        PriorityQueue<Student> pq  = new PriorityQueue<>();    //  Using java's priority queue.
        for(Student i: students){
            pq.add(i);
        }

        while (pq.size() > 0) {
            Student student = pq.peek();
            pq.remove();
            System.out.println(student);
        }
    }
}