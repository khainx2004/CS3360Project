package PMG;

import java.util.HashSet;
import java.util.Set;

public class App {
    public static void main(String[] args){
        Set<String> headPermissions = new HashSet<>();
        headPermissions.add("ADD_PROJECT");
        headPermissions.add("EDIT_PROJECT");
        headPermissions.add("DELETE_PROJECT");
        headPermissions.add("VIEW_PROJECT");

        Set<String> regularPermissions = new HashSet<>();
        regularPermissions.add("ADD_PROJECT");
        regularPermissions.add("EDIT_PROJECT");
        regularPermissions.add("VIEW_PROJECT");

        Set<String> internPermissions = new HashSet<>();
        internPermissions.add("EDIT_PROJECT");
        internPermissions.add("VIEW_PROJECT");

        Set<String> salePermissions = new HashSet<>();
        salePermissions.add("VIEW_CUSTOMERS");
        salePermissions.add("VIEW_SALES");

        Role headRole = new Role("Head",headPermissions);
        Role regularRole = new Role("Regular", regularPermissions);
        Role internRole = new Role("Intern", internPermissions);
        Role saleRole = new Role("Sale",salePermissions);

        Department itDepartment = new Department("IT Department");
        Department salesDepartment = new Department("Sales Department");

        Employee khai = new Employee("Khai");
        Employee khiem = new Employee("Khiem");
        Employee vu = new Employee("Vu");
        Employee quan = new Employee("Quan");

        itDepartment.assignRole(khai,regularRole);
        salesDepartment.assignRole(khai,saleRole);
        itDepartment.assignRole(khiem, headRole);
        itDepartment.assignRole(quan,internRole);
        itDepartment.assignRole(vu,internRole);

        System.out.println("===================================================================");
        khai.employeeInfo();
        khiem.employeeInfo();
        vu.employeeInfo();
        quan.employeeInfo();
        System.out.println("===================================================================");
        itDepartment.listEmployees();
        System.out.println("===================================================================");
        Project CS360 = new Project("CS360");
        Project project2 = new Project("P2");
        itDepartment.addProject(CS360);
        itDepartment.addProject(project2);
        itDepartment.listProjects();

        CS360.addEmployee(khai,regularRole);
        CS360.addEmployee(khiem,headRole);
        CS360.addEmployee(vu,internRole);
        CS360.addEmployee(quan,internRole);

        project2.addEmployee(khai,headRole);
        project2.addEmployee(khiem,regularRole);

        System.out.println("===================================================================");
        CS360.listAllEmployees();
        System.out.println("===================================================================");
        project2.listAllEmployees();

        System.out.println("===================================================================");
        khai.performAction("ADD_PROJECT");
        khiem.performAction("DELETE_PROJECT"); //not allowed
        khai.performAction("DELETE_PROJECT");
        quan.performAction("EDIT_PROJECT");
        vu.performAction("VIEW_PROJECT");
        vu.performAction("ADD_PROJECT"); //not allowed
        khai.performAction("VIEW_SALES"); //not allowed
    }

}
