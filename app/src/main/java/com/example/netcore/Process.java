package com.example.netcore;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Process {
    FetchFile fetchFile=new FetchFile();
    String data;
    String dataArray[];
    Map<String,Integer> countWords=new HashMap<String, Integer>();

    {
        try {
            data = fetchFile.run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void countOccur(){
        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                dataArray=data.split(" ");
                int count =0;
                for(String s :dataArray){
                    if(countWords.containsKey(s)) {
                        count = countWords.get(s);
                        countWords.put(s, count + 1);
                    }
                    else {
                        countWords.put(s,1);
                    }
                }

            }
        };
        new Thread(runnable).start();


    }

   ArrayList<Map.Entry<String,Integer>> reverseOrder(Map<String,Integer> map){
        ;
        List<Map.Entry<String,Integer>> statistics=new ArrayList<>(map.entrySet());
        Collections.sort(statistics, (o1, o2) -> o1.getValue().compareTo(o2.getValue()));
        List<Map.Entry<String,Integer>> topTen=statistics.subList(0,9);
        ArrayList<Map.Entry<String,Integer>> arrayList= new ArrayList<>(topTen);
        return arrayList;
    }

}
