package problems_by_year.year_2020.month_08.problems_0817.Search_Suggestions_System;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

/**
 * ClassName BinarySolution
 *
 * @version 1.0
 * @Author: ion
 * @Date: 2020/8/20 8:28 上午
 */
public class BinarySolution {

    public static void main(String[] args) {
        String[] products = new String[]{"mobile", "mouse", "moneypot", "monitor", "mousepad"};
        String searchWord = "mouse";
        BinarySolution binarySolution = new BinarySolution();
        binarySolution.suggestedProducts_A1(products, searchWord);

    }

    /**
     * approach 1: sort then binary search
     * 1. sort input array
     * 2. use binary search to find first index
     * 3. check the following 3 words
     * time: O(nlogn) ---> python timsort
     * space: O(n) ---> might need to scan the entire input array
     *
     * @param products
     * @param searchWord
     * @return
     */
    public List<List<String>> suggestedProducts_A1(String[] products, String searchWord) {
        List<List<String>> res= new ArrayList<>();
        int low=0;
        int high= products.length-1;
        int min=0;
        // Sorting in lexically increasing order
        Arrays.sort(products);
        for(int i=0; i<searchWord.length(); i++) {
            // Checking from the low side
            while ((low <= high) && (products[low].length() <= i || products[low].charAt(i) != searchWord.charAt(i))) {
                // if the character does not match, we do not need to search that word
                low++;
            }

            // Checking from the end side
            while((low <= high ) && (products[high].length() <= i || products[high].charAt(i) != searchWord.charAt(i))) {
                // if the character does not match, we do not need to search that word
                high--;
            }

            // After this is done, we will have our search from low+3 (as we can choose only 3 words maximum)
            // And it can only go upto high+1 maximum
            min= Math.min(low+3, high+1);

            // Adding to the results now
            List<String> temp= new ArrayList<String>();
            for(int j= low; j<min; j++) {
                temp.add(products[j]);
            }
            res.add(temp);
        }
        return res;
    }


    public List<List<String>> suggestedProducts_A2(String[] products, String searchWord) {
        List<List<String>> res = new ArrayList<>();
        TreeMap<String, Integer> map = new TreeMap<>();
        Arrays.sort(products);
        List<String> productsList = Arrays.asList(products);

        for (int i = 0; i < products.length; i++) {
            map.put(products[i], i);
        }

        String key = "";
        for (char c : searchWord.toCharArray()) {
            key += c;
            String ceiling = map.ceilingKey(key);
            String floor = map.floorKey(key + "~");
            if (ceiling == null || floor == null) {
                break;
            }
            res.add(productsList.subList(map.get(ceiling), Math.min(map.get(ceiling) + 3, map.get(floor) + 1)));
        }

        while (res.size() < searchWord.length()) {
            res.add(new ArrayList<>());
        }
        return res;
    }

}
