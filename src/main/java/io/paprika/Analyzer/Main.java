package io.paprika.analyzer;

import io.paprika.neo4j.QuartileCalculator;
import io.paprika.parser.ObjCParser;

import java.io.File;
import java.io.IOException;

/**
 * Created by Sarra on 28/02/2016.
 */
public class Main {
    public static void main(String[] args)
    {
        //The file path is hard-coded to avoid reading from System.in which is quite complicated with gradle
        File f = new File("C:\\Users\\Sarra\\Desktop\\Adapt-Paprika\\iOS-apps\\Health\\rTracker-master\\Classes");
        Analyzer analyzer = new Analyzer();
        //analyzer.identifyPatterns();
        //analyzer.computeStatistics();






        String appName ="rTracker";
        String appKey = "rTracker";
        String category="Health";
      try {
            analyzer.parse(f, appName, category, appKey);

        }catch (IOException ioe)
        {
            ioe.printStackTrace();
            System.out.println("The cause:"+ ioe.getCause());
        }


    }
}
