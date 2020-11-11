package WorkersData;

public class Department extends Branch{
    private String department;
    Department(String name, String branch, String department) {
        super(name, branch);
        this.department = department;
    }
    Department(String name, String branch) {
        super(name, branch);
    }
    Department(String name) {
        super(name);
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
