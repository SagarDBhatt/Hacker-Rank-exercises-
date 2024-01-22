package EasyLevel;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class FindFibonacciSeries {

    public static void main(String[] args){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        try{
            bw.write("Enter the number : \n " );
            bw.flush();

            int n = Integer.parseInt(br.readLine());

            List<Integer> res = SolutionFibonacci.getFibonnaciSeries(n);

            for(Integer i : res){
                bw.write(i + " ");
                bw.flush();
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }//main

}//class

class SolutionFibonacci{

    public static List<Integer> getFibonnaciSeries(int n){
        List<Integer> result = new ArrayList<Integer>();
        result.add(0);
        result.add(1);

        for(int i = 1; i <= n-2; i++){
            result.add(result.get(i) + result.get(i-1));
        }

        return result;
    }
}