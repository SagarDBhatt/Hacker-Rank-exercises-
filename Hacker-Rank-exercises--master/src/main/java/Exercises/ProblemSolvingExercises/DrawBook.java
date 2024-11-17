/**
 * Book has the page 1 in front of the right side. Starting from there we are given the number of pages of book.
 * find the minimum number of pages that needs to be turned in order to reach the requested page
 * starting from either front or back.
 */

//SI
//6
//2

//SO
//1

//5
//4

//0

package Exercises.ProblemSolvingExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DrawBook {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int n = Integer.parseInt(br.readLine());
            int p = Integer.parseInt(br.readLine());

            System.out.println(SolutionDrawBook.findMinNumOfPagesToTurn(n, p));
        }catch (IOException e){
            e.printStackTrace();
        }
    }//main
}//class

class SolutionDrawBook{
    public static int findMinNumOfPagesToTurn(int n,int p){
        int min = 0;
        if(p==1)return min;
        if(p <= n/2){
            for(int i = 2; i < n; i+=2){
                min++;
                if(p==i || p==i+1)break;
            }
        }
        else{
            if(n%2==0 && p!= n){
                for(int i = n-1; i >= 0; i-=2){
                    min++;
                    if(p==i || p== i-1)break;
                }
            }
            else {
                if(p==n || p== n-1)return min;
                for(int i = n; i >= 0; i-=2){
                    if(p==i || p== i-1)break;
                    min++;
                }
            }
        }
        return  min;
    }
}
