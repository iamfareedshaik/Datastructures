import java.util.*;

class TreeNode{
    int key;
    TreeNode left;
    TreeNode right;
    int height;
    public TreeNode(int key){
        this.key = key;
        this.height = 1;
        this.left = null;
        this.right = null;
    }
}

class BST{
    TreeNode root = null;
    
    public void createNode(int key){
        TreeNode temp = new TreeNode(key);
        root = insertNode(root, temp);
    }

    TreeNode insertNode(TreeNode root, TreeNode temp){
        if(root == null){
            return temp;
        }

        if(temp.key < root.key){
            root.left = insertNode(root.left, temp);
        }
        if(temp.key > root.key){
            root.right = insertNode(root.right, temp);
        }

        root.height = 1 + Math.max(getHeight(root.left), getHeight(root.right));
        int bf = balanceFact(root);
        
        if(bf < -1 && temp.key > root.right.key){
            root = leftRotation(root);
        }

        if(bf < -1 && temp.key < root.right.key){
            root.right = rightRotation(root.right);
            root = leftRotation(root);
        }

        if(bf > 1 && temp.key < root.left.key){
            root = rightRotation(root);
        }

        if(bf > 1 && temp.key > root.left.key){
            root.left = leftRotation(root.left);
            root = rightRotation(root);
        }

        return root;
    }

    void traverse(){
        preOrder(root);
        System.out.print("\n");
        postOrder(root);
        System.out.print("\n");
        inOrder(root);
        System.out.print("\n");
        levelOrder(root);
        System.out.print("\n");
    }

    void preOrder(TreeNode root){
        if(root != null){
            System.out.print(root.key + " ->");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    void postOrder(TreeNode root){
        if(root != null){
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.key + "->");
        }
    }

    void inOrder(TreeNode root){
        if(root != null){
            inOrder(root.left);
            System.out.print(root.key + "->");
            inOrder(root.right);
        }
    }

    void levelOrder(TreeNode root){
        if(root != null){
            Queue<TreeNode> queue = new LinkedList();
            queue.add(root);
            while(!queue.isEmpty()){
                TreeNode temp = queue.poll();
                System.out.print(temp.key);
                if(temp.left != null) queue.add(temp.left);
                if(temp.right != null) queue.add(temp.right);
            }
        }
    }

    int getHeight(TreeNode root){
        if(root != null)
            return root.height;
        return 0;
    }

    int balanceFact(TreeNode root){
        if(root.left == null){
            return root.right.height;
        }
        if(root.right == null){
            return root.left.height;
        }
        return (root.left.height - root.right.height);
    }

    TreeNode rightRotation(TreeNode root){
        TreeNode temp = root.left;
        root.left = temp.right;
        temp.right = root;
        root.height = Math.max(getHeight(root.left), getHeight(root.right)) + 1;
        temp.height = Math.max(getHeight(temp.left), getHeight(temp.right)) + 1;
        return temp;
    }

    TreeNode leftRotation(TreeNode root){
        TreeNode temp = root.right;
        root.right = temp.left;
        temp.left = root;
        root.height = Math.max(getHeight(root.left), getHeight(root.right)) + 1;
        temp.height = Math.max(getHeight(temp.left), getHeight(temp.right)) + 1;
        return temp;
    }
}



public class BinarySearch{
    public static void main(String args[]){
        BST bs = new BST();
        bs.createNode(20);
        bs.createNode(5);
        bs.createNode(30);
        bs.createNode(6);
        bs.createNode(4);
        bs.traverse();
        
    }
}