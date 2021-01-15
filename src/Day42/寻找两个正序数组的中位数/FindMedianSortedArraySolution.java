package Day42.寻找两个正序数组的中位数;

import common.TreeNode;

public class FindMedianSortedArraySolution {
    public static void main(String[] args) {
        TreeNode node = new TreeNode();

    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int total = m+n;
        if (total%2==1){
            int midIndex=total/2;
            double median = getKthElement(nums1, nums2, midIndex + 1);
            return median;
        }else {
            int midIndex1=total/2-1;
            int midIndex2=total/2;
            double median1 = getKthElement(nums1, nums2, midIndex1 + 1);
            double median2 = getKthElement(nums1, nums2, midIndex2 + 1);
            double median = (median1+median2)/2.0;
            return median;
        }

    }

    public int getKthElement(int[] nums1, int[] nums2, int k){
        int m =nums1.length;
        int n = nums2.length;
        int index1 = 0;
        int index2= 0;

        while (true){
            if (index1==m){
                return nums2[index2+k-1];
            }
            if (index2==n){
                return nums1[index1+k-1];
            }
            if (k==1){
                return Math.min(nums1[index1],nums2[index2]);
            }
            int half = k/2;
            int newIndex1 = Math.min(index1+half,m)-1;
            int newIndex2 = Math.min(index2+half,n)-1;
            int pivot1 = nums1[newIndex1], pivot2 = nums2[newIndex2];
            if (pivot1 <= pivot2) {
                k -= (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;
            } else {
                k -= (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }


        }
    }
}
