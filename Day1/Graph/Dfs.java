import java.util.*;
class Vertex{
    int source;
    int destination;
    int weight;

    public Vertex(int source, int destination, int weight){
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }
}

class Graph{
    int vertices;
    List<List<Vertex>> adjvertex;

    public Graph(int vertices){
        this.vertices = vertices;
        this.adjvertex = new ArrayList<>(vertices);
        for(int i =0;i<vertices;i++){
            this.adjvertex.add(new ArrayList<>());
        }
    }

    public void addEdge(int source, int destination, int weight){
        adjvertex.get(source).add(new Vertex(source, destination, weight));
        adjvertex.get(destination).add(new Vertex(destination, source, weight));
    }

    public void traversal(){
        boolean[] visited = new boolean[vertices];
        Dfstraversal(0, visited);
        Bfstraversal(0);
        Djskstra(0);
        Bellmanfold(0);
    }

    public void Dfstraversal(int start, boolean[] visited){
        visited[start] = true;
        System.out.print(start);
        for(Vertex vertices : adjvertex.get(start)){
            if(!visited[vertices.destination])
                Dfstraversal(vertices.destination, visited);
        }
    }

    public void Djskstra(int start){
        int length[] = new int[vertices];
        boolean[] visited = new boolean[vertices];
        Arrays.fill(length, Integer.MAX_VALUE);
        length[0] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        while(!queue.isEmpty()){
            int starts = queue.poll();
            visited[starts] = true;
            for(Vertex v: adjvertex.get(starts)){
                int dist = length[starts] + v.weight;
                if(dist < length[v.destination]){
                    length[v.destination] = dist;
                }
                if(!visited[v.destination]){
                    queue.add(v.destination);
                }
            }
        }

        for(int i =0;i<vertices;i++){
            System.out.print(length[i]+ "-->");
        }
    }

    public void Bellmanfold(int start){
        Integer length[] = new Integer[vertices];
        Arrays.fill(length, Integer.MAX_VALUE);
        length[start] = 0;

        for(int i =0;i<vertices-1;i++){
            for(int j =0;j<vertices;j++){
                for(Vertex edge: adjvertex.get(j)){
                    if(length[j] != Integer.MAX_VALUE && (length[j] + edge.weight < length[edge.destination])){
                        length[edge.destination] = length[j] + edge.weight;
                    }
                }
            }
        }

        for(int i =0;i<vertices;i++){
            for(Vertex edge:adjvertex.get(i)){
                if(length[i] != Integer.MAX_VALUE && length[i]+edge.weight < length[edge.destination]){
                    System.out.print("Graph contains negative cycle");
                    return;
                }
            }
        }
        for(int i=0;i<vertices;i++){
            System.out.print(length[i]+"->");
        }
    }

    public void Bfstraversal(int start){
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[vertices];
        queue.add(start);
        while(!queue.isEmpty()){
            int ver = queue.poll();
            System.out.print(ver);
            visited[ver] = true;
            for(Vertex v : adjvertex.get(ver)){
                if(!visited[v.destination]){
                    visited[v.destination] = true;
                    queue.add(v.destination);
                }
                    
            }
        }
    }
}

class Dfs{
    public static void main(String args[]){
        Graph graph = new Graph(5);
        graph.addEdge(0, 1, 9);
        graph.addEdge(0, 2, 6);
        graph.addEdge(0, 3, 5);
        graph.addEdge(0, 4, 3);
        graph.addEdge(2, 1, 2);
        graph.addEdge(2, 3, 4);
        graph.traversal();
    }
}