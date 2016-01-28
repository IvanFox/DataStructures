package dataStructures.trees.huffman_algo;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


/**
 * Created by IvanLis on 15/11/15.
 * Student No: c00185055
 * All rights reserved
 */

public class Logic {

    private static class LazyHolder {
        private static final Logic INSTANCE = new Logic();
    }


    private static String filename;
    private static HashMap<Character, Integer> hashMap;
    private static HashMap<Character, String> huffmanCodes;
    private static Queue<Node> nodes;
    private static Node root;

    private Logic() {
        hashMap = new HashMap<>();
        nodes = new PriorityQueue<>();
        huffmanCodes = new HashMap<>();

    }

    public static Logic getInstance() {
        return LazyHolder.INSTANCE;
    }

    public void setPathToFile(String filename) {
        Logic.filename = filename;
        initClassStructure();
    }


    private void readFile() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))) {
            int ch, value;
            while ((ch = bufferedReader.read()) != -1) {
                // if current char is not exist as a value in HashMap -> add it
                if (hashMap.get((char) ch) == null) {
                    hashMap.put((char) ch, 1);
                } else { // else increment value
                    value = hashMap.get((char) ch);
                    hashMap.put((char) ch, ++value);
                }
            }
        } catch (IOException e) {

        }
    }

    public HashMap<Character, Integer> getHashMap() {
        return hashMap;
    }

    private Queue<Node> convertHashMapToList() {
        Queue<Node> queue = new PriorityQueue<>((Comparator.comparing(Node::getOccurrence)));
        hashMap.entrySet().stream().map(Node::new).forEach(queue::add);
        return queue;
    }

    private Node createTree(Queue<Node> list) {

        Node lowest1, lowest2;
        while (list.size() != 1) {
            lowest1 = list.remove();
            lowest2 = list.remove();
            list.add(new Node(lowest1, lowest2));
        }
        return list.remove();
    }

    private HashMap<Character, String> generateHuffmanScheme(Node root, HashMap<Character, String> map, String s) {
        if (root.isLeaf()) {
            map.put(root.getCharacter(), s);
            return map;
        }
        generateHuffmanScheme(root.getLeftChild(), map, s + "0");
        generateHuffmanScheme(root.getRightChild(), map, s + "1");
        return map;
    }

    public HashMap<Character, String> getHuffmanCodes() {
        if (huffmanCodes != null) return huffmanCodes;
        return null;
    }

    private void initClassStructure() {
        readFile();
        nodes = convertHashMapToList();
        root = createTree(nodes);
        huffmanCodes = generateHuffmanScheme(root, huffmanCodes, "");
    }

    public StringBuilder decodeEncodedOutput(StringBuilder endodedOutput) {
        StringBuilder currentChar = new StringBuilder(); // holds binary representation of first retrieved char
        StringBuilder decodedOutput = new StringBuilder(); // used to return decoded output

        while (endodedOutput.length() > 0) {
            currentChar.append(endodedOutput.charAt(0));
            endodedOutput.deleteCharAt(0);
            // when currentChar binary representation matched with values in HashMap -> find and add the key of this value
            if (getHuffmanCodes().containsValue(currentChar.toString())) {
                getHuffmanCodes().entrySet().stream().filter(e -> Objects.equals(e.getValue(), currentChar.toString())).forEach(e -> {
                    decodedOutput.append(e.getKey());
                    currentChar.delete(0, currentChar.length());
                });
            }
        }
        return decodedOutput;
    }

    public StringBuilder generateEncodedOutput() throws Exception {
        StringBuilder output = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))) {
            int c;
            while ((c = bufferedReader.read()) != -1) {
                output.append(huffmanCodes.get((char) c));
            }
        }
        return output;
    }


    private class Node {

        private Character character;
        private int occurrence;
        private Node leftChild;
        private Node rightChild;

        // constructor for internal node
        public Node(Node one, Node two) {
            this.leftChild = one;
            this.rightChild = two;
            this.occurrence = one.getOccurrence() + two.getOccurrence();
            this.character = null;
        }

        public Node(Map.Entry<Character, Integer> entry) {
            this.character = entry.getKey();
            this.occurrence = entry.getValue();
        }

        public Character getCharacter() {
            return character;
        }

        public int getOccurrence() {
            return occurrence;
        }


        public Node getLeftChild() {
            return leftChild;
        }


        public Node getRightChild() {
            return rightChild;
        }


        public boolean isLeaf() {
            return leftChild == null && rightChild == null;
        }

        @Override
        public String toString() {
            return "Character: " + character + " = Occurrence: " + occurrence;
        }

    }
}
