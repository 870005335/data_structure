package test.com.liubin;


import main.com.liubin.LinkedList.LinkedList;
import main.com.liubin.queue.LinkQueue;
import main.com.liubin.queue.Queue;
import main.com.liubin.queue.SingleLinkQueue;


public class Test {
	public static void main(String[] args) {
		Queue<Integer> queue = new LinkQueue<>();
		queue.enQueue(1);
		queue.enQueue(2);
		queue.enQueue(3);
		System.out.println(queue);
//		queue.deQueue();
//		System.out.println(queue);
		LinkedList<Integer> linkedList = new LinkedList<>();
		linkedList.addFirst(1);
		linkedList.addFirst(2);
		linkedList.addFirst(3);
		System.out.println(linkedList);
	}



}
