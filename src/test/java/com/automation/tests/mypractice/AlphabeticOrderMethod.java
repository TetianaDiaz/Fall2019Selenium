package com.automation.tests.mypractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AlphabeticOrderMethod {

    public static void main(String[] args) {


        List<String> list = new ArrayList<>();
        list.add("book");
        list.add("column");
        list.add("aebra");

        boolean AlphabeticOrder = true;

        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).compareTo(list.get(i + 1)) > 0) {
                System.out.println(list.get(i).compareTo(list.get(i + 1)));
                AlphabeticOrder = false;
                break;
            }
        }
        System.out.println(AlphabeticOrder);

        List<String> list2 = new ArrayList<>(Arrays.asList("aaa", "bye", "privet"));
        System.out.println(isSortedInAlphabeticOrder(list2));
        System.out.println(isSortedInAlphabeticOrder(list));

    }

    public static boolean isSortedInAlphabeticOrder(List<String> list){
        boolean isInAlphabeticOrder = true;
        for (int i = 0; i <list.size()-1 ; i++) {
            if(list.get(i).compareTo(list.get(i+1))>0){
                isInAlphabeticOrder= false;
                break;
            }
        }
        return isInAlphabeticOrder;
    }

}
