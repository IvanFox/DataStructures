package DataStructures.trees.huffman_algo;


import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.util.Map.Entry;


/**
 * Created by IvanLis on 15/11/15.
 * Student No: c00185055
 * All rights reserved
 */

public class Logic {

    private final String filename;


    /**
     *
     * @param filename the filename of an text file
     */
    public Logic(String filename) {
        this.filename = filename;
    }

    /**
     *
     * @param hashMap
     * @return read file and returns HashMap with an character as a key  and number of occurrence as a value
     */
    public HashMap<Character, Integer> readFile(HashMap<Character, Integer> hashMap){
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))) {
            int c, value;
            while ((c = bufferedReader.read()) != -1) {
                // if current char is not exist as a value in HashMap -> add it
                if(hashMap.get((char)c) == null) {
                    hashMap.put((char) c, 1);
                }
                else { // else increment value
                    value = hashMap.get((char)c);
                    hashMap.put((char)c, ++value);
                }
            }
        }catch (Exception e){
        e.printStackTrace();
        }
        return hashMap;
    }

    /**
     *
     * @param nodes
     * @param hashMap
     * @return returns collection of nodes -> represented as a list
     */
    public List<Node> convertHashMapToList (List<Node> nodes, HashMap<Character, Integer> hashMap){
        Iterator<Entry<Character, Integer>> itr = hashMap.entrySet().iterator();
        while(itr.hasNext()){
            nodes.add(new Node(itr.next()));
        }
        return nodes;
    }

    /**
     *
     * @param nodes receives number of nodes as a list
     * @return returns the root of the created binary tree
     */
     public static Node createTree(List<Node> nodes){
        Node lowest1, lowest2;
        while (nodes.size() != 1){
            lowest1 = nodes.stream().min(Comparator.<Node>naturalOrder()).get();
            nodes.remove(lowest1);
            lowest2 = nodes.stream().min(Comparator.<Node>naturalOrder()).get();
            nodes.remove(lowest2);
            nodes.add(new Node(lowest1, lowest2));
        }
        return nodes.get(0);
    }

    public HashMap<Character, String> generateHuffmanCode(Node node, HashMap<Character, String> map, String s) {
        if (node.isLeaf()) {
            map.put(node.getCharacter(), s);
            return map;
        }
        generateHuffmanCode(node.getLeftChild(), map, s + "0");
        generateHuffmanCode(node.getRightChild(), map, s + "1");
        return map;
    }
}
