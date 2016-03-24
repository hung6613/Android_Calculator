package com.example.applycation.calculator.expression;


import java.util.Scanner;

/**
 * Created by Tri dep trai on 20/3/2016.
 */
public class Expression {
    String expression;
    double value;
    public Expression(){
        expression="";
    }
    public Expression(String expression){

        setExpression(expression);
    }
    public static String getLastString(String str){

        String temp = "";
        Scanner scanner = new Scanner(str);
        while(scanner.hasNext())
            temp = scanner.next();
        return temp;
    }
    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
    private boolean isDouble(double x){
        return (x - (int)x) != 0.0;
    }
    public String getValueString(){
        if(isDouble(value)){
            String result = value + "";
            int count=0;
            for(;count<result.length();count++)
                if(result.charAt(count)=='.') break;
            if(count<4&&result.length()>count+4)return result.substring(0,count+5);
            return result.substring(0,count*2+1);
        }
        else return (int)value+"";
    }
    public static boolean containEqual(String str){
        for(int i=0;i<str.length();i++)
            if(str.charAt(i)=='=') return true;
        return false;
    }
    public static boolean containOperator(String str){
        Scanner scan = new Scanner(str);
        while(scan.hasNext()){
            if(Check.isOperator(scan.next()))
                return true;
        }
        return false;
    }
    public static String wipeDuplicateZero(String str){
        String newStr="";
        Scanner scanner= new Scanner(str);
        while(scanner.hasNext()){
            String temp = scanner.next();
            if(temp.length()>1&&temp.charAt(0)=='0'&&temp.charAt(1)!='.')
                temp = temp.substring(1);
            newStr += Check.isNumber(temp) ? temp : " " + temp + " ";
        }
        return newStr;
    }
    public double solve(){
        Infix expression_infix = new Infix(expression);
        Postfix expression_postfix = new Postfix(expression_infix.toPostfix());
        value = expression_postfix.toValue();
        return value;
    }
}
