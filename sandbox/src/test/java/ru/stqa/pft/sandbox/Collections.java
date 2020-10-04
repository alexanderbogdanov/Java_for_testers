/*
 * Copyright (c) Alexander Bogdanov 2020
 */

package ru.stqa.pft.sandbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Collections {

    public static void main(String[] args) {
        String[] langs = {"Java", "C#", "Python", "PHP"};

//        List<String> languages = new ArrayList<String>();
//        languages.add("Java");
//        languages.add("C#");
//        languages.add("Python");
//        languages.add("PHP");
//        List languages = Arrays.asList("Java", "C#", "Python", "PHP");
        List<String> languages = Arrays.asList("Java", "C#", "Python", "PHP");

//        for (int i = 0; i < languages.size(); i++) {
//            System.out.println("I want to learn " + languages.get(i));
//        }


//        for (Object l : languages) {
//            System.out.println("I want to learn " + l);
//        }
        for (String l : languages) {
            System.out.println("I want to learn " + l);
        }

//        for (String l : langs) {
//            System.out.println("I want to learn " + l);
//        }
    }
}
