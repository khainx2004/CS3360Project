package PMG;

import java.util.HashMap;
import java.util.Map;

public class Department {
    private String name;
    private Map<Employee,Role> employeeRoleMap = new HashMap<>();
    private Map<String, Project> projectMap = new HashMap<>();

    public Department(String name) {
        this.name = name;
    }
    public String getName(){
        return this.name;
    }

    public Map<Employee, Role> getEmployeeRoleMap() {
        return employeeRoleMap;
    }

    public void setEmployeeRoleMap(Map<Employee, Role> employeeRoleMap) {
        this.employeeRoleMap = employeeRoleMap;
    }

    public Map<String, Project> getProjectMap() {
        return projectMap;
    }

    public void setProjectMap(Map<String, Project> projectMap) {
        this.projectMap = projectMap;
    }

    public void addProject(Project project){
        projectMap.put(project.getProjectName(),project);
        System.out.println("Project: " + project.getProjectName() + " added to department: " + this.name);
    }

    public Role getRole(Employee employee){
        return employeeRoleMap.get(employee);
    }

    public void assignRole(Employee employee, Role role){
        if (employee.getDepartment() == null){
            employee.setDepartment(this);
            employeeRoleMap.put(employee,role);
            System.out.println("Employee: " + employee.getName() + " is assigned to Role: " + role.getName() + " in: " + this.getName());
        }
        else {
            System.out.println("Employee: " + employee.getName() + " is not allowed to perform the action.");

        }
    }
    public boolean hasPermission(Employee employee, String permissions) {
        Role role = employeeRoleMap.get(employee);
        return role != null && role.getPermissions().contains(permissions);
    }
    public void listEmployees(){
        System.out.println("Department: " + this.name);
        for (Map.Entry<Employee,Role> entry: employeeRoleMap.entrySet()){
            System.out.println("Employee: " + entry.getKey().getName() + " --> Role: " + entry.getValue().getName());
        }
    }
    public void listProjects(){
        System.out.println("Projects of Department " + this.name + ": ");
        for (String project: projectMap.keySet()){
            System.out.println("-) " + project);
        }
    }
}
