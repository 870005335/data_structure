package test.com.liubin;


import main.com.liubin.LinkedList.LinkedList;

public class Test {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        System.out.println(linkedList.getSize());
        System.out.println(linkedList.get(2));
    }


}
