import java.io.*;
import java.util.*;

public class solution{
   static class Edge{
      int src; 
      int nbr;
      
      Edge(int src, int nbr){
         this.src = src; 
         this.nbr = nbr;
      }
   }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int n = Integer.parseInt(br.readLine());
      int k = Integer.parseInt(br.readLine());
      
      // write your code here
      ArrayList<Edge>[] graph = new ArrayList[n];
      for(int i = 0; i < n; i++){
         graph[i] = new ArrayList<>();
      }

      for(int i = 0; i < k; i++){
         String str = br.readLine();
         int v1 = Integer.parseInt(str.split(" ")[0]);
         int v2 = Integer.parseInt(str.split(" ")[1]); 
         graph[v1].add(new Edge(v1, v2));
         graph[v2].add(new Edge(v2, v1));
      }

      ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
      boolean[] visited = new boolean[n]; 
      for(int i = 0; i < graph.length; i++){
         if(visited[i] == false){
            ArrayList<Integer> comp = new ArrayList<>(); 
            fillcomp(graph, comp, i, visited);
            comps.add(comp);
         }
      }

      int count = 0; 
      for(int i = 0; i < comps.size(); i++){
         for(int j = i + 1; j < comps.size(); j++){
            int si = comps.get(i).size(); 
            int sj = comps.get(j).size(); 
            int pairs = si * sj;
            count += pairs;
         }
      }

      System.out.print(count);
   }

   static void fillcomp(ArrayList<Edge>[] graph, ArrayList<Integer> comp, int i, boolean[] visited){
      visited[i] = true; 
      comp.add(i);
      for(int j = 0; j < graph[i].size(); j++){
         Edge edge = graph[i].get(j); 
         int nbr = edge.nbr;
         
         if(visited[nbr] == false){
            fillcomp(graph, comp, nbr, visited);
         }
      }
   }

}