import java.io.*;
import java.util.*;

public class solution{

  public static class PriorityQueue {
    ArrayList<Integer> data;

    public PriorityQueue() {
      data = new ArrayList<>();
    }

    public void add(int val) {
      // write your code here
      data.add(val);
      upheapify(data.size() - 1);
    }
    
    private void upheapify(int s){
      if(s == 0){
        return;
      }

      int pid = (s-1)/2;
      if(data.get(pid) > data.get(s)){
        Collections.swap(data, pid, s);
        upheapify(pid);
      }
    }

    public int remove() {
      // write your code here
      if(data.size() == 0){
        System.out.println("Underflow");
        return -1;
      }

      Collections.swap(data, 0, data.size()-1);
      int val = data.remove(data.size() - 1);
      downheapify(0);
      return val; 
    }

    private void downheapify(int i){
      int minidx = i;
      int lci = 2*i + 1; 
      int rci = 2*i + 2;

      if(lci < data.size() && data.get(lci) < data.get(minidx)){
        minidx = lci;
      }
      if(rci < data.size() && data.get(rci) < data.get(minidx)){
        minidx = rci;
      }

      if(minidx != i){
        Collections.swap(data, minidx, i);
        downheapify(minidx);
      }
    }

    public int peek() {
      // write your code here
      if(data.size() == 0){
        System.out.println("Underflow");
        return -1;
      }
      return data.get(0);
    }

    public int size() {
      // write your code here
      return data.size(); 
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PriorityQueue qu = new PriorityQueue();

    String str = br.readLine();
    while (str.equals("quit") == false) {
      if (str.startsWith("add")) {
        int val = Integer.parseInt(str.split(" ")[1]);
        qu.add(val);
      } else if (str.startsWith("remove")) {
        int val = qu.remove();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("peek")) {
        int val = qu.peek();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("size")) {
        System.out.println(qu.size());
      }
      str = br.readLine();
    }
  }
}