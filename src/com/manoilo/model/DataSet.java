package com.manoilo.model;

import java.util.ArrayList;

/**
 * Created by Modest on 05.12.2016.
 */
public class DataSet {
    private ArrayList<Float> c;

    private ArrayList<ArrayList<Integer>> a;
    private int lineAmmount;
    private  int nodesAmaunt;
    public DataSet() {
        this.c = new ArrayList<>();
        this.a = new ArrayList<>();
    }

    public int getNodesAmaunt() {
        return nodesAmaunt;
    }

    public void setNodesAmaunt(int nodesAmaunt) {
        this.nodesAmaunt = nodesAmaunt;
    }


    public void setLineAmmount(int lineAmmount){
        this.lineAmmount = lineAmmount;
    }

    public int getLinesAmmount(){
        return lineAmmount;
    }

    public ArrayList<Float> getC() {
        return c;
    }

    public void setC(ArrayList<Float> c) {
        this.c = c;
    }

    public ArrayList<ArrayList<Integer>> getA() {
        return a;
    }

    public void setA(ArrayList<ArrayList<Integer>> a) {
        this.a = a;
    }
}
