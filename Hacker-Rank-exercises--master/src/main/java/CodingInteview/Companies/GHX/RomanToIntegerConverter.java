package CodingInteview.Companies.GHX;

import java.util.HashMap;
import java.util.Map;

public class RomanToIntegerConverter {
    public static void main(String[] args) {
        System.out.println(SolutionConveter.convert("MDL"));
        System.out.println(SolutionConveter.convert("IV"));
        System.out.println(SolutionConveter.convert("MDIV"));

    }//main
}//class

class SolutionConveter{
    public static Integer convert(String romanval){

        Integer result;
        //1. Create the map to map the string with the int values.
        Map<String, Integer> mapper = new HashMap<String,Integer>();
        mapper.put("I",1);
        mapper.put("V",5);
        mapper.put("X",10);
        mapper.put("L",50);
        mapper.put("C",100);
        mapper.put("D",500);
        mapper.put("M",1000);

        //2. Validate the values are in asc order.
        result = isLargetsOrderCalc(romanval,mapper);

        //3. sum each values and return the result.

        //4. subtract the value and return the result.
        return result;
    }

    public static Integer isLargetsOrderCalc(String romanVal, Map<String, Integer> mapper){
        //String[] rom = romanVal.split("");
        //boolean isMax = true;
        Integer result = 0;

        for(int i =0; i < romanVal.length()-1; i++){
            if(mapper.get(String.valueOf(romanVal.charAt(i))) > mapper.get(String.valueOf(romanVal.charAt(i+1)))){
              result += mapper.get(String.valueOf(romanVal.charAt(i)));
            }
            else{
                result -= mapper.get(String.valueOf(romanVal.charAt(i)));
            }
        }
        result += mapper.get(String.valueOf(romanVal.charAt(romanVal.length()-1)));

        return result;
    }
}
