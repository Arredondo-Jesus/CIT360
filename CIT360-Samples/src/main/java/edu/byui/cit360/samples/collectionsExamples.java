/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.byui.cit360.samples;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 *
 * @author Jesus Arredondo
 */
public class collectionsExamples {

    public Set addElement(Set tree, String element) {
        tree.add(element);
        return tree;
    }

    public void printTree(Set tree) {
        //access via Iterator
        Iterator iterator = tree.iterator();

        while (iterator.hasNext()) {
            String element = (String) iterator.next();
            System.out.println(element);
        }
    }

    public Map addToMap(String key, String element) {
        Map map = new TreeMap();
        map.put(key, element);
        return map;

    }

    public void printMap(Map map) {
        for (Object key : map.keySet()) {
            Object value = map.get(key);
            System.out.println(value);
        }
    }

    public static void main(String args[]) {
        Map map = new TreeMap();
        Set set = new TreeSet();

        collectionsExamples ex = new collectionsExamples();
        map = ex.addToMap("hola", "Item 1 of a map");
        ex.printMap(map);
        set = ex.addElement(set, "Element 1 of a set");
        ex.printTree(set);

    }

}
