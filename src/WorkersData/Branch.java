package WorkersData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Branch extends Company{
    public static int branchAmount = 0;
    private int branchId;
    private String branch;

    Branch(int companyId, String name, int branchId, String branch) {
        super(companyId, name);
        this.branchId = branchId;
        this.branch = branch;
    }

    Branch(int companyId, String name) {
        super(companyId, name);
    }

    public String getBranch() {
        return this.branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public static void showBranches(List<Project> list, int companyId){
        String company = list.get(companyId).getName();
        for(int index=0; index<list.size(); index++){
            if(list.get(index).getCompanyId() == companyId && list.get(index).getBranch() != null && list.get(index).getDepartment() == null){
                System.out.println(list.get(index).getBranchId()+". "+list.get(index).getName()+", "+list.get(index).getBranch());
            }
        }

//        for (Project m : list)
//        {
//            if(m.getName().equals(company) && m.getBranch() != null && m.getDepartment() == null){
//                System.out.println(m.getBranchId()+". "+m.getName()+", "+m.getBranch());
//            }
//        }
    }
    public static void searchBranch(List<Project> list, String name, int companyId){
//        String company = list.get(companyId).getName();
//        for (Project m : list)
//            if(m.getBranch() != null && m.getDepartment() == null && m.getName().equals(company) && m.getBranch().contains(name))
//                System.out.println(m.getCompanyId()+". "+m.getName()+", "+m.getBranch());

        for(int index=0; index<list.size(); index++){
            if(list.get(index).getCompanyId() == companyId && list.get(index).getBranch() != null && list.get(index).getDepartment() == null && list.get(index).getBranch().contains(name)){
                System.out.println(list.get(index).getCompanyId()+". "+list.get(index).getName()+", "+list.get(index).getBranch());
            }
        }
    }
    public static void addBranch(List<Project> list, int companyId){
        Scanner console2 = new Scanner(System.in);
        //list.forEach(x->x.getCompanyId());
        String company = "";
        for(int index=0; index<list.size(); index++){
            if(list.get(index).getCompanyId() == companyId && list.get(index).getBranch() == null){
                company = list.get(index).getName();
                break;
            }
        }
        list.add(new Project(companyId, company, Branch.branchAmount, console2.nextLine()));
    }
    public static void removeBranch(List<Project> list, int branchId){
        //list.remove(companyId);// powinny być usuwane wszystkie po nazwie
        List<Integer> indexesToRemoveBranch = new ArrayList<Integer>();
        //System.out.println(list.size());
        for(int index=0; index<list.size(); index++){
            if(list.get(index).getBranchId() == branchId){
                indexesToRemoveBranch.add(index);
            }
            System.out.println("List contains: "+list.get(index).getBranchId()+", "+index);
        }
        if(indexesToRemoveBranch.size() == 0) {
            System.out.println("Podany identyfikator nie zawiera oddziału");
        }
        for(Integer index : indexesToRemoveBranch){
            System.out.println("Index: "+index);
            list.remove((int)index);
            //list.remove(3);
        }
        indexesToRemoveBranch.clear();
    }

    public void setBranchId(int branchId) {
        branchAmount = branchId;
        this.branchId = branchAmount;
    }

    public int getBranchId() {
        return branchId;
    }
}
