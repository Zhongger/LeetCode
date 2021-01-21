package Day51.部分排序;

import java.util.Arrays;

public class SubSortSolution {
    public static void main(String[] args) {
        SubSortSolution solution = new SubSortSolution();
        int[] array = {1,2,4,7,10,11,7,12,6,7,16,18,19};
        int[] arr = solution.subSort2(array);
        System.out.println(Arrays.toString(arr));
    }
    public int[] subSort(int[] array) {
        if(array == null || array.length == 0 || array.length == 1) return new int[]{-1,-1};
        int m = 0 , n = array.length - 1;
        //注意：数组中的数可能为负数
        int min = Integer.MAX_VALUE , max = Integer.MIN_VALUE;
        //max为乱序的最大值，min为乱序的最小值
        for(int i = 0 ; i < array.length ; i++){
            if(max <= array[i]){
                max = array[i];
            }else{
                //记录乱序数组小于最大值的最大索引
                m = i;
            }
        }
        for(int j = array.length - 1 ; j >= 0 ; j--){
            if(min >= array[j]){
                min = array[j];
            }else{
                //记录乱序数组大于最大值的最小索引
                n = j;
            }
        }
        return m > n ? new int[]{n,m} : new int[]{-1,-1};

    }

    public int[] subSort2(int[] array) {
        int[] clone = array.clone();
        Arrays.sort(clone);
        int left = -1;
        int right = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != clone[i]) {
                if (left == -1) {
                    left = i;
                }
                right = i;
            }
        }
        return new int[]{left, right};
    }
}
