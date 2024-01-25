/**
 * Given a String, find out the longest string with only 2 characters alternatively available.
 * Ex: String S = 'beabeefeab'
 *
 * Now, remove all instances of character 'e' will give us: s= babfab
 * Now, remove all instance of character 'f' will give us: s= babab
 *
 * This is the longest String with only 2 alternating characters. Return the length of the String.
 *
 * Sample Input:
 * 10
 * beabeefeab
 *
 * Sample output:
 * 5
 */


package ThreeMonthPreparationKit.October_2022.Week9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class TwoCharacters {
    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try{
            int n = Integer.parseInt(br.readLine());
            String S = br.readLine();
            System.out.println(SolutionTwoAlternatingCharacters.alternate(S));
        }catch (Exception e){
            e.printStackTrace();
        }



    }//main
}//end of class

class SolutionTwoAlternatingCharacters {

    public static int alternate(String s) {
        // Convert the String into Unique Characters ArrayList or HashSet

        Set<Character> st = new LinkedHashSet<>();
        for(Character c : s.toCharArray()){
            st.add(c);
        }

        System.out.println(st.toString());



        return 0;
    }

}