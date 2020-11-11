package WorkersData;

import java.util.List;

public class Project extends Worker{
    private String project;
    Project(String name, String branch, String department, String worker, String project) {
        super(name, branch, department, worker);
        this.project = project;
    }
    Project(String name, String branch, String department, String worker) {
        super(name, branch, department, worker);
    }
    Project(String name, String branch, String department) {
        super(name, branch, department);
    }
    Project(String name, String branch) {
        super(name, branch);
    }
    Project(String name) {
        super(name);
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

}
