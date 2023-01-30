
package com.gl.BalancingBracket;

import java.util.Stack;

public class BalancingBracket {

	public static void main(String[] args) {

		String expression = "([[{}]])";

		if (isBalanced(expression)) {

			System.out.print("The entered String has Balanced Brackets");
		} else {
			System.out.println("The entered String do not contain Balanced Brackets");
		}

	}

	private static boolean isBalanced(String expression) {

		Stack<Character> stack = new Stack<Character>();

		for (int i = 0; i < expression.length(); i++) {

			// check if c is '(' '{' '['
			char character = expression.charAt(i);

			// push to stack
			if (character == '(' || character == '[' || character == '{') {
				stack.push(character);
				continue;
			}

			if (stack.isEmpty()) {
				return false;
			}

			char c;
			// pop from the stack c= ( )
			switch (character) {

			case '}':
				c = stack.pop();
				if (c == '(' || c == '[')
					return false;
				break;

			case ')':
				c = stack.pop();
				if (c == '{' || c == '[')
					return false;
				break;

			case ']':
				c = stack.pop();
				if (c == '(' || c == '{')
					return false;
				break;

			}
		}

		return stack.isEmpty();

	}

}