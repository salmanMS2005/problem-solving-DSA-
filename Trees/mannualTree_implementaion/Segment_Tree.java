package trees;

public class segmentTree {
    private static class Node{
        private int val;
        private int stind;
        private int endind;
        Node left;
        Node right;

        public Node(int stind,int endind){
            this.stind=stind;
            this.endind=endind;
        }
    }
    Node root;
    public segmentTree(int[] arr){
        root=construct(arr,0,arr.length-1);
    }
    public Node construct(int[] arr,int st,int end){
        if(st==end){
            //leaf node
            Node leaf=new Node(st,end);
            leaf.val=arr[st];
            return leaf;
        }
        Node node=new Node(st,end);
        int mid=(st+end)/2;

        node.left=construct(arr,st,mid);
        node.right=construct(arr,mid+1,end);

        node.val=node.left.val+node.right.val;

        return node;
    }
    public void display(){
        display(root);
    }
    private void display(Node node){
        String str="";
        //left node
        if(node.left!=null) {
            System.out.print("Interval = [" + node.left.stind + "-" + node.left.endind + "] and data :" + node.left.val + "=> ");
        }else{
            System.out.println(" no left node present");
        }
        //center node
        System.out.print(" Interval = [" + node.stind + "-" + node.endind + "] and data :" + node.val );
        //right node
        if(node.right!=null) {
            System.out.print(" => Interval = [" + node.right.stind + "-" + node.right.endind + "] and data :" + node.right.val );
        }else{
            System.out.println(" no right node present");
        }
        System.out.println();

        if(node.left!=null){
            display(node.left);
        }
        if(node.right!=null){
            display(node.right);
        }
    }

//changing a value of the node by taking target index and then updating every val of the node
    public void changes(int val,int ind){
        root.val = changes(root,val,ind);
    }
    private int changes(Node node,int val,int ind){
        if(ind==node.stind && ind==node.endind){
            node.val=val;
            return node.val;
        }
        int mid=(node.stind+ node.endind)/2;
        if (ind <= mid) {
            changes(node.left,val,ind);
        } else {
            changes(node.right,val,ind);
        }
        node.val=node.left.val+node.right.val;
            return node.val;
        }

//adding the node value till the given range
    public int query(int st,int end){
        return query(root,st,end);
    }
    private int query(Node node,int st,int end){
        if(node.stind>=st && node.endind<=end){
            return node.val;
        }else if(node.stind>end || node.endind<st){
            return 0;
        }else{
            return query(node.left,st,end) + query(node.right,st,end);
        }
    }
}
