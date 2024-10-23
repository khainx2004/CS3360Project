package PMG;

import java.util.HashMap;
import java.util.Map;

public class Department {
    private String name;
    private Map<Employee,Role> employeeRole = new HashMap<>();
    private Map<String, Project> projectList = new HashMap<>();

    public Department(String name) {
        this.name = name;
    }
    public String getName(){
        return this.name;
    }

    public Map<Employee, Role> getEmployeeRole() {
        return employeeRole;
    }

    public void setEmployeeRole(Map<Employee, Role> employeeRole) {
        this.employeeRole = employeeRole;
    }

    public Map<String, Project> getProjectList() {
        return projectList;
    }

    public void setProjectList(Map<String, Project> projectList) {
        this.projectList = projectList;
    }

    public void addProject(Project project){
        projectList.put(project.getProjectName(),project);
        System.out.println("Project: " + project.getProjectName() + " added to department: " + this.name);
    }

    public Role getRole(Employee employee){
        return employeeRole.get(employee);
    }

    public void assignRole(Employee employee, Role role){
        if (employee.getDepartment() == null){
            employee.setDepartment(this);
            employeeRole.put(employee,role);
            System.out.println("Employee: " + employee.getName() + " is assigned to Role: " + role.getName() + " in: " + this.getName());
        }
        else {
            System.out.println("Employee: " + employee.getName() + " is not allowed to perform the action.");

        }
    }
    public boolean hasPermission(Employee employee, String permissions) {
        Role role = employeeRole.get(employee);
        return role != null && role.getPermissions().contains(permissions);
    }
    public void listEmployees(){
        System.out.println("Department: " + this.name);
        for (Map.Entry<Employee,Role> entry: employeeRole.entrySet()){
            System.out.println("Employee: " + entry.getKey().getName() + " --> Role: " + entry.getValue().getName());
        }
    }
    public void listProjects(){
        System.out.println("Projects of Department " + this.name + ": ");
        for (String project: projectList.keySet()){
            System.out.println("-) " + project);
        }
    }
}
