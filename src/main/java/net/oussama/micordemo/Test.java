package net.oussama.micordemo;

import java.util.ArrayList;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(10,20,30));
        ArrayList<Integer> list2;
        list2= (ArrayList) list.clone();
        System.out.println(list2);
    }
}
