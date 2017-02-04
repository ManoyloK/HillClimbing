package com.manoilo.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * Created by Modest on 05.12.2016.
 */
public class HillClimbing {
    private ArrayList<Integer> x = new ArrayList<>();
    private int LAMDA = 1000000;
    private HashMap<ArrayList<Integer>,Double> summF = new HashMap<>();


    public ArrayList<Integer> execute(DataSet world) {
        boolean found = true;

        ArrayList<Integer> y = new ArrayList<>();

        x=getRandomX(world.getLinesAmmount());
        System.out.println("X " + x);
        ArrayList<Integer> bestY = new ArrayList<>(x);
        double fBestY = f(x,world.getC(),world.getA());
        double fx =0;
        do {
            found=false;
            for (int i = 0;i<x.size();i++) {
                y = getNeighborhood(x,i);
                double fy =f(y,world.getC(),world.getA());
                if (fBestY>fy){
                    bestY=y;
                    fBestY=f(bestY,world.getC(),world.getA());
                }
            }
                fx = f(x,world.getC(),world.getA());
                System.out.println("BestY cost: "+fBestY);
                System.out.println("X cost: "+fx);
                System.out.println("BestY " + bestY);

                if (fBestY<fx){
                   // System.out.println(f(bestY,world.getC(),world.getA()));
                    x=bestY;
                    System.out.println("New X " + x);
                    found = true;

                }



        }while (found);
        printResult(x,world.getC());
        return x;
    }

    private ArrayList<Integer> getRandomX(int size){
        ArrayList<Integer> xi = new ArrayList<>();
        Random randomizer = new Random();
        int i = randomizer.nextInt(size);
        for (int j= 0;j<size;j++)
        {
            xi.add(randomizer.nextInt(2));
        }
        //xi.set(i,1);
        return xi;
    }
    private ArrayList<Integer> getNeighborhood(ArrayList<Integer> x,int i){
        ArrayList<Integer> y =new ArrayList<>(x);
        if (y.get(i)==0){
            y.set(i,1);
        }
        else
            y.set(i,0);
        return y;
    }
    private void  printResult(ArrayList<Integer> x,ArrayList<Float> c){
        System.out.println("Result:" );
        for (int i=0;i<x.size();i++){
            if (   x.get(i)>0 ){
                System.out.print(i+1+" " );
            }
        }
        System.out.println( );
        System.out.println("Cost:" );
        double f=0;
        for (int j= 0;j<x.size();j++)
        {
            f+=x.get(j)*c.get(j);
        }
        System.out.println(f );
    }
    private double f(ArrayList<Integer> x,ArrayList<Float> c,ArrayList<ArrayList<Integer>> a){
        double f = 0;
        if (summF.containsKey(x)){
            f = summF.get(x);
        }
        else
        {
            for (int j= 0;j<x.size();j++)
            {
                f+=x.get(j)*c.get(j);
            }
            summF.put(x,f);
        }

        f=f+LAMDA*dist( Ax(x,a));
        return f;
    }
    private ArrayList<Integer> Ax(ArrayList<Integer> x,ArrayList<ArrayList<Integer>> a){
        ArrayList<Integer> resultVector = new ArrayList<>();
        int summ = 0;
        for (int j = 0; j < a.get(0).size(); j++) {
            summ=0;
            for (int i = 0; i < x.size(); i++) {
               summ += a.get(i).get(j) * x.get(i);
            }
            resultVector.add(summ-1);
        }
        return resultVector;
    }
    private  double dist(ArrayList<Integer> x){
        double dist=0;
        for (int j= 0;j<x.size();j++)
        {
            if (x.get(j)==-1){
                dist++;
            }

        }
        return dist;
    }
}
