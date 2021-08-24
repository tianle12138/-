package problem_6XX;

import java.util.*;
import java.util.stream.Collectors;

// 692. 前K个高频单词
public class _692 {
    List<String> res = new ArrayList<>();

    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<String > maxHeap = new PriorityQueue<>((o1, o2) -> {
            Integer i1 = map.get(o1);
            Integer i2 = map.get(o2);
            if(i1.equals(i2)){
               return o1.compareTo(o2);
            }else {
               return i2 - i1;
            }
        });

        for (String s : map.keySet()) {
            maxHeap.add(s);
        }
        for (int i = 0; i < k && maxHeap.size()>0; i++) {
            res.add(maxHeap.poll());
        }
        return res;

    }

    // public List<String> topKFrequent(String[] words, int k) {
    //     HashMap<String, Integer> map = new HashMap<>();
    //     for (String word : words) {
    //         map.put(word, map.getOrDefault(word,0) + 1);
    //     }
    //     Set<Map.Entry<String, Integer>> entries = map.entrySet();
    //     List<Map.Entry<String,Integer>> list = new ArrayList<>(entries);
    //     Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
    //         @Override
    //         public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
    //             if(o1.getValue().equals(o2.getValue())){
    //                 return o1.getKey().compareTo(o2.getKey());
    //             }else{
    //                 return o2.getValue() - o1.getValue();
    //             }
    //         }
    //     });
    //     for (Map.Entry<String, Integer> es : list.subList(0, k)) {
    //         res.add(es.getKey());
    //     }
    //     return res;
    // }
}
