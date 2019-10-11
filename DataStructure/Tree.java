package BinarySearchTraversal;

public class Tree {
    Node node;

    public Tree(int value) {
        node = new Node(value);
    }
    public Node insert(Node node,int value){
        if(node==null){
            return new Node(value);
        }
        //move to the left if the passed value is less than the current node
        if(value<node.value)
            node.left=(insert(node.left,value));

        //move to the right if the passed value is greater than the current node
        if(value>=node.value)
            node.right=insert(node.right,value);

        return node;
    }

    //For Traversing in Order
    public void inOrder(Node node){
        if(node!=null){
            inOrder(node.left);
            System.out.println(node.value+" ");
            inOrder(node.right);
        }
    }

    //Traversing in DescOrder
    public void inDescOrder(Node node){
        if(node!=null){
            inOrder(node.right);
            System.out.println(node.value+" ");
            inOrder(node.left);
        }
    }
}
