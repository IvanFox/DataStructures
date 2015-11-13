package DataStructures.trees.binary;

/**
 * Created by IvanLis on 08/11/15.
 * Student No: c00185055
 * All rights reserved
 */
public class BinaryTree <T> {

    private Node root;
    private int size;
    private int height;


    public BinaryTree(Node root) {
        initBinaryTree(root);
    }


    private void initBinaryTree(Node node){
        root = node;
        size = 1;
        height = 1;
        node.setParent(null);
    }

    public int getHeight() {
        return height;
    }

    public Node getRoot() {
        return root;
    }

    public int getSize() {
        return size;
    }

    public void addLChild(Node child, Node parent){
        if(getHeight() == 1){
            child.setParent(root);
            root.setLeftChild(child);
        }
        else {

        }




    }


    public void addRChild(Node child){



    }
}
