package test.com.liubin.test;

import main.com.liubin.stack.ArrayStack;
import main.com.liubin.stack.LinkStack;
import main.com.liubin.stack.SinglyLinkStack;
import main.com.liubin.stack.Stack;

import java.util.List;
import java.util.Random;

/**
* Title:Compare.java
* @discription: 
* @author liubin@segi.com
* @created 2019-10-25 11:20
*/
public class Compare {
	public static void main(String[] args) {
		int opCount = 100000;
		Stack<Integer> arrayStack = new ArrayStack<>();
		double arrayTime = testStack(arrayStack, opCount);
		Stack<Integer> singlyStack = new SinglyLinkStack<>();
		double singlyTime = testStack(singlyStack, opCount);
		Stack<Integer> linkStack = new LinkStack<>();
		double linkTime = testStack(linkStack, opCount);
		System.out.println(arrayTime);
		System.out.println(singlyTime);
		System.out.println(linkTime);
	}

	private static double testStack(Stack<Integer> stack, int opCount) {
		long startTime = System.nanoTime();
		Random random = new Random();
		for (int i = 0; i < opCount; i++) {
			stack.push(random.nextInt(Integer.MAX_VALUE));
		}
		for (int i = 0; i < opCount; i++) {
			stack.pop();
		}
		long endTime = System.nanoTime();
		return (endTime - startTime) / 1000000000.0;
	}


}
