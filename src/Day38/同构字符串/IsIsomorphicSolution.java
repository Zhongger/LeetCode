package Day38.同构字符串;

import java.util.HashMap;

public class IsIsomorphicSolution {

    public static void main(String[] args) {
        IsIsomorphicSolution solution = new IsIsomorphicSolution();
        System.out.println(solution.isIsomorphic("foo", "bar"));
    }

    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> mapS = new HashMap<>();
        HashMap<Character, Character> mapT = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char x = s.charAt(i);
            char y = t.charAt(i);
            if (mapS.containsKey(x)&&mapS.get(x)!=y|| mapT.containsKey(y)&&mapT.get(y)!=x){
                return false;
            }
            mapS.put(x,y);
            mapT.put(y,x);
        }
        return true;
    }
}
