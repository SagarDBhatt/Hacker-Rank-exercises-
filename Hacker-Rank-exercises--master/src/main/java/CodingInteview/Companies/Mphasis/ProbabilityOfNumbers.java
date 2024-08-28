//Given a number 1 - 100, randomly picked up two random numbers and find the absolute difference. Remove those two numbers and add the absolute difference number.
// Now, do the same exercise until we receive the 1 number. If the number is over 50 (51-100) then its bigger number. Else it is smaller number.
// Do the same exercise 10 times and provide the probability of getting the bigger and smaller number.

package CodingInteview.Companies.Mphasis;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class ProbabilityOfNumbers {
    public static void main(String[] args) {

        List<String> result = findTheFinalNumber(10, 10);

        System.out.println("Smaller Number % = " + result.stream().filter(i-> i.equals("Smaller Number")).count()  * 100 /result.size());
        System.out.println("Bigger number % = " + result.stream().filter(i -> i.equals("Bigger Number")).count()* 100 /result.size() );
    }//main

    public static List<String> findTheFinalNumber(int N, int times){


        List<String> result = new ArrayList<>();
        List<Integer> numbers = new ArrayList<Integer>();


        while(times > 0) {
            IntStream.range(1, N + 1).forEach(i -> numbers.add(i));

            while (numbers.size() > 1) {
                Integer random1 = numbers.get((int) (numbers.size() * Math.random()));
                Integer random2 = numbers.get((int) (numbers.size() * Math.random()));
                Integer difference = Math.abs(random1 - random2);

                numbers.remove(random1);
                numbers.remove(random2);

                if (!numbers.contains(difference)) numbers.add(difference);
            }

            if (numbers.get(0) >= N / 2) result.add("Bigger Number");
            else result.add("Smaller Number");
            times--;
        }
        System.out.println(result);

        return result;
    }

}//class
