package 学生出勤记录I;

import java.util.HashMap;

public class CheckRecordSolution {
    public static void main(String[] args) {
        CheckRecordSolution solution = new CheckRecordSolution();
        System.out.println(solution.checkRecord("PPALLP"));
        System.out.println(solution.checkRecord("PPALLL"));
    }

    public boolean checkRecord(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] array = s.toCharArray();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 'L') {
                int j = i + 1;
                int count = 1;
                while (j < array.length && array[j] == 'L') {
                    j++;
                    count++;
                }
                if (count >= 3) {
                    return false;
                }
            }
            if (map.containsKey(array[i])) {
                map.put(array[i], map.get(array[i]) + 1);
            } else {
                map.put(array[i], 1);
            }
        }
        if (!map.containsKey('A') || map.get('A') < 2) {
            return true;
        }
        return false;
    }

    //更优化
    public boolean checkRecordV2(String s) {
        int absents = 0, lates = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == 'A') {
                absents++;
                if (absents >= 2) {
                    return false;
                }
            }
            if (c == 'L') {
                lates++;
                if (lates >= 3) {
                    return false;
                }
            } else {
                lates = 0;
            }
        }
        return true;
    }

}
