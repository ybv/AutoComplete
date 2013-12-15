package com.ybv.AutoC.servlet;
import java.util.*;
 
public class Trie {
 
    LinkedHashMap root;
    int nodeC;

    public Trie() {
       root = new LinkedHashMap();
       nodeC=0;
    }

    public Trie(String[] sa) {
        this(); 
        addAll(sa);
    }
 

    public Trie(Collection<String> sc) {
        this();
        addAll(sc);
    }
 

    public void add(String s) {
        LinkedHashMap<String,LinkedHashMap> curr_node = root;
        for (int i = 0, n = s.length(); i < n; i++) {
            Character s2 = s.charAt(i);
            String c = s2.toString();
            if (curr_node.containsKey(c)){
            		curr_node = curr_node.get(c);
            		//nodeC++;
            		//System.out.println("node VAL: " +nodeC+ "String :"+c);
            }
            else {
                curr_node.put(c, new LinkedHashMap<Character, HashMap>());
              //  nodeC+=1;
               // System.out.println("node VAL: " +nodeC+ "String :"+c);
                curr_node = curr_node.get(c);
            }
           

        }
        
        curr_node.put(s, new LinkedHashMap<Character, HashMap>()); // term
      //  System.out.println("node VAL: " +nodeC+ "String :"+s);
    }
 
    /**
     *  Adds a String[] of words to the trie
     * 
     *  @param sa String[] to add to the trie
     */
    public void addAll(String[] sa) {
        for (String s: sa)
            add(s);
    }
 
    /**
     *  Adds a Collection<String> of words to the trie
     * 
     *  @param sc Collection<String> to add to the trie
     */
    public void addAll(Collection<String> sc) {
        for (String s: sc)
            add(s);
    }
    
    public LinkedHashMap<String, LinkedHashMap> getRoot(){
		return root;
    	
    }
 
    public boolean contains(String s) {
        LinkedHashMap<String, LinkedHashMap> curr_node = root; 
        for (int i = 0, n = s.length(); i < n; i++) {
        	  Character s2 = s.charAt(i);
              String c = s2.toString();
            if (curr_node.containsKey(c))
                curr_node = curr_node.get(c);
            else 
                return false;
        }
        if (curr_node.containsKey('\0'))
            return true;
        else 
            return false; 
    }
}