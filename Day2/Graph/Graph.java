import java.util.*;
class Node{
    int key;
    int source;
    int destination;
    int weight;

    Node(int key, int source, int destination, int weight){
        this.key = key;
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }
}

class GraphStruct{
    List<List<Node>> adjvert;
    int vertices;
    GraphStruct(int vertices){
        this.vertices = vertices;
        this.adjvert = new ArrayList<>(vertices);
        for(int i =0;i< vertices;i++){
            adjvert.add(new ArrayList<>());
        }
    }

    void createNode(int key, int source, int destination, int weight){
        adjvert.get(source).add(new Node(key, source, destination, weight));
    }

    void printGraph(){
        System.out.print("welcome");
        for(int i =0;i< vertices;i++){
            List<Node> a = adjvert.get(i);
            for(Node list: a){
                System.out.print(list.key + "->" +list.destination + "=>" + list.weight);
            }
        }
    }
    
    void Bfs(int key){
        System.out.println("BFS");
        Queue<Integer> queue = new LinkedList();
        boolean visited [] = new boolean[vertices]; 
        queue.add(key);
        visited[key] = true;
        while(!queue.isEmpty()){
            int temp = queue.poll();
            System.out.print(temp);
            for(Node nd : adjvert.get(temp)){
                if(!visited[nd.destination])
                {
                    queue.add(nd.destination);
                    visited[nd.destination] = true;
                }
            }
        }
    }

    void Dfs(int key, boolean visited[]){
        visited[key] = true;
        System.out.println(key);
        for(Node nodes : adjvert.get(key)){
            if(!visited[nodes.destination])
                Dfs(nodes.destination, visited);
        }
    }

    void dijkstras(int key){
        int destination[] = new int[vertices];
        Arrays.fill(destination, Integer.MAX_VALUE);
        destination[key] = 0;
        boolean visited[] = new boolean[vertices];
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node n1, Node n2) {
                return Integer.compare(n1.weight, n2.weight);
            }
        });

        pq.add(new Node(-1, key, key, 0));
        while(!pq.isEmpty()){
            Node currentNode = pq.poll();
            int currentKey = currentNode.destination;

            if (visited[currentKey]) {
                continue;
            }

            visited[currentKey] = true;
            for(Node node : adjvert.get(currentKey)){
                int weigh = destination[currentKey] + node.weight;
                if(!visited[node.destination]){
                    if(weigh < destination[node.destination]){
                        destination[node.destination] = weigh;
                        pq.add(new Node(-1, currentKey, node.destination, weigh));
                    }
                }
            }
        }

        for(int i =0;i<vertices;i++){
            System.out.print("Dijkstras");
            System.out.println(destination[i]);
        }
    }

    void Kosarajus(){
        
    }

void bellmanFord(int source) {
    int[] distance = new int[vertices];
    Arrays.fill(distance, Integer.MAX_VALUE);
    distance[source] = 0;

    for (int i = 0; i < vertices - 1; i++) {
        for (List<Node> nodes : adjvert) {
            for (Node node : nodes) {
                int u = node.source;
                int v = node.destination;
                int weight = node.weight;
                if (distance[u] != Integer.MAX_VALUE && distance[u] + weight < distance[v]) {
                    distance[v] = distance[u] + weight;
                }
            }
        }
    }
    boolean hasNegativeCycle = false;
    for (List<Node> nodes : adjvert) {
        for (Node node : nodes) {
            int u = node.source;
            int v = node.destination;
            int weight = node.weight;
            if (distance[u] != Integer.MAX_VALUE && distance[u] + weight < distance[v]) {
                hasNegativeCycle = true;
                break;
            }
        }
    }
    for(int i =0;i<vertices;i++){
        System.out.println(distance[i]);
    }
}

    void prims(int key){
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node n1, Node n2) {
                return Integer.compare(n1.weight, n2.weight);
            }
        });
        boolean visited[] = new boolean[vertices];
        visited[key] = true;

        int cost = 0;
        for (Node node : adjvert.get(key)) {
            pq.add(node);
        }
        while(!pq.isEmpty()){
            Node temp = pq.poll();
            if(!visited[temp.destination]){
                cost = cost + temp.weight;
                visited[temp.destination] = true;
            }

            for(Node nextnode : adjvert.get(temp.destination)){
                if(!visited[nextnode.destination])
                    pq.add(nextnode);
            }
        }
   
        System.out.println(cost);
    }

    void allpathdestination(int sou, String path, int dest, boolean visited[]){
        path += sou + " ";
        if(sou == dest){
            System.out.println("my paths ->"+path);
            return;
        }
        visited[sou] = true;
        for(Node node : adjvert.get(sou)){
            if(!visited[node.destination]){
                allpathdestination(node.destination, path, dest,visited);
            }
        }
        
        visited[sou] = false;
    }
}

class Graph{
    public static void main(String args[]){
       GraphStruct gs = new GraphStruct(5);
       gs.createNode(0, 0, 2, 3);
       gs.createNode(0, 0, 4, 5);
       gs.createNode(4, 4, 2, 4);
       gs.createNode(2, 2, 3, 6);
       gs.createNode(3, 3, 0, 10);
       gs.printGraph();
       gs.Bfs(0);
       boolean visited[] = new boolean[5];
       gs.Dfs(0, visited);
       gs.dijkstras(0);
       gs.prims(0);
       gs.allpathdestination(0, "", 3, new boolean[5]);
       gs.bellmanFord(0);
    }
}