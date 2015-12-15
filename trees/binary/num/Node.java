package dataStructures.trees.binary.num;

/**
 * @author IvanLis
 * @version 1.0
 * @since 15/12/2015.
 * <p>
 * labs
 */
public class Node {

    private Node leftChild;
    private Node rightChild;
    private Node parent;
    private Integer value;
    private Integer height;

    public Node(Integer value) {
        this.value = value;
        initNode();
    }

    public Node() {
        initNode();

    }

    private void initNode(){
        this.leftChild = null;
        this.rightChild = null;
        setHeight(1);
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public boolean hasLeft() {
        return getLeftChild() != null;
    }

    public boolean hasRight() {
        return getRightChild() != null;
    }

    public boolean isLeaf() {
        return !(hasLeft() && hasRight());
    }

}
