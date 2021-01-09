package Day42.数组中的第K个最大元素;

import java.util.Random;

public class FindKthLargestSolution {

    private Random random = new Random();

    public int findKthLargest(int[] nums, int k) {
        int target = nums.length-k;//目标元素的下标
        int i = quickSelect(nums, 0, nums.length - 1, target);
        return i;
    }

    public int quickSelect(int[] nums , int left,int right,int index){
        int q = randomPartition(nums, left, right);
        if (q==index){
            return nums[q];
        }else {
            return q<index?quickSelect(nums,q+1,right,index):quickSelect(nums,left,q-1,index);
        }

    }

    public int randomPartition(int[] nums,int left,int right){
        // [0,right-left+1)->[left,right]
        int randomIndex = random.nextInt(right - left + 1) + left;//随机数的下标
        //  交换nums[randomIndex]， nums[right], 也就是将随机数先放在[left,right]最右边nums[right]上
        swap(nums,randomIndex,right);
        return partition(nums,left,right);
    }

    public int partition(int[] nums,int left ,int right){
        int x = nums[right];
        int i = left-1;
        for (int j = left; j < right; j++) {
            if (nums[j]<=x){
                swap(nums,++i,j);
            }
        }

        swap(nums,i+1,right);
        return i+1;
    }

    public void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
