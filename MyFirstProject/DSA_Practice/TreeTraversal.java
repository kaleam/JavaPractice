package DSA_Practice;

class Node{
    public int data;
    public Node left, right;
    public Node(int data){
        this.data = data;
        left = right = null;
    }
}

class Tree{
    public Node root;
    public Tree(){
        root = null;
    }
    public void inorder(Node root){
        if(root == null)
            return;
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    public void preorder(Node root){
        if(root == null)
            return;
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
    public void postOrder(Node root){
        if(root == null)
            return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+" ");
    }
}

public class TreeTraversal {
    public static void main(String[] args) {
        Tree pt = new Tree();
        Node root = new Node(36);
        pt.root = root;
        pt.root.left = new Node(26);
        pt.root.right = new Node(46);
        pt.root.left.left = new Node(21);
        pt.root.left.right = new Node(31);
        pt.root.left.left.left = new Node(11);
        pt.root.left.left.right = new Node(24);
        pt.root.right.left = new Node(41);
        pt.root.right.right = new Node(56);
        pt.root.right.right.left = new Node(51);
        pt.root.right.right.right = new Node(66);

        System.out.println();
        System.out.println("The Preorder traversal of given binary tree is - ");
        pt.preorder(root);
        System.out.println("\n");
        System.out.println("The Inorder traversal of given binary tree is - ");
        pt.inorder(root);
        System.out.println("\n");
        System.out.println("The Postorder traversal of given binary tree is - ");
        pt.postOrder(root);
        System.out.println();
    }

}
