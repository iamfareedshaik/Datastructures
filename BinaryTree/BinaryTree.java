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

class BinaryTree{
    TreeNode root;
    void createNode(int key){
        TreeNode node = new TreeNode(key);
        root = insertNode(root, node);
    }

    TreeNode insertNode(TreeNode root, TreeNode node){
        if(root == null){
            root = node;
            return root;
        }
        if(node.key < root.key ){
            root.left = insertNode(root.left, node);
        }
        if(node.key > root.key){
        root.right = insertNode(root.right, node);
        }
        return root;
        
    }

    void search(){
        PreOrder(root);
        postOrder(root);
        inOrder(root);
    }

    void PreOrder(TreeNode root){
        if(root != null){
            System.out.print(root.key);
            PreOrder(root.left);
            PreOrder(root.right);
        }
    }

    void postOrder(TreeNode root){
        if(root != null){
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.key);
        }
    }

    void inOrder(TreeNode root){
        if(root !=  null){
            inOrder(root.left);
            System.out.print(root.key);
            inOrder(root.right);
        }
    }

}
class Bt{
    public static void main(String args[]){
        BinaryTree bt = new BinaryTree();
        bt.createNode(5);
        bt.createNode(34);
        bt.createNode(44);
        bt.createNode(11);
        bt.createNode(13);
        bt.search();
    }
}