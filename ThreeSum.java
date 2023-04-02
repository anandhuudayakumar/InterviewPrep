import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1,0,1,2,-1,-4}));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> finalSet =  new HashSet<>();
        List<List<Integer>> finalList =  new ArrayList<>();
        Set<Set<Integer>> confirmationList = new HashSet<>();


        for(int i =0;i<nums.length;i++){
            for(int j=0;j<nums.length; j++){
                for(int k=0; k<nums.length; k++){
                    if(i!=j && i!=k && j!=k ){
                        if( (nums[i]+nums[j]+nums[k]) == 0){

                            List<Integer> tempList =new ArrayList<>();

                            tempList.add(nums[i]);
                            tempList.add(nums[j]);
                            tempList.add(nums[k]);

                            Set<Integer>tempSet =  new HashSet<>(tempList);
                            if(!confirmationList.contains(tempSet)){
                                finalSet.add(tempList);
                                confirmationList.add(tempSet);
                            }
                        }
                    }


                }
            }
        }
        for(List<Integer> set: finalSet){
            finalList.add(new ArrayList<>(set));
        }
        return finalList;
    }
}
