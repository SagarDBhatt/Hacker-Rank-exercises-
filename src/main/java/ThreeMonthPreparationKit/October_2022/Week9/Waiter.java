package ThreeMonthPreparationKit.October_2022.Week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static ThreeMonthPreparationKit.October_2022.Week9.Utility.getFirstFewPrimeNumbers;


public class Waiter {

    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try{
            String[] inp = br.readLine().split(" ");
            int n = Integer.parseInt(inp[0]);
            int q = Integer.parseInt(inp[1]);

            List<Integer> inpList = Arrays.stream(br.readLine().split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            List<Integer> result = Utility.getTheResultantArray(inpList, q);

            System.out.println(result);


        }catch(IOException e){
            e.printStackTrace();
        }


    }//end of main

}//end of class

class Utility{

    public static List<Integer> getFirstFewPrimeNumbers(int q){

        List<Integer> primeNumbers = new ArrayList<Integer>();
        primeNumbers.add(2);
        int cnt = 1;

            for(int i = 2; i < Math.pow(q,3); i++){
                if(cnt == q)break;
                for( int j = 2; j < i; j++){

                    if( i % j == 0){
                        break;
                    }
                    else{
                        if(j == i-1){
                            primeNumbers.add(i);
                            cnt++;
                        }
                    }
                }// j
            }// i

        return primeNumbers;
    }//end of method

    /**
     * The task is :
     * 1. Find the first q prime numbers.
     * 2. Convert the input list to Stack.
     * 3. For each prime number, iterate the given input list. If the number is divisible then add to Stack B. Else Add to Stack A.
     * 4. Move B stack elements to Answer array.
     * 5. Follow the same procedure for each of the iteration.
     * 6. At the end, if A stack has some values then pop it and add to answers Stack and return.
     * @param number
     * @param q
     * @return
     */
    public static List<Integer> getTheResultantArray(List<Integer> number, int q){


        List<Integer> firstQPrimeNumbers = getFirstFewPrimeNumbers(q);
//        System.out.println(firstQPrimeNumbers);

        Stack<Integer> A = new Stack<>();
        Stack<Integer> B = new Stack<>();

        List<Integer> answers = new ArrayList<Integer>();

        for(Integer i : firstQPrimeNumbers){
            Collections.reverse(number);
            for(Integer j : number){

                if(j % i == 0)B.push(j);
                else A.push(j);

            }// j

            while(!B.isEmpty()){
                answers.add(B.pop());
            }
            number.clear();
            number.addAll(A);
            A.clear();

        }// i

//        while (!A.isEmpty()){
//            answers.add(A.pop());
//        }
        for(int k = number.size()-1; k >= 0; k--){
            answers.add(number.get(k));
        }

        return answers;
    }//end of method

}
