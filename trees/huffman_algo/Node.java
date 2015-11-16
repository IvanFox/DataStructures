package DataStructures.trees.huffman_algo;

import java.util.Map;

/**
 * Created by IvanLis on 15/11/15.
 * Student No: c00185055
 * All rights reserved
 */
public class Node {

    private Character character;
    private double occurrence;
    private Node leftChild;
    private Node rightChild;

    public Node(Character character, double occurrence) {
        this.character = character;
        this.occurrence = occurrence;
    }

    public Node(Map.Entry<Character, Double> entry){
        this.character = entry.getKey();
        this.occurrence = entry.getValue();
    }

    public Character getCharacter() {
        return character;
    }


    public void setCharacter(Character character) {
        this.character = character;
    }

    public double getOccurrence() {
        return occurrence;
    }

    public void setOccurrence(double occurrence) {
        this.occurrence = occurrence;
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

    public boolean isLeaf(){
        return leftChild == null && rightChild == null;
    }

    @Override
    public String toString(){
        return "Character: " + character + " = Occurrence: " + occurrence;
    }
}
