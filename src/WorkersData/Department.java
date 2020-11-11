package WorkersData;

import java.util.List;
import java.util.Scanner;

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

    public static void showDepartments(List<Project> list, int companyId, int branchId){
        String company = list.get(companyId).getName();
        String branch = list.get(branchId).getBranch();
        for (Project m : list)
        {
            if(m.getBranch() != null && m.getDepartment() != null && m.getName().equals(company) && m.getBranch().equals(branch) && m.getWorker() == null){
                System.out.println(m.getCompanyId()+". "+m.getName()+", "+m.getBranch()+", "+m.getDepartment());
            }
        }
    }

    public static void addDepartment(List<Project> list, int companyId, int branchId){
        Scanner console2 = new Scanner(System.in);
        String company = list.get(companyId).getName();
        String branch = list.get(branchId).getBranch();
        list.add(new Project(company, branch, console2.nextLine()));
    }
}
