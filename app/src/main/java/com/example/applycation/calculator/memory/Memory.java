package com.example.applycation.calculator.memory;

import java.util.ArrayList;
/**
 * Created by Apink on 22/03/2016.
 */
public class Memory {
    private static ArrayList<Double> listM = new ArrayList<Double>();
    private static double M = 0;
    public static void Mplus(double x){
        M = M + x;
    }
    public static void Mminus(double x){
        M = M - x;
    }
    public static double MResult(){
        return M;
    }
    public static void MSave(double x){
        listM.add(x);
    }
    public static void MClear() {
        M = 0;
        listM.clear();
    }

}
