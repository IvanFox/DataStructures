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
        root = avlTree.addNode(root, 1);
        root = avlTree.addNode(root, 6);
        root = avlTree.addNode(root, 8);
        root = avlTree.addNode(root, 0);
        root = avlTree.addNode(root, 5);
        root = avlTree.addNode(root, 9);
        root = avlTree.addNode(root, 15);
        root = avlTree.addNode(root, 45);
        root = avlTree.addNode(root, 10);
        root = avlTree.addNode(root, 34);
        root = avlTree.addNode(root, 40);
        root = avlTree.addNode(root, 45);
        root = avlTree.addNode(root, 50);
        root = avlTree.addNode(root, 55);
        root = avlTree.addNode(root, 55);
        root = avlTree.addNode(root, 65);
        root = avlTree.addNode(root, 75);
        root = avlTree.addNode(root, 85);
        root = avlTree.addNode(root, 95);


        System.out.println("Pre Order");
        avlTree.preOrder(root);

        System.out.println("\nIn Order");
        avlTree.inOrder(root);

        System.out.println("Root value: " + root.getValue());


//        avlTree.findMinMax(root);
    }
}
