package mock;

import entity.User;
import java.util.ArrayList;
import java.util.List;

public class Data {
    public static final List<User> users = new ArrayList() {{
        add(new User("U1", "Alice"));
        add(new User("U2", "Bob"));
        add(new User("U3", "Charlie"));
        add(new User("U4", "David"));
        add(new User("U5", "Eve"));
    }};

    public static final List<String[]> friendships = new ArrayList() {{
        add(new String[]{"U1", "U2"});
        add(new String[]{"U1", "U3"});
        add(new String[]{"U2", "U3"});
        add(new String[]{"U2", "U4"});
        add(new String[]{"U3", "U5"});
    }};
}
