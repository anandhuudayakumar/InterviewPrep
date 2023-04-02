import java.util.*;


public class TwoSum {

    public static void main(String[] args) {
        Arrays.stream(twoSum(new int[]{3, 2, 4,}, 6)).forEach(System.out::println);
    }

    public static   int[] twoSum(int[] nums, int target) {
        Map<Integer,List<Integer>> numsMap = new HashMap();

        for(int i=0;i<nums.length;i++){
            if(numsMap.containsKey(nums[i])){
                List<Integer> indices = numsMap.get(nums[i]);
                indices.add(i);
                numsMap.put(nums[i],indices);
            }else{
                List<Integer> tempList = new ArrayList<>();
                tempList.add(i);
                numsMap.put(nums[i],tempList);
            }
        }

        for(int i=0; i<nums.length; i++){
            int requiredValue = target-nums[i];
            if(numsMap.containsKey(requiredValue)){
                List<Integer> first = numsMap.get(nums[i]);
                List<Integer> second = numsMap.get(requiredValue);
                if(requiredValue == nums[i]){

                    if(first.size()<=1) continue;
                    else return new int[]{first.get(0),first.get(1)};
                }else{

                    return new int[]{first.get(0),second.get(0)};
                }
            }
        }
        return null;
    }
}
