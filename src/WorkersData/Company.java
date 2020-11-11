package WorkersData;

import java.util.List;

public class Company<T extends Comparable<T>> extends General{
    static int companyAmount = 0;
    private int companyId;
    private String name;

    Company(String name) {
        companyAmount++;
        this.setCompanyId();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public void setName(String name) {
        this.name = name;
    }

    private void setCompanyId(){
        this.companyId = companyAmount;
    }

}
