package dataStructures.trees.binary.num;

/**
 * @author IvanLis
 * @version 1.0
 * @since 15/12/2015.
 * <p>
 * labs
 */
public class BinaryTreeDemo {

    public static void main(String[] args) {
        Node root = new Node(5);

        BinaryTree avlTree = new BinaryTree(root);

        root = avlTree.addNode(root, 4);
        root = avlTree.addNode(root, 3);
        root = avlTree.addNode(root, 2);

        System.out.println("Pre Order");
        avlTree.preOrder(root);
        System.out.println("\nIn Order");
        avlTree.inOrder(root);


    }
}
