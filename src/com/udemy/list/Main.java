package com.udemy.list;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Employee janeJones = new Employee("Jane", "Jones", 123);
        Employee johnDoe = new Employee("John", "Doe", 4567);
        Employee marySmith = new Employee("Mary", "Smith", 22);
        Employee mikeWilson = new Employee("Mike", "Wilson", 3245);

        Map<String, Employee> hashMap = new HashMap<String, Employee>();
        hashMap.put("Jones", janeJones);
        hashMap.put("Doe", johnDoe);
        hashMap.put("Smith", marySmith);


//        hashMap.put("Doe", mikeWilson); // this will cause mikeWilson to replace johnDoe, because of the key
        hashMap.putIfAbsent("Doe", mikeWilson); // will only insert if the key "Doe" has not been used

        System.out.println(hashMap.get("asdf")); // returns null since key does not exist
        System.out.println(hashMap.getOrDefault("asdf", mikeWilson));
        // ^ getOrDefault() returns default object if it can find the key

        System.out.println(hashMap.remove("Jones"));


        System.out.println(hashMap.containsKey("Doe"));
        // ^ this is faster than the below line because it uses the key to hash the value and jump straight to it

        System.out.println(hashMap.containsValue(janeJones));
        // ^ this is just passing the "Object" so it needs to search the whole hashTable

//        Iterator<Employee> iterator = hashMap.values().iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }

        hashMap.forEach((k, v) -> System.out.println("key = " + k + ", Employee= " + v));
    }
}
