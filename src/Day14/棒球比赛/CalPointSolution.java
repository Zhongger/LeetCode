package Day14.棒球比赛;

import java.util.Stack;

public class CalPointSolution {
    public static void main(String[] args) {
        CalPointSolution solution = new CalPointSolution();
        String[] ops = {"5","-2","4","C","D","9","+","+"};
        System.out.println(solution.calPoints(ops));
    }
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        Integer sum = 0 ;
        for (String s : ops) {
            switch (s){
                case "C":
                    Integer pop = stack.pop();
                    sum=sum-pop;
                    break;
                case "D":
                    Integer peek_double = 2*stack.peek();
                    stack.push(peek_double);
                    sum=sum+peek_double;
                    break;
                case "+":
                    Integer pop1 = stack.pop();
                    Integer pop2 = stack.pop();
                    sum=sum+pop1+pop2;
                    stack.push(pop2);
                    stack.push(pop1);
                    stack.push(pop1+pop2);
                    break;
                default:
                    stack.push(Integer.valueOf(s));
                    sum=sum+stack.peek();
                    break;
            }
        }
        return sum;
    }
}
