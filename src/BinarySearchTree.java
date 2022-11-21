public class BinarySearchTree{
    Node root;
    public void insert(Node node){
        root = insertHelper(root, node);
    }
    private Node insertHelper(Node root ,Node node){
        int data = node.data;
        if(root == null){
            root = node;
            return root;
        }
        else if (data < root.data) {
            root.Left = insertHelper(root.Left, node);
        }
        else {
            root.right = insertHelper(root.right, node);
        }
        return root;
    }
    public void Display(){
        displayHelper(root);
    }
    private void displayHelper(Node root){
        if (root != null){
            displayHelper(root.Left);
            System.out.println(root.data);
            displayHelper(root.right);
        }
    }
    public Boolean search(int data){
        return searchHelper(root, data);
    }
    private Boolean searchHelper(Node root, int data) {
        if (root == null) {
            return false;
        }
        else if (root.data == data) {
            return true;
        }
        else if (root.data > data)
        {
            return searchHelper(root.Left, data);
        }
        else {
            return searchHelper(root.right, data);
        }
    }
    public void remove(int data){
        if(search(data)){
            removeHelper(root, data);
        }
        else {
            System.out.println(data + " could not be found");
        }
    }
    public Node removeHelper(Node root, int data){
        if(root == null){
            return root;
        }
        else if (data<root.data) {
            root.Left = removeHelper(root.Left, data);
        }
        else if (data>root.data) {
            root.right = removeHelper(root.right, data);

        }
        else { // node found
            if(root.Left == null && root.right == null){
                root = null;
            }
            else if (root.right!=null) { // find a successor to replace this node
               root.data = Successor(root);
               root.right = removeHelper(root.right, root.data);
            }
            else { // find a predecessor to replace this node
                root.data = predecessor(root);
                root.Left = removeHelper(root.Left, root.data);
            }
        }
        return root;
    }
    private int Successor(Node root){ // Find the least value bellow the right child of this root value
        root = root.right;
        while(root.Left != null){
            root = root.Left;
        }
        return root.data;
    }
    private int predecessor(Node root){ // Find the greatest value of the left child of this root node
        root = root.Left;
        while(root.right != null){
            root = root.right;
        }
        return root.data;
    }
}


