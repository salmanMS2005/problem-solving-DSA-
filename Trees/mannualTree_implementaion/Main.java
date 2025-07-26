package trees;

public class Maintree {
    public static void main(String[] args) {

        
        //binary tree implementation
        Scanner sc =new Scanner(System.in);
        Binarytrees bt = new Binarytrees();
        bt.populate(sc);
        bt.prettydisplay();
        bt.display();*/

        
        //binary search tree implementation
        BST bst=new BST();
        int[] arr={5,2,7,1,4,6,9,8,3,10};
        bst.putvalue(arr);
        bst.display();
        bst.inorder();
        bst.isbalanced();
        */

        AVL
        AVL avl=new AVL();
        for(int i=1;i<8;i++){
            avl.insert(i);
        }
        int[] arr={1,2,3,4,5,6,7};
        avl.putvalue(arr);
        avl.prettydisplay();*/

        //segment trees
        int[] arr={3,8,6,7,-2,-8,4,9};
        segmentTree st =new segmentTree(arr);
        st.display();
        System.out.println(st.query(0,7));
        st.changes(7000,1);
        st.display();
        System.out.println(st.query(0,7));
    }
}
