package trees.binary.avl;

import java.util.function.Function;

/**
 * @author IvanLis
 * @version 1.0
 * @since 15/12/2015.
 * <p>
 * labs
 */
public class BinaryTree {

    private Node root;
    private Function<Integer, Node> newNode = Node::new;

    public BinaryTree(Node root) {
        initBinaryTree(root);
    }

    private void initBinaryTree(Node root) {
        this.root = root;
        root.setHeight(1);
    }


    private int height(Node node) {
        if (node == null) {
            return 0;
        } else
            return node.getHeight();
    }

    private int balance(Node node) {
        if (node == null) {
            return 0;
        } else return height(node.getLeftChild()) - height(node.getRightChild());
    }

    private Node rotateRight(Node node) {
        Node newNode = node.getLeftChild();
        Node temp = newNode.getRightChild();
        newNode.setRightChild(node);
        node.setLeftChild(temp);

        node.setHeight(max(height(node.getLeftChild()), height(node.getRightChild())) + 1);
        newNode.setHeight(max(height(newNode.getLeftChild()), height(node.getRightChild())) + 1);
        return newNode;
    }

    private Node rotateLeft(Node node) {
        Node newNode = node.getRightChild();
        Node temp = newNode.getLeftChild();
        newNode.setLeftChild(node);
        node.setRightChild(temp);
        node.setHeight(max(height(node.getLeftChild()), height(node.getRightChild())) + 1);
        newNode.setHeight(max(height(newNode.getLeftChild()), height(node.getRightChild())) + 1);
        return newNode;
    }

    private Node leftRightRotation(Node node) {
        node.setLeftChild(rotateLeft(node.getLeftChild()));
        return rotateRight(node);
    }

    private Node rightLeftRotation(Node node) {
        node.setRightChild(rotateRight(node.getRightChild()));
        return rotateLeft(node);
    }


    private int max(int num1, int num2) {
        return (num1 > num2 ? num1 : num2);
    }

    public Node addNode(Node node, Integer value) {
        if (node == null) {
            return newNode.apply(value);
        } else {
            if (node.getValue() > value) {
                node.setLeftChild(addNode(node.getLeftChild(), value));
            } else
                node.setRightChild(addNode(node.getRightChild(), value));

            node.setHeight(max(height(node.getLeftChild()), height(node.getRightChild())) + 1);
            int balanceVal = balance(node);
//            System.out.println(balanceVal);

            // left left rotation
            if (balanceVal > 1 && value < node.getLeftChild().getValue()) {
                System.out.println("Right Rotation");
                return rotateRight(node);
            }
            // right right
            if (balanceVal < -1 && value > node.getRightChild().getValue()) {
                System.out.println("Left Rotation");
                return rotateLeft(node);
            }

            // left right

            if (balanceVal > 1 && value > node.getLeftChild().getValue()) {
                System.out.println("Left right rotation");
                return leftRightRotation(node);
            }

            // right left
            if (balanceVal < -1 && value < node.getRightChild().getValue()) {
                System.out.println("Right Left rotation");
                rightLeftRotation(node);
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

    public void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.getLeftChild());
        System.out.println(root.getValue());
        inOrder(root.getRightChild());
    }

    public void findMax(Node root) {
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
        findMin(root.getLeftChild());
    }

    public void findMinMax(Node root) {
        System.out.print("Min: ");
        findMin(root);
        System.out.print("Max: ");
        findMax(root);

//        while(current.getLeftChild() != null) {
//            current = current.getLeftChild();
//        }
//        System.out.println(current.getValue());
//
//        current = root;
//        while(current.getRightChild() != null) {
//            current = current.getRightChild();
//        }
//        System.out.println(current.getValue());
    }

    public boolean isElementExist(Node root, Integer value) {
        Node current = root;
        while (current != null) {
            if (current.getValue().equals(value)) {
                return true;
            } else if (current.getValue() > value) {
                current = current.getLeftChild();
            } else
                current = current.getRightChild();
        }
        return false;
    }
}

