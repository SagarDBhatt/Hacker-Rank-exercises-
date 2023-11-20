//Super digit of any number is found by summing all the digits until the sum came to a single digit.
//For eg: super digit of 898 = 8 + 9 + 8 = 27; 2 + 7 = 9; So the answer is 9.

//SampleInput:
//148 3
// Input is String and counter. So the input value should be - 148148148 (148 string 3 times).

//SampleOutput:
//3

package ThreeMonthPreparationKit.October_2022.Week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EX07_FindSuperDigit {
    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            String[] inputString = br.readLine().split(" ");
            String n = inputString[0];
            int k = Integer.parseInt(inputString[1]);
            System.out.println(ResultSuperDigit.superDigit(n, k));
        }catch(IOException e){
            System.out.println(e.getMessage());
        }

    }//eof main
}//eof class

class ResultSuperDigit {

    public static int superDigit(String n, int k) {
        // Write your code here
        String numStr = "";
        Long num = 0L;

        // 1A). Find the sum of the given string and multiply the sum with the K. Convert the result
        //  in String to eliminate the steps to concatenate the string.
        for(Character ch : n.toCharArray()){
            num += Integer.parseInt(String.valueOf(ch));
        }
        numStr = String.valueOf(num * k);

        Integer counter = 0;
        //2. Create a loop to get the reduced number of the string ubtil the reduced
        // number is single digit.
        String reducedNumber = numStr;
        while(reducedNumber.length() != 1){
            reducedNumber = getReducedString(reducedNumber);
        }

//        //Below Solution gave timeout error, Need to enhance the code.
//        //1. Generate the number by concating the sting.
//        for(int i = 0; i < k; i++){
//            numStr = numStr.concat(n);
//        }
//
//        Integer counter = 0;
//        //2. Create a loop to get the reduced number of the string ubtil the reduced
//        // number is single digit.
//        String reducedNumber = numStr;
//        while(reducedNumber.length() != 1){
//            reducedNumber = getReducedString(reducedNumber);
//        }

        return Integer.parseInt(reducedNumber);
    }

    public static String getReducedString(String string){
        int counter = 0;
        //1. Convert the String to Characters and count the sums.
        for(Character c : string.toCharArray()){
            counter += Integer.parseInt(String.valueOf(c));
        }
        return String.valueOf(counter);
    }
}