import java.util.*;

interface BinaryTree<T>{
    public void add(Tree root, Tree node);
    public void iterate(String order);
}


class Tree{
    public int value;
    public int height;
    public Tree left;
    public Tree right;
    Tree(int value){
        this.value = value;
        this.height = 1;
        this.left = null;
        this.right = null;
    }
}


class BinaryTreeImpl implements BinaryTree{
    private Tree root;

    BinaryTreeImpl(){
        this.root = null;
    }

    void add(int value){
        root = insertion(root, new Tree(value));
    }

    public Tree insertion(Tree root, Tree node){
        if(root == null){
            return node;
        }
        
        if(node.value < root.value){
            root.left = insertion(root.left, node);
        }

        if(node.value > root.value){
            root.right = insertion(root.right, node);
        }

        return root;
    }

    public void avlTree(Tree root, Tree node){
        if(root == null){
            return node;
        }

        if(node.value < root.value){
            root.left = avlTree(root, node);
        }

        if(node.value > root.value){
            root.right = avlTree(root, node);
        }

        root.height = 1 + max(getHeight(root.left), getHeight(root.right));
        balance = getBalance(root);

        //right
        if(balance > 1 && getBalance(root.left)>=0){
            return rightRotation(root);
        }

        //left right
        if(balance > 1 && getBalance(root.left) < 0){
            root.left = leftRotation(root.left);
            return rightRotation(root);
        }

        //left
        if(balance < 1 && getBalance(root.right) <=0){

        }

        //left right
        if(balance < 1 && getBalance(root.right) > 0){

        }
        
    }

    public getBalance(Tree root){
        return root.left.value - root.right.value;
    }

    public int getHeight(Tree node){
        return node.height;
    }

    public void iterate(String order){
        if(order.equals("preOrder")){
            preOrder(root);
        }else if(order.equals("postOrder")){
            postOrder(root);
        }else if(order.equals("inOrder")){
            inOrder(root);
        }else if(order.equals("levelOrder")){
            levelOrder(root);
        }
    }

    void preOrder(Tree root){
        if(root != null){
            System.out.print(root.value + "->");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    void postOrder(Tree root){
        if(root != null){
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.value + "->");
        }
    }

    void levelOrder(Tree root){
        if(root == null) return;
        Queue<Tree> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            Tree pulledNode = queue.poll();
            System.out.print(pulledNode.value + "->");
            if(pulledNode.left != null) queue.add(pulledNode.left);
            if(pulledNode.right != null) queue.add(pulledNode.right);
        }
    }

    void inOrder(Tree root){
        if(root != null){
            inOrder(root.left);
            System.out.print(root.value + "->");
            inOrder(root.right);
        }
    }

}


class Simple{
    public static void main(String args[]){
        BinaryTreeImpl tree = new BinaryTreeImpl();
        tree.add(104);
        tree.add(102);
        tree.add(101);
        tree.add(103);
        tree.add(105);
        tree.add(106);
        tree.iterate("preOrder");
        System.out.println();
        tree.iterate("postOrder");
        System.out.println();
        tree.iterate("inOrder");
        System.out.println();
        tree.iterate("levelOrder");
    }
}