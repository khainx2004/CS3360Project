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

        Role headRole = new Role("Head",headPermissions);
        Role regularRole = new Role("Regular", regularPermissions);
        Role internRole = new Role("Intern", internPermissions);

        Department itDepartment = new Department();

        Employee khai = new Employee("Khai");
        Employee khiem = new Employee("Khiem");
        Employee vu = new Employee("Vu");
        Employee quan = new Employee("Quan");

        khai.assignRole(itDepartment,regularRole);
        khiem.assignRole(itDepartment,headRole);
        vu.assignRole(itDepartment,internRole);
        quan.assignRole(itDepartment,internRole);

        Project CS360 = new Project("CS360");

        CS360.addEmployee(khai,regularRole);
        CS360.addEmployee(khiem,headRole);
        CS360.addEmployee(vu,internRole);
        CS360.addEmployee(quan,internRole);

        CS360.performAction(khai,"ADD_PROJECT");
        CS360.performAction(khiem, "DELETE_PROJECT");
        CS360.performAction(khai,"DELETE_PROJECT");
        CS360.performAction(quan,"EDIT_PROJECT");
        CS360.performAction(vu,"VIEW_PROJECT");
        CS360.performAction(vu,"ADD_PROJECT");
    }

}
