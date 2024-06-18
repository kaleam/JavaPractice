package GoogleInterview;

import java.util.*;

public class GroupAnagrams {
    private List<List<String>> groupAnagrams(String[] str){
        Map<String, List<String>> map = new HashMap<>();
        for(String s : str){
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sortedStr = new String(chars);
            List<String> list = new ArrayList<>();
            if(map.containsKey(sortedStr))
                list = map.get(sortedStr);
            list.add(s);
            map.put(sortedStr, list);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        GroupAnagrams g = new GroupAnagrams();
        String[] str = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(g.groupAnagrams(str));
    }
}
