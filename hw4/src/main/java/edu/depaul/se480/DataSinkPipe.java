package edu.depaul.se480;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Class: SE480 - pipe to display 10 most commonly seen words
 * Author: Raquib Talukder
 **/

public class DataSinkPipe {
    private ArrayList<String> morphologicalRootsArrayList;
    private ArrayList<String> topTenWords = new ArrayList<>();

    public DataSinkPipe(ArrayList<String> morphologicalRootsArrayList){
        this.morphologicalRootsArrayList = morphologicalRootsArrayList;
    }

    public List<Map.Entry<String, Long>> OrderTopTen(){
        Map<String, Long> map = morphologicalRootsArrayList.stream()
                .collect(Collectors.groupingBy(w -> w, Collectors.counting()));

        List<Map.Entry<String, Long>> result = map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(10)
                .collect(Collectors.toList());

        System.out.println(result.toString());

        return result;
    }

}
