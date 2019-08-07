package Codes;

import java.util.*;

class Node{
    int data;
    Node left,right;
    int pos;
    Node(int data,int pos){
        this.data=data;
        left=null;
        right=null;
        this.pos=pos;
    }
}
class BST{
    static Node root=null;
    static int position=0;

    static Node insert(Node root,int data,int pos){
        if(root==null) {
            System.out.println(pos);
            return new Node(data,pos);
        }
        else if(data>root.data)
            root.right=insert(root.right,data,pos*2+1);
        else
            root.left=insert(root.left,data,pos*2);
        return root;
    }

    /*static void fillPos(Node root,int pos){
    if(root==null)return;
    root.pos=pos;
    fillPos(root.right,2*pos+1);
    fillPos(root.left,2*pos);
    }

    static void printPos(Node root,int data) {
    if(root==null)return;
    if(data==root.data)
    System.out.println(root.pos);
    if(data>root.data)
    printPos(root.right,data);
    else
    printPos(root.left,data);
    }
    */
    static Node delete(Node root,int data){
        if (root == null){
            return root;
        }
        if (data < root.data)
            root.left = delete(root.left, data);
        else if (data > root.data)
            root.right = delete(root.right, data);
        else{
            System.out.println(root.pos);
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
            root.data = minValue(root.right);
            root.right = delete(root.right, root.data);
        }
        return root;
    }

    static int minValue(Node root)
    {
        int minval = root.data;
        while (root.left != null)
        {
            minval = root.left.data;
            root = root.left;
        }
        return minval;
    }
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        int q=0;
        if(sc.hasNextInt())
            q=sc.nextInt();
        while(q-->0){

            String inp=sc.next();
            int data=sc.nextInt();
            if(inp.equals("i")){

                root=insert(root,data,1);
            }
            else if(inp.equals("d")){
                root=delete(root,data);
            }

        }
        sc.close();
    }

}

