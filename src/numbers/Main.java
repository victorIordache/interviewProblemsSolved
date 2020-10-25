package numbers;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        // This would be way easier using Collections.frequency and other methods which are already implemented
        // but I guess that's not the point of this interview.
        HashMap<Integer,Integer> map = new HashMap<>();
        List<Integer> numberList = new ArrayList<>();

        addNumbersToList(numberList);
        mapValueByFreq(numberList,map);
        System.out.println(map);
        output(55,map);

    }
    public static void mapValueByFreq(List<Integer> list,HashMap<Integer,Integer> map){
        for(int value : list){
            if(map.containsKey(value)){
                map.replace(value,map.get(value)+1);
            }else{
                map.put(value,1);
            }
        }
    }

    public static void output(int kScores, HashMap<Integer,Integer> map){

        /*
            for the numberList -> [4,4,2,2,2,2,3,3,1,1,6,7,5]
            the map will be [ 1->2 , 2->4 , 3->2 , 4-> 2 , 5->1 , 6->1 , 7->1 ]
            the output will be 2,4,3.
            It comes in this order because 2 has higher frequency than 4, then 4 has the same freq as 3, but 4 is greater than 3
            This way if two numbers have the same freq the higher one will be displayed first then the other one.
        */
        List<Integer> highestFreq = new ArrayList<>();

        int maxFreq = 0;
        int counter = 0;
        int highestKey = 0;

        // If the kScores > map.size() show only the numbers that I have
        // This way I avoid zeros in the output ( [6, 3, 2, 7, 5, 1, 0, 0, 0, 0...] )
        if(kScores > map.size()){
            kScores = map.size();
        }
        do{
            for(Map.Entry<Integer,Integer> entry : map.entrySet()){
                // This is the first if to avoid entering into this one everytime this for is at the 1st step.
                // This results in a high complexity if the list's size is big. Could create a new comparator and rearrange the map by value
                if(entry.getValue() == maxFreq){
                    // If I have 2 freq which are equal, change the reference from the lower key(number) to the higher one
                    highestKey = entry.getKey();
                }
                if(entry.getValue() > maxFreq){
                    maxFreq = entry.getValue();
                    highestKey = entry.getKey();
                }
            }
            // By adding the key(number) instead of the value(freq) you don't need to find afterwards the key which has the selected value
            // This is easier because you might have 2 keys with the same value, but you'll get the first key which has a lower key(number) than the second one.
            highestFreq.add(highestKey);
            map.remove(highestKey,maxFreq);
            //Reseting the maxFreq & highestKey
            maxFreq = 0;
            highestKey = 0;
            counter++;
        }while(counter != kScores);
        System.out.println(highestFreq);
    }

    public static void addNumbersToList(List<Integer> list){
        list.add(6);
        list.add(5);
        list.add(2);
        list.add(6);
        list.add(6);
        list.add(2);
        list.add(1);
        list.add(7);
        list.add(3);
        list.add(3);
        list.add(3);
    }
}
