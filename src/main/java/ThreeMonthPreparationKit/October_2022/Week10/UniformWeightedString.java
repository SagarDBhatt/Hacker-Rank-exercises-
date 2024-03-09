/**
 *  ** Each character has the weight a = 1, b = 2, c = 3 ....
 *  ** Uniform String is the String which has only 1 character, Fir Eg, String S = aaabbbbccccdd has uniform strings as - [a, aa, aaa, aaaa, b, bb, bbb, bbbb ... ]
 *  ** Find the weight of each uniform string and check whether the string weight is included in the query. If yes then put Yes else No.
 */

//Sample Input
//abccddde
//6
//1
//3
//12
//5
//9
//10

//Sample Output:
//Yes
//Yes
//Yes
//Yes
//No
//No

package ThreeMonthPreparationKit.October_2022.Week10;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class UniformWeightedString {
    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try{
            String S = br.readLine();
            int queries = Integer.parseInt(br.readLine());
            List<Integer> queryList = new ArrayList<>();
            IntStream.range(0,queries).forEach(i -> {
                try {
                    queryList.add(Integer.parseInt(br.readLine()));
                }catch(IOException e){
                    e.printStackTrace();
                }
            });
            List<String> resultString = UniformWeightedStringResult.weightedUniformStrings(S, queryList);

            resultString.stream().forEach(System.out::println);
        }catch (IOException e){
            e.printStackTrace();
        }


    }//end of main
}//end of class

class UniformWeightedStringResult {

    /**
     * Below solution is not accepted as the time limit is exceeds. Need to optimize the solution.
     * @param s
     * @param queries
     * @return
     */
    public static List<String> weightedUniformStrings2(String s, List<Integer> queries) {
        //1. Set the weight of each character in a given string.
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        for(Character c : s.toCharArray()){
            map.put(c, c - 'a' + 1);
        }

        //2. Get the list of Uniform Strings.
        Set<String> uniformStrings = getTheUniformString(s);

        //3. Get the weight of each String.
        List<String> resultStr = new ArrayList<>();
        List<Integer> resultInt = new ArrayList<>();
        for(String st : uniformStrings){
            resultInt.add(st.chars().map(i -> map.get((char)i)).sum());
        }

        for(int i : queries){
            if(resultInt.contains(i))resultStr.add("Yes");
            else resultStr.add("No");
        }

        return resultStr;

    }//end of method

    public static Set<String> getTheUniformString(String s){
        Set<String> uniformStrings = new LinkedHashSet<>();

        for(int i = 0; i < s.length(); i++){
            for(int j = i; j < s.length(); j++){
                //if(j == i)uniformStrings.add(s.substring(i,j));
                if(s.charAt(i) != s.charAt(j))continue;
                uniformStrings.add(s.substring(i,j+1));
            }
        }

        return uniformStrings;
    }//end of method

    /**
     * Option 2: Optimize the solution.
     * Rather than creating the uniform string check for each character in the iteration and add to the weights.
     * Then check the weights against the Queries and add to resultStringList.
     */

    public static List<String> weightedUniformStrings(String s, List<Integer> queries){

        Set<Integer> weights = new LinkedHashSet<>();

        for(int i = 0; i < s.length();){
            int sum = 0;
//            for(int j = i; j < s.length();j++){
//                if(s.charAt(j) != s.charAt(i))continue;
//                sum += s.charAt(i) - 'a' + 1;
//                weights.add(sum);
//            }
            int j = i;
            while(j < s.length() && s.charAt(i) == s.charAt(j)){
                sum += s.charAt(i) - 'a' + 1;
                weights.add(sum);
                j+=1;
            }
            i = j;
        }
        System.out.println(weights);

        List<String> result = new ArrayList<>();
        for(int i : queries){
            if(weights.contains(i))result.add("Yes");
            else result.add("No");
        }
        return result;
    }


}//end of class