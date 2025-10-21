package edu.northeastern.week7.arraylist;

import java.util.ArrayList;

public class ArrayListExample {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(20);
        list.add(0, 252);
        System.out.println(list.size());

        for(Integer a:list)
            System.out.println("item: " + a);
    }
}