package stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class RemoveDuplicateLetters_316 {

    public String removeDuplicateLetters(String s) {
        int len=s.length();
        char[] charArray = s.toCharArray();
        int[] lastIndex = new int[26];
        for (int i=0;i<len;i++){
            lastIndex[charArray[i]-'a']=i;
        }
        Deque<Character> stack = new ArrayDeque<>();
        boolean[] visited = new boolean[26];
        for (int i=0;i<len;i++){
            if (visited[charArray[i]-'a']){
                continue;
            }
            while (!stack.isEmpty()
                    &&stack.peekFirst()>charArray[i]
                    &&lastIndex[stack.peekFirst()-'a']>i){
                Character top = stack.removeLast();
                visited[top-'a']=false;
            }
            stack.addLast(charArray[i]);
            visited[charArray[i]-'a']=true;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (char c:stack){
            stringBuilder.append(c);
        }
        System.out.println(stringBuilder.toString());
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String s="bcabc";
        new RemoveDuplicateLetters_316().removeDuplicateLetters(s);
    }
}
