package CodingInteview.Companies.AWS_SDE_InterviewPrep;



public class DecodingTheString {

    public static void main(String[] args) {
        //Given the String aaabbbccddda return the decoding string as a3b3c2d3a1
        String s = "aabcddae";
        String result = getTheDecodedString(s);
        System.out.println(result);
    }//main

    public static String getTheDecodedString(String S){
        //Convert the String to Character array
        char[] ch = S.toCharArray();

        //Get the first Character and counter var
        char character = ch[0];
        int counter = 1;

        //Iterate the char array and append the String to the Result String.
        StringBuilder sb = new StringBuilder();

        for(int i = 1; i < ch.length; i++){
            if(character == ch[i]){
                counter++;
            }
            else{
                sb.append(character);
                sb.append(counter);
                character = ch[i];
                counter = 1;
            }
        }
        sb.append(character);
        sb.append(counter);

        return sb.toString();
    }
}//
