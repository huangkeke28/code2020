package tsetStackQuene;

import dataStructure0326.MyStack;

import java.util.*;

public class InterviewStackQuene {
    //实现括号匹配问题 {} () []
    public boolean isvalid(String s) {
        //创建一个栈 存储左括号
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put('[', ']');
        map.put('(', ')');
        map.put('{', '}');
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            //先判断是否为左括号
            if (c == '{' || c == '[' || c == '(') {
                //是左括号 那么就入栈
                stack.push(c);
                continue;
            }
            if (stack.isEmpty()) {
                return false;
            }
            char h = stack.pop();
            if (c == map.get(h)) {
                continue;
            }
//            if (c == '{' && h == '}') {
//                continue;
//            }
//            if (c == '[' && h == ']') {
//                continue;
//            }
//            if (c == '(' && h == ')') {
//                continue;
//            }
            return false;
        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }

}
