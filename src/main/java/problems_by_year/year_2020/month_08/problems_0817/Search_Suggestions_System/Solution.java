package problems_by_year.year_2020.month_08.problems_0817.Search_Suggestions_System;

import java.util.*;

/**
 * ClassName Solution
 *
 * @version 1.0
 * @Author: ion
 * @Date: 2020/8/17 8:23 上午
 */
public class Solution {

    /**
     * ["havana"]
     * "tatiana"
     * [[],[],[],[],[],[],[]]
     * 暴力破解法
     * @param products
     * @param searchWord
     * @return
     */
    public List<List<String>> suggestedProducts_R1(String[] products, String searchWord) {
        Map<Integer, TreeSet<String>> map = new TreeMap<>();
        for (int i = 0; i < searchWord.toCharArray().length; i++) {
            for (int j = 0; j < products.length; j++) {
                String prod = products[j];
                if (!map.containsKey(i)) {
                    map.put(i, new TreeSet<String>());
                }
                TreeSet<String> value = map.get(i);
                if (prod.startsWith(searchWord.substring(0, i+1))) {
                    value.add(prod);
                }
            }
        }
        List<List<String>> res = new ArrayList<>();
        for (Map.Entry<Integer, TreeSet<String>> entry : map.entrySet()) {
            List<String> subEle = new ArrayList<>();
            int len = entry.getValue().size();
            for (int i = 0; i < 3 && i < len; i++) {
                subEle.add(entry.getValue().pollFirst());
            }
            res.add(subEle);
        }
        return res;
    }

    public List<List<String>> suggestedProducts_A1(String[] products, String searchWord) {
        PriorityQueue<String> pq = new PriorityQueue<>(3, (s1,s2) -> s1.compareTo(s2));
        List<List<String>> list = new ArrayList<>();

        for(int i = 1; i<=searchWord.length(); i++){
            String temp = searchWord.substring(0, i);
            for(String s : products){
                if(s.startsWith(temp)){
                    pq.offer(s);
                }
            }
            List<String> temp_list = new ArrayList<>();
            for(int j = 0; j<3; j++){
                if(pq.peek() != null){
                    temp_list.add(pq.poll());
                }
            }
            pq.clear();
            list.add(temp_list);
        }
        return list;
    }


    /**
     * more simply code.
     * O(KN) where K is the length of searchWord and N is the length of the products
     * @param products
     * @param searchWord
     * @return
     */
    public List<List<String>> suggestedProducts_A2(String[] products, String searchWord) {
        List<List<String>> result = new ArrayList<>();
        PriorityQueue<String> heap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 1; i <= searchWord.length(); i++) {
            String t = searchWord.substring(0, i);
            for (String product: products) {
                if (product.startsWith(t)) {
                    heap.offer(product);
                }
                if (heap.size() > 3) {
                    heap.poll();
                }
            }

            LinkedList<String> temp = new LinkedList<>();
            while (!heap.isEmpty()) {
                temp.addFirst(heap.poll());
            }
            result.add(temp);
        }
        return result;
    }
}
