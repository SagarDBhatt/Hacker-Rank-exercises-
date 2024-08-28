package CodingInteview.Companies.AWS_SDE_InterviewPrep;

import java.util.*;

public class LogsAscending {
    public static void main(String[] args) {

        //We are given the list of logs. First word of the logs is identifier. We need to sort the logs to get the Strings logs first and then digits logs.
        // Strings logs should be sorted. Digits logs should be in the same order.

        List<String> list = new ArrayList<>();
        list.add("d1 1 2 3 4");
        list.add("l1 art can");
        list.add("d2 3 4 5");
        list.add("l2 own kit dig");
        list.add("l3 art zero");

        List<String> result = getSortedLogs(list);

        System.out.println(result);

    }//main

    public static List<String> getSortedLogs(List<String> logs){

        //Iterate the list. Separate the letter and digits list.
        List<String> leterList = new ArrayList<>();
        List<String> digitList = new LinkedList<>(); //Use LinkedList to maintain the insertion order.
        List<String> resultList = new ArrayList<>();

        for(String s : logs){
            String identifier = s.split(" ")[0];
            if(identifier.startsWith("d"))digitList.add(s);
            else leterList.add(s);
        }

        Collections.sort(leterList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.split(" ")[1].compareToIgnoreCase(o2.split(" ")[1]);
            }
        });

        resultList.addAll(leterList);
        resultList.addAll(digitList);

        return resultList;
    }
}
