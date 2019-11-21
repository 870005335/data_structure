package test.com.liubin.test;

import java.util.Stack;

/**
* Title:ParenthesisMatching.java
* @discription:  栈的应用之一---括号匹配
* @author liubin@segi.com
* @created 2019-10-16 18:01
*/
public class ParenthesisMatching {

	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(' || c == '[' || c == '{') {
				stack.push(c);
				System.out.println(stack);
			} else {
				if (stack.isEmpty()) {
					return false;
				}
				Character topChar = stack.pop();
				if (c == ')' && topChar != '(' || c ==  ']' &&
						topChar != '[' || c == '}' && topChar != '{') {
					return false;
				}
			}
		}
		return stack.empty();
	}
}
