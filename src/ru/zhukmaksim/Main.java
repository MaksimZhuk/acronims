package ru.zhukmaksim;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        //Starting words
        String[] words = {"son", "nos", "pidor", "asd", "asdasdasd", "dsa", "sonson", "aab", "baa", "caa", "aac", "das"};

        HashMap<WordMap, List<String>> res = new HashMap<>();
        //Throw iterating over all words we count there leters and splits into acronims group.
        for (String s: words){
            WordMap dict = new WordMap(s);
            if (res.containsKey(dict)){
                res.get(dict).add(s);
            } else {
                ArrayList<String> tmp = new ArrayList<>();
                tmp.add(s);
                res.put(dict, tmp);
            }

        }
        //finally print them)
        res.entrySet().forEach((entry) ->{
            if (entry.getValue().size() > 1){
                entry.getValue().forEach(System.out::println);
                System.out.println("___________");
            }

        });


    }
}
