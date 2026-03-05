import java.util.*;

public class Week01and02 {

    // username -> userId
    static HashMap<String, Integer> users = new HashMap<>();


    static HashMap<String, Integer> attempts = new HashMap<>();


    public static boolean checkAvailability(String username) {

        // increase attempt count
        attempts.put(username, attempts.getOrDefault(username, 0) + 1);

        return !users.containsKey(username);
    }

    git add .
    public static List<String> suggestAlternatives(String username) {

        List<String> suggestions = new ArrayList<>();

        suggestions.add(username + "1");
        suggestions.add(username + "2");

        if (username.contains("_")) {
            suggestions.add(username.replace("_", "."));
        }

        return suggestions;
    }

    // Get most attempted username
    public static String getMostAttempted() {

        String maxUser = "";
        int maxCount = 0;

        for (String user : attempts.keySet()) {
            if (attempts.get(user) > maxCount) {
                maxCount = attempts.get(user);
                maxUser = user;
            }
        }

        return maxUser + " (" + maxCount + " attempts)";
    }

    public static void main(String[] args) {

        // existing users
        users.put("john_doe", 101);
        users.put("admin", 102);
        users.put("guest", 103);

        System.out.println("john_doe → " + checkAvailability("john_doe"));
        System.out.println("jane_smith → " + checkAvailability("jane_smith"));

        System.out.println("\nSuggestions for john_doe:");
        System.out.println(suggestAlternatives("john_doe"));

        // simulate attempts
        checkAvailability("admin");
        checkAvailability("admin");
        checkAvailability("admin");

        System.out.println("\nMost Attempted Username:");
        System.out.println(getMostAttempted());
    }
}