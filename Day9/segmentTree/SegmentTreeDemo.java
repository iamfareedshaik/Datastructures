class Segment{
    private int[] tree;
    private int[] nums;

    public Segment(int[] nums){
        if(nums.length >0){
            this.nums = nums;
            int size = nums.length*4;
            tree = new int[size];
            buildTree(0,0,nums.length - 1);
        }
    }

    private void buildTree(int node, int start, int end){
        if(start == end){
            tree[node] = nums[start];
        } else{
            int mid = start + (end - start)/2;
            buildTree(2*node + 1, start, mid);
            buildTree(2*node + 2, mid + 1, end);
            tree[node] = tree[2*node + 1] + tree[2*node + 2];
        }
    }
}