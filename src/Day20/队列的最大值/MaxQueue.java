package Day20.队列的最大值;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by Zhong Mingyi on 2020/11/12.
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
 * 若队列为空，pop_front 和 max_value 需要返回 -1
 */
public class MaxQueue {

    private Deque<Integer> queue;
    private Deque<Integer> helper;

    public MaxQueue() {
        queue =  new LinkedList<>();
        helper = new LinkedList<>();
    }

    public int max_value() {
        return helper.isEmpty()?-1:helper.peekFirst();

    }

    public void push_back(int value) {
        while (!helper.isEmpty()&&value>helper.peekLast()){
            helper.pollLast();
        }
        queue.offer(value);
        helper.offer(value);
    }

    public int pop_front() {
        if (queue.isEmpty()){
            return -1;
        }
        Integer res = queue.poll();
        if (helper.peekFirst()==res){
            helper.pollFirst();
        }
        return res;

    }

    public static void main(String[] args) {
        MaxQueue maxQueue = new MaxQueue();
        maxQueue.push_back(15);
        System.out.println(maxQueue.max_value());
        maxQueue.push_back(9);
        System.out.println(maxQueue.max_value());
        maxQueue.push_back(16);
        System.out.println(maxQueue.max_value());
    }
}
