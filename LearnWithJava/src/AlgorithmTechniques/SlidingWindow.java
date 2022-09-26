package AlgorithmTechniques;

import java.util.Arrays;

public class SlidingWindow {
//    public int minSubArrayLen(int target, int[] nums) {
//        int minCount = 0;
//        int sum = 0;
//        for(int a : nums){
//            sum+=a;
//            minCount++;
//            if(sum>=target)break;
//        }
//        int result = minCount;
//        if(sum< target) return 0;
//        for(int i= 1; i<nums.length; i++)
//        {
//            if(Arrays.stream(Arrays.stream(nums).skip(i).toArray()).limit(minCount-1).sum()>= target)
//            {
//                result = minCount - 1;
//                minCount--;
//            }
//        }
//
//        return result;
//    }
public int minSubArrayLen(int target, int[] nums) {
    if (Arrays.stream(nums).sum() < target) return 0;
    int minLength = nums.length;
    int sum = 0;
    int lastSum = 0;
    int left = 0;
    for (int i = 0; i < nums.length; i++)
    {
        sum += nums[i];
        while (sum >= target)
        {
            lastSum = sum;
            sum -= nums[left];
            left++;
        }
        minLength = lastSum >= target && (i - left + 2 > 0) ? Math.min(minLength, i - left + 2) : minLength;
    }
    return lastSum>=target? minLength:0;
}
}
