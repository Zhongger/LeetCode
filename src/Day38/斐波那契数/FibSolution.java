package Day38.斐波那契数;

public class FibSolution {
    public int fib(int n) {
        if (n<1){
            return 0;
        }
        if (n==1||n==2){
            return 1;
        }
        int prev = 1;
        int cur = 1;
        for (int i = 3; i <= n; i++) {
            int sum = prev+cur;
            prev=cur;
            cur=sum;
        }
        return cur;
    }
}
