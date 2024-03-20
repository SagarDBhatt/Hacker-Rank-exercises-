/**
 * We are given the list of cookies with their sweetness. We need to mix least 2 sweet cookies to make a new sweetness cookies.
 * We need to perform the process until we get all the cookies in the list of same or higher sweetness.
 */

//SI:
//6 7
//1 2 3 9 10 12

//SO
//2


package ThreeMonthPreparationKit.October_2022.Week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class JesseAndCookies {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String[] inp = br.readLine().split(" ");
            int n = Integer.parseInt(inp[0]);
            int k = Integer.parseInt(inp[1]);

            List<Integer> listOfCookies = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

            System.out.println(JesseAndCookiesResult.cookies(k,listOfCookies));
        }catch(IOException e){
            e.printStackTrace();
        }
    }//end of main
}//class

class JesseAndCookiesResult {

    /*
     * Complete the 'cookies' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY A
     */

    /**
     * Below solution failed the 6 test cases due to time limit exception.
     * @param k
     * @param cookies
     * @return
     */
//    public static int cookies(int k, List<Integer> cookies) {
//        // * Validate if all the cookies are sweeter than k. If yes, return 0.
//        boolean allCookiesAreSweeterThanK = isAllCookiesSweeterThanK(k, cookies);
//        if(allCookiesAreSweeterThanK)return 0;
//
//        // * Sort the cookies ascending based on the sweetness.
//
////
////       Collections.sort(cookies, Collections.reverseOrder());
////
////        Collections.sort(cookies, new Comparator<Integer>() {
////            @Override
////            public int compare(Integer o1, Integer o2) {
////                return o1 - o2;
////            }
////        });
////
////        Collections.sort(cookies, Collections.reverseOrder());
//        Collections.sort(cookies, (o1, o2) -> o1 - o2);
//        // * Combine first 2 cookies and make the new sweetness cookies. Add the counter.
//        // * Repeat the process and return the counter.
//        // * Check if all cookies are sweeter than K.
//
//        int counter = 0;
//        while(!isAllCookiesSweeterThanK(k, cookies)) {
//            if(cookies.size()==1)return -1;
//            int combinedCookie = cookies.get(0) + 2 * cookies.get(1);
//            cookies.remove(0);
//            cookies.remove(0);
//            cookies.add(combinedCookie);
//            Collections.sort(cookies, (o1, o2) -> o1 - o2);
//            counter++;
//        }
//        // * If not possible, return -1.
//        return counter;
//    }
//
//    private static boolean isAllCookiesSweeterThanK(int k, List<Integer> cookies) {
//        Optional<Integer> cookie = cookies.stream().filter(i -> i < k).findFirst();
//        if(!cookie.isEmpty())return false;
//        return true;
//    }

    public static int cookies(int k, List<Integer> cookies){
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(cookies);
        if(isAllCookiesSweeterThanK(k,pq))return 0;

        int counter = 0;
        while(!isAllCookiesSweeterThanK(k, pq)){
            if(pq.size()==1)return -1;
            pq.add(pq.poll() + pq.poll()*2);
            counter++;
        }

        return counter;
    }

    private static boolean isAllCookiesSweeterThanK(int k, PriorityQueue<Integer> pq){
        Optional<Integer> ans = pq.stream().filter(i -> i < k).findFirst();
        if(ans.isEmpty())return true;
        return false;
    }
}
