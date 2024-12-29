package bo;

import graph.Graph;
import entity.User;
import graph.Node;

import java.util.Map;

public class UserBO {
    private Graph graph;

    public UserBO(Graph graph) {
        this.graph = graph;
    }

    public void addUser(String id, String name) {
        if (graph.getAllNodes().containsKey(id)) {
            System.out.println("User ID already exists!");
            return;
        }
        graph.addUser(new User(id, name));
        System.out.println("User added successfully: " + name);
    }

    public Map<String, Node> getAllUsers() {
        return graph.getAllNodes();
    }
}
