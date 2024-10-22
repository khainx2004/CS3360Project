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

        Department itDepartment = new Department();
        Department salesDepartment = new Department();

        Employee khai = new Employee("Khai");
        Employee khiem = new Employee("Khiem");
        Employee vu = new Employee("Vu");
        Employee quan = new Employee("Quan");

        khai.assignRole(itDepartment,regularRole);
        khai.assignRole(salesDepartment,saleRole);
        khiem.assignRole(itDepartment,headRole);
        vu.assignRole(itDepartment,internRole);
        quan.assignRole(itDepartment,internRole);

        System.out.println("===================================================================");
        khai.employeeInfo();
        khiem.employeeInfo();
        vu.employeeInfo();
        quan.employeeInfo();
        Project CS360 = new Project("CS360");

        CS360.addEmployee(khai,regularRole);
        CS360.addEmployee(khiem,headRole);
        CS360.addEmployee(vu,internRole);
        CS360.addEmployee(quan,internRole);

        System.out.println("===================================================================");
        CS360.listAllEmployees();

        System.out.println("===================================================================");
        khai.performAction(itDepartment,"ADD_PROJECT");
        khiem.performAction(itDepartment, "DELETE_PROJECT"); //not allowed
        khai.performAction(itDepartment,"DELETE_PROJECT");
        quan.performAction(itDepartment,"EDIT_PROJECT");
        vu.performAction(itDepartment,"VIEW_PROJECT");
        vu.performAction(itDepartment,"ADD_PROJECT"); //not allowed
        khai.performAction(salesDepartment,"VIEW_SALES"); //not allowed
    }

}
