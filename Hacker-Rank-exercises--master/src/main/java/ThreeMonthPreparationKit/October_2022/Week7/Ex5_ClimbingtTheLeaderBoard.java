/**
 * The given array is the score of the player in desc order with 1st is Rank 1 and so on.
 * The same score ranks the same and the next score is in sequence.
 *
 * We are given the score of our player and need to print the rank based on the score and provided rank.
 *
 * Sample input:
 * 7
 * 100 100 50 40 40 20 10
 * 4
 * 5 25 50 120
 *
 * Sample output:
 * 6
 * 4
 * 2
 * 1
 *
 * The first array is the score of the player with the rank 1 to n. Based on this rank, we need to print the rank.
 */
package ThreeMonthPreparationKit.October_2022.Week7;

import javax.imageio.event.IIOReadProgressListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Ex5_ClimbingtTheLeaderBoard {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            int n = Integer.parseInt(br.readLine());
            List<Integer> inputList = Arrays.stream(br.readLine().split(" "))
                    .map(Integer::parseInt).collect(Collectors.toList());
            int p = Integer.parseInt(br.readLine());
            List<Integer> playerScoreList = Arrays.stream(br.readLine().split(" "))
                    .map(Integer::parseInt).collect(Collectors.toList());
            List<Integer> resultRank = ResultClimbingTheLeaderboard.climbingLeaderboard(inputList, playerScoreList);
            resultRank.stream().forEach(System.out::println);
        }catch(IOException e){
            e.printStackTrace();
        }
    }//end of main

}//class

class ResultClimbingTheLeaderboard {

    //V2 of the method with the passed test cases - Improve Time complexity:
    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        // Write your code here
        //Approach 2: Using Collections.binarySearch() method to find the location.

        // //a. Create the Set of unique Ranked Score from the given list.
        // Set<Integer> uniqRank = new LinkedHashSet<Integer>();
        // for(Integer rank : ranked){
        //     uniqRank.add(rank);
        // }
        Set<Integer> uniqRank = new LinkedHashSet<Integer>(ranked);

        // //a.1) Convert the Set to the List collections.
        List<Integer> uniqRankList = new ArrayList<Integer>(uniqRank);

        // List<Integer> uniqRankList = ranked.stream()
        //                 .distinct().collect(Collectors.toList());

        //b. Iterate the score of given player and identify the rank. Add to the result List.
        List<Integer> resultList = new ArrayList<Integer>();
        for(Integer playerScore : player){
            int n = Collections.binarySearch(uniqRankList, playerScore, Collections.reverseOrder());
            // if(uniqRankList.contains(playerScore))resultList.add(n+1);
            if(n >= 0)resultList.add(n+1);
            else resultList.add(Math.abs(n));
        }

        return resultList;
    }

    //V1 of the method with the passed test cases.
//    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
//        // Write your code here
//       //Approach 2: Using Collections.binarySearch() method to find the location.
//
//        //a. Create the Set of unique Ranked Score from the given list.
//        Set<Integer> uniqRank = new LinkedHashSet<Integer>();
//        for(Integer rank : ranked){
//            uniqRank.add(rank);
//        }
//
//        //a.1) Convert the Set to the List collections.
//        List<Integer> uniqRankList = new ArrayList<Integer>(uniqRank);
//
//        //b. Iterate the score of given player and identify the rank. Add to the result List.
//        List<Integer> resultList = new ArrayList<Integer>();
//        for(Integer playerScore : player){
//            int n = Collections.binarySearch(uniqRankList, playerScore, Collections.reverseOrder());
//            if(uniqRankList.contains(playerScore))resultList.add(n+1);
//            else resultList.add(Math.abs(n));
//        }
//
//        return resultList;
//
//        //Approach 1: The manual steps to find the location of the element in the collection.
//        // Convert the ranked score with the rank.
////        Map<Integer, Integer> initRankedMap = new HashMap<Integer, Integer>();
////        int counter = 1;
////        for(int i = 0; i < ranked.size(); i++){
////            if(initRankedMap.containsKey(ranked.get(i)))continue;
////            initRankedMap.put(ranked.get(i),counter++);
////        }
////        System.out.println(initRankedMap);
////
////        //ResultList
////        List<Integer> resultList = new ArrayList<>();
////
////        //Now iterate the player score and iterate initRankedMap and then identify the rank.
////        for(Integer plaScore : player){
////            if(initRankedMap.containsKey(plaScore)){
////                resultList.add(initRankedMap.get(plaScore));
////            }
////        }
////        System.out.println(resultList);
////
////        return Arrays.asList(1,2,3);
//    }//end of method

}//end of class
