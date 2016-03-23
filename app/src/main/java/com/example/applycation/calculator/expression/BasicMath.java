package com.example.applycation.calculator.expression;

/**
 * Created by Hung si da on 20/03/2016.
 */
public class BasicMath {

    public static double plus(double a, double b){
        return a+b;
    }
    public static double multiply(double a, double b){
        return a*b;
    }
    public static double divide(double a, double b){
        if(b==0)    return Double.parseDouble(null);
        else return a/b;
    }
    public static double minus(double a, double b){
        return a-b;
    }
    public static double reverse(double a){
        return -1*a;
    }
    public static double xMu2(double x){
        return x*x;
    }
    public static double mod(double a,double b){
        return a%b;
    }
    public static double motPhanX(double x){
        if(x==0)    return Double.parseDouble(null);
        else    return 1/x;
    }
    public static double sqrtX(double x){
        if(x < 0)   return Double.parseDouble(null);
        else return Math.sqrt(x);
    }


    public static double tong(double a,double b){
        return a+b;
    }

}
