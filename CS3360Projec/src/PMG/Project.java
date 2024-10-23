package PMG;

import java.util.HashMap;
import java.util.Map;

public class Project {
    private String projectName;
    private Map<Employee, Role> projectRole = new HashMap<>();

    public Project(String projectName){
        this.projectName = projectName;
    }

    public String getProjectName(){
        return this.projectName;
    }
    public Map<Employee, Role> getProjectRole() {
        return projectRole;
    }

    public void addEmployee(Employee employee, Role role){
        projectRole.put(employee,role);
    }
    public void editEmployeeRole(Employee employee, Role role){
        if (projectRole.containsKey(employee)){
            projectRole.put(employee,role);
            System.out.println("Edit Employee's Role successfully.");
        }
        else {
            System.out.println("Employee not found.");
        }
    }
    public void removeEmployee(Employee employee){
        if (projectRole.containsKey(employee)){
            projectRole.remove(employee);
            System.out.println("Removed employee: " + employee.getName());
        }
        else {
            System.out.println("Employee not found.");
        }
    }
    public void listAllEmployees(){
        for(Map.Entry<Employee,Role> entry : projectRole.entrySet()){
            System.out.println("Project: " + this.projectName + " ==> Employee: " + entry.getKey().getName() + " --> Role: " + entry.getValue().getName());
        }
    }

}
