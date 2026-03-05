import java.util.*;

class Transaction{
    int id;
    int amount;
    String merchant;
    String time;
    Transaction(int id,int amount,String merchant,String time){
        this.id=id;
        this.amount=amount;
        this.merchant=merchant;
        this.time=time;
    }
}

public class Week01and02 {

    static List<Transaction> list=new ArrayList<>();

    static void add(Transaction t){
        list.add(t);
    }

    static void twoSum(int target){
        HashMap<Integer,Transaction> map=new HashMap<>();
        for(Transaction t:list){
            int c=target-t.amount;
            if(map.containsKey(c)){
                System.out.println(map.get(c).id+" "+t.id);
            }
            map.put(t.amount,t);
        }
    }

    public static void main(String[] args){
        add(new Transaction(1,500,"StoreA","10:00"));
        add(new Transaction(2,300,"StoreB","10:15"));
        add(new Transaction(3,200,"StoreC","10:30"));
        twoSum(500);
    }
}