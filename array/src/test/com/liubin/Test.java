package test.com.liubin;


import main.com.liubin.LinkedList.SinglyLinkedList;
import main.com.liubin.stack.SinglyLinkStack;
import main.com.liubin.stack.Stack;

import java.util.LinkedList;

public class Test {
	public static void main(String[] args) {
		Stack<Integer> stack = new SinglyLinkStack<>();
		stack.push(1);
		stack.push(2);
		System.out.println(stack);
	}

}
