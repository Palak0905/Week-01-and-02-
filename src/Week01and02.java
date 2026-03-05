import java.util.*;

public class Week01and02 {

    static HashMap<String,Set<String>> map=new HashMap<>();

    static List<String> ngrams(String text,int n){
        String[] w=text.split(" ");
        List<String> list=new ArrayList<>();
        for(int i=0;i<=w.length-n;i++){
            String g="";
            for(int j=0;j<n;j++) g+=w[i+j]+" ";
            list.add(g.trim());
        }
        return list;
    }

    static void addDoc(String id,String text){
        for(String g:ngrams(text,3)){
            map.putIfAbsent(g,new HashSet<>());
            map.get(g).add(id);
        }
    }

    static void check(String text){
        Map<String,Integer> score=new HashMap<>();
        for(String g:ngrams(text,3)){
            if(map.containsKey(g)){
                for(String d:map.get(g)){
                    score.put(d,score.getOrDefault(d,0)+1);
                }
            }
        }
        for(String k:score.keySet()){
            System.out.println(k+" "+score.get(k));
        }
    }

    public static void main(String[] args){
        addDoc("essay1","data science is very interesting and useful");
        addDoc("essay2","machine learning and data science are related");
        check("data science is useful");
    }
}