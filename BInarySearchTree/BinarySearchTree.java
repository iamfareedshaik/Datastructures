class TreeNode{
    int key;
    TreeNode left;
    TreeNode right;
    TreeNode(int key){
        this.key = key;
        this.left = null;
        this.right = null;
    }
}

class BinarySearchTree{
    TreeNode root;

    void createNode(int key){
        TreeNode node = new TreeNode(key);
        root = insertNode(root, node);
    }

    TreeNode insertNode(TreeNode root, TreeNode node){
        if(root == null){
            root = node;
            return node;
        }
        if(node.key > root.key){
            root.right = insertNode(root.right, node);
        }
        if(node.key <root.key){
            root.left = insertNode(root.left, node);
        }
        return root;
    }

    boolean search(int key){
        return searchRecord(root, key);
    }
    boolean searchRecord(TreeNode root, int key){
        if(root == null){
            return false;
        }
        if(root.key == key){
            return true;
        }
        
        if(root.key > key)
        {
            return searchRecord(root.left, key);
        }
      
        return searchRecord(root.right, key);
    }
}

class BST{
    public static void main(String args[]){
        BinarySearchTree bst = new BinarySearchTree();
        bst.createNode(40);
        bst.createNode(20);
        bst.createNode(3);
        bst.createNode(11);
        if(bst.search(11)){
            System.out.print("found");
        }else{
            System.out.print("not found");
        }
    }
}
