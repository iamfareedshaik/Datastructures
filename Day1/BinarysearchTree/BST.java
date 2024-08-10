import java.util.*;

class Node{
    int key;
    Node left;
    Node right;
    public Node(int key){
        this.key = key;
        this.left = null;
        this.right = null;
    }
}

class BinaryTree{
    Node root;

    void createNode(int key){
        Node temp = new Node(key);
        root = insertNode(root, temp );
    }

    Node insertNode(Node root, Node temp){
        if(root == null){
            return temp;
        }

        if(temp.key < root.key){
            root.left = insertNode(root.left, temp);
        }
        if(temp.key > root.key){
            root.right = insertNode(root.right, temp);
        }
        return root;
    }

    void preOrder(Node root){
        if(root != null){
            System.out.print(root.key + "->");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    void postOrder(Node root){
        if(root !=null){
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.key + "->");
        }
    }

    void inOrder(Node root){
        if(root != null){
            inOrder(root.left);
            System.out.print(root.key + "->");
            inOrder(root.right);
        }
    }

    void traversal(){
        System.out.print("started traversal");
        inOrder(root);
        System.out.print("\n");
        postOrder(root);
        System.out.print("\n");
        preOrder(root);
        System.out.print("\n");
        levelOrder(root);
    }

    void levelOrder(Node root){
        if(root == null) return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            Node temp = queue.poll();
            System.out.print(temp.key + "->");
            if(temp.left != null) queue.add(temp.left);
            if(temp.right != null) queue.add(temp.right);
        }
    }
}

class BST{
    public static void main(String args[]){
        BinaryTree tree = new BinaryTree();
        tree.createNode(10);
        tree.createNode(20);
        tree.createNode(9);
        tree.createNode(6);
        tree.createNode(8);
        tree.traversal();
    }
}