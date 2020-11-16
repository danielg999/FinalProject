package WorkersData;

import java.util.*;

public class Branch extends Company{
    public static int branchAmount = 0;
    private int branchId;
    private String branch;

    Branch(int counterId, int companyId, String name, int branchId, String branch) {
        super(counterId, companyId, name);
        this.branchId = branchId;
        this.branch = branch;
    }

    Branch(int counterId, int companyId, String name) {
        super(counterId, companyId, name);
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
    }
    public static void searchBranch(List<Project> list, String name, int companyId){
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
        list.add(new Project(General.getCounter(), companyId, company, Branch.branchAmount, console2.nextLine()));
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
        Collections.sort(indexesToRemoveBranch, Collections.reverseOrder());
        for(int index2 = 0; index2<indexesToRemoveBranch.size(); index2++){
            System.out.println("Index: "+index2+", value: "+ indexesToRemoveBranch.get(index2));
            list.remove((int)indexesToRemoveBranch.get(index2));
        }
        for(int index3=0; index3<list.size(); index3++){
            System.out.println("List contains2: "+list.get(index3).getBranchId()+", "+index3);
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
