package stack;

import java.util.Stack;

public class IsValid_20 {

    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> characters = new Stack<>();
        for (Character c:chars){
            if (c.equals('(') || c.equals('{') || c.equals('[')){
                characters.push(c);
            }else {
                if (! characters.isEmpty() && leftOf(c) == characters.peek()){
                    characters.pop();
                }else {
                    return false;
                }
            }
        }
        return characters.isEmpty();
    }

    char leftOf(char c){
        if (c == '}'){
            return '{';
        }
        if (c == ')'){
            return '(';
        }
        return '[';
    }

    public static void main(String[] args) {
        String str = "()";
        new IsValid_20().isValid(str);
    }
}
