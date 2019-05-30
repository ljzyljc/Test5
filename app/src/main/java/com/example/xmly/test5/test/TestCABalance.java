package com.example.xmly.test5.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class TestCABalance {
//    private static float mCSize = 13.6f;
//    private static float mASize = 19.6f;
//
//    private static float mGrowRateOfC = 1.05f;
//    private static float mGowRateOfA = 1.03f;

    //    public static void main(String[] args) {
//        for (int i = 0; i < 20; i++) {
//            mCSize = mCSize * mGrowRateOfC;
//            mASize = mASize * mGowRateOfA;
//            System.out.println("---------"+mCSize+"-------"+mASize);
//            if (mCSize > mASize) {
//                System.out.println("-----超过----"+mCSize);
//                break;
//            }
//        }
//    }
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        for (String item : list) {
            if (item.equals("2")){
                System.out.println(item);
                list.remove(item);
            }
        }
//        Iterator<String> iterator = list.iterator();
//        while (iterator.hasNext()){
//            String item = iterator.next();
//            if (item.equals("2")){
//                System.out.println(item);
//                iterator.remove();
//            }
//        }
//        for (int i = 0; i < list.size(); i++) {
//            if (list.get(i).equals("2")) {
//                System.out.println(list.get(i));
//                list.remove(i);
//            }
//        }
    }
}
