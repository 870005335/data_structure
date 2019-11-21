package test.com.liubin.problem;

import main.com.liubin.maxheap.MaxHeap;
import main.com.liubin.queue.PriorityQueue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
* Title:TopkFrequent.java
* @discription: LeetCode 347 前K个高频元素
* @author liubin@segi.com
* @created 2019-11-21 10:05
*/
public class TopKFrequent {

	private class Frequent implements Comparable<Frequent>  {
		private int e;
		private int frequent;

		public Frequent(int e, int frequent) {
			this.e = e;
			this.frequent = frequent;
		}


		@Override
		public int compareTo(Frequent other) {
			if (frequent < other.frequent) {
				return 1;
			} else if (frequent > other.frequent) {
				return -1;
			} else {
				return 0;
			}
		}
	}

	public List<Integer> topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : nums) {
			if (map.containsKey(num)) {
				map.put(num, map.get(num) + 1);
			} else {
				map.put(num, 1);
			}
		}
		PriorityQueue<Frequent> priorityQueue = new PriorityQueue<>();
		map.forEach((key, value) -> {
			if (priorityQueue.getSize() < k) {
				priorityQueue.enQueue(new Frequent(key, value));
			} else {
				if (value > priorityQueue.getHead().frequent) {
					priorityQueue.deQueue();
					priorityQueue.enQueue(new Frequent(key, value));
				}
			}
		});
		List<Integer> resultList = new LinkedList<>();
		while (!priorityQueue.isEmpty()) {
			resultList.add(priorityQueue.deQueue().e);
		}
		return resultList;
	}
}
