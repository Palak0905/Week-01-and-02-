import java.util.*;

public class Week01and02 {

    static HashMap<String,Integer> freq=new HashMap<>();

    static void addQuery(String q){
        freq.put(q,freq.getOrDefault(q,0)+1);
    }

    static List<String> search(String prefix){
        PriorityQueue<Map.Entry<String,Integer>> pq=new PriorityQueue<>((a,b)->b.getValue()-a.getValue());
        for(String q:freq.keySet()){
            if(q.startsWith(prefix)) pq.add(Map.entry(q,freq.get(q)));
        }
        List<String> res=new ArrayList<>();
        int i=0;
        while(!pq.isEmpty() && i<10){
            res.add(pq.poll().getKey());
            i++;
        }
        return res;
    }

    public static void main(String[] args){
        addQuery("java tutorial");
        addQuery("javascript");
        addQuery("java download");
        addQuery("java tutorial");
        System.out.println(search("jav"));
    }
}