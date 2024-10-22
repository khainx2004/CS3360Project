package PMG;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Employee {
    private String name;
    private Map<Department, Role> roleMap = new HashMap<>();
    private Map<Department, Set<String>> departmentPermissions = new HashMap<>();
    public Employee(String name) {
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public Map<Department,Role> getRoleMap(){
        return this.roleMap;
    }
    public void setRoleMap(Map<Department, Role> roleMap) {
        this.roleMap = roleMap;
    }

    public Map<Department, Set<String>> getDepartmentPermissions() {
        return departmentPermissions;
    }

    public void setDepartmentPermissions(Map<Department, Set<String>> departmentPermissions) {
        this.departmentPermissions = departmentPermissions;
    }

    public void assignRole(Department department, Role role){
        roleMap.put(department,role);
        departmentPermissions.put(department,new HashSet<>());

        departmentPermissions.get(department).addAll(role.getPermissions());
    }

    public boolean hasPermission(Department department, String permissions) {
        return departmentPermissions.getOrDefault(department, new HashSet<>()).contains(permissions);
    }

    public void updatePermission(Department department, String permissions) {
        if (departmentPermissions.containsKey(department)){
            departmentPermissions.get(department).add(permissions);
        }
    }
}
