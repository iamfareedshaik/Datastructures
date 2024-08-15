import java.util.*;

class Node{
    int source;
    int destination;
    int weight;

    public Node(int source, int destination, int weight){
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }
}

class Graphstruct{
    List<List<Node>> adjvert;
    int vertices;

    public Graphstruct(int vertices){
        this.vertices = vertices;
        this.adjvert = new ArrayList<>();

        for(int i =0;i< vertices; i++){
            this.adjvert.add(new ArrayList());
        }
    }

    void createNode(int source, int destination, int weight){
        this.adjvert.get(source).add(new Node(source, destination, weight));
    }

    void Dfs(int start, boolean visited[]){
        visited[start] = true;
        System.out.print(start);
        for(Node node: adjvert.get(start)){
            if(!visited[node.destination]){
                Dfs(node.destination, visited);
            }
        }
    }

    void Bfs(int start){
        boolean visited[] = new boolean[vertices];
        Queue queue = new Queue();
        queue.add(start);
        visited[key] = true;
        while(!queue.isEmpty()){
            int key = queue.poll();
            System.out.print(key)
            for(Node node : adjvert.get(key)){
                if(!visited[node.destination]){
                    queue.add(node.destination)
                    visited[key] = true;
                }
            }
        }
    }

    void Djkstras(int key){
        Queue queue =  new LinkedList();
        Integer destination[] = new Integer[vertices];
        boolean visited[] =  new boolean[vertices];
        Arrays.fill(destination, Integer.MAX_VALUE);
        queue.add(key);
        destination[key] = 0;
        while(!queue.isEmpty()){
            int key = queue.poll();
            visited[key] = true;
            for(Node node : adjvert.get(key)){
                int weight = destination[key] + node.destination.weight;
                if(!visited[node.destination] && weight < destination[node.destination]){
                    destination[node.destination] = weight;
                    queue.add(node.destination);
                }
            }
        }
    }

    void Bellmanfold(int key){
        Integer distance[] = new Integer[vertices];
        Arrays.fill(distance, Integer.MAX_VALUE);

        distance[0] = 0;
        for(int i =0; i<vertices-1; i++){
            for(i=0; i< vertices;i++){
                visited[i] = true;
                for(list<Node> node : adjvert.get(i)){
                    int weight = distance[i] + node.destination.weight;
                    if(distance[node.destination] != Integer.MAX_VALUE && weight < distance[node.destination]){
                        distance[node.destination] = weight;
                    }
                }
            }
        }

        for(i=0; i< vertices;i++){
            for(List<Node> node : adjvert.get(i)){
                int weight = distance[i] + node.destination.weight;
                if(weight < distance[node.destination]){
                    distance[node.destination] = weight;
                    break;
                }
            }
        }
    }

    void kosarjus(int start, list stack){
        visited[start] =true;
        for(Node node : adjvert.get(key)){
            if(!visited[node.destination]){
                kosarjus(node.destination)
            }
        }
        stack.push(node.destination);
    }

    void allpathdestination(int source, int destination, String path, int visited[]){
        if(source == destination){
            System.out.print(path);
            return;
        }

        visited[source] = true;
        for(Node node : adjvert.get(source)){
            if(!visited[node.destination]){
                allpathdestination(node.destination, destination, path, visited);
            }
        }
        visited[source] =false;
    }


    void prims(int start){
        Queue queue = new LinkedList();
        boolean visited[] = new visited[vertices];
        visited[start] = true;
        for(Node node : adjvert.get(start)){
            queue.add(node);
        }

        while(!queue.isEmpty()){
            Node temp = queue.poll()
            if(!visited[temp.destination]){
                visited[temp.destination] = true;
                cost += temp.weight;
            }
            for(Node node : adjvert.get(temp.destination)){
                if(!visited[node.destination]){
                    queue.add(node.destination)
                }
            }
        }
        System.out.print(cost);
    }

}

class Graph{
    public static void main(String args[]){
        Graphstruct gp = new Graphstruct(6);
        boolean visited[] = new boolean[6];
        gp.createNode(0, 1, 2);
        gp.createNode(1, 2, 3);
        gp.createNode(2, 3, 1);
        gp.createNode(3, 4, 1);
        gp.createNode(1, 4, 6);
        gp.createNode(0, 4, 4);
        gp.Dfs(0, visited);
        
    }
}