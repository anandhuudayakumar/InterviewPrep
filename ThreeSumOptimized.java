import java.util.*;

public class ThreeSumOptimized {

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1,0,1,2,-1,-4}));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Set<Set<Integer>> confirmationSet = new HashSet<>();
        List<List<Integer>> finalList =  new ArrayList<>();
        /**
         * sort the array
         * use two pointer method to find j, k
         */
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            int j = i+1;
            int k = nums.length-1;
            while(j<k){
                if( (nums[i] + nums[j] + nums[k]) == 0){
                    List<Integer> tempList = new ArrayList<>();
                    tempList.add(nums[i]);
                    tempList.add(nums[j]);
                    tempList.add(nums[k]);
                    Set<Integer> tempSet = new HashSet<>(tempList);
                    if(!confirmationSet.contains(tempSet)){
                        finalList.add(tempList);
                        confirmationSet.add(tempSet);
                    }
                    j++;
                    k--;
                }else if((nums[j] + nums[k]) < -1*nums[i]){
                    j++;
                }else if ((nums[j] + nums[k]) > -1*nums[i]){
                    k--;
                }
            }

        }

        return finalList;
    }
}
