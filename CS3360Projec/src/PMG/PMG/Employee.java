package PMG;



public class Employee {
    private String name;
    private Department department;

    public Employee(String name) {
        this.name = name;
    }

    public Department getDepartment(){
        return this.department;
    }
    public void setDepartment(Department department){
        this.department = department;
    }

    public String getName(){
        return this.name;
    }

    public void performAction(String action){
        if (department != null && department.hasPermission(this, action)){
            System.out.println("Employee: " + this.getName() + " performed action: " + action);
        }
        else {
            System.out.println("Employee: " + this.getName() + " is not allowed to perform the action.");
        }
    }
    public void employeeInfo(){
        if(department != null) {
            Role role = department.getRole(this);
            if (role != null) {
                System.out.println("Employee: " + this.getName() + " --> Department: " + department.getName() + " --> Department's Role: " + role.getName());
            } else {
                System.out.println("Employee " + this.getName() + " has no role in the Department.");
            }
        }
        else {
            System.out.println("Employee: " + this.getName() + " is not assigned to any department.");
        }
    }
}
