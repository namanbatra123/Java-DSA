import java.util.*;

public class concept{
    public static class MyPriorityQueue<T>{
        ArrayList<T> data;
        Comparator cmptr;

        public MyPriorityQueue() {
            data = new ArrayList<>();
            cmptr = null;
        }

        public MyPriorityQueue(Comparator cmptr) {
            data = new ArrayList<>();
            this.cmptr = cmptr; 
        }

        public void add(T val) {
            data.add(val);
            upheapify(data.size() - 1);
        }

        public void upheapify(int i) {
            if (i == 0)
                return;
            int pi = (i - 1) / 2;
            if(isSmaller(i, pi) == true){
                Collections.swap(data, pi, i);
                upheapify(pi);
            }
        }

        public T remove() {
            if (data.size() == 0) {
                System.out.println("Underflow");
                return null;
            }
            Collections.swap(data, 0, data.size() - 1); // swaping first and last
            T val = data.remove(data.size() - 1);
            downheapify(0);
            return val;
        }

        public void downheapify(int i) {
            int min = i;

            int lci = 2 * i + 1;
            if (lci < data.size() && isSmaller(lci, min) == true)
                min = lci;

            int rci = 2 * i + 2;
            if (rci < data.size() && isSmaller(rci, min) == true)
                min = rci;

            if (min != i) {
                Collections.swap(data, i, min);
                downheapify(min);
            }
        }

        public T peek() {
            if (data.size() == 0) {
                System.out.println("Underflow");
                return null;
            }
            return data.get(0);
        }

        public int size() {
            return data.size();
        }

        boolean isSmaller(int i, int j){
            T ith = data.get(i);
            T jth = data.get(j);

            if(cmptr != null){
                if(cmptr.compare(ith, jth) < 0){
                    return true;
                }
                else{
                    return false;
                }
            }
            else{
                Comparable cith = (Comparable)ith;
                Comparable cjth = (Comparable)jth;

                if(cith.compareTo(cjth) < 0){
                    return true;
                }
                else{
                    return false;
                }
            }
        }
    }

    static class Student implements Comparable<Student>{
        String name; 
        int ht; 
        int wt; 
        int marks;

        Student(String name, int ht, int wt, int marks){
            this.name = name; 
            this.ht = ht; 
            this.wt = wt; 
            this.marks = marks; 
        }

        public String toString(){
            return this.name + "-> " + this.ht + ", " + this.wt + ", " + this.marks;
        }

        public int compareTo(Student other){
            return this.ht - other.ht;
        }
    }

    static class WeightComparator implements Comparator<Student>{
        public int compare(Student s1, Student s2){
            return s1.wt - s2.wt;
        }
    }

    static class MarksComparator implements Comparator<Student>{
        public int compare(Student s1, Student s2){
            return s1.marks - s2.marks;
        }
    }

    public static void main(String[] args) throws Exception {
        Student[] students = new Student[5];
        students[0] = new Student("A", 180, 75, 90);
        students[1] = new Student("B", 150, 85, 33);
        students[2] = new Student("C", 185, 72, 99);
        students[3] = new Student("D", 165, 65, 75);
        students[4] = new Student("E", 177, 55, 88);

        PriorityQueue<Student> pqHt = new PriorityQueue<>();    //  Using java's priority queue. Implemeted using comparable.
        PriorityQueue<Student> pqWt  = new PriorityQueue<>(new WeightComparator());  // implemented using comparator.
        PriorityQueue<Student> pqMarks  = new PriorityQueue<>(new MarksComparator()); // implemented using comparator.

        for(Student i: students){
            pqHt.add(i);
            pqWt.add(i);
            pqMarks.add(i);
        }

        System.out.println("On The Basis Of Height");
        while (pqHt.size() > 0) {
            Student student = pqHt.peek();
            pqHt.remove();
            System.out.println(student);
        }

        System.out.println("On The Basis Of Weight");
        while (pqWt.size() > 0) {
            Student student = pqWt.peek();
            pqWt.remove();
            System.out.println(student);
        }

        System.out.println("On The Basis Of Marks");
        while (pqMarks.size() > 0) {
            Student student = pqMarks.peek();
            pqMarks.remove();
            System.out.println(student);
        }
    }
}