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

    public static boolean containEqual(String str){
        for(int i=0;i<str.length();i++)
            if(str.charAt(i)=='=') return true;
        return false;
    }
    public double solve(){
        Infix expression_infix = new Infix(expression);
        Postfix expression_postfix = new Postfix(expression_infix.toPostfix());
        value = expression_postfix.toValue();
        return value;
    }
}
