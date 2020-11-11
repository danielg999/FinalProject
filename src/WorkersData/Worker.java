package WorkersData;

public class Worker extends Department{
    private String worker;
    Worker(String name, String branch, String department, String worker) {
        super(name, branch, department);
        this.worker = worker;
    }
    Worker(String name, String branch, String department) {
        super(name, branch, department);
    }
    Worker(String name, String branch) {
        super(name, branch);
    }
    Worker(String name) {
        super(name);
    }

    public String getWorker() {
        return worker;
    }

    public void setWorker(String worker) {
        this.worker = worker;
    }
}
