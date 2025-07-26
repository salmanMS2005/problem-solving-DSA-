package trees;

import java.util.Scanner;

public class Binarytrees {
    private static class Node{
        int value;
        Node right;
        Node left;
        public Node(int value){
            this.value=value;
        }
    }
    private Node root;

    public void populate(Scanner scanner){
        System.out.println("enter the root node:");
        int value= scanner.nextInt();
        root=new Node(value);
        populate(scanner,root);
    }
    private void populate(Scanner scanner,Node node){
        System.out.println("want to add value at the left of "+node.value);
        boolean left=scanner.nextBoolean();
        if(left){
            System.out.println("enter the left node value:");
            int val=scanner.nextInt();
            node.left=new Node(val);
            populate(scanner,node.left);
        }
        System.out.println("want to add value at the right of "+node.value);
        boolean right=scanner.nextBoolean();
        if(right){
            System.out.println("enter the right value of "+node.value);
            int val=scanner.nextInt();
            node.right=new Node(val);
            populate(scanner,node.right);
        }
    }
    public void display(){
        display(root,"");
    }
    private void display(Node root,String space){
        if(root==null){
            return;
        }
        System.out.println(space+root.value);
        display(root.right,space+"\t");
        display(root.left,space+"\t");
    }
    public void prettydisplay(){
        prettydisplay(root,0);
    }
    private void prettydisplay(Node root,int level){
        if(root==null){
            return;
        }
        prettydisplay(root.right,level+1);

        if(level!=0){
            for(int i=0;i<level-1;i++){
                System.out.print("|\t\t");
            }
            System.out.println("|-------->"+root.value);
        }
        else{
            System.out.println(root.value);
        }
        prettydisplay(root.left,level+1);
    }
}
