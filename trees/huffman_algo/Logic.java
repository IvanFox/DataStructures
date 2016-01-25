package dataStructures.trees.huffman_algo;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;


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
    private static List<Node> nodes;
    private static Node root;

    private Logic() {
        hashMap = new HashMap<>();
        nodes = new ArrayList<>();
        huffmanCodes = new HashMap<>();
        initClassStructure();
    }

    public static Logic getInstance(String filename) {
        Logic.filename = filename;
        return LazyHolder.INSTANCE;
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

    public static HashMap<Character, Integer> getHashMap() {
        return hashMap;
    }

    private static List<Node> convertHashMapToList() {
        return hashMap.entrySet().stream().map(Node::new).collect(Collectors.toList());
    }

    private static Node createTree(List<Node> list) {
        Node lowest1, lowest2;
        while (list.size() != 1) {
            lowest1 = list.stream().min(Comparator.<Node>naturalOrder()).get();
            list.remove(lowest1);
            lowest2 = list.stream().min(Comparator.<Node>naturalOrder()).get();
            list.remove(lowest2);
            list.add(new Node(lowest1, lowest2));
        }
        return list.get(0);
    }

    private static HashMap<Character, String> generateHuffmanScheme(Node root, HashMap<Character, String> map, String s) {
        if (root.isLeaf()) {
            map.put(root.getCharacter(), s);
            return map;
        }
        generateHuffmanScheme(root.getLeftChild(), map, s + "0");
        generateHuffmanScheme(root.getRightChild(), map, s + "1");
        return map;
    }

    public static HashMap<Character, String> getHuffmanCodes() {
        if (huffmanCodes != null) return huffmanCodes;
        return null;
    }

    private void initClassStructure() {
        readFile();
        nodes = convertHashMapToList();
        root = createTree(nodes);
        huffmanCodes = generateHuffmanScheme(root, huffmanCodes, "");
    }

    public static StringBuilder decodeEncodedOutput(StringBuilder endodedOutput) {
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

    public static StringBuilder generateEncodedOutput() throws Exception {
        StringBuilder output = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))) {
            int c;
            while ((c = bufferedReader.read()) != -1) {
                output.append(huffmanCodes.get((char) c));
            }
        }
        return output;
    }
}
