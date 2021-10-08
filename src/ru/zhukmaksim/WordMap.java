package ru.zhukmaksim;

import java.util.*;

public class WordMap {
    /**
     * This class is made to simulate some properties of Python Counter class :)
     * It's count all letters in String during initializing.
     * Then it creates strings like a[c0]b[c1]c[c2]d..., where c0.. are amount of this letter, like abbs -> a1b2s1.
     * This is a result String which may be used to call hashcode end equals     *
     */
    private final HashMap<Character, Integer> dict;
    private final String word;
    private final int len;
    private final String result;
    {
        dict = new HashMap<>();
    }

    public WordMap(String word) {
        this.word = word;
        this.len = word.length();
        for (int i = 0; i < word.length(); i++){
            Character c = this.word.charAt(i);
            if (dict.containsKey(c)){
                dict.put(c, dict.get(c) + 1);
            } else {
                dict.put(c, 1);
            }

        }
        Set<Map.Entry<Character, Integer>> set = this.dict.entrySet();
        StringBuilder result = new StringBuilder();
        ArrayList<Map.Entry<Character, Integer>> list = new ArrayList<>(set);
        list.sort((a,b)->a.getKey().compareTo(b.getKey()));
        for (Map.Entry<Character, Integer> e : list){
            result.append(e.getKey());
            result.append(e.getValue());
        }
//        System.out.println(result.toString());
        this.result = result.toString();

    }
    public void print_dict(){
        this.dict.entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + " " + entry.getValue());
        });
    }

    @Override
    public int hashCode() {
        return result.toString().hashCode();
    }

    public String getResult() {
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this==obj)
            return true;
        if (obj instanceof WordMap){
            return this.result.equals(((WordMap) obj).getResult());
        }
        return false;
    }
}
