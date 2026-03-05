import java.util.*;

public class Week01and02 {

    static HashMap<String,Integer> pageViews=new HashMap<>();
    static HashMap<String,Set<String>> uniqueUsers=new HashMap<>();
    static HashMap<String,Integer> sources=new HashMap<>();

    static void processEvent(String url,String user,String source){
        pageViews.put(url,pageViews.getOrDefault(url,0)+1);

        uniqueUsers.putIfAbsent(url,new HashSet<>());
        uniqueUsers.get(url).add(user);

        sources.put(source,sources.getOrDefault(source,0)+1);
    }

    static void dashboard(){
        PriorityQueue<Map.Entry<String,Integer>> pq=
                new PriorityQueue<>((a,b)->b.getValue()-a.getValue());

        pq.addAll(pageViews.entrySet());

        int i=0;
        while(!pq.isEmpty() && i<10){
            Map.Entry<String,Integer> e=pq.poll();
            int u=uniqueUsers.get(e.getKey()).size();
            System.out.println(e.getKey()+" "+e.getValue()+" views "+u+" unique");
            i++;
        }

        for(String s:sources.keySet()){
            System.out.println(s+" "+sources.get(s));
        }
    }

    public static void main(String[] args){
        processEvent("/article/breaking-news","user1","google");
        processEvent("/article/breaking-news","user2","facebook");
        processEvent("/sports/championship","user3","direct");
        dashboard();
    }
}