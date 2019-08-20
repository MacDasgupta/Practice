package DailyCodingProblem;

import Useful.BNode;

public class UnivalCount {

    BNode root;
    int count =0;
    public static void main(String[] args) {
        /* Let us construct the below tree
                5
              /   \
            4      5
          /  \      \
         4    4      5 */

        UnivalCount tree = new UnivalCount();
        tree.root = new BNode(5);
        tree.root.left = new BNode(4);
        tree.root.right = new BNode(5);
        tree.root.left.left = new BNode(4);
        tree.root.left.right = new BNode(4);
        tree.root.right.right = new BNode(5);

        System.out.println("The value of single value sub tree is "+tree.countSingle());

    }

    int countSingle(){
        return countSingle(root);
    }
    int countSingle(BNode node){
        countSingleRec(node);
        return count;
    }

    boolean countSingleRec(BNode node){
        if(node==null)
            return true;

        // Recursively count in left and right subtrees also
        boolean left = countSingleRec(node.left);
        boolean right = countSingleRec(node.right);

        if(node.left !=null && node.data !=node.left.data)
            return false;
        if(node.right !=null && node.data !=node.right.data)
            return false;

        count++;
        return true;


    }

}
