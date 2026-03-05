import java.util.*;

class TokenBucket{
    int tokens;
    int max;
    long last;
    int rate;

    TokenBucket(int max,int rate){
        this.max=max;
        this.rate=rate;
        this.tokens=max;
        this.last=System.currentTimeMillis();
    }

    boolean allow(){
        long now=System.currentTimeMillis();
        long diff=(now-last)/1000;
        if(diff>0){
            tokens=Math.min(max,tokens+(int)(diff*rate));
            last=now;
        }
        if(tokens>0){
            tokens--;
            return true;
        }
        return false;
    }
}

public class Week01and02 {

    static HashMap<String,TokenBucket> map=new HashMap<>();

    static String checkRateLimit(String client){
        map.putIfAbsent(client,new TokenBucket(1000,1));
        TokenBucket t=map.get(client);
        if(t.allow()) return "Allowed "+t.tokens+" remaining";
        return "Denied";
    }

    public static void main(String[] args){
        System.out.println(checkRateLimit("abc123"));
        System.out.println(checkRateLimit("abc123"));
    }
}