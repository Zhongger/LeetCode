package Day45.接雨水;

public class TrapSolution {
    public int trap(int[] height) {
        int res = 0;
        int size = height.length;
        for (int i = 1; i < size - 1; i++) {
            int max_left = 0;
            int max_right = 0;
            for (int j = i; j >=0 ; j--) {
                max_left=Math.max(max_left,height[j]);
            }
            for (int j = i; j <size ; j++) {
                max_right=Math.max(max_right,height[j]);
            }
            res+=Math.max(max_left,max_right)-height[i];
        }
        return res;
    }

    public int trap2(int[] height) {
        if (height == null || height.length == 0)
            return 0;
        int ans = 0;
        int size = height.length;
        int[] left_max = new int[size];
        int[] right_max = new int[size];
        left_max[0]=height[0];
        for (int i = 1; i < size; i++) {
            left_max[i]=Math.max(left_max[i-1],height[i]);
        }
        right_max[size-1]=height[size-1];
        for (int i = size-2; i >= 0 ; i++) {
            right_max[i]=Math.max(right_max[i+1],height[i]);
        }
        for (int i = 1; i < size-1; i++) {
            ans+=Math.min(left_max[i],right_max[i])-height[i];
        }
        return ans;

    }
}
