package test.com.liubin.test;

import main.com.liubin.maxheap.MaxHeap;

import java.util.Random;

/**
* Title:TestMaxHeap.java
* @discription: 测试最大堆
* @author liubin@segi.com
* @created 2019-11-20 19:03
*/
public class TestMaxHeap {

	public static void main(String[] args) {
		int n = 1000000;
		MaxHeap<Integer> maxHeap = new MaxHeap<>();
		Integer[] integers = new Integer[n];
		Random random = new Random();
		for (int i = 0; i < n; i++) {
			integers[i] = random.nextInt(Integer.MAX_VALUE);
		}
		maxHeap.heapify(integers);
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = maxHeap.extractMax();
		}
		for (int i = 1; i < n; i++) {
			if (arr[i - 1] < arr[i]) {
				throw new RuntimeException("error");
			}
		}
		System.out.println("completed");
	}
}
