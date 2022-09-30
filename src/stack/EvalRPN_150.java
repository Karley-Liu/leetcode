package stack;

import java.util.Stack;

public class EvalRPN_150 {

    public int evalRPN(String[] tokens) {
        int first=0,second=0,res=0;
        Stack<Integer> numStack = new Stack<>();
        for (String t:tokens){
            if (t.equals("+")||t.equals("-")||t.equals("*")||t.equals("/")){
                second=numStack.pop();
                first=numStack.pop();
                switch (t){
                    case "+":
                        numStack.push(first+second);
                        break;
                    case "-":
                        numStack.push(first-second);
                        break;
                    case "*":
                        numStack.push(first*second);
                        break;
                    case "/":
                        numStack.push(first/second);
                    default:
                }
            }else {
                numStack.push(Integer.valueOf(t));
            }
        }
        res=numStack.pop();
        System.out.println(res);
        return res;
    }

    public static void main(String[] args) {
        String[] token={"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        new EvalRPN_150().evalRPN(token);
    }
}
