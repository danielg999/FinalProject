package WorkersData;

import java.util.List;

public class Project extends Worker{
    public static int projectAmount = 0;
    private String project;
    private int projectId;
    Project(int companyId, String name, int branchId, String branch, int departmentId, String department, int workerId, String worker, int projectId, String project) {
        super(companyId, name, branchId, branch, departmentId, department, workerId, worker);
        this.project = project;
        this.projectId = projectId;
    }
    Project(int companyId, String name, int branchId, String branch, int departmentId, String department, int workerId, String worker) {
        super(companyId, name, branchId, branch, departmentId, department, workerId, worker);
        if(this.getProject() == null){
            //System.out.println(getWorkerId());
            IncrementWorkerId();
            //System.out.println(getWorkerId());
        }
    }
    Project(int companyId, String name, int branchId, String branch, int departmentId, String department) {
        super(companyId, name, branchId, branch, departmentId, department);
        if(this.getWorker() == null){
            //System.out.println(getDepartmentId());
            IncrementDepartmentId();
            //System.out.println(getDepartmentId());
        }
    }
    Project(int companyId, String name, int branchId, String branch) {
        super(companyId, name, branchId, branch);
        if(this.getDepartment() == null){
            //System.out.println(getBranchId());
            IncrementBranchId();
            //System.out.println(getBranchId());
        }
    }
    Project(int companyId, String name) {
        super(companyId, name);
        if(this.getBranch() == null){
            //System.out.println(getCompanyId());
            IncrementCompanyId();
            //System.out.println(getCompanyId());
        }
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    private void IncrementCompanyId() {
        this.setCompanyId(companyAmount+1);
    }

    public void IncrementBranchId() {
        this.setBranchId(branchAmount+1);
    }
    public void IncrementProjectId() {
        this.setProjectId(projectAmount+1);
    }
    public void IncrementWorkerId() {
        this.setWorkerId(workerAmount+1);
    }
    public void IncrementDepartmentId() {
        this.setDepartmentId(departmentAmount+1);
    }
    public void setProjectId(int projectId) {
        projectAmount = projectId;
        this.projectId = projectAmount;
    }

    public int getProjectId() {
        return projectId;
    }
}
