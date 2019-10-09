package com.liubin;

public class Main {
    public static void main(String[] args) {
        Array arr = new Array();
        arr.add(1);
        arr.addFirst(3);
        arr.add(2, 5);
        for (int i = 0; i < arr.getSize(); i++) {
            System.out.println(arr.getData()[i]);
        }
        System.out.println(arr.get(2));
        System.out.println(arr.toString());
        System.out.println(arr.contains(6));


    }
}
