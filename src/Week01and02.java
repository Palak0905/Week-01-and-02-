import java.util.*;

class DNSEntry{
    String ip;
    long expiry;
    DNSEntry(String ip,long ttl){
        this.ip=ip;
        this.expiry=System.currentTimeMillis()+ttl;
    }
}

public class Week01and02 {

    static HashMap<String,DNSEntry> cache=new HashMap<>();
    static int hits=0;
    static int miss=0;

    static String resolve(String domain){
        DNSEntry e=cache.get(domain);
        long now=System.currentTimeMillis();
        if(e!=null && e.expiry>now){
            hits++;
            return "Cache HIT "+e.ip;
        }
        miss++;
        String ip="172.217."+new Random().nextInt(200)+"."+new Random().nextInt(200);
        cache.put(domain,new DNSEntry(ip,300000));
        return "Cache MISS "+ip;
    }

    static void stats(){
        int total=hits+miss;
        double rate=(total==0)?0:(hits*100.0/total);
        System.out.println("Hit Rate "+rate+"%");
    }

    public static void main(String[] args){
        System.out.println(resolve("google.com"));
        System.out.println(resolve("google.com"));
        stats();
    }
}