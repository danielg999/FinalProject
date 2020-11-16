package WorkersData;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Department extends Branch{
    public static int departmentAmount = 0;
    private int departmentId;
    private String department;
    Department(int counterId, int companyId, String name, int branchId, String branch, int departmentId, String department) {
        super(counterId, companyId, name, branchId, branch);
        this.departmentId = departmentId;
        this.department = department;
    }
    Department(int counterId, int companyId, String name, int branchId, String branch) {
        super(counterId, companyId, name, branchId, branch);
    }
    Department(int counterId, int companyId, String name) {
        super(counterId, companyId, name);
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public static void showDepartments(List<Project> list, int companyId, int branchId){
        for(int index=0; index<list.size(); index++){
            if(list.get(index).getCompanyId() == companyId && list.get(index).getBranchId() == branchId && list.get(index).getDepartment() != null && list.get(index).getWorker() == null){
                System.out.println(list.get(index).getDepartmentId()+". "+list.get(index).getName()+", "+list.get(index).getBranch()+", "+list.get(index).getDepartment());
            }
        }
    }

    public static void addDepartment(List<Project> list, int companyId, int branchId){
        Scanner console2 = new Scanner(System.in);
        String company = "";
        String branch = "";
        boolean isCompanyFound = false;
        boolean isBranchFound = false;
        for(int index=0; index<list.size(); index++){
            if(isCompanyFound == true && isBranchFound == true)
                break;
            if(isCompanyFound == false && list.get(index).getCompanyId() == companyId && list.get(index).getBranch() == null){
                company = list.get(index).getName();
                isCompanyFound = true;
            }
            if(isBranchFound == false && list.get(index).getCompanyId() == companyId && list.get(index).getBranchId() == branchId && list.get(index).getDepartment() == null){
                branch = list.get(index).getBranch();
                isBranchFound = true;
            }
        }
        list.add(new Project(General.getCounter(), companyId, company, branchId, branch, Department.departmentAmount, console2.nextLine()));
    }

    public static void removeDepartment(List<Project> list, int departmentId){
        //list.remove(companyId);// powinny być usuwane wszystkie po nazwie
        List<Integer> indexesToRemoveDepartment = new ArrayList<Integer>();
        //System.out.println(list.size());
        for(int index=0; index<list.size(); index++){
            if(list.get(index).getDepartmentId() == departmentId){
                indexesToRemoveDepartment.add(index);
            }
            System.out.println("List contains: "+list.get(index).getBranchId()+", "+index);
        }
        if(indexesToRemoveDepartment.size() == 0) {
            System.out.println("Podany identyfikator nie zawiera działu");
        }
        Collections.sort(indexesToRemoveDepartment, Collections.reverseOrder());
        for(int index2 = 0; index2<indexesToRemoveDepartment.size(); index2++){
            System.out.println("Index: "+index2+", value: "+ indexesToRemoveDepartment.get(index2));
            list.remove((int)indexesToRemoveDepartment.get(index2));
        }
        for(int index3=0; index3<list.size(); index3++){
            System.out.println("List contains2: "+list.get(index3).getDepartmentId()+", "+index3);
        }
        indexesToRemoveDepartment.clear();
    }

    public static void searchDepartment(List<Project> list, String name, int companyId, int branchId){
        for(int index=0; index<list.size(); index++){
            if(list.get(index).getCompanyId() == companyId && list.get(index).getBranchId() == branchId && list.get(index).getDepartment() != null && list.get(index).getWorker() == null && list.get(index).getDepartment().contains(name)){
                System.out.println(list.get(index).getDepartmentId()+". "+list.get(index).getName()+", "+list.get(index).getBranch()+", "+list.get(index).getDepartment());
            }
        }
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        departmentAmount = departmentId;
        this.departmentId = departmentAmount;
    }
}
