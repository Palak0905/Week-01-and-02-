import java.util.*;

public class Week01and02 {

    static HashMap<String,Integer> stock=new HashMap<>();
    static LinkedHashMap<Integer,String> waiting=new LinkedHashMap<>();
    static int position=1;

    static int checkStock(String p){
        return stock.getOrDefault(p,0);
    }

    static synchronized String purchaseItem(String p,int user){
        int s=stock.getOrDefault(p,0);
        if(s>0){
            stock.put(p,s-1);
            return "Success "+(s-1)+" units remaining";
        }else{
            waiting.put(position,user+"");
            return "Added to waiting list position "+position++;
        }
    }

    public static void main(String[] args){
        stock.put("IPHONE15_256GB",100);

        System.out.println(checkStock("IPHONE15_256GB"));
        System.out.println(purchaseItem("IPHONE15_256GB",12345));
        System.out.println(purchaseItem("IPHONE15_256GB",67890));
    }
}