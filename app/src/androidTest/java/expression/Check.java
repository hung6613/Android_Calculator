package expression;

import java.util.Scanner;
import java.util.Stack;

//Singleton 
public class Check {
	private Check(){
		//private
		//khong the khoi tao doi tuong Expression tu ben ngoai
	}
	public static boolean isNumber(String str){
		try{
			Double.parseDouble(str);
			return true;
		}catch(Exception ex){
			return false;
		}
	}
	//Kiem tra toan hang
	public static boolean isOperand(String str){
		char ch = str.charAt(0);
		return isNumber(str) || (str.length()==1 && isAlphabet(ch+""));
	}
	//Kiem tra co phai la a,b,c,...x,y,z,... A,B,C,...X,Y,Z,...
	public static boolean isAlphabet(String str){
		int t = (int)str.charAt(0);
		return (t >= 65 && t <= 90) || (t>=97 && t<= 122);
	}
	//Kiem tra dau ngoac ( )
	public static boolean isBracket(String str){
		return str.equals("(")||str.equals(")");
	}
	public static boolean isOpen(String str){
		return str.equals("(");
	}
	public static boolean isClose(String str){
		return str.equals(")");
	}
	//Do uu tien cua toan tu //^ = 1	// */% = 2 // +- = 3
	private final static String OPERATOR="^*/%+-";
	private static Scanner scan;
	public static int priority(String str){
		int check = OPERATOR.indexOf(str.charAt(0));
		return check == 0 ? 1 : check < 4 ? 2 : 3;
	}
	//Kiem tra toan tu
	public static boolean isOperator(String str){
		return OPERATOR.indexOf(str.charAt(0))>-1;	
	}
	//kiem tra 2 phan tu ngoai cung co phai la NUMBER khong
	public static boolean isOutermostElementNumber(Stack<String> stack) {
		if(stack.size()>=2){
			String a = stack.pop();
			String b = stack.pop();
			stack.push(b);stack.push(a);
			return Check.isNumber(a)&&Check.isNumber(b);	
		}
		return false;
	}
	//Kiem tra dau ngoac cua bieu thuc co dung hay khong
	public static boolean isBrace(String s){
		Stack<Character> stack = new Stack<Character>();
		for(int i=0;i<s.length();i++)
			if(isBracket(s.charAt(i)+"")) 			
				if(isOpen(s.charAt(i)+""))  		
					stack.push(s.charAt(i));
				else							
					if(stack.isEmpty() || !isCompleteBracket(stack.peek(), s.charAt(i)))	
							return false;
					else	stack.pop();					
		return stack.isEmpty();
	}
	private static boolean isCompleteBracket(char a,char b){
		return a=='(' && b==')';
	}
	public static String reverse(String a){
		String s="";
		Stack<String> stack = new Stack<String>();
		scan = new Scanner(a);
		while(scan.hasNext())
			stack.push(scan.next());
		while(!stack.isEmpty()){
			String x = stack.pop();
			if(Check.isBracket(x))
				x=Check.isClose(x) ? "(" : ")";
			s+=x+" ";
		}			
		return s;	
	}
}
