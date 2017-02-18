package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by udingji on 2/6/17.
 */
public class LetterCombinations {

    public static List<String> letterCombinations(String digits) {

        if (digits == null || digits.trim().length() == 0){
            return new ArrayList<>();
        }
        Map<Character,String[]> map = new HashMap<>();
        map.put('2',new String[]{"a","b","c"});
        map.put('3',new String[]{"d","e","f"});
        map.put('4',new String[]{"g","h","i"});
        map.put('5',new String[]{"j","k","l"});
        map.put('6',new String[]{"m","n","o"});
        map.put('7',new String[]{"p","q","r","s"});
        map.put('8',new String[]{"t","u","v"});
        map.put('9',new String[]{"w","x","y","z"});

        char[] list = digits.toCharArray();

        List<String> result = recurLetterCombine(map,list,list.length-1);

        return result;
    }

    private static LinkedList<String> recurLetterCombine(Map<Character,String[]> map, char[] list, int index){
        if (index == 0){
            LinkedList<String > result = new LinkedList<>();
            char c = list[index];
            String[] letters = map.get(c);
            for (String l : letters){
                result.add(l);
            }
            return result;
        }
        LinkedList<String> temp = recurLetterCombine(map,list,index-1);
        char c = list[index];
        String[] letters = map.get(c);

        while (temp.peek().length() == index){
            String t = temp.poll();
            for (String l : letters){
                temp.add(t+l);
            }
        }

        return temp;
    }

    public static void main(String[] args) {
        String digits = "23";
        List<String> result = letterCombinations(digits);
        for (String s : result){
            System.out.print(s + ", ");
        }
    }
}
