import java.util.*;
class TreeNode{
    int key;
    TreeNode left;
    TreeNode right;
    int height;
    public TreeNode(int key){
        this.key = key;
        this.left = this.right = null;
        this.height = 1;
    }
}

class Bst{
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
        }
        root.height = Math.max(getHeight(root.right), getHeight(root.left)) + 1;

        int bf = getBalance(root);

        // Left 
        if(bf < -1 && temp.key > root.right.key){
            return leftRotation(root);
        }
        
        // right left
        if(bf < -1 && temp.key < root.right.key){
            root.right = rightRotation(root.right);
            return leftRotation(root);
        }

        //right
        if(bf > 1 && temp.key < root.left.key){
            return rightRotation(root);
        }

        //left right
        if(bf > 1 && temp.key > root.left.key){
            root.left = leftRotation(root.left);
            return rightRotation(root);
        }
        return root;
    }

    int getBalance(TreeNode root){
        if(root == null){
            return 0;
        }
        return getHeight(root.left) - getHeight(root.right);
    }

    int getHeight(TreeNode root){
        if(root == null){
            return 0;
        }
        return root.height;
    }

    TreeNode leftRotation(TreeNode root){
        TreeNode temp = root.right;
        root.right = temp.left;
        temp.left = root;

        root.height = Math.max(getHeight(root.left), getHeight(root.right)) + 1;
        temp.height = Math.max(getHeight(temp.left), getHeight(temp.right)) + 1;

        return temp;
    }

    TreeNode rightRotation(TreeNode root){
        TreeNode temp = root.left;
        root.left = temp.right;
        temp.right = root;
        
        root.height = Math.max(getHeight(root.left), getHeight(root.right)) + 1;
        temp.height = Math.max(getHeight(temp.left), getHeight(temp.right)) + 1;
        return temp;
    }

    void traverse(){
        preOrder(root);
        System.out.println();
        postOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println();
        levelOrder(root);
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

    void inOrder(TreeNode root){
        if(root != null){
            inOrder(root.left);
            System.out.print(root.key + "->");
            inOrder(root.right);
        }

    }

    void levelOrder(TreeNode root){
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        if(root != null){
            while(!queue.isEmpty()){
                TreeNode temp = queue.poll();
                System.out.print(temp.key + "->");
                if(temp.left != null) queue.add(temp.left);
                if(temp.right != null) queue.add(temp.right);
            }
        }
    }
}

class BinaryTree{
    public static void main(String args[]){
        Bst bt = new Bst();
        bt.createNode(12);
        bt.createNode(10);
        bt.createNode(5);
        bt.createNode(4);
        bt.traverse();
    }
}