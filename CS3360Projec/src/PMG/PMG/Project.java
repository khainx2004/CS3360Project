package PMG;

import java.util.HashMap;
import java.util.Map;

public class Project {
    private String projectName;
    private Map<Employee, Role> projectTeam = new HashMap<>();

    public Project(String projectName){
        this.projectName = projectName;
    }

    public String getProjectName(){
        return this.projectName;
    }
    public Map<Employee, Role> getProjectTeam() {
        return projectTeam;
    }

    public void addEmployee(Employee employee, Role role){
        projectTeam.put(employee,role);
    }
    public void editEmployeeRole(Employee employee, Role role){
        if (projectTeam.containsKey(employee)){
            projectTeam.put(employee,role);
            System.out.println("Edit Employee's Role successfully.");
        }
        else {
            System.out.println("Employee not found.");
        }
    }
    public void removeEmployee(Employee employee){
        if (projectTeam.containsKey(employee)){
            projectTeam.remove(employee);
            System.out.println("Removed employee: " + employee.getName());
        }
        else {
            System.out.println("Employee not found.");
        }
    }
    public void listAllEmployees(){
        for(Map.Entry<Employee,Role> entry : projectTeam.entrySet()){
            System.out.println("Project: " + this.projectName + " ==> Employee: " + entry.getKey().getName() + " --> Role: " + entry.getValue().getName());
        }
    }

}
