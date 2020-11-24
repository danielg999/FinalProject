package WorkersData;

import java.time.LocalDate;
import java.util.List;

public class Project extends Worker{
    private static int projectAmount = 0;
    private String project;
    private int projectId;
    Project(int counterId, String partnerShipName, LocalDate creationDate, boolean internationality, int companyId, String name, int branchId, String branch, int departmentId, String department, int workerId, String worker, Positions position, int projectId, String project) {
        super(counterId, partnerShipName, creationDate, internationality, companyId, name, branchId, branch, departmentId, department, workerId, worker, position);
        this.project = project;
        this.projectId = projectId;
    }
    Project(int counterId, String partnerShipName, LocalDate creationDate, boolean internationality, int companyId, String name, int branchId, String branch, int departmentId, String department, int workerId, String worker, Positions position) {
        super(counterId, partnerShipName, creationDate, internationality, companyId, name, branchId, branch, departmentId, department, workerId, worker, position);
        if(this.getProject() == null){
            //System.out.println(getWorkerId());
            IncrementWorkerId();
            //System.out.println(getWorkerId());
        }
    }
    Project(int counterId, String partnerShipName, LocalDate creationDate, boolean internationality, int companyId, String name, int branchId, String branch, int departmentId, String department) {
        super(counterId, partnerShipName, creationDate, internationality, companyId, name, branchId, branch, departmentId, department);
        if(this.getWorker() == null){
            //System.out.println(getDepartmentId());
            IncrementDepartmentId();
            //System.out.println(getDepartmentId());
        }
    }
    Project(int counterId, String partnerShipName, LocalDate creationDate, boolean internationality, int companyId, String name, int branchId, String branch) {
        super(counterId, partnerShipName, creationDate, internationality, companyId, name, branchId, branch);
        if(this.getDepartment() == null){
            //System.out.println(getBranchId());
            IncrementBranchId();
            //System.out.println(getBranchId());
        }
    }
    Project(int counterId, String partnerShipName, LocalDate creationDate, boolean internationality, int companyId, String name) {
        super(counterId, partnerShipName, creationDate, internationality, companyId, name);
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
        this.setCompanyId(Company.getCompanyAmount()+1);
    }

    public void IncrementBranchId() {
        this.setBranchId(Branch.getBranchAmount()+1);
    }
    public void IncrementProjectId() {
        this.setProjectId(projectAmount+1);
    }
    public void IncrementWorkerId() {
        this.setWorkerId(Worker.getWorkerAmount()+1);
    }
    public void IncrementDepartmentId() {
        this.setDepartmentId(Department.getDepartmentAmount()+1);
    }
    public void setProjectId(int projectId) {
        projectAmount = projectId;
        this.projectId = projectAmount;
    }

    public int getProjectId() {
        return projectId;
    }

    public static int getProjectAmount() {
        return projectAmount;
    }

    public static void setProjectAmount(int projectAmount) {
        Project.projectAmount = projectAmount;
    }

    public static void showDataBase(List<Project> list){
        for(int index=0; index<list.size(); index++){
            System.out.println(list.get(index).getCounterId()+". "+list.get(index).getPartnerShipName()+", "+
                    list.get(index).getCreationDate()+", "+list.get(index).getInternationality()+", "+(list.get(index).getName() == null?"":
                    list.get(index).getName())+", "+(list.get(index).getBranch() == null ? "" : list.get(index).getBranch()+", ")
                    +(list.get(index).getDepartment() == null ? "" : list.get(index).getDepartment()+", ")+
                    (list.get(index).getWorker() == null ? "" : list.get(index).getWorker()));
        }
    }
}
