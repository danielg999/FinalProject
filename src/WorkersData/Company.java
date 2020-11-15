package WorkersData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Company<T extends Comparable<T>> extends General{
    public static int companyAmount = 0;
    private  int companyId;
    private String name;

    Company(int companyId, String name) {
        //companyAmount++;
        //this.setCompanyId();
        this.companyId = companyId;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        companyAmount = companyId;
        this.companyId = companyAmount;
    }

    public void setName(String name) {
        this.name = name;
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
            list.add(new Project(Company.companyAmount, company));
        }

        else
            System.out.println("Podana firma już istnieje");
    }
    public static void removeCompany(List<Project> list, int id){
        List<Integer> indexesToRemove = new ArrayList<Integer>();
        //System.out.println(list.size());
        for(int index=0; index<list.size(); index++){
            if(list.get(index).getCompanyId() == id){
                indexesToRemove.add(index);
            }
        }
        if(indexesToRemove.size() == 0){
            System.out.println("Podany identyfikator nie zawiera firmy");
        }
        for(Integer index : indexesToRemove){
            System.out.println(list.get(index).getCompanyId()+", "+index);
            list.remove((int)index);
        }
        indexesToRemove.clear();
    }

    public static void searchCompany(List<Project> list, String name){
        for (Project m : list)
            if(m.getName().contains(name) && m.getBranch() == null)
                System.out.println(m.getCompanyId()+". "+m.getName());
    }

    @Override
    public void doSth() {

    }
}
