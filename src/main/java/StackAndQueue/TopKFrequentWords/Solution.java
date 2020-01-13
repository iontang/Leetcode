package StackAndQueue.TopKFrequentWords;

import java.util.*;

public class Solution {

    public static void main(String[] args) {

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        priorityQueue.add(3);
        priorityQueue.add(2);

        priorityQueue.add(8);


        String[] words = {"i", "love","leetcode", "i", "love", "coding", "h", "h", "ab", "ab"};
        Solution solution = new Solution();
        solution.topKFrequent(words,3);
        String s1 = new String("h");
        String s2 = new String("love");
        System.out.println(s1.compareTo(s2));
//        if (s1 == (s2)) {
//            System.out.println("yes");
//        } else {
//            System.out.println("No");
//        }
    }

    // We can solve this problem by hash。
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> count = new HashMap();
        for (String word : words) {
            count.put(word, count.getOrDefault(word, 0) +1);
        }

        // maintain a min heap.
        PriorityQueue<String> priorityQueue = new PriorityQueue<>((w1, w2) -> count.get(w1).equals(count.get(w2)) ?
                w2.compareTo(w1) : count.get(w1) - count.get(w2)); // 如果单词数相同，维护最大堆，否则，按照单词个数比较维护最小堆。


        for (String word: count.keySet()) {
            priorityQueue.offer(word);
            if (priorityQueue.size() > k) priorityQueue.poll();
        }

        List<String> list = new ArrayList<String>();
        while (!priorityQueue.isEmpty()) list.add(priorityQueue.poll());
        Collections.reverse(list);
        return list;
    }

}
