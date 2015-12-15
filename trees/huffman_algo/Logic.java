package dataStructures.trees.huffman_algo;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;


/**
 * Created by IvanLis on 15/11/15.
 * Student No: c00185055
 * All rights reserved
 */

public class Logic {

    private final String filename;
    private HashMap<Character, Integer> hashMap;
    private HashMap<Character, String> huffmanCodes;
    private List<Node> nodes;
    private Node root;

    public Logic(String filename) throws Exception {
        this.filename = filename;
        hashMap = new HashMap<>();
        nodes = new ArrayList<>();
        huffmanCodes = new HashMap<>();
        initClassStructure();
    }

     private void readFile() {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))) {
            int ch, value;
            while ((ch = bufferedReader.read()) != -1) {
                // if current char is not exist as a value in HashMap -> add it
                if(hashMap.get((char)ch) == null) {
                    hashMap.put((char) ch, 1);
                }
                else { // else increment value
                    value = hashMap.get((char)ch);
                    hashMap.put((char)ch, ++value);
                }
            }
        }
        catch (IOException e){

        }
    }

    public HashMap<Character, Integer> getHashMap() {
        return hashMap;
    }

    private void convertHashMapToList(){
        Iterator<Entry<Character, Integer>> itr = hashMap.entrySet().iterator();
        while(itr.hasNext()){
            nodes.add(new Node(itr.next()));
        }
    }

     private void  createTree(){
        Node lowest1, lowest2;
        while (nodes.size() != 1){
            lowest1 = nodes.stream().min(Comparator.<Node>naturalOrder()).get();
            nodes.remove(lowest1);
            lowest2 = nodes.stream().min(Comparator.<Node>naturalOrder()).get();
            nodes.remove(lowest2);
            nodes.add(new Node(lowest1, lowest2));
        }
        root = nodes.get(0);
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

    private void initClassStructure() throws Exception {
        readFile();
        convertHashMapToList();
        createTree();
        huffmanCodes = generateHuffmanScheme(root, huffmanCodes, "");
    }

    public StringBuilder decodeEncodedOutput(StringBuilder endodedOutput){
        StringBuilder currentChar = new StringBuilder(); // holds binary representation of first retrieved char
        StringBuilder decodedOutput = new StringBuilder(); // used to return decoded output

        while (endodedOutput.length() > 0){
            currentChar.append(endodedOutput.charAt(0));
            endodedOutput.deleteCharAt(0);
            // when currentChar binary representation matched with values in HashMap -> find and add the key of this value
            if (getHuffmanCodes().containsValue(currentChar.toString())){
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
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))) {
            int c;
            while ((c = bufferedReader.read()) != -1) {
                output.append(huffmanCodes.get((char) c));
            }
        }
        return output;
    }
}
