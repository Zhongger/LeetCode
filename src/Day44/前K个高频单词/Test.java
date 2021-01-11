package Day44.前K个高频单词;

import java.util.PriorityQueue;

public class Test {
    public static void main(String args[]) {
        String str1 = "i";//小
        String str2 = "love";//大
        System.out.println(str2.compareTo(str1));
        PriorityQueue<String> queue = new PriorityQueue<>();//默认最小堆
        queue.offer(str1);
        queue.offer(str2);
        System.out.println(queue.poll());


    }
}
