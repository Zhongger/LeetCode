package Day13.逆波兰表达式求值;

import java.util.Stack;

public class EvalRPNSolution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        Integer op1,op2;
        for (int i = 0; i < tokens.length; i++) {
             switch (tokens[i]){
                 case "+":
                     op2=stack.pop();
                     op1=stack.pop();
                     stack.push(op1+op2);
                     break;
                 case "-":
                     op2=stack.pop();
                     op1=stack.pop();
                     stack.push(op1-op2);
                     break;
                 case "*":
                     op2=stack.pop();
                     op1=stack.pop();
                     stack.push(op1*op2);
                     break;
                 case "/":
                     op2=stack.pop();
                     op1=stack.pop();
                     stack.push(op1/op2);
                     break;
                 default:
                     stack.push(Integer.valueOf(tokens[i]));
                     break;
             }
        }
        return stack.pop();
    }
}
