package trees;

public class BST {
    private static class Node{
        private int value;
        private Node right;
        private Node left;
        private int height;

        public Node(int value){
            this.value=value;
        }
    }
    Node node;
    //getting the height
    public int getHeight(Node node){
        if(node==null){
            return -1;
        }else {
            return node.height;
        }
    }
    //checking is the node is empty
    public boolean isEmpty(){
        return node==null;
    }
    //getting the value of the particular node
    private int getValue(Node root){
        if(root==null){
            return -1;
        }
        return root.value;
    }
    //inserting the values of array into bst
    public void insert(int val){
        node=insert(val,node);
    }
    private Node insert(int val,Node node){
        if(node==null){
            node= new Node(val);
            return node;
        }
        if(val<node.value){
            node.left=insert(val,node.left);
        }
        if(val>node.value){
            node.right=insert(val,node.right);
        }
        node.height=Math.max(getHeight(node.left),getHeight(node.right))+1;

        return node;
    }
    //checking whether the tree is balanced
    public void isbalanced(){
        System.out.println(isbalanced(node));
    }
    private boolean isbalanced(Node node){
        if(node == null){
            return true;
        }
        return Math.abs(getHeight(node.left)-getHeight(node.right))<=1 && isbalanced(node.left) && isbalanced(node.right);
    }
    //inserting value from an array into bst
    public void putvalue(int[] arr){
        for(int i: arr){
            insert(i);
        }
    }
    //Displaying the bst:
    public void display(){
        displaybst(node,"Root node: ");
    }
    private void displaybst(Node node,String details){
        if(node==null){
            return;
        }
        System.out.println(details+node.value);
        displaybst(node.left,"left child of :"+node.value+":");
        displaybst(node.right,"right child of "+node.value+":");
    }
    //inserting a sorted array into a bst to overcome the limitations
    public void sortedinsert(int[] arr){
        sortedinsert(arr,0,arr.length-1);
    }
    private void sortedinsert(int[] arr,int st,int end){
        if(st>end){
            return;
        }
        int mid=st+(end-st)/2;
        insert(arr[mid]);
        sortedinsert(arr,st,mid);
        sortedinsert(arr,mid+1,end);
    }
    //preorder printing
    public void preorder(){
        preorder(node);
    }
    private void preorder(Node node){
        if(node==null){
            return;
        }
        System.out.println(node.value+" ");
        preorder(node.left);
        preorder(node.right);
    }
    //inorder printing
    public void inorder(){
        inorder(node);
    }
    private void inorder(Node node){
        if(node==null){
            return;
        }
        inorder(node.left);
        System.out.println(node.value+" ");
        inorder(node.right);
    }
    //postorder printing
    public void postorder(){
        postorder(node);
    }
    private void postorder(Node node){
        if(node==null){
            return;
        }
        postorder(node.left);
        postorder(node.right);
        System.out.println(node.value+" ");
    }
}
