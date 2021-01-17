package Day49.合并两个有序的数组;

public class MergeSolution {
    public void merge(int A[], int m, int B[], int n) {
        int i = m - 1;
        int j = n - 1;
        int index = m + n - 1;//AB合并后最后一个元素所在位置
        while(i >= 0 && j >= 0)//AB合并，谁大就先放谁
            A[index --] = A[i] > B[j] ? A[i --] : B[j --];
        while(j >= 0)//如果B没有遍历完，那么之间丢在A数组里面
            A[index --] = B[j --];
    }
}
