/**
 * Write the function to reverse the String and List.
 */

//SI
//ThisIsReverseString
//1 2 3 4 5 6 7 8 9


package CodingInteview.Companies.Meta_Prep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class ReverseTheStringAndList {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        try{
            String s = bufferedReader.readLine();
            System.out.println("Input String == " + s);
            System.out.println("Reverse String == " + ReverseStrAndList.revereString(s));

            List<Integer> ls = Arrays.stream(bufferedReader.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
            System.out.println("Initial list ==" + ls);

            System.out.println("Reverse list == " + ReverseStrAndList.reverseList(ls));
        }catch (IOException e){
            e.printStackTrace();
        }
    }//main
}//class

class ReverseStrAndList{
    public static String revereString(String s){

        //One way is to add all the characters in the Stacks and return the Stack pop.
        Stack<String> st = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            st.add(String.valueOf(s.charAt(i)));
        }

        String revS1 = "";
        for(int i = 0; i < s.length(); i++){
            revS1 = revS1.concat(st.pop());
        }

        System.out.println("Rev S1 = " + revS1);

        //Another method is to iterate each characters from the back and return the String.
        String revS2 = "";
        for(int i = s.length()-1; i >= 0; i--){
            revS2 = revS2.concat(String.valueOf(s.charAt(i)));
        }

        System.out.println("Rev S2 = " + revS2);

        return s;
    }

    public static List<Integer> reverseList(List<Integer> ls){

        return ls;
    }
}
