package com.manoilo.utility;

import com.manoilo.model.DataSet;

import java.io.*;
import java.util.*;

/**
 * Created by Modest on 05.12.2016.
 */
public class Utility {
    private static final String NEW_LINE = "\\n";
    private static final String WHITE_SPACE = "\\s+";


    public static File openFile(String path) throws IOException {
        return new File(path);
    }

    public static DataSet parseDataSet(File file) throws FileNotFoundException, MissingFormatArgumentException {
        Scanner scanner = new Scanner(file);
        DataSet dataSet = new DataSet();
        ArrayList<Float> c = new ArrayList<>();
        dataSet.setNodesAmaunt(scanner.nextInt());
        dataSet.setLineAmmount(scanner.nextInt());
        int id = 0;


        ArrayList<ArrayList<Integer>> a = initiliaze(dataSet.getLinesAmmount(),dataSet.getNodesAmaunt()) ;

        while(scanner.hasNext()){

            c.add(Float.parseFloat(scanner.next()));
            scanner.useDelimiter(NEW_LINE);

            String[] values = scanner.nextLine().trim().split(WHITE_SPACE);

            for (String value : values) {
                a.get(id).set(Integer.parseInt(value)-1,1);
            }
            scanner.useDelimiter(WHITE_SPACE);
            id++;
        }
        dataSet.setC(c);
        dataSet.setA(a);
        return dataSet;
    }
    private static ArrayList<ArrayList<Integer>> initiliaze(int n, int m){
        ArrayList<ArrayList<Integer>> a = new ArrayList<>();
        for (int i = 0;i<n;i++){
            a.add(new ArrayList<>());
            for (int j = 0;j<m;j++){
                a.get(i).add(0);
            }
        }
        return  a;

    }
}
