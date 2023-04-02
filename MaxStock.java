import java.util.HashSet;
import java.util.Set;

import static java.lang.Integer.*;

public class MaxStock {
    public static void main(String[] args) {
        maxSubArray(new int[]{2,1,-3,4,-1,2,1,-5,4});
    }
    public int maxProfit(int[] prices) {
        //stock 7,1,5,3,6,4
        int minValue = prices[0];
        int maxValue = MIN_VALUE;
        int profit = 0;
        for(int i=0;i<prices.length;i++){
            if(prices[i]<minValue) minValue = prices[i];
            if(prices[i]-minValue>profit){
                maxValue = prices[i];
                profit= maxValue-minValue;
            }
            return profit;
        }


        return 0;
    }


    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i])) return true;
            else set.add(nums[i]);
        }
        return false;
    }

    public static int[] productExceptSelf(int[] nums) {

        int arrayLength =  nums.length;
        int[] prefixArray = new int[arrayLength];
        int[] postfixArray =  new int[arrayLength];
        int[] finalArray = new int[arrayLength];

        //populate prefix array by multiplying each element with the prefix and store the value, iteration from left to right
        int initialProductValue =1;
        finalArray[0] = 1;
        for(int i =0;i<arrayLength-1;i++){
//            initialProductValue = initialProductValue * nums[i];
//            prefixArray[i] = initialProductValue;
            finalArray[i+1] = finalArray[i] * nums[i];
        }
        initialProductValue = 1;
        //populate postfix array by multiplying each element with the postfix value, iteration from right to left
        for(int i=arrayLength-2;i>0;i--){
            initialProductValue = initialProductValue * nums[i];
            postfixArray[i] = initialProductValue;
            finalArray[i-1] = finalArray[i] * nums[i+1];
        }

        for(int i=0;i<arrayLength;i++){
            if(i == 0) finalArray[i] = postfixArray[i+1];
            else if(i == arrayLength-1) finalArray[i] = prefixArray[i-1];
            else finalArray[i] = postfixArray[i+1] * prefixArray[i-1];
        }
        return finalArray;
    }

    public static int maxSubArray(int[] nums) {

        int maxValueTillCurrent = nums[0];
        int totalMaxValue = nums[0];
        for(int i=1;i<nums.length;i++){
            maxValueTillCurrent = maxValueTillCurrent + nums[i];
            if(totalMaxValue < maxValueTillCurrent) totalMaxValue = maxValueTillCurrent;
            if(maxValueTillCurrent<0) maxValueTillCurrent = 0;
        }
        return totalMaxValue;
    }

    public int findMin(int[] nums) {
        //[1,2,3] => [3,2,1]
        for(int i=0;i<nums.length;i++){
            if(nums[i]<nums[i+1]) return nums[i];
        }
        return nums[nums.length-1];
    }
}
