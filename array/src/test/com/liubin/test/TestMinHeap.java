package test.com.liubin.test;


import main.com.liubin.maxheap.MinHeap;

import java.util.Random;

/**
* Title:TestMinHeap.java
* @discription: 测试最小堆
* @author liubin@segi.com
* @created 2019-11-21 14:28
*/
public class TestMinHeap {

	public static void main(String[] args) {
		int n = 1000000;
		MinHeap<Integer> minHeap = new MinHeap<>();
		Random random = new Random();
		for (int i = 0; i < n; i++) {
			int value = random.nextInt(Integer.MAX_VALUE);
			minHeap.add(value);
		}
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = minHeap.extractMin();
		}
		for (int i = 1; i < n; i++) {
			if (arr[i - 1] > arr[i]) {
				throw new RuntimeException("error");
			}
		}
		System.out.println("completed");
	}
}
