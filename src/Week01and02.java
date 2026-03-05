import java.util.*;

class LRU<K,V> extends LinkedHashMap<K,V>{
    int cap;
    LRU(int cap){
        super(cap,0.75f,true);
        this.cap=cap;
    }
    protected boolean removeEldestEntry(Map.Entry<K,V> e){
        return size()>cap;
    }
}

public class Week01and02 {

    static LRU<String,String> L1=new LRU<>(10000);
    static HashMap<String,String> L2=new HashMap<>();
    static HashMap<String,String> L3=new HashMap<>();

    static String getVideo(String id){
        if(L1.containsKey(id)){
            return "L1 HIT";
        }
        if(L2.containsKey(id)){
            L1.put(id,L2.get(id));
            return "L2 HIT";
        }
        if(L3.containsKey(id)){
            L2.put(id,L3.get(id));
            return "L3 HIT";
        }
        return "NOT FOUND";
    }

    public static void main(String[] args){
        L3.put("video_123","data");
        System.out.println(getVideo("video_123"));
        System.out.println(getVideo("video_123"));
    }
}