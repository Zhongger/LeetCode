package Day17.同一平面内两圆是否碰撞;

public class CollisWithSolution {
    public static void main(String[] args) {
        CollisWithSolution solution = new CollisWithSolution();
        System.out.println(solution.collisWith(1, 2, 3, 4, 5, 6));
    }
    public boolean collisWith (int x1, int y1, int r1, int x2, int y2, int r2) {
        return Math.sqrt(Math.pow(Math.abs(x1-x2),2)+Math.pow(Math.abs(y1-y2),2))<=(r1+r2);
    }
}
