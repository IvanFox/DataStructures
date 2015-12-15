package dataStructures.trees.binary.object;

/**
 * Created by IvanLis on 13/11/15.
 * Student No: c00185055
 * All rights reserved
 */
public class BinaryDemo {

    public static void main(String[] args) {

        Person person = new Person("Ivan Lissitsnoi", "AOL", "Software Engineer Intern");
        Person person1 = new Person("Dmitrij Lob", "Google", "Software Engineer Intern");
        Person person2 = new Person("Liam Mooloney", "AOL", "Software Engineer Intern");
        Person person3 = new Person("John Doe", "Amazon", "Software Engineer Intern");
        Person person4 = new Person("Joe Fox", "SAP", "Software Engineer Intern");

        Node initNode = new Node(person);



        BinaryTree binaryTree = new BinaryTree(initNode);
        binaryTree.addLeftChild(new Node(person1));
        binaryTree.addRightChild(new Node(person1));
        binaryTree.addRightChild(new Node(person2));
        binaryTree.addRightChild(new Node(person4));
        binaryTree.addRightChild(new Node(person3));
        binaryTree.traverseInOrder(initNode);


        System.out.println(binaryTree.getSize());




    }

}
