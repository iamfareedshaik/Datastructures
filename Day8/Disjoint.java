
class joint{

    private int parent[];
    private int rank[];

    public joint(int size){
        parent = new int[size];
        rank = new int[size];

        for(int i=0;i<size;i++){
            parent[i] = i;
            rank[i] = 0;
        }
    }

    public void union(int p, int q){
        int rootp = find(p);
        int rootq = find(q);

        if(rootp == rootq) return;

        if(rank[rootp] < rank[rootq]){
            parent[rootp] = rootq;
        }else if (rank[rootq] < rank[rootp]){
            parent[rootq] = rootp;
        }else{
            parent[rootp] = rootq;
            rank[rootq]++;
        }

    }

    public void find(int p){
        if(p != parent[p]){
            parent[p]= find(p);
        }
        return parent[p];
    }
}

class Disjoint{
    public static void main(String args[]){

    }
}