package com.example.xmly.test5.hashmap;

import android.support.annotation.NonNull;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class TestHashMap {

    public static void main(String[] args) {

        TestHashMap testHashMap = new TestHashMap();
        testHashMap.test();
//        testHashMap.testReflect();

    }

    public void test(){
        Map<Key, String> map = new HashMap<>();
        map.put(new Key(1), "13");
        map.put(new Key(2), "23");
        map.put(new Key(3), "33");
        map.put(new Key(4), "43");
        map.put(new Key(5), "53");
        map.put(new Key(6), "63");
        map.put(new Key(7), "73");
        map.put(new Key(8), "83");
        map.put(new Key(9), "93");
        map.put(new Key(10),"103");
        map.put(new Key(11),"104");
        map.put(new Key(12),"123");
    }


    private class Key implements Comparable<Key> {

        private final int value;

        Key(int value) {
            this.value = value;
        }

        @Override
        public int compareTo(Key o) {
            return Integer.compare(this.value, o.value);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass())
                return false;
            Key key = (Key) o;
            return value == key.value;
        }

        @Override
        public int hashCode() {
            return 1;
        }
    }

    //反射获取
    public void testReflect(){
        HashMap m = new HashMap<Integer, String>();
        m.put(10, "1nihao");
        m.put(11, "2nihao");
        m.put(12, "3nihao");
        m.put(13, "4nihao");
        m.put(14, "5nihao");
        m.put(15, "6nihao");
        m.put(16, "7nihao");
        m.put(17, "8nihao");
        m.put(18, "9nihao");
        m.put(19, "10nihao");
        m.put(20, "11nihao");

        // 利用反射,获取内部字段 "table"
        Class clsHashMap = null;
        Class clsHashMap$Node = null;
        Field[] f = null;
        Field t = null, fNode = null;
        try {
            clsHashMap = Class.forName("java.util.HashMap");
            clsHashMap$Node = Class.forName("java.util.HashMap$Node");
            f = clsHashMap.getDeclaredFields();
            AccessibleObject.setAccessible(f, true);
            for (Field field : f) {
                // System.out.println(field.getName());
                if (field.getName() == "table")
                    t = field;
            }
            Object[] O = ((Object[]) t.get(m));
            for (Object o : O) {
                if (o != null) {
                    System.out.println(o);
                    // Object e = clsHashMap$Node..newInstance();
                    fNode = clsHashMap$Node.getDeclaredField("next");
                    fNode.setAccessible(true);
                    while ((o = fNode.get(o)) != null) {
                        System.out.println(o);
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        // System.out.println(f.getName());
        catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


}
