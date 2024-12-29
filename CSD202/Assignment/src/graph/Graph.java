package graph;

import entity.User;

import java.util.*;

public class Graph {
    private Map<String, Node> nodes;

    public Graph() {
        nodes = new HashMap<>();
    }

    public void addUser(User user) {
        if (!nodes.containsKey(user.getId())) {
            nodes.put(user.getId(), new Node(user));
        }
    }

    public void connectUsers(String userId1, String userId2) {
        Node node1 = nodes.get(userId1);
        Node node2 = nodes.get(userId2);

        if (node1 != null && node2 != null) {
            node1.addConnection(node2);
        }
    }

    public Set<Node> findMutualConnectionsBFS(String userId1, String userId2) {
        Node node1 = nodes.get(userId1);
        Node node2 = nodes.get(userId2);

        if (node1 == null || node2 == null) {
            System.out.println("One or both users do not exist.");
            return Collections.emptySet();
        }

        Set<Node> visited1 = bfs(node1);
        Set<Node> visited2 = bfs(node2);

        visited1.retainAll(visited2);
        return visited1;
    }

    private Set<Node> bfs(Node startNode) {
        Set<Node> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();

        queue.add(startNode);
        visited.add(startNode);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            for (Node neighbor : current.getConnections()) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }

        return visited;
    }

    public Map<String, Node> getAllNodes() {
        return nodes;
    }
}
