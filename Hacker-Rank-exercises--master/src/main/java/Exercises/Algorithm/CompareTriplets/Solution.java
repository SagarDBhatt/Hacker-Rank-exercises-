package Exercises.Algorithm.CompareTriplets;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {

    // Complete the compareTriplets function below.
    static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        int aliceCount =0, bobCount = 0;
        for(int i=0; i< a.size();i++){
            if(a.get(i) > b.get(i))
                aliceCount++;
            if(a.get(i) < b.get(i))
                bobCount++;
        }
        List<Integer> resultList = new ArrayList<>(Arrays.asList(aliceCount,bobCount));
        return resultList;
    }

    public static void main(String[] args) throws IOException {
        //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
/*
        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> b = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = compareTriplets(a, b);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();*/
        final Scanner scan = new Scanner(System.in);

        System.out.println("Insert score of Alice");

        List<Integer> aliceScore = new ArrayList<Integer>();
        aliceScore.add(scan.nextInt());
        aliceScore.add(scan.nextInt());
        aliceScore.add(scan.nextInt());

        System.out.println("Enter Bob's score");

        List<Integer> bobsScore = new ArrayList<Integer>();
        bobsScore.add(scan.nextInt());
        bobsScore.add(scan.nextInt());
        bobsScore.add(scan.nextInt());

        List<Integer> result = compareTriplets(aliceScore,bobsScore);
        System.out.println(result.get(0) + " " + result.get(1));
    }

}
