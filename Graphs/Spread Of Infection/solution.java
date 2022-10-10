import java.io.*;
import java.util.*;

public class solution{
   static class Edge {
      int src;
      int nbr;

      Edge(int src, int nbr) {
         this.src = src;
         this.nbr = nbr;
      }
   }

   static class pair{
      int vtx; 
      int time;

      pair(int vtx, int time){
         this.vtx = vtx; 
         this.time = time;
      }
   }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int vtces = Integer.parseInt(br.readLine());
      ArrayList<Edge>[] graph = new ArrayList[vtces];
      for (int i = 0; i < vtces; i++) {
         graph[i] = new ArrayList<>();
      }

      int edges = Integer.parseInt(br.readLine());
      for (int i = 0; i < edges; i++) {
         String[] parts = br.readLine().split(" ");
         int v1 = Integer.parseInt(parts[0]);
         int v2 = Integer.parseInt(parts[1]);
         graph[v1].add(new Edge(v1, v2));
         graph[v2].add(new Edge(v2, v1));
      }

      int src = Integer.parseInt(br.readLine());
      int t = Integer.parseInt(br.readLine());
      
      // write your code here
      int count = 0; 
      boolean[] visited = new boolean[vtces]; 
      ArrayDeque<pair> queue = new ArrayDeque<>(); 
      queue.add(new pair(src, 1));

      while(queue.size() > 0){
         pair rem = queue.remove(); 

         if(visited[rem.vtx] == true){
            continue; 
         }

         visited[rem.vtx] = true;

         if(rem.time > t){
            break; 
         }

         count++; 
         for(int i = 0; i < graph[rem.vtx].size(); i++){
            Edge e = graph[rem.vtx].get(i); 

            if(visited[e.nbr] == false){
               queue.add(new pair(e.nbr, rem.time + 1));
            }
         }

      }

      System.out.println(count);
   }

}