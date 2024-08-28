package ThreeMonthPreparationKit.October_2022.Week2;

import java.io.*;

public class EX07_FindAngrams {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line = bufferedReader.readLine();

        System.out.println(ResultAngrams.pangrams(line));
    }//EOF MAIN
}//EOD CLASS

class ResultAngrams {

    /*
     * Complete the 'pangrams' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String pangrams(String s) {
        // Write your code here

        s = s.toLowerCase();
        boolean isPangrams = true;

        for(char char1 ='a'; char1 < 'z'; char1++){
            if(!s.contains(String.valueOf(char1))){
                isPangrams = false;
                break;
            }
        }
        if(isPangrams){
            return "pangram";
        }
        else{
            return "not pangram";
        }
    }

}

