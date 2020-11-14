package WorkersData;

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
        String company = list.get(companyId).getName();
        String branch = list.get(branchId).getBranch();
        String department = list.get(departmentId).getDepartment();
        for (Project m : list)
        {
            if(m.getBranch() != null && m.getDepartment() != null && m.getWorker() != null && m.getName().equals(company) && m.getBranch().equals(branch) && m.getDepartment().equals(department) && m.getProject() == null){
                System.out.println(m.getWorkerId()+". "+m.getName()+", "+m.getBranch()+", "+m.getDepartment()+", "+m.getWorker());
            }
        }
    }
    public static void addWorker(List<Project> list, int companyId, int branchId, int departmentId){
        Scanner console2 = new Scanner(System.in);
        String company = list.get(companyId).getName();
        String branch = list.get(branchId).getBranch();
        String department = list.get(departmentId).getDepartment();
        list.add(new Project(companyId, company, Branch.branchAmount, branch, Department.departmentAmount, department, Worker.workerAmount, console2.nextLine()));
    }

    public void setWorkerId(int workerId) {
        workerAmount = workerId;
        this.workerId = workerAmount;
    }

    public int getWorkerId() {
        return workerId;
    }
}
