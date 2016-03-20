package expression;

import java.util.Scanner;
import java.util.Stack;

import mathHandler.BasicMath;

public class Postfix {
	private String postfix,infix;
	private double value;
	public Postfix(String postfix){
		this.postfix=postfix;
		value=0;
		if(!check()) {
			this.postfix = "";
			//System.out.println("Cant solve this type of String");
		}
	}
	public String getPostfix() {
		return postfix;
	}
	public double getValue() {
		return value;
	}
	public void setPostfix(String postfix) {
		this.postfix = postfix;
	}
	public void setValue(double value) {
		this.value = value;
	}
	//kiem tra bieu thuc
	public boolean check(){
		if(postfix.equals("")) return false;;
		Stack<String> stack = new Stack<String>();
		//kb = new Scanner (System.in);
		scan = new Scanner(postfix);
		while(scan.hasNext()){
			String x = scan.next();
			if(!Check.isOperator(x)){
				stack.push(x);
			}
			else{
				if(stack.isEmpty()||!Check.isOperand(stack.pop()))   return false;
				if(stack.isEmpty()||!Check.isOperand(stack.peek()))  return false;
			}
		}
		return stack.size()==1;
	}
	//chuyen sang trung to
	public String toInfix(){
		//chua lam
		return infix;
	}
	private Scanner scan,kb;

	//Viet code su dung ham BasicMath o day
	public double toValue(){
		if(postfix.equals("")) return 0;
		kb = new Scanner(System.in);
		Stack<String> calculate = new Stack<String>();
		scan = new Scanner(postfix);
		while(scan.hasNext()){
			String x = scan.next();
			if(Check.isNumber(x))
				calculate.push(x);
			if(Check.isAlphabet(x)){
				System.out.print("Enter "+x+": ");
				calculate.push(kb.nextDouble()+"");
			}
			if(Check.isOperator(x)){
				double b = Double.parseDouble(calculate.pop());
				double a = Double.parseDouble(calculate.pop());
				double result;
				switch (x) {
					case "+" :	result = BasicMath.tong(a,b);	break;
					case "-" :	result = a - b;	break;
					case "*" :	result = a * b;	break;
					case "/" :	result = a / b;	break;
					case "%" :	result = a % b;	break;
					case "^" :	result = Math.pow(a,b);break;
					default  :  result = 0; break;
				}
				calculate.push(result+"");
			}
			//System.out.println(calculate);
		}
		value = Double.parseDouble(calculate.pop());
		return value;
	}
	/*public static void main(String[] args) {
		//InfixToPostfix itp = new InfixToPostfix("27 / ( 3 - y * 12 ) + 9");
		//Infix itp = new Infix("( x + y ) ^ 2 - 3 * ( z - 2 ) / 4 + h % 2");
		//Infix itp = new Infix();
		
		Postfix ptv = new Postfix("5 E ^ D C B ^ A + * + ");
		System.out.println(ptv.postfix);
		System.out.println(ptv.toValue());
		
	}*/
}
