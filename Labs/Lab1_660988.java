package Labs;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

import solutions.pack1.*;

public class Lab1_660988 {
    public static void task1() {
        System.out.println("--task1---");
        ArrayList<String> lis1a = new ArrayList<>(Arrays.asList("Lily","Daisy"));
        ArrayList<String> lis1b = new ArrayList<>(Arrays.asList("Tulip","Daisy"));
        ArrayList<String> lis1c = new ArrayList<>();
        lis1c.addAll(lis1b);
        lis1c.addAll(lis1a);
        System.out.println(lis1c); 
        System.out.println(lis1a);
    }
    public static void task2() {
        System.out.println("--task2---");
        ArrayList<StringBuilder> lis1a = new ArrayList<>(Arrays.asList(new StringBuilder("Lily"), new StringBuilder( "Daisy")));
        ArrayList<StringBuilder> lis1b = new ArrayList<>(lis1a);
        lis1b.add(new StringBuilder("30"));        
        System.out.println(lis1b); 
        System.out.println(lis1a);  // Original data seems not affected
        StringBuilder sb = lis1a.get(0);
        sb.append("mySuffix");
        
        // Does lis2b.get(0) object change? Or it is not affected. Check it yourself.
        // complete the task by display "shallow copy" if lis2b first element is affected.

        if (lis1a.get(0) == lis1b.get(0)){
            System.out.println("Shallow copy");
        }
    }
    public static void task3() {
        System.out.println("--task3---");
        List<String> lis3 = new ArrayList<>(Arrays.asList("Lily","Daisy","Tulip","Daisy"));
        String temp = lis3.get(0);
        lis3.removeIf(element -> !element.equals(temp));
        System.out.println(lis3);
    }
    public static void task4() { // show unique elements
        System.out.println("--task4---");
        // ArrayList<String> lis1 = new ArrayList<>(Arrays.asList("Lily","Daisy","Tulip","Daisy"));
        List<String> lis4a = Arrays.asList("Lily","Daisy","Tulip","Daisy");
        HashSet<String> flowers = new HashSet<>(lis4a);
        for (String ele : flowers) {
            System.out.print(ele + " ");
        }
        System.out.println();
        ArrayList<Dog> lis4b = new ArrayList<>(Arrays.asList(new Dog(Breed.pomeranian,1200), new Dog(Breed.beagle, 2300), new Dog(Breed.jack, 1440), new Dog(Breed.beagle,2300)));
        HashSet<Dog> dogs = new HashSet<>(lis4b);
        for (Dog ele : dogs) {
            System.out.print(ele + " ");
        }
        System.out.println();
    }
    static void task5() { // dog breed frequency 
        System.out.println("--task5---");
        ArrayList<Dog> lis5 = new ArrayList<>(Arrays.asList(new Dog(Breed.pomeranian,1200), new Dog(Breed.beagle, 2300), new Dog(Breed.jack, 1440), new Dog(Breed.beagle,2300)));
        HashMap<Breed,Integer> map = new HashMap<>();
        for (Dog ele : lis5){
            map.put(ele.getbreed(), map.getOrDefault(ele.getbreed(), 0) + 1);
        }
        for (Entry<Breed, Integer> ele : map.entrySet()) {
            System.out.println(ele.getKey() + "\t" + ele.getValue());
        }
    }
    static void task6() { // number of unique elements
        System.out.println("--task6---");
        ArrayList<Dog> lis6 = new ArrayList<>(Arrays.asList(new Dog(Breed.pomeranian,1200), new Dog(Breed.beagle, 2300), new Dog(Breed.jack, 1440), new Dog(Breed.beagle,2300)));        
        HashMap<Breed,Integer> map = new HashMap<>();
        for (Dog ele : lis6){
            map.put(ele.getbreed(), map.getOrDefault(ele.getbreed(), 0) + 1);
        }
        int count = 0;
        for (Entry<Breed, Integer> ele : map.entrySet()) {
           count++;
        }
        System.out.println("The number of unique element is " + count);
    }    
    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task4();
        task5();
        task6();
        task4a();
    }
    static int N = 10_000;
    static Integer [] arr = new Integer [N];
    static int num_iter = 100_000 * 10;
    static ArrayList<Integer> lis = new ArrayList<>();
    static LinkedList<Integer> llis;
    static {
        for (int i = 0; i < N; i++) {
            lis.add(i);
        }
        Collections.shuffle(lis);
        lis.toArray(arr);
        llis = new LinkedList<>(lis);
    }
    static void demo_arrayList(int idx) {
        int value;
        // long start = System.currentTimeMillis();
        long start = System.nanoTime();
        for (int iter = 0; iter < num_iter; iter++) {
            value = lis.get(idx);
        }
        long time = (System.nanoTime() - start);
        System.out.println("ArrayList \ttakes " + time);
    }
    static void demo_linkedList(int idx) {
        int value;
        // long start = System.currentTimeMillis();
        long start = System.nanoTime();
        for (int iter = 0; iter < num_iter; iter++) {
            value = llis.get(idx);
        }
        long time = (System.nanoTime() - start);
        System.out.println("Linkedlist \ttakes " + time);
    }
    static void demo_array(int idx) {
        int value;
        // long start = System.currentTimeMillis();
        long start = System.nanoTime();
        for (int iter = 0; iter < num_iter; iter++) {
            value = arr[idx];
        }
        long time = (System.nanoTime() - start);
        System.out.println("Array \ttakes " + time);
    }
    static void task4a() {
        System.out.println("--task7---");
        for (int index = 0; index < arr.length; index += arr.length/4) {
            System.out.println("Index is at " + index);
            demo_arrayList(index);
            demo_linkedList(index);
            demo_array(index);
        }
    }
}