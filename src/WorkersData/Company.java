package WorkersData;

import java.util.List;

public class Company<T extends Comparable<T>> extends General implements IncrementCompanyId{
    private static int companyAmount = 0;
    private  int companyId;
    private String name;

    Company(String name) {
        //companyAmount++;
        //this.setCompanyId();
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

    public static void showCompanies(List<Project> list){
        for (Project m : list)
        {
            if(m.getBranch() == null)
                System.out.println(m.getCompanyId()+". "+m.getName());
        }
    }
    public static void addCompany(List<Project> list, String company){
        int flag = 0;
        for(Project item : list)
            if(item.getName().contains(company))
                flag = 1;
        if(flag == 0){
            list.add(new Project(company));
        }

        else
            System.out.println("Podana firma już istnieje");
    }
    public static void removeCompany(List<Project> list, int id){
        if(list.get(id).getBranch() == null)
            list.remove(id);
        else
            System.out.println("Podany identyfikator nie zawiera firmy");
        // powinny być usuwane wszystkie po nazwie
    }

    public static void searchCompany(List<Project> list, String name){
        for (Project m : list)
            if(m.getName().contains(name) && m.getBranch() == null)
                System.out.println(m.getCompanyId()+". "+m.getName());
    }

    @Override
    public void IncrementCompanyId() {
        this.companyAmount++;
        this.setCompanyId();
    }
}
