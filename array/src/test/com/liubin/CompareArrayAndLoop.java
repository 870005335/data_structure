package test.com.liubin;

import main.com.liubin.ArrayQueue;
import main.com.liubin.LoopQueue;
import main.com.liubin.Queue;

import java.util.Random;

/**
 * @ClassName CompareArrayAndLoop
 * @Description: 比较数组队列和循环队列
 * @Author Arthas_liubin@Foxmail.com
 * @Date 2019/10/20 0:43
 * @Version V1.0
 **/
public class CompareArrayAndLoop {

    public static void main(String[] args) {
        int opCount = 100000;
        Queue<Integer> arrayQueue = new ArrayQueue<>();
        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        double arrayTime = testQueue(arrayQueue, opCount);
        double looTime = testQueue(loopQueue, opCount);
        System.out.println("ArrayQueue, time: " + arrayTime + "s");
        System.out.println("LoopQueue, time: " + looTime + "s");
    }

    private static double testQueue(Queue<Integer> queue, int opCount) {
        long startTime = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            queue.enQueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            queue.deQueue();
        }
        long endTime = System.nanoTime();
        return (endTime - startTime)/1000000000.0;
    }
}
