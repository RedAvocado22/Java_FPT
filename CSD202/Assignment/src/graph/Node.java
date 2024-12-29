package graph;

import entity.User;
import java.util.HashSet;
import java.util.Set;

public class Node {

    private User user;
    private Set<Node> connections;

    public Node(User user) {
        this.user = user;
        this.connections = new HashSet<>();
    }

    public User getUser() {
        return user;
    }

    public Set<Node> getConnections() {
        return connections;
    }

    public void addConnection(Node node) {
        if (node != null && node != this) {
            connections.add(node);
            node.getConnections().add(this);
        }
    }

    @Override
    public String toString() {
        return user.getName();
    }
}
