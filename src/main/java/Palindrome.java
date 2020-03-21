import java.io.*;
import java.util.*;

public class Palindrome {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        int length = A.length() / 2;
        boolean dec = false;

        for(int i = 0; i < length; i++)
        {
            if(A.charAt(i) == A.charAt(length-i))
                dec = true;

            else
                dec = false;
        }

        if(dec)
            System.out.println("Yes");
        else
            System.out.println("No");

    }
}



