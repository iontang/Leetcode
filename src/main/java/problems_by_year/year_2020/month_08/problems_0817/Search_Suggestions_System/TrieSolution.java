package problems_by_year.year_2020.month_08.problems_0817.Search_Suggestions_System;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName TrieSolution
 *
 * @version 1.0
 * @Author: ion
 * @Date: 2020/8/19 11:37 下午
 */
public class TrieSolution {

    class TrieNode {
        char currIndex;
        TrieNode[] childNodeList;
        boolean isEnd;

        public TrieNode(char c) {
            this.currIndex = c;
            this.childNodeList = new TrieNode[26];
            isEnd = false;
        }
    }

    /**
     * Trie树的解法：
     * 有可以参考的模版：
     * https://leetcode-cn.com/problems/search-suggestions-system/solution/zui-po-shi-yi-dong-tao-mo-ban-zi-dian-shu-jie-fa-s/
     * @param products
     * @param searchWord
     * @return
     */
    private int index;
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        TrieNode root = new TrieNode('/');
        // 构建树
        for (String prod : products) {
            this.createTrie(prod, root);
        }
        List<List<String>> res = new ArrayList<>();
        // 遍历树
        for (int i = 0; i < searchWord.length(); i++) {
            index = 0;
            List<String> subList = getLstBySubStr(root, searchWord.substring(0, i+1));
            res.add(subList);
        }
        return res;
    }

    /**
     * 在创建Trie的时候，传入的是product，不是products，否则构建出来的就不是Trie树
     */
    private void createTrie(String product, TrieNode root) {
        char[] prodArr = product.toCharArray();
        for (int i = 0; i < prodArr.length; i++) {
            char c = prodArr[i];
            if (root.childNodeList[c - 'a'] == null) {
                root.childNodeList[c - 'a'] = new TrieNode(c);
            }
            root = root.childNodeList[c - 'a'];
        }
        root.isEnd = true;
    }

    private List<String> getLstBySubStr(TrieNode root, String subStr) {
        List<String> subList = new ArrayList<>();
        // 首先，遍历当前字符串的字符，
        for (char c : subStr.toCharArray()) {
            if (root.childNodeList[c - 'a'] == null) {
                return subList;
            }
            root = root.childNodeList[c - 'a'];
        }
        // 前缀完全匹配后，首先检查单词是不是已经匹配完；
        if (root.isEnd == true) {
            subList.add(subStr);
            ++index;
        }
        for (TrieNode trieNode : root.childNodeList) {
            if (trieNode != null) {
                dfs(trieNode, subStr, subList);
            }
        }
        return subList;
    }

    private void dfs(TrieNode root, String sb, List<String> subList) {
        if (root == null || index == 3) {
            return;
        }
        sb = sb + root.currIndex;
        if (root.isEnd) {
            subList.add(sb);
            ++index;
        }
        for (TrieNode trieNode : root.childNodeList) {
            if (trieNode != null) {
                dfs(trieNode, sb, subList);
            }
        }
    }

    public static void main(String[] args) {
        String[] products = new String[]{"mobile", "mouse", "moneypot", "monitor", "mousepad"};
        String searchWord = "mouse";
        /**
         * 如果超过三个，则按字典顺序返回
         * [
         *      ["mobile","moneypot","monitor"],
         *      ["mobile","moneypot","monitor"],
         *      ["mouse","mousepad"],
         *      ["mouse","mousepad"],
         *      ["mouse","mousepad"]
         * ]
         */
        TrieSolution solution = new TrieSolution();
        solution.suggestedProducts(products, searchWord);
        System.out.println();
    }

}
