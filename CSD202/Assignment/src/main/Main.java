package main;

import bo.UserBO;
import bo.FriendshipBO;
import graph.Graph;
import mock.Data;
import util.Validate;
import graph.Node;
import entity.User;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();
        UserBO userBO = new UserBO(graph);
        FriendshipBO friendshipBO = new FriendshipBO(graph);

        loadData(userBO, friendshipBO);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add new user");
            System.out.println("2. Add friendship");
            System.out.println("3. Find mutual friends");
            System.out.println("4. Exit");

            int choice = Validate.getInt("Choose an option (1-4): ", "Invalid choice! Please select 1-4.", "Invalid input!", 1, 4);

            switch (choice) {
                case 1:
                    addNewUser(userBO);
                    break;
                case 2:
                    addFriendship(friendshipBO, userBO);
                    break;
                case 3:
                    findMutualFriends(friendshipBO, userBO);
                    break;
                case 4:
                    System.out.println("Exiting program...");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    private static void loadData(UserBO userBO, FriendshipBO friendshipBO) {
        for (User user : Data.users) {
            userBO.addUser(user.getId(), user.getName());
        }

        for (String[] pair : Data.friendships) {
            friendshipBO.addFriendship(pair[0], pair[1]);
        }
    }

    private static void addNewUser(UserBO userBO) {
        String userId;
        do {
            userId = Validate.getString("Enter new user ID (format: U[0-9]+): ", "Invalid ID format!", "U[0-9]+");
            if (userBO.getAllUsers().containsKey(userId)) {
                System.out.println("User ID already exists! Please enter a different ID.");
            } else {
                break;
            }
        } while (true);

        String userName = Validate.getString("Enter new user name: ", "Name cannot be empty!", ".+");
        userBO.addUser(userId, userName);
    }

    private static void addFriendship(FriendshipBO friendshipBO, UserBO userBO) {
        System.out.println("\nAvailable Users:");
        for (Node node : userBO.getAllUsers().values()) {
            System.out.println("- " + node.getUser().getId() + ": " + node.getUser().getName());
        }

        String userId1 = Validate.getString("Enter the ID of the first user: ", "Invalid ID format!", "U[0-9]+");
        String userId2 = Validate.getString("Enter the ID of the second user: ", "Invalid ID format!", "U[0-9]+");
        friendshipBO.addFriendship(userId1, userId2);
    }

    private static void findMutualFriends(FriendshipBO friendshipBO, UserBO userBO) {
        System.out.println("\nAvailable Users:");
        for (Node node : userBO.getAllUsers().values()) {
            System.out.println("- " + node.getUser().getId() + ": " + node.getUser().getName());
        }

        String userId1 = Validate.getString("Enter the ID of the first user: ", "Invalid ID format!", "U[0-9]+");
        String userId2 = Validate.getString("Enter the ID of the second user: ", "Invalid ID format!", "U[0-9]+");
        friendshipBO.findMutualFriends(userId1, userId2);
    }
}
