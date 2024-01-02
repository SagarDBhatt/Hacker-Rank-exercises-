package ThreeMonthPreparationKit.October_2022.Week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

public class SuperReducedString {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            String s = br.readLine();
            System.out.println(ResultSuperReducedString.superReducedString(s));
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }//end of main
}//end of class

class ResultSuperReducedString {

    /*
     * Complete the 'superReducedString' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */
    //baab -> null
    //aaabccddd -> abd
    public static String superReducedString(String s) {
        // Write your code here
        List<Character> ls = s.chars().mapToObj(i -> (char) i).collect(Collectors.toList());

        while(isAdjacentCharsSame(ls)){
            for(int i = 0; i < ls.size()-1; i++){
                if(ls.get(i) == ls.get(i+1)){
                    ls.remove(i);
                    ls.remove(i);
                    i--;
                }
            }
        }
        if(ls.size() == 0)return "Empty String";
        return ls.stream().map(i -> i.toString()).collect(Collectors.joining());
    }//end of method

    public static boolean isAdjacentCharsSame(List<Character> ls){
        for(int j = 0; j < ls.size()-1; j++){
            if(ls.get(j) == ls.get(j+1))return true;
        }
        return false;
    }

}