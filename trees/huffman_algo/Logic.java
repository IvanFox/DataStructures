package DataStructures.trees.huffman_algo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;


/**
 * Created by IvanLis on 15/11/15.
 * Student No: c00185055
 * All rights reserved
 */
public class Logic {

    private static HashMap<Character, Integer> readFile(String filename, HashMap<Character, Integer> hashMap){
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))) {
            int c, value;
            while ((c = bufferedReader.read()) != -1) {
                if(hashMap.get((char)c) == null) {
                    hashMap.put((char) c, 1);
                }
                else {
                    value = hashMap.get((char)c);
                    hashMap.put((char)c, ++value);
                }

            }

        }catch (Exception e){
        e.printStackTrace();
        }
        return hashMap;
    }

    public static void main(String[] args) {
        String filename = "/Users/IvanLis/test.txt";

        HashMap<Character, Integer> hashMap = new HashMap<>();
        hashMap = readFile(filename,hashMap);

        System.out.println(hashMap.get('a'));


    }

}
