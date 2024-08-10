import java.util.*;

class TreeNode{
    int key;
    TreeNode left;
    TreeNode right;
    int height;

    public TreeNode(int key){
        this.key = key;
        this.left = null;
        this.right = null;
        this.height = 1;
    }
}

class BstTree{
    TreeNode root;

    void createNode(int key){
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
        } else{
            return root;
        }

        root.height = Math.max(getHeight(root.left), getHeight(root.right)) + 1;

        int bf = getbalance(root);
        if(bf > 1){
            if(temp.key < root.left.key ){
                return rightRotate(root);
            }
        }
        if(bf < -1){
            if(temp.key > root.right.key){
                return leftRotate(root);
            }
        }
        if(bf > 1){
            if(temp.key > root.left.key){
                root.left = leftRotate(root.left);
                return rightRotate(root);
            }
        }

        if(bf < -1 && temp.key < root.right.key){
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;

    }

    TreeNode rightRotate(TreeNode y){
        TreeNode x = y.left;
        TreeNode t2 = x.right;

        x.right = y;
        y.left = t2;

        y.height =  Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height =  Math.max(getHeight(x.left), getHeight(x.right)) + 1;

        return x;
    }

    TreeNode leftRotate(TreeNode x){
        TreeNode y = x.right;
        TreeNode T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;

        return y;
    }

    int getHeight(TreeNode root){
        if(root == null){
            return 0;
        }
        return root.height;
    }

    int getbalance(TreeNode root){
        if(root == null){
            return 0;
        }

        return getHeight(root.left) - getHeight(root.right);
    }

    void traversal(){
        preOrder(root);
        System.out.print("\n");
        postOrder(root);
        System.out.print("\n");
        levelOrder(root);
        System.out.print("\n");
        inOrder(root);
    }

    void preOrder(TreeNode root){
        if(root != null){
            System.out.print(root.key + "->");
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

    void levelOrder(TreeNode root){
        if(root == null){
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode temp = queue.poll();
            System.out.print(temp.key + "->");
            if(temp.left != null) queue.add(temp.left);
            if(temp.right != null) queue.add(temp.right);
        }
    }

    void inOrder(TreeNode root){
        if(root !=null){
            inOrder(root.left);
            System.out.print(root.key + "->");
            inOrder(root.right);
        }

    }
}

public class AvlTree{
    public static void main(String args[]){
        BstTree tree = new BstTree();
        tree.createNode(10);
        tree.createNode(20);
        tree.createNode(9);
        tree.createNode(6);
        tree.createNode(8);
        tree.traversal();

    }
}