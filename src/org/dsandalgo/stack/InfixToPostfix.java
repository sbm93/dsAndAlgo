package org.dsandalgo.stack;

import java.util.Stack;

public class InfixToPostfix {
	public static void main(String[] args) {
		String exp = "a+b*(c^d-e)^(f+g*h)-i"; 
        System.out.println(infixToPostfix(exp));
	}
	
	static String infixToPostfix(String exp) {
		
		String results = "";
		
		Stack<Character> stack = new Stack<Character>();
		
		/*
		 * for(int i=0; i<exp.length();i++) { char c = exp.charAt(i);
		 * 
		 * if(Character.isLetterOrDigit(c)) results += c; else if(c == '(') {
		 * stack.push(c); } else if() { while(!stack.isEmpty() && stack.peek() != '(') {
		 * 
		 * } } else {
		 * 
		 * }
		 * 
		 * 
		 * }
		 */
		
		return results;
		
	}
	
}
