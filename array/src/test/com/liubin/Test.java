package test.com.liubin;


import main.com.liubin.ArrayQueue;
import main.com.liubin.Queue;



public class Test {
    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayQueue<>();
        for (int i = 0; i < 5; i++) {
            queue.enQueue(i);
            System.out.println(queue);
        }
        queue.deQueue();
        System.out.println(queue);
    }


}
