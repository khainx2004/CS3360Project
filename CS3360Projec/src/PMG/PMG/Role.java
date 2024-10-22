package PMG;

import java.util.HashSet;
import java.util.Set;

public class Role {
    private String name;
    private Set<String> permissions = new HashSet<>();
    public Role(String name, Set<String> permissions) {
        this.name = name;
        this.permissions = permissions;
    }
    public Set<String> getPermissions() {
        return permissions;
    }
    public void setPermissions(Set<String> permissions) {
        this.permissions = permissions;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }



}
