package com.example.applycation.calculator.expression;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Infix {	
	private String infix,postfix,prefix;
	private double value;
	public Infix(String inFix) {
		this.infix=inFix;
		postfix="";
		prefix="";
		if(!check()) {
			this.infix = "";
			//System.out.println("Cant solve this type of String");
		}
	}
	public String getInfix() {
		return infix;
	}
	public String getPostfix() {
		return postfix;
	}
	public void setInfix(String inFix) {
		this.infix = inFix;
	}
	public void setPostfix(String postFix) {
		this.postfix = postFix;
	}
	private Scanner scan;
	public boolean check(){
		if(Check.isBrace(infix) == false) return false;
		scan = new Scanner(infix);
		ArrayList<String> check = new ArrayList<String>();
		while(scan.hasNext())
			check.add(scan.next());
		if(Check.isOperator(check.get(0)))
			return false;
		if(Check.isOperator(check.get(check.size()-1))) 
			return false;
		for(int i = 1; i<check.size()-1; i++){
			String a = check.get(i-1);
			String b = check.get(i+1);
			if(Check.isOperator(check.get(i)))
				if((!Check.isOperand (a) && !Check.isBracket(a)) || (!Check.isOperand (b) && !Check.isBracket(b)))
					return false;
			if(Check.isOperand (check.get(i)))
				if((!Check.isOperator(a) && !Check.isBracket(a)) || (!Check.isOperator(b) && !Check.isBracket(b)))
					return false;
		}
		return true;
	}
	//chuyen sang hau to
	public String toPostfix(){
		Stack<String> operatorStack = new Stack<String>();
		scan = new Scanner(infix);
		while(scan.hasNext()){
			String x = scan.next();
			if (Check.isOperand(x)){
				postfix+=x+" ";
			}
			if (Check.isOpen(x))
				operatorStack.push(x);
			if (Check.isOperator(x)){
				while(  !operatorStack.isEmpty() && 
						!Check.isOpen(operatorStack.peek()) && 
						Check.priority(x) >= Check.priority(operatorStack.peek()))
					postfix+=operatorStack.pop()+" ";	
				operatorStack.push(x);
			}
			if (Check.isClose(x)){
				while(!Check.isOpen(operatorStack.peek()))
					postfix+=operatorStack.pop()+" ";
				operatorStack.pop();
			}
		}
		while(!operatorStack.isEmpty())
			postfix+=operatorStack.pop()+" ";
		return postfix;	
	}
	//chuyen sang tien to
	public String toPrefix(){
		String infix = Check.reverse(this.infix);
		Stack<String> stack = new Stack<String>();
		scan = new Scanner(infix);
		while(scan.hasNext()){
			String x = scan.next();
			if(Check.isOperand(x))
				prefix += x+" ";
			if(Check.isOperator(x)){
				while(	!stack.isEmpty() && 
						Check.priority(x) >= Check.priority(stack.peek()) && 
						!Check.isOpen(stack.peek()) )
					prefix += stack.pop()+" ";					
				stack.push(x);
			}
			if(Check.isOpen(x))
				stack.push(x);
			if(Check.isClose(x)){
				while(!stack.isEmpty() && !Check.isOpen(stack.peek()))
					prefix += stack.pop()+" ";
				stack.pop();				
			}
		}
		while(!stack.isEmpty())
			prefix += stack.pop()+" ";
		prefix = Check.reverse(prefix);		
		return prefix;
	}
	//chuyen ve value
	public double toValue(){
		//chua lam
		return value;
	}
	/*public static void main(String[] args) {
		Infix a;
		//a = new Infix("( 3 + 4 ) ^ 2 - 3 * ( 5 - 2 ) / 4 + 5 / 2");
		//a = new InfixToPostfix("27 / ( 3 - y * 12 ) + 9");
		a = new Infix("A ^ B * ( C ^ ( D / E ) ^ F ^ G ) - H / K");
		//System.out.println(a.infix);
		//System.out.println(a.toPostfix());
		//System.out.println(a.reverse());
		System.out.println(a.toPrefix());
		System.out.println(a.toPostfix());
	}*/
}
