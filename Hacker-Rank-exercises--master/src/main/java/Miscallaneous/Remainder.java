package Miscallaneous;

import java.io.*;
import java.util.*;

class Remainder {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Quotient and Remainder - ");
        int i = sc.nextInt();
        int j = sc.nextInt();
        int count=0;

        while(i > 0){
            i = i - j;

            if(i>0){
                count++;
            }
            else
                break;
        }

        System.out.println("Quotient = " + count);
        System.out.println("Remainder = " + (j+i));

    }//end main
}//end class