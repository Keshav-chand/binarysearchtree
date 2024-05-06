import java.util.Scanner;
public class binarysearchtree{
    static class Node{
        int key;
        Node left,right;
    };
    static Node newNode(int data){//making new node temp
        Node temp=new Node();
        temp.key=data;
        temp.left=null;
        temp.right=null;

        return temp;
    }
    static Node insert(Node root,int key){
        Node newnode=newNode(key);
        Node x=root;
        Node currentparent=null;

        while(x!=null){
            currentparent=x;
            if(key<x.key){//checking for left subtree
                x=x.left;
            }
            else if(key>x.key){//checking for right subtree
                x=x.right;
            }
            else{
                System.out.println("value already exists");
                return newnode;
            }
        }
        if(currentparent==null){//for checking left and right condtion for inserting the values
            currentparent=newnode;
        }
        else if(key< currentparent.key){
            currentparent.left=newnode;
        }
        else{
            currentparent.right=newnode;
        }
        return currentparent;
    }
    static boolean search(Node root,int key){
        root = searchrecurssive(root,key);
        if(root!=null){
            return true;
        }
        else{
            return false;
        }
    }
    static Node searchrecurssive(Node root,int key){
        if(root==null || root.key==key){
            return root;
        }
        if(root.key>key){
            return searchrecurssive(root.left,key);
        }
        else{
            return searchrecurssive(root.right,key);
        }
    }
    static void inorder(Node root){
        if(root==null){
            return ;
        }
        else{
            inorder(root.left);
            System.out.println(root.key+"");
            inorder(root.right);
        }
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int value;
        boolean status;
        Node root=null;
        int []arr={34,1,89,22,19,38};

        for(int i=0;i<arr.length;i++){
            value=arr[i];
               if(root==null){
            root=insert(root,arr[i]);
        }
        else{
            insert(root,value);
        }}
        System.out.println("Inorder binary tree\n");
        inorder(root);

        int stop=-1;
        while(stop!=0){
            System.out.println("\nenter value to search");
            int val=sc.nextInt();
            status=search(root,val);
            if(status==true){
                System.out.println("Value found in tree \n Enter 0 to stop or another digit to continue searching");
                if(sc.nextInt()==0){
                    stop=0;
                }
              
            }
            else if(status==false) {
                System.out.println("Value not found in tree \n Enter 0 to stop or another digit to continue searching");
                    if(sc.nextInt()==0){
                        stop=0;
            }
        }}
        System.out.println("program completed");
        
}
}

