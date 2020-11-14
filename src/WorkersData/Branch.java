package WorkersData;

import java.util.List;
import java.util.Scanner;

public class Branch extends Company{
    private String branch;
    public static int branchAmount = 0;
    private int branchId;
    Branch(String name, String branch) {
        super(name);
        this.branch = branch;
    }

    Branch(String name) {
        super(name);
    }

    public String getBranch() {
        return this.branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public static void showBranches(List<Project> list, int companyId){
        String company = list.get(companyId).getName();
        for (Project m : list)
        {
            if(m.getName().equals(company) && m.getBranch() != null && m.getDepartment() == null){
                System.out.println(m.getCompanyId()+". "+m.getName()+", "+m.getBranch());
            }
        }
    }
    public static void searchBranch(List<Project> list, String name, int companyId){
        String company = list.get(companyId).getName();
        for (Project m : list)
            if(m.getBranch() != null && m.getDepartment() == null && m.getName().equals(company) && m.getBranch().contains(name))
                System.out.println(m.getCompanyId()+". "+m.getName()+", "+m.getBranch());
    }
    public static void addBranch(List<Project> list, int companyId){
        Scanner console2 = new Scanner(System.in);
        String company = list.get(companyId).getName();
        list.add(new Project(company, console2.nextLine()));
    }
    public static void removeBranch(List<Project> list, int companyId){
        list.remove(companyId);// powinny być usuwane wszystkie po nazwie
    }

    public void setBranchId(int branchId) {
        branchAmount = branchId;
        this.branchId = branchAmount;
    }

    public int getBranchId() {
        return branchId;
    }
}
