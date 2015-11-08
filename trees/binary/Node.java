package DataStructures.trees.binary;

/**
 * Created by IvanLis on 08/11/15.
 * Student No: c00185055
 * All rights reserved
 */
public class Node <T> {

    private T data;
    private Node lChild;
    private Node rChild;


    public Node(T data) {
        this.data = data;
        initChildNodes();
    }

    public T getData() {
        return data;
    }

    public Node getlChild() {
        return lChild;
    }

    public Node getrChild() {
        return rChild;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setlChild(Node lChild) {
        this.lChild = lChild;
    }

    public void setrChild(Node rChild) {
        this.rChild = rChild;
    }

    private void initChildNodes(){
        lChild = null;
        rChild = null;
    }
}
