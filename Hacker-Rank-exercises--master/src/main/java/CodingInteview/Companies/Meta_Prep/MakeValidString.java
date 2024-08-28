/**
 * Given a string, identify the minimum number of parentheses that needs to be removed to make it valid.
 *
 * For eg:  s t ( d b ( b d ) d ) w ) => This string has 2 open brackets and 3 closing brackets. To make it valid, I need to remove the
 * 1 closing parentheses to get the valid string
 */

//SI
//6
//st(db(bd)d)w)

//SO:
// 1

package CodingInteview.Companies.Meta_Prep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class MakeValidString {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            int n = Integer.parseInt(br.readLine());
            String s = br.readLine();
            System.out.println(MakeTheStringValidSolution.getMinCount(s));
        }catch (IOException e){
            e.printStackTrace();
        }

    }//main
}//class

class MakeTheStringValidSolution{
    public static int getMinCount(String s){

        // => Iterate the string and find all the opening brackets.
        // => If the bracket is opened then add that index in the stack.
        // => If we find the matching closing bracket then remove/pop the stack.
        // => If we find the closing bracket for which we dont have any opening bracket then add the index to the set.
        // => Iterate the string and remove the string which does not have the closing brackets.

        Stack<Integer> openingBracketStacks = new Stack<>();
        Set<Integer> invalidIndex = new HashSet<>();

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(')openingBracketStacks.add(i);
            if(s.charAt(i) == ')' && !openingBracketStacks.isEmpty())openingBracketStacks.pop();
            else if(s.charAt(i) == ')') invalidIndex.add(i);
        }

        String resStr = "";
       for(int i = 0; i < s.length(); i++){
           if(invalidIndex.contains(i) || openingBracketStacks.contains(i))continue;
           resStr = resStr.concat(String.valueOf(s.charAt(i)));
       }

        System.out.println(resStr);
        int result = invalidIndex.size() + openingBracketStacks.size();
        return result;
    }
}