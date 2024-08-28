package CodingInteview.Companies.InRhythm;

import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        int[] A = new int[]{1,2,3,4,6};
        System.out.println(solution(A));
    }

    public static int solution(int[] A) {
        Arrays.sort(A);
        // Implement your solution here
        int temp = 1;
        for(int i = 1; i < 100000; i++){
            if( Arrays.binarySearch(A, i) >= 0)continue;
            else{temp = i; break;}
        }
        return temp;
    }
}