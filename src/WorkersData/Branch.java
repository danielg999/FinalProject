package WorkersData;

public class Branch extends Company{
    private String branch;
    Branch(String name, String branch) {
        super(name);
        this.branch = branch;
    }

    Branch(String name) {
        super(name);
    }

    public String getBranch() {
        return this.branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }
}
