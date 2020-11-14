package WorkersData;

import java.util.List;

public class Project extends Worker{
    public static int projectAmount = 0;
    private String project;
    private int projectId;
    Project(String name, String branch, String department, int workerId, String worker, int projectId, String project) {
        super(name, branch, department, workerId, worker);
        this.project = project;
        this.projectId = projectId;
    }
    Project(String name, String branch, String department, int workerId, String worker) {
        super(name, branch, department, workerId, worker);
        if(this.getProject() == null){
            System.out.println(getWorkerId());
            IncrementWorkerId();
            System.out.println(getWorkerId());
        }
    }
    Project(String name, String branch, String department) {
        super(name, branch, department);
    }
    Project(String name, String branch) {
        super(name, branch);
        if(this.getDepartment() == null){
            //System.out.println(getDepartment());
            IncrementBranchId();
            //System.out.println(getCompanyId());
        }
    }
    Project(String name) {
        super(name);
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
    public void setProjectId(int projectId) {
        projectAmount = projectId;
        this.projectId = projectAmount;
    }

    public int getProjectId() {
        return projectId;
    }
}
