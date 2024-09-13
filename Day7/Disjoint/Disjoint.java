class Disjoint{
    private parent[];
    private rank[];

    Disjoint(int size){
        parent = new int[size];
        rank = new int[size];

        for(int i=0;i<size;i++){
            parent[i] = i;
            rank[i]=0;
        }
    }

    public void find(int p){
        if(p != parent[p]){
            parent[p] = find(parent[p]);
        }
        return parent[p];
    }

    public viod union(int p, int q){
        int rootp = find(p);
        int rootq = find(q);

        if(rank[rootp] < rank[rootq]){
            parent[rootp] = rootq; 
        }else if(rank[rootq] < rank[rootp]){
            parent[rootq] = rootp;
        }else{
            parent[rootp] = rootq;
            rank[rootq]++;
        }
    }
    public boolean connected(int p , int q){
        return find(p) == find(q);
    }
}