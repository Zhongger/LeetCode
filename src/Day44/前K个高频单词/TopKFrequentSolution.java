package Day44.前K个高频单词;

import java.util.*;

public class TopKFrequentSolution {
    public static void main(String[] args) {
        TopKFrequentSolution solution = new TopKFrequentSolution();
        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        int k = 1;
        System.out.println("love".compareTo("i"));// 3
        System.out.println(solution.topKFrequent(words, k));
    }
    public List<String> topKFrequent(String[] words, int k) {
        List<String> resList = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
        }
        PriorityQueue<String> queue =
                new PriorityQueue<String>((w1, w2) -> map.get(w1).equals(map.get(w2)) ? w2.compareTo(w1) : map.get(w1) - map.get(w2));
        for (String word : words) {
            queue.offer(word);
            if (queue.size()>k){

                queue.poll();
            }
        }
        while (!queue.isEmpty()){
            resList.add(queue.poll());
        }
        Collections.reverse(resList);
        return resList;
    }
}
