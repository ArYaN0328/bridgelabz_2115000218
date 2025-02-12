
import java.util.*;

class User {
    int userId;
    String name;
    int age;
    List<Integer> friendIds; // List to store friend connections

    public User(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friendIds = new ArrayList<>();
    }

    public void addFriend(int friendId) {
        if (!friendIds.contains(friendId)) {
            friendIds.add(friendId);
        }
    }

    public void removeFriend(int friendId) {
        friendIds.remove(Integer.valueOf(friendId));
    }

    public boolean isFriend(int friendId) {
        return friendIds.contains(friendId);
    }

    public List<Integer> getFriendIds() {
        return friendIds;
    }

    public void displayFriends() {
        System.out.println("Friends of " + name + " (ID: " + userId + "): " + friendIds);
    }
}

class UserNode {
    User user;
    UserNode next;

    public UserNode(User user) {
        this.user = user;
        this.next = null;
    }
}

class SocialMedia {
    private UserNode head;

    public void addUser(int userId, String name, int age) {
        User newUser = new User(userId, name, age);
        UserNode newNode = new UserNode(newUser);
        if (head == null) {
            head = newNode;
        } else {
            UserNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public User findUserById(int userId) {
        UserNode temp = head;
        while (temp != null) {
            if (temp.user.userId == userId) {
                return temp.user;
            }
            temp = temp.next;
        }
        return null;
    }

    public User findUserByName(String name) {
        UserNode temp = head;
        while (temp != null) {
            if (temp.user.name.equalsIgnoreCase(name)) {
                return temp.user;
            }
            temp = temp.next;
        }
        return null;
    }

    public void addFriendConnection(int userId1, int userId2) {
        User user1 = findUserById(userId1);
        User user2 = findUserById(userId2);
        if (user1 != null && user2 != null) {
            user1.addFriend(userId2);
            user2.addFriend(userId1);
        }
    }

    public void removeFriendConnection(int userId1, int userId2) {
        User user1 = findUserById(userId1);
        User user2 = findUserById(userId2);
        if (user1 != null && user2 != null) {
            user1.removeFriend(userId2);
            user2.removeFriend(userId1);
        }
    }

    public List<Integer> findMutualFriends(int userId1, int userId2) {
        User user1 = findUserById(userId1);
        User user2 = findUserById(userId2);
        List<Integer> mutualFriends = new ArrayList<>();
        if (user1 != null && user2 != null) {
            for (int friendId : user1.getFriendIds()) {
                if (user2.isFriend(friendId)) {
                    mutualFriends.add(friendId);
                }
            }
        }
        return mutualFriends;
    }

    public void displayAllFriends(int userId) {
        User user = findUserById(userId);
        if (user != null) {
            user.displayFriends();
        } else {
            System.out.println("User not found.");
        }
    }

    public void searchUser(String query) {
        try {
            int id = Integer.parseInt(query);
            User user = findUserById(id);
            if (user != null) {
                System.out.println("User found: " + user.name + " (ID: " + user.userId + ", Age: " + user.age + ")");
            } else {
                System.out.println("User not found.");
            }
        } catch (NumberFormatException e) {
            User user = findUserByName(query);
            if (user != null) {
                System.out.println("User found: " + user.name + " (ID: " + user.userId + ", Age: " + user.age + ")");
            } else {
                System.out.println("User not found.");
            }
        }
    }

    public void countFriends(int userId) {
        User user = findUserById(userId);
        if (user != null) {
            System.out.println(user.name + " has " + user.getFriendIds().size() + " friends.");
        } else {
            System.out.println("User not found.");
        }
    }
}

public class SocialMediaApp {
    public static void main(String[] args) {
        SocialMedia sm = new SocialMedia();

        // Adding users
        sm.addUser(1, "Alice", 25);
        sm.addUser(2, "Bob", 28);
        sm.addUser(3, "Charlie", 22);
        sm.addUser(4, "David", 30);
        sm.addUser(5, "Eve", 27);

        // Adding friend connections
        sm.addFriendConnection(1, 2);
        sm.addFriendConnection(1, 3);
        sm.addFriendConnection(2, 4);
        sm.addFriendConnection(3, 5);
        sm.addFriendConnection(4, 5);

        // Display friends of a user
        sm.displayAllFriends(1);
        sm.displayAllFriends(2);
        sm.displayAllFriends(3);

        // Find mutual friends
        System.out.println("Mutual friends between Alice and Bob: " + sm.findMutualFriends(1, 2));
        System.out.println("Mutual friends between Charlie and David: " + sm.findMutualFriends(3, 4));

        // Remove a friend connection
        sm.removeFriendConnection(1, 2);
        sm.displayAllFriends(1);
        sm.displayAllFriends(2);

        // Search for users
        sm.searchUser("Alice");
        sm.searchUser("3");

        // Count number of friends
        sm.countFriends(1);
        sm.countFriends(2);
    }
}

