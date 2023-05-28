package leetcode.tree;

/**
 * 720. 词典中最长的单词
 *
 * 给出一个字符串数组 words 组成的一本英语词典。返回 words 中最长的一个单词，该单词是由 words 词典中其他单词逐步添加一个字母组成。
 *
 * 若其中有多个可行的答案，则返回答案中字典序最小的单词。若无答案，则返回空字符串。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：words = ["w","wo","wor","worl", "world"]
 * 输出："world"
 * 解释： 单词"world"可由"w", "wo", "wor", 和 "worl"逐步添加一个字母组成。
 *
 * @author chengzeshan
 * @version 1.0, 2022/03/16
 * @since practice 1.0.0
 */
public class No720LongestWord {
    public String longestWord(String[] words) {
        String ans = "";
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        int max = 0;
        for(String word : words){
            if(word.length() >= max && trie.search(word)){
                if(word.length() == max){
                    if(ans.compareTo(word) > 0) ans = word;
                } else {
                    ans =word;
                    max = word.length();
                }
            }
        }
        return ans;
    }

    class Trie {

        private Trie[] children;
        private boolean isEnd;

        /** Initialize your data structure here. */
        public Trie() {
            children = new Trie[26];
            isEnd = false;
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            Trie node = this;
            for (int i = 0 ; i < word.length() ; i++){
                char ch = word.charAt(i);
                int index = ch - 'a';
                if (node.children[index] == null){
                    node.children[index] = new Trie();
                }
                node = node.children[index];
            }
            node.isEnd = true;

        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            Trie node= searchPrefix(word);
            return node != null && node.isEnd;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {

            return searchPrefix(prefix) != null;
        }


        private Trie searchPrefix(String prefix) {
            Trie node = this;
            for (int i = 0; i < prefix.length(); i++) {
                char ch = prefix.charAt(i);
                int index = ch - 'a';
                if (node.children[index] == null) {
                    return null;
                }
                node = node.children[index];
                if (!node.isEnd){
                    return null;
                }
            }
            return node;
        }


    }


}
