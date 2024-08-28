package Miscallaneous;

import java.util.Scanner;

public class Java_Loops_II {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int counter = scan.nextInt();

        for(int i=0;i<counter;i++){
            int a = scan.nextInt();
            int b = scan.nextInt();
            int n = scan.nextInt();

            int c = a;
            for(int j=0;j<n;j++){
                c += Math.pow(2,j) * b;
                System.out.print(c + " ");
            }
            System.out.println();

            //End
        }
    }
}
