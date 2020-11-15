package WorkersData;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Worker extends Department{
    public static int workerAmount = 0;
    private int workerId;
    private String worker;
    Worker(int companyId, String name, int branchId, String branch, int departmentId, String department, int workerId, String worker) {
        super(companyId, name, branchId, branch, departmentId, department);
        this.workerId = workerId;
        this.worker = worker;
    }
    Worker(int companyId, String name, int branchId, String branch, int departmentId, String department) {
        super(companyId, name, branchId, branch, departmentId, department);
    }
    Worker(int companyId, String name, int branchId, String branch) {
        super(companyId, name, branchId, branch);
    }
    Worker(int companyId, String name) {
        super(companyId, name);
    }

    public String getWorker() {
        return worker;
    }

    public void setWorker(String worker) {
        this.worker = worker;
    }

    public static void showWorkers(List<Project> list, int companyId, int branchId, int departmentId){
        for(int index=0; index<list.size(); index++){
            if(list.get(index).getCompanyId() == companyId && list.get(index).getBranchId() == branchId && list.get(index).getDepartmentId() == departmentId && list.get(index).getWorker() != null && list.get(index).getProject() == null){
                System.out.println(list.get(index).getWorkerId()+". "+list.get(index).getName()+", "+list.get(index).getBranch()+", "+list.get(index).getDepartment()+", "+list.get(index).getWorker());
            }
        }
    }
    public static void addWorker(List<Project> list, int companyId, int branchId, int departmentId){
        Scanner console2 = new Scanner(System.in);
        String company = "";
        String branch = "";
        String department = "";
        boolean isCompanyFound = false;
        boolean isBranchFound = false;
        boolean isDepartmentFound = false;
        for(int index=0; index<list.size(); index++){
            if(isCompanyFound == true && isBranchFound == true && isDepartmentFound == true)
                break;
            if(isCompanyFound == false && list.get(index).getCompanyId() == companyId && list.get(index).getBranch() == null){
                company = list.get(index).getName();
                isCompanyFound = true;
            }
            if(isBranchFound == false && list.get(index).getCompanyId() == companyId && list.get(index).getBranchId() == branchId && list.get(index).getDepartment() == null){
                branch = list.get(index).getBranch();
                isBranchFound = true;
            }
            if(isDepartmentFound == false && list.get(index).getCompanyId() == companyId && list.get(index).getBranchId() == branchId && list.get(index).getDepartmentId() == departmentId && list.get(index).getWorker() == null){
                department = list.get(index).getDepartment();
                isDepartmentFound = true;
            }
        }
        list.add(new Project(companyId, company, branchId, branch, departmentId, department, Worker.workerAmount, console2.nextLine()));
    }

    public static void removeWorker(List<Project> list, int workerId){
        //list.remove(companyId);// powinny być usuwane wszystkie po nazwie
        List<Integer> indexesToRemoveWorker = new ArrayList<Integer>();
        //System.out.println(list.size());
        for(int index=0; index<list.size(); index++){
            if(list.get(index).getWorkerId() == workerId){
                indexesToRemoveWorker.add(index);
            }
            System.out.println("List contains: "+list.get(index).getWorkerId()+", "+index);
        }
        if(indexesToRemoveWorker.size() == 0) {
            System.out.println("Podany identyfikator nie zawiera działu");
        }
        Collections.sort(indexesToRemoveWorker, Collections.reverseOrder());
        for(int index2 = 0; index2<indexesToRemoveWorker.size(); index2++){
            System.out.println("Index: "+index2+", value: "+ indexesToRemoveWorker.get(index2));
            list.remove((int)indexesToRemoveWorker.get(index2));
        }
        for(int index3=0; index3<list.size(); index3++){
            System.out.println("List contains2: "+list.get(index3).getWorkerId()+", "+index3);
        }
        indexesToRemoveWorker.clear();
    }

    public static void searchWorker(List<Project> list, String name, int companyId, int branchId, int departmentId){
        for(int index=0; index<list.size(); index++){
            if(list.get(index).getCompanyId() == companyId && list.get(index).getBranchId() == branchId && list.get(index).getDepartmentId() == departmentId && list.get(index).getWorker() != null && list.get(index).getProject() == null && list.get(index).getWorker().contains(name)){
                System.out.println(list.get(index).getWorkerId()+". "+list.get(index).getName()+", "+list.get(index).getBranch()+", "+list.get(index).getDepartment()+", "+list.get(index).getWorker());
            }
        }
    }

    public void setWorkerId(int workerId) {
        workerAmount = workerId;
        this.workerId = workerAmount;
    }

    public int getWorkerId() {
        return workerId;
    }
}
