/**
 * We are given a Sting of number and value K. We can replace K numbers in a way that the String become palindrome. Find the highest palindrome number by
 * replacing the k numbers.
 */

//SI
//6 3
//092282

//SO
//992299

package ThreeMonthPreparationKit.October_2022.Week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class HighestValuePalindrome {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String[] arr = br.readLine().split(" ");
            int n = Integer.parseInt(arr[0]);
            int k = Integer.parseInt(arr[1]);

            String s = br.readLine();

            System.out.println(HighestValuePalindromeResult.highestValuePalindrome(s, n, k));
        }catch (IOException e){
            e.printStackTrace();
        }
    }//main
}//class

class HighestValuePalindromeResult {

    /**
     * HackerRank discussion section provided solution
     */
    public static String highestValuePalindrome(String s, int n, int k) {
        StringBuilder sb = new StringBuilder(s);
        Set<Integer> in = new HashSet<>();


        if(s.length() == 1) {
            return "9";
        }

        int total = n%2 ==0 ? n/2: n/2 + 1;

        for (int i = 0; i < total; i++) {
            if(sb.charAt(i) != sb.charAt(n - 1 -i)) {
                if( k > 0) {
                    if( sb.charAt(i) > sb.charAt(n - 1 -i)) {
                        sb.setCharAt(n - 1 -i, sb.charAt(i));
                    } else {
                        sb.setCharAt(i, sb.charAt(n - 1 -i));
                    }
                    in.add(i);
                } else {
                    return "-1";
                }
                k--;
            }
        }

        System.out.println("After Validation: " + k + " val: " + sb.toString());
        int j = 0;
        while(k > 0 && j < total) {

            if(sb.charAt(j) == '9') {
                j++;
                continue;
            }
            if(in.contains(j)) {
                sb.setCharAt(n - 1 - j, '9');
                sb.setCharAt(j, '9');
                k--;
            } else {
                if(k == 1) {
                    j++;
                    continue;
                }
                sb.setCharAt(n - 1 -j, '9');
                sb.setCharAt(j, '9');
                k -= 2;
            }
            j++;
        }

        if(k > 0 && n%2 != 0) {
            sb.setCharAt(n/2, '9');
        }
        return sb.toString();
    }

    /**
     * My attempt to solve the answer.
     */
//    public static String highestValuePalindrome(String s, int n, int k) {
//        int length = n % 2 == 0 ? n/2 : n/2 + 1;
//        int[] mark = new int[6];
//        IntStream.range(0,n).forEach(m -> mark[m] = 0);
//
//        //* Make the string palindrome by changing the characters and reduce k--.
//        for(int i = 0; i < length; i++){
//            if(s.charAt(i) != s.charAt(s.length()-i-1)){
//                if(s.charAt(i) > s.charAt(s.length()-i-1) && k > 0){
//                    s = s.substring(0,s.length()-i-1) + s.charAt(i) + s.substring(s.length()-i);
//                    k--;
//                    //Make the character index to true so we dont need to recount in next iteration.
//                    mark[s.length()-i-1] = 1;
//                }
//                else if(k > 0){
//                    s = s.substring(0,i) + s.charAt(s.length()-i-1) + s.substring(i+1);
//                    k--;
//                    mark[i] = 1;
//                }
//            }
//        }//FOR
//
//        // ** If string is palindrome using K iteration.
//            // && Check if k is still available. if yes, then switch the characters to make higher value palindrome string.
//        int j = 0;
//        while(k > 0 && j < length){
//            if(s.charAt(j) != '9'){
//                    if(mark[j] != 1 && k >0){
//                        String newStr = s.substring(0,j) + '9' + s.substring(j+1);
//                        if(isPalindrome(newStr)){
//                            s = newStr;
//                            k--;
//                        }
//                    }else{
//                        String newStr = s.substring(0,j) + '9' + s.substring(j+1);
//                        if(isPalindrome(newStr)) {
//                            s = newStr;
//                        }
//                    }
//                    if(mark[s.length()-j-1] != 1 && k > 0){
//                        String newStr = s.substring(0,s.length()-j-1) + '9' + s.substring(s.length()-j);
//                        if(isPalindrome(newStr)){
//                            s = newStr;
//                            k--;
//                        }
//                    }
//                    else{
//                        String newStr = s.substring(0,s.length()-j-1) + '9' + s.substring(s.length()-j);
//                        if(isPalindrome(newStr)) {
//                            s = newStr;
//                        }
//                    }
//                    j++;
//            }
//            else{
//                j++;
//                continue;
//            }
////            for(int i = 0; i < k; i++){
////                if(s.charAt(i) != '9'){
////                    s = s.substring(0,i) + '9' + s.substring(i+1);
////                    s = s.substring(0,s.length()-i-1) + '9' + s.substring(s.length()-i);
////                    k--;
////                }
////            }
//        }
//                // && If not, then return the string.
//            // ** If string is not palindrome then return -1 if k = 0 and string is still not palindrome.
//
//        if(isPalindrome(s))return s;
//        return String.valueOf(-1);
//    }
//
//    public static boolean isPalindrome(String s){
//        for(int i = 0; i < s.length()/2; i++){
//            if(s.charAt(i) != s.charAt(s.length()-i-1))return false;
//        }
//        return true;
//    }

}