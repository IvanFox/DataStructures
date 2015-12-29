package dataStructures.trees.binary.avl;

/**
 * @author IvanLis
 * @version 1.0
 * @since 15/12/2015.
 * <p>
 * labs
 */
public class BinaryTreeDemo {

    public static void main(String[] args) {
        Node root = new Node(13);
        BinaryTree avlTree = new BinaryTree(root);

        root = avlTree.addNode(root, 17);
//        root = avlTree.addNode(root, 5);
//        root = avlTree.addNode(root, 10);
//        root = avlTree.addNode(root, 4);
//        root = avlTree.addNode(root, 6);
//        root = avlTree.addNode(root, 8);
//        root = avlTree.addNode(root, 7);
        root = avlTree.addNode(root, 18);


        System.out.println("Pre Order");
        avlTree.preOrder(root);

        System.out.println("\nIn Order");
        avlTree.inOrder(root);

        System.out.println("Root value: " + root.getValue());
        System.out.println(avlTree.isElementExist(root, 8));

//        avlTree.findMinMax(root);
    }
}
