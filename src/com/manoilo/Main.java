package com.manoilo;


import com.manoilo.model.DataSet;
import com.manoilo.model.HillClimbing;

import java.io.File;
import java.util.ArrayList;

import static com.manoilo.utility.Utility.openFile;
import static com.manoilo.utility.Utility.parseDataSet;

public class Main {

    public static void main(String[] args) {
        try{
            ArrayList<Integer> result = new ArrayList<Integer>();
            File file = openFile("D:/Study/5/PCA/SetCoveringProblem/instances/1");
            DataSet dataSet = parseDataSet(file);
            HillClimbing hillClimbing = new HillClimbing();
            long start = System.currentTimeMillis();
            result=hillClimbing.execute(dataSet);
            long finish = System.currentTimeMillis();
        } catch(Exception e){
            e.printStackTrace();
        }
    }

}

