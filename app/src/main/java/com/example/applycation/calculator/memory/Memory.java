package com.example.applycation.calculator.memory;

import java.util.ArrayList;
/**
 * Created by Apink on 22/03/2016.
 */
public class Memory {
    private  ArrayList<Double> listM;
    private double M;
    public Memory(){
        M = 0;
        listM = new ArrayList<Double>();
    }
    public void setListM(ArrayList<Double> listM) {
        this.listM = listM;
    }
    public void setM(double m) {
        M = m;
    }
    public double getM() {
        return M;
    }
    public ArrayList<Double> getListM() {
        return listM;
    }
    public void Mplus(double x){
        M = M + x;
    }
    public void Mminus(double x){
        M = M - x;
    }
    public double MResult(){
        return M;
    }
    public void MSave(double x){
        listM.add(x);
    }
    public void MClear() {
        M = 0;
        listM.clear();
    }

}
