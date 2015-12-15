package dataStructures.trees.binary.num;

/**
 * @author IvanLis
 * @version 1.0
 * @since 15/12/2015.
 * <p>
 * labs
 */
public class BinaryTree {

    private Node root;


    public BinaryTree(Node root) {
        initBinaryTree(root);
    }

    private void initBinaryTree (Node root) {
        this.root = root;
        root.setHeight(1);
    }


    private int height(Node node) {
        if (node == null) {
            return 0;
        }
        else
            return node.getHeight();
    }

    private int balance(Node node) {
        if (node == null) {
            return 0;
        }
        else return (height(node.getLeftChild()) - height(node.getRightChild()));
    }

    private Node rotateRight(Node node) {
        System.out.println("Rotating right");
        Node newNode = node.getLeftChild();
        Node temp = newNode.getRightChild();
        newNode.setRightChild(node);
        node.setLeftChild(temp);

        node.setHeight(max(height(node.getLeftChild()), height(node.getRightChild())) + 1 );
        newNode.setHeight(max(height(newNode.getLeftChild()), height(node.getRightChild())) + 1);
        return newNode;
    }

    private Node rotateLeft(Node node) {
        System.out.println("Rotating left");
        Node newNode = node.getRightChild();
        Node temp = newNode.getLeftChild();
        newNode.setLeftChild(node);
        node.setRightChild(temp);

        node.setHeight(max(height(node.getLeftChild()), height(node.getRightChild())) + 1 );
        newNode.setHeight(max(height(newNode.getLeftChild()), height(node.getRightChild())) + 1);
        return newNode;
    }

    public int max(int num1, int num2){
        return (num1 > num2 ? num1 : num2);
    }

    public Node addNode(Node node, Integer value) {
        if (node == null) {
            return new Node(value);
        }
        else {
            if (node.getValue() > value) {
                node.setLeftChild(addNode(node.getLeftChild(), value));
            }
            else
                node.setRightChild(addNode(node.getRightChild(), value));

            node.setHeight(max(height(node.getLeftChild()), height(node.getRightChild())) + 1);
            int balanceVal = balance(node);
//            System.out.println(balanceVal);

            // left left rotation
            if (balanceVal > 1 && value < node.getLeftChild().getValue()) {
                return rotateRight(node);
            }
            // right right
            if (balanceVal < -1 && value > node.getLeftChild().getValue()) {
                return rotateLeft(node);
            }

            // left right

            if (balanceVal > 1 && value > node.getLeftChild().getValue()) {
                node.setLeftChild(rotateLeft(node.getLeftChild()));
                return rotateRight(node);
            }

            // right left
            if (balanceVal < -1 && value < node.getLeftChild().getValue()) {
                node.setRightChild(rotateRight(node.getRightChild()));
                return rotateLeft(node);
            }
            return node;
        }
    }

    public void preOrder(Node node) {
        if (node != null) {
            System.out.println("Value: " + node.getValue());
//            System.out.println("\tHeight: " + node.getHeight() + "\nBalance: " + balance(node));
            preOrder(node.getLeftChild());
            preOrder(node.getRightChild());
        }
    }

    public void inOrder(Node root){
        if (root == null){
            return;
        }
        inOrder(root.getLeftChild());
        System.out.println(root.getValue());
        inOrder(root.getRightChild());
    }

    public void findMax(Node root){
        if (root.getRightChild() == null) {
            System.out.println(root.getValue());
            return;
        }
        findMax(root.getRightChild());
    }

    public void findMin(Node root) {
        if (root.getLeftChild() == null) {
            System.out.println(root.getValue());
            return;
        }
        findMax(root.getLeftChild());
    }



}
