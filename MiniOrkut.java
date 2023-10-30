import java.util.*;

public class MiniOrkut {

    // Creating HashMap to store User's friends and other user's information.
    public static HashMap<String, ArrayList<String>> friendList = new HashMap<>();
    public static HashMap<String, String> userInformation = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nWelcome to Mini Orkut!");
            System.out.println("1. Sign Up");
            System.out.println("2. Log In");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    signUp(sc);
                    break;
                case 2:
                    String username = logIn(sc);
                    if (username != null) {
                        loggedInUser(username, sc);
                    }
                    break;
                case 3:
                    System.out.println("Exiting the program...");
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void signUp(Scanner sc) {
        System.out.print("Enter your name: ");
        String name = sc.next();
        System.out.print("Enter your username: ");
        String username = sc.next();

        // Adding the new user to the userInformation HashMap.
        userInformation.put(username, name);
        friendList.put(username, new ArrayList<>());

        System.out.println("Sign Up successful! Please Log In.");
    }

    public static String logIn(Scanner sc) {
        System.out.print("Enter your username: ");
        String username = sc.next();

        if (userInformation.containsKey(username)) {
            return username;
        } else {
            System.out.println("Invalid username. Please try again.");
            return null;
        }
    }

    public static void loggedInUser(String username, Scanner sc) {
        while (true) {
            System.out.println("\nWelcome " + username + "!");
            System.out.println("1. View My Profile");
            System.out.println("2. View Friends' Profiles");
            System.out.println("3. Add Friends");
            System.out.println("4. Log Out");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    viewMyProfile(username);
                    break;
                case 2:
                    viewFriendsProfiles(username);
                    break;
                case 3:
                    addFriends(username, sc);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void viewMyProfile(String username) {
        System.out.println("\nMy Profile:");
        System.out.println("Name: " + userInformation.get(username));
        System.out.println("Username: " + username);
    }

    public static void viewFriendsProfiles(String username) {
        ArrayList<String> friends = friendList.get(username);

        if (friends.isEmpty()) {
            System.out.println("\nYour friend list is empty.");
        } else {
            System.out.println("\nYour Friends' Profiles:");
            for (String friend : friends) {
                System.out.println("Name: " + userInformation.get(friend));
                System.out.println("Username: " + friend);
                System.out.println();
            }
        }
    }

    public static void addFriends(String username, Scanner sc) {
        System.out.print("Enter your friend's username: ");
        String friendUsername = sc.next();

        if (userInformation.containsKey(friendUsername)) {
            if (!friendList.get(username).contains(friendUsername)) {
                friendList.get(username).add(friendUsername);
                System.out.println("Friend added successfully.");
            } else {
                System.out.println("You are already friends with this user.");
            }
        } else {
            System.out.println("Invalid username. Please try again.");
        }
    }
}
