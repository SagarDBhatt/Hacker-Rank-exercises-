package CodingInteview.Companies.AWS_SDE_InterviewPrep;

import java.util.*;

public class SuggestedProducts {
    public static void main(String[] args) {

        //Given the list of Products and Search word. When user type the first character of the seached word then we should give the 3 best suggestions.
        // For eg: we have list of products and User is typing the seach word as "mouse".
        // In this case, when user type first char 'm', we need to give 3 alphabetically ordered suggestions as ["mobile", "moneypot", "monitor];
        List<String> products = new ArrayList<>(Arrays.asList("mobile", "moneypot", "mouse", "monitor", "mousepad"));
        String searchWord = "mouse";

        List<List<String>> result = getProducts(products, searchWord);
        System.out.println(result);
    }//main

    public static List<List<String>> getProducts(List<String> products, String searchWord){
        //Sort the products alphabetically.
        Collections.sort(products, (o1, o2) -> o1.compareToIgnoreCase(o2));

        //Iterate the char array and for each word find the matching product and add to the result list.
        List<List<String>> resultList = new ArrayList<>();

        for(int i = 0; i < searchWord.length(); i++){
            StringBuilder sb = new StringBuilder(searchWord.substring(0, i + 1));
            List<String> list = new ArrayList<>();

            for(String product : products){
                if(product.startsWith(sb.toString())){
                    list.add(product);
                    if(list.size()==3)break;
                }
            }
            resultList.add(list);
        }

        return resultList;
    }
}
