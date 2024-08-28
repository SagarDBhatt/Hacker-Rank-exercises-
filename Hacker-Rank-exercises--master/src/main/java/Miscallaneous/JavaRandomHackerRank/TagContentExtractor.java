/**
 * Given the sentence of the String, find the content between the valid string.
 */

//SI
//4
//<h1>Nayeem loves counseling</h1>
//<h1><h1>Sanjay has no watch</h1></h1><par>So wait for a while</par>
//<Amee>safat codes like a ninja</amee>
//<SA premium>Imtiaz has a secret crush</SA premium>

//SO
//Nayeem loves counseling
//Sanjay has no watch
//So wait for a while
//None
//Imtiaz has a secret crush

package Miscallaneous.JavaRandomHackerRank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TagContentExtractor {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            int n = Integer.parseInt(br.readLine());
//            List<String> inputList = new ArrayList<>();
//            IntStream.range(0,n).forEach(i -> {
//                try {
//                    inputList.add(br.readLine());
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }
//            });
//            System.out.println(inputList);

            List<String> inp2 = IntStream.range(0,n).mapToObj(i -> {
                try {
                    return br.readLine();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }).toList();
            System.out.println(inp2);

            ResultTagContentExtractor.getContent(inp2);

        }catch (IOException e){
            e.printStackTrace();
        }
    }//main
}//class

class ResultTagContentExtractor{
    public static void getContent(List<String> list){
        List<String> resultList = new ArrayList<>();

        for(String s : list){
            //Pattern pattern = Pattern.compile("^<([^<>]+)>([^<>]+)</\\1>$");
            Pattern pattern = Pattern.compile("<([^<>]+)>([^<>]+)</\\1>");
            Matcher matcher = pattern.matcher(s);
            boolean patternMatcher = false;

            while(matcher.find()){
                System.out.println(matcher.group(2));
                patternMatcher = true;
            }
            if(!patternMatcher){
                System.out.println("None");
            }

//            if(!matcher.find()) {
//                System.out.println("None");
//            }
//            else{
//                String matchedStr = matcher.group(2);
//                Matcher matcher1 = pattern.matcher(matchedStr);
//
//                while(matcher1.find()){
//                    matchedStr = matcher1.group(2);
//                    matcher1 = pattern.matcher(matchedStr);
//                }
//                System.out.println(matchedStr);
//            }
        }
    }
}