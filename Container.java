import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Arrays.stream;

public class Container {

    public static void main(String[] args) {
        maxArea(new int[]{1,2,4,3});
    }

    public static int maxArea(int[] height) {

        int i =0;
        int j = height.length-1;
        int area =  0;
        while(i<j){
            int heightPoint1 =  height[i];
            int heightPoint2 =  height[j];
            area = Math.max(area,Math.min(heightPoint1,heightPoint2) * Math.abs(j-i));
            if(height[i] < height[j]) i++;
            else j--;
        }
        return area;
    }
}
