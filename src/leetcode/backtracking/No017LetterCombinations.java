package leetcode.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: chengzeshan
 * @date: 2019-06-10 23:39
 */
//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
//
//给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
public class No017LetterCombinations {
    private Map<String,String> letterMap = new HashMap<>();
    public No017LetterCombinations(){
        letterMap.put("2","abc");
        letterMap.put("3","def");
        letterMap.put("4","ghi");
        letterMap.put("5","jkl");
        letterMap.put("6","mno");
        letterMap.put("7","pqrs");
        letterMap.put("8","tuv");
        letterMap.put("9","wxyz");
    }

    private List<String> resultList = new ArrayList<>();
    private void recursiveStr(String combinStr,String remainderDigits){

        System.out.println(remainderDigits.length());
        if (remainderDigits.length() == 0){
            this.resultList.add(combinStr);
            System.out.println("resultList:"+resultList);
        }else {
            System.out.println("length(1)"+remainderDigits.length());
            String singelStr = remainderDigits.substring(0,1);
            System.out.println(remainderDigits);
            System.out.println("length(2)"+remainderDigits.length());
            String letter = letterMap.get(singelStr);
            for (int i = 0 ; i < letter.length(); i ++){
                String nextLetter = letter.substring(i,i+1);
                System.out.println("remainderDigits:"+remainderDigits);
                System.out.println("nextLetter:"+nextLetter);
                System.out.println("length(3)"+remainderDigits.length());
                //todo:为什么放到外头不行
//                remainderDigits = remainderDigits.substring(1);
                recursiveStr(combinStr+nextLetter,remainderDigits.substring(1));
            }
        }

    }
    // public List<String> letterCombinations(String digits) {
    //     if ("".equals(digits)){
    //         return resultList;
    //     }
    //     this.recursiveStr("",digits);
    //     return resultList;
    // }

    //回溯

    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<String>();
        if (digits.length() == 0) {
            return combinations;
        }
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        backtrack(combinations, phoneMap, digits, 0, new StringBuffer());
        return combinations;
    }

    public void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuffer combination) {
        if (index == digits.length()) {
            combinations.add(combination.toString());
        } else {
            char digit = digits.charAt(index);
            String letters = phoneMap.get(digit);
            int lettersCount = letters.length();
            for (int i = 0; i < lettersCount; i++) {
                combination.append(letters.charAt(i));
                backtrack(combinations, phoneMap, digits, index + 1, combination);
                combination.deleteCharAt(index);
            }
        }
    }


}
