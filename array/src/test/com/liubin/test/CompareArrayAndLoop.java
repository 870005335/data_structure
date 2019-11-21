package test.com.liubin.test;

import main.com.liubin.queue.ArrayQueue;
import main.com.liubin.queue.LinkQueue;
import main.com.liubin.queue.LoopQueue;
import main.com.liubin.queue.Queue;
import main.com.liubin.queue.SingleLinkQueue;

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
        Queue<Integer> loopQueue = new LoopQueue<>();
        Queue<Integer> singlyQueue = new SingleLinkQueue<>();
        Queue<Integer> linkQueue = new LinkQueue<>();
        double arrayTime = testQueue(arrayQueue, opCount);
        double looTime = testQueue(loopQueue, opCount);
        double singlyTime = testQueue(singlyQueue, opCount);
        double linkTime = testQueue(linkQueue, opCount);

        System.out.println("ArrayQueue, time: " + arrayTime + "s");
        System.out.println("LoopQueue, time: " + looTime + "s");
        System.out.println("SingleLinkQueue, time:" + singlyTime + "s");
        System.out.println("LinkQueue, time:" + linkTime + "s");
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
