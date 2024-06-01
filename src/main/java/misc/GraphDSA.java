package misc;

import java.util.*;
import java.util.stream.Collectors;

public class GraphDSA {

  public static class Edge<T> {
    T start;
    int weight;
    T end;

    public Edge(T i, T j, int weight) {
      this.start = i;
      this.end = j;
      this.weight = weight;
    }

    public static <L> Edge<L> create(L i, L j , int w){
      return new Edge<>(i,j,w);
    }
  }

  public static class Graph<T> {
    private final Map<T,List<Edge<T>>> graph = new HashMap<>();

    @SafeVarargs
    public final void putEdgesForVertexIntoGraph(T i, Edge<T>... edges){
      List<Edge<T>> newList = Arrays.stream(edges).collect(Collectors.toList());
      if(this.graph.get(i) != null)
        newList.addAll(this.graph.get(i));
      this.graph.put(i , newList);
    }

    @SafeVarargs
    public final void putEdgesIntoGraph(Edge<T>... edges){
      for(Edge<T> t  : edges){
        if(this.graph.get(t.start) == null){
          List<Edge<T>> ls = new ArrayList<>();
          ls.add(t);
          this.graph.put(t.start ,ls);
        }else{
          var ls = this.graph.get(t.start);
          ls.add(t);
          this.graph.put(t.start ,ls);
        }
      }
    }

    public Map<T,List<Edge<T>>> getGraph(){
      return this.graph;
    }

    public List<T> getNeighboursOfVertex(T i){
      return this.graph.get(i)
          .stream().map(edge -> edge.end)
          .collect(Collectors.toList());
    }

    public void bfs(){
      System.out.println("================== BFS ==================");
      Map<T, Boolean> visited = new HashMap<>();
      for(T m : this.graph.keySet()){
        if(visited.get(m) == null || !visited.get(m)){
          bfsAdapter(m, visited);
        }
      }
    }
    public void bfsAdapter(T start, Map<T, Boolean> visited){
      StringBuilder sb = new StringBuilder();
      Queue<T> queue = new ArrayDeque<>();
      queue.add(start);
      while(!queue.isEmpty()){
        T node = queue.poll();
        if(visited.get(node) == null || !visited.get(node)){
          visited.put(node, true);
          queue.addAll(getNeighboursOfVertex(node));
          sb.append(node).append(" -> ");
        }
      }
      System.out.println(sb.substring(0, sb.lastIndexOf(" -> ")));
    }

    public void dfs(){
      System.out.println("================== DFS ==================");
      Map<T, Boolean> visited = new HashMap<>();
      for(T m : this.graph.keySet()){
        if(visited.get(m) == null || !visited.get(m)){
          StringBuilder s = new StringBuilder();
          dfsAdapter(m, visited , s);
          System.out.println(s.substring(0, s.lastIndexOf(" -> ")));
        }
      }
    }

    private void dfsAdapter(T m, Map<T, Boolean> visited, StringBuilder s) {
      if(Boolean.TRUE.equals(visited.get(m))) return;
      s.append(m).append(" -> ");
      visited.put(m, true);
      for(T node : getNeighboursOfVertex(m)){
        dfsAdapter(node, visited, s);
      }
    }


    private void printAllPossiblePaths(T start , T end){
      System.out.println("================== Print All Possible Paths from source to target ==================");
      Map<T, Boolean> visited = new HashMap<>();
      List<List<T>> allPaths = new ArrayList<>();
      List<T> path = new ArrayList<>();
      path.add(start);
      printAllPossiblePathsAdapter(start, end , visited , allPaths, path);
      allPaths.forEach(System.out::println);
    }

    private void printAllPossiblePathsAdapter(T start, T end, Map<T, Boolean> visited, List<List<T>> ls, List<T> path) {
      if(start == end){
        ls.add(path);
        return;
      }
      for(T n : this.getNeighboursOfVertex(start)) {
        if(visited.get(n) == null || !visited.get(n)){
          visited.put(start, true);
          List<T> pathNew = new ArrayList<>(path);
          pathNew.add(n);
          printAllPossiblePathsAdapter(n, end, visited, ls, pathNew);
          visited.put(start, false);
        }
      }
    }

  }

  public static void main(String[] args) {
    Graph<Integer> graphObj = new Graph<>();
    graphObj.putEdgesForVertexIntoGraph(0 , Edge.create(0,1,1),Edge.create(0,2,1));
    graphObj.putEdgesForVertexIntoGraph(1 , Edge.create(1,0,1),Edge.create(1,3,1),Edge.create(1,4,1));
    graphObj.putEdgesForVertexIntoGraph(2 , Edge.create(2,0,1),Edge.create(2,4,1));
    graphObj.putEdgesForVertexIntoGraph(3 , Edge.create(3,1,1),Edge.create(3,4,1),Edge.create(3,5,1));
    graphObj.putEdgesForVertexIntoGraph(4 , Edge.create(4,1,1),Edge.create(4,2,1),Edge.create(4,3,1),Edge.create(4,5,1));
    graphObj.putEdgesForVertexIntoGraph(5 , Edge.create(5,3,1),Edge.create(5,4,1),Edge.create(5,6,1));
    graphObj.putEdgesForVertexIntoGraph(6 , Edge.create(6,5,1));
    graphObj.putEdgesForVertexIntoGraph(7 , Edge.create(7,8,1));
    graphObj.putEdgesForVertexIntoGraph(8 , Edge.create(8,7,1));
    System.out.println("========== neighbours ==============\n" +graphObj.getNeighboursOfVertex(4));
    graphObj.dfs();
    graphObj.bfs();
    graphObj.printAllPossiblePaths(0 , 5);
  }

}