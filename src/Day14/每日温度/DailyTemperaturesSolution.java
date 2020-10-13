package Day14.每日温度;

import java.util.Stack;

public class DailyTemperaturesSolution {
    public static void main(String[] args) {
        DailyTemperaturesSolution solution = new DailyTemperaturesSolution();
        int[] T = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(solution.dailyTemperatures(T));
    }
    public int[] dailyTemperatures(int[] T) {
        int[] resArr = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < T.length; i++) {
            while (!stack.isEmpty()&&T[i]>T[stack.peek()]){
                int prevIndex = stack.pop();
                resArr[prevIndex] = i-prevIndex;
            }
            stack.push(i);
        }
        return resArr;
    }
}
