/*
Given a string, , matching the regular expression [A-Za-z !,?._'@]+, split the string into tokens. We define a token to be one or more consecutive English alphabetic letters. Then, print the number of tokens, followed by each token on a new line.

        Note: You may find the String.split method helpful in completing this challenge.

        Input Format

        A single string, .

        Constraints

        is composed of any of the following: English alphabetic letters, blank spaces, exclamation points (!), commas (,), question marks (?), periods (.), underscores (_), apostrophes ('), and at symbols (@).
        Output Format

        On the first line, print an integer, , denoting the number of tokens in string  (they do not need to be unique). Next, print each of the  tokens on a new line in the same order as they appear in input string .

        Sample Input

        He is a very very good boy, isn't he?
        Sample Output

        10
        He
        is
        a
        very
        very
        good
        boy
        isn
        t
        he
        Explanation

        We consider a token to be a contiguous segment of alphabetic characters.
        There are a total of  such tokens in string , and each token is printed in the same order in which it appears in string.

*/

import java.util.Scanner;

public class JavaStringTokens {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the string here: ");
        String s = scan.nextLine();
        int counter = 0;
        // Write your code here.

        String[] split = s.trim().split("[\\s!,?._'@]+");
/*        for(String sp : split){
            //System.out.println(sp);
            counter++;
        }*/


        if(s== null || s.trim().equals("")){
            counter = 0;
           //System.out.println("Inside 0");
        }

        else {
            counter = split.length;
        }
        System.out.println("Count =" + counter);
        for(String s2: split){
            System.out.println(s2);
        }

        scan.close();
    }//end of main
}//end of class
