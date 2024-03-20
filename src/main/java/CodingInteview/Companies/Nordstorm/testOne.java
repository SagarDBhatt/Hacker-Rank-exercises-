package CodingInteview.Companies.Nordstorm;

public class testOne {
    public static void main(String[] args) {

        //Given the array find the minimum num of jumps to reach the end of array.
        // Each num at an index is the number of jumps that can be made at the index.
        //int[] inpArr = {2,3,1,2,4};
        int[] inpArr = {2,2,1,1,4};
        int distToEnd = Integer.MAX_VALUE;
        int initalInd = 0;
        int initialVal = inpArr[initalInd];
        int nextVal = initialVal;
        int nextInd;
        int counter = 1;

        while(distToEnd > 0){
            //Find the first element and next element for which the distance to length is minimum.
            for(int i = initalInd+1; i <= initialVal; i++){
                nextVal = inpArr[i];
                if(inpArr.length - (initialVal + nextVal) < distToEnd &&
                        inpArr.length - (initialVal + nextVal) >= 0){
                    distToEnd = inpArr.length - (initialVal + nextVal);
                    nextInd = i;
                    nextVal = inpArr[i];
                    counter++;
                }
            }
        }

        System.out.println(counter);
    }//main
}//class
