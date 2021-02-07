package Day52;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] nums = {{1,3,5,7,9},{2,4,6,8,10},{1,8,10,12,18},
                {2,6,19,30,36}};
        int[] res=solution.merge(nums);
        System.out.println(Arrays.toString(res));
    }
    public int[] merge(int[][] nums){
        int group = nums.length/2;
        int[][] result =  new int[group][];
        for(int i=0;i<nums.length;i+=2){
            result[i/2] = mergeTwoArr(nums[i],nums[i+1]);
        }
        return merge(result);
    }

    public int[] mergeTwoArr(int[] nums1,int[] nums2){
        int length1=nums1.length;
        int length2=nums2.length;
        int[] arrs  = new int[length1+length2];
        int i =0;
        int j= 0;
        int index = 0;
        while(i<length1&&j<length2){
            if(nums1[i]<nums2[j]){
                arrs[index]=nums1[i];
                index++;
                i++;
            }else{
                arrs[index]=nums2[j];
                index++;
                j++;
            }
        }
        while(i<length1){
            arrs[index]=nums1[i];
            index++;
            i++;
        }
        while(j<length2){
            arrs[index]=nums2[j];
            index++;
            j++;
        }
        return arrs;


    }
}
