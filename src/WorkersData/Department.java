package WorkersData;

import java.util.List;
import java.util.Scanner;

public class Department extends Branch{
    public static int departmentAmount = 0;
    private int departmentId;
    private String department;
    Department(int companyId, String name, int branchId, String branch, int departmentId, String department) {
        super(companyId, name, branchId, branch);
        this.departmentId = departmentId;
        this.department = department;
    }
    Department(int companyId, String name, int branchId, String branch) {
        super(companyId, name, branchId, branch);
    }
    Department(int companyId, String name) {
        super(companyId, name);
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public static void showDepartments(List<Project> list, int companyId, int branchId){
        String company = list.get(companyId).getName();
        String branch = list.get(branchId).getBranch();
        for (Project m : list)
        {
            if(m.getBranch() != null && m.getDepartment() != null && m.getName().equals(company) && m.getBranch().equals(branch) && m.getWorker() == null){
                System.out.println(m.getDepartmentId()+". "+m.getName()+", "+m.getBranch()+", "+m.getDepartment());
            }
        }
    }

    public static void addDepartment(List<Project> list, int companyId, int branchId){
        Scanner console2 = new Scanner(System.in);
        String company = list.get(companyId).getName();
        String branch = list.get(branchId).getBranch();
        list.add(new Project(companyId, company, Branch.branchAmount, branch, Department.departmentAmount, console2.nextLine()));
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        departmentAmount = departmentId;
        this.departmentId = departmentAmount;
    }
}
