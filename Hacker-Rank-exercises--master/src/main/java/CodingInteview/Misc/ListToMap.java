/**
 * The function listToMap should work as illustrated by the following examples:
 *
 * listToMap(['Julia', 'Tony', 'Steve', 'James']) == {'J': 2, 'T': 1, 'S': 1};
 * listToMap(['Julia']) == {'J': 1};
 * listToMap(['julia']) == {'J': 1};
 * listToMap(['Julia', 'julian']) == {'J': 2};
 * listToMap(['Julia', 'Julia', 'Julia']) == {'J': 1};
 * listToMap(['Julia', 'juliA']) = {'J': 1};
 * listToMap(['Julia', '4Tom', 'J4ck']) = {'J': 1};
 * listToMap(['4Tom', 'J4ck']) == {};
 * listToMap([]) == {};
 * listToMap(['Julia ', '   James ']) == {'J': 2}
 */

package CodingInteview.Misc;


import java.util.*;

public class ListToMap {
    public static void main(String[] args) {

        SolutionListTOMap.listToMap(Arrays.asList("Julia","Tony","Steve","James","julia", "To4", "  jame    "));

    }//main
}//class

class SolutionListTOMap{

    public static boolean isValidString(String s){
        //remove the names that includes the digits in theie name.
        for(Character c : s.toCharArray()){
            if(Character.isDigit(c)){
                return false;
            }
        }
        return true;
    }

    public static void listToMap(List<String> names) {

        //Find out the unique names
        Set<String> setNames = new HashSet<>();

        for (String name : names) {
            //Remove the duplicate, extra spaces.
            if (!setNames.contains(name.trim().toUpperCase())) {
                if (isValidString(name.trim().toUpperCase())) {
                    setNames.add(name.trim().toUpperCase());
                }
            }
        }

        //Create a map to print the name and occurrence.
        Map<String,Integer> map = new HashMap<>();

        for(String name : setNames){
            map.put(name.substring(0,1), map.getOrDefault(name.substring(0,1), 0) + 1);
        }
        System.out.println(map);


//        for(String name : setNames){
//           if(map.containsKey(name.substring(0,1))){
//               map.put(name.substring(0,1), map.get(name.substring(0,1)) + 1);
//           }
//           else{
//               map.put(name.substring(0,1), 1);
//           }
//        }
//        System.out.println(map);
    }//EOF listToMap
}