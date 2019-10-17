package test.com.liubin;


import main.com.liubin.ArrayQueue;
import main.com.liubin.LoopQueue;
import main.com.liubin.Queue;



public class Test {
    public static void main(String[] args) {
        Queue<Integer> queue = new LoopQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enQueue(i);
        }
        System.out.println(queue);
        queue.deQueue();
        queue.enQueue(10);
        queue.enQueue(11);
        System.out.println(queue);
    }


}
