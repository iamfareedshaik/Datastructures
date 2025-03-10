class TreeNode{
    int key;
    TreeNode left;
    TreeNode right;
    int height;
    TreeNode(int key){
        this.key = key;
        this.left = this.right = null;
        this.height = 1;
    }
}


class BinaryTree{
    TreeNode root;
    void createNode(int key){
        TreeNode temp = new TreeNode(key);
        root = insertNode(root, temp);
    }

    TreeNode insertNode(TreeNode root, TreeNode temp){
        if(root == null){
            return temp;
        }
        if(temp < root.key){
            root.left = insertNode(root.left, temp);
        }
        if(temp > root.key){
            root.right = insertNode(root.right, temp);
        }

        root.height= Math.max(getHeight(root.left), getHeight(root.right)) + 1;

        int bf = getBalance(root);

        if(bf < 0){
            TreeNode temp =  root.right;
            root.right = temp.left;
            temp.left = root;
        }
        if(bf > 0){
            TreeNode temp = root.left;
            root.left = temp.right;
            temp.right = root;
        }
        if(bf < 0 && temp.key < root.right.key){
            TreeNode temp = root.left;
            root.left = temp.right;
            temp.right = root;
        }
    }

    int getBalance(TreeNode root){
        if(root == null) return 0;
        return getHeight(root.left) - getHeight(root.right);
    }

    int getHeight(TreeNode root){
        if(root == null) return 0;
        return root.height;
    }
}