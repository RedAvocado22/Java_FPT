package bo;

import graph.Graph;
import graph.Node;

import java.util.Set;

public class FriendshipBO {
    private Graph graph;

    public FriendshipBO(Graph graph) {
        this.graph = graph;
    }

    public void addFriendship(String userId1, String userId2) {
        if (!graph.getAllNodes().containsKey(userId1) || !graph.getAllNodes().containsKey(userId2)) {
            System.out.println("One or both user IDs do not exist.");
            return;
        }
        graph.connectUsers(userId1, userId2);
        System.out.println("Friendship added between " + graph.getAllNodes().get(userId1).getUser().getName() +
                " and " + graph.getAllNodes().get(userId2).getUser().getName());
    }

    public void findMutualFriends(String userId1, String userId2) {
        if (!graph.getAllNodes().containsKey(userId1) || !graph.getAllNodes().containsKey(userId2)) {
            System.out.println("One or both user IDs do not exist.");
            return;
        }

        Set<Node> mutualFriends = graph.findMutualConnectionsBFS(userId1, userId2);
        if (!mutualFriends.isEmpty()) {
            System.out.println("\nMutual friends between " + graph.getAllNodes().get(userId1).getUser().getName() +
                    " and " + graph.getAllNodes().get(userId2).getUser().getName() + ":");
            for (Node friend : mutualFriends) {
                if (!friend.getUser().getId().equals(userId1) && !friend.getUser().getId().equals(userId2)) {
                    System.out.println("- " + friend.getUser().getName());
                }
            }
        } else {
            System.out.println("\nNo mutual friends found.");
        }
    }
}
