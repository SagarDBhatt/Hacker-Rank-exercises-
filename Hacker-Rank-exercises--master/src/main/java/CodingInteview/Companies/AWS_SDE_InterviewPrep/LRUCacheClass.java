package CodingInteview.Companies.AWS_SDE_InterviewPrep;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCacheClass {
    Map<Integer, Integer> map;
    Integer cap;

    public LRUCacheClass(int capacity){
        map = new LinkedHashMap<>(capacity);
        cap = capacity;
    }

    public int get(int key){
//        if(map.containsKey(key))return map.get(key);
//        else return -1;
        return map.getOrDefault(key, -1);
    }

    public void put(int key, int val){
        if(map.containsKey(key))map.put(key,val);
        else{
            if(map.size() >= cap){
                map.remove(map.keySet().iterator().next());
            }
            map.put(key,val);
        }
    }

    public void print(){
        System.out.println(map);
    }

}

class mainClass{
    public static void main(String[] args) {
        LRUCacheClass obj = new LRUCacheClass(5);
        System.out.println(obj.get(4));
        obj.put(2,4);
        System.out.println(obj.get(2));
        obj.put(2,5);
        System.out.println(obj.get(2));
        obj.put(1,5);
        obj.put(3,5);
        obj.put(4,5);
        obj.put(5,5);
        obj.print();
        obj.put(6,5);
        obj.print();
    }//main
}
