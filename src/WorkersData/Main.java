package WorkersData;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner console = new Scanner(System.in);
        List<Project> companies = new ArrayList<Project>();
//        List<Branch> companies2 = new ArrayList<Branch>();
//        List<Department> companies3 = new ArrayList<Department>();
//        List<Worker> companies4 = new ArrayList<Worker>();
//        List<Project> companies5 = new ArrayList<Project>();


        companies.add(new Project("xxx"));
        companies.add(new Project("xxx", "dsd2"));
        companies.add(new Project("nazwaFirmy"));
        companies.add(new Project("nazwaFirmy", "oddzial"));
        companies.add(new Project("nazwaFirmy", "oddzial", "Dzial"));
        companies.add(new Project("nazwaFirmy", "oddzial", "Dzial", "pracownik"));
        companies.add(new Project("nazwaFirmy", "oddzial", "Dzial", "pracownik", "projekt"));
        //showCompanies(companies5);
        String choice;
        Integer companyId, branchId, departmentId;
        Integer choice2;
        do{
            System.out.println("MENU FIRM\n-------------------------");
            System.out.println("1) Pokaż firmy");
            System.out.println("2) Dodaj firmę");
            System.out.println("3) Usuń firmę");
            System.out.println("4) Znajdź firmę po nazwie");
            System.out.println("5) Zarządzaj firmą");
            System.out.println("6) Zakończ");
            choice = console.nextLine();
            switch(choice){
                case "1":
                    showCompanies(companies);
                    break;
                case "2":

                    addCompany(companies, console.nextLine());
                    //companies.add(new Company("Druga"));
                    break;
                case "3":
                    System.out.print("Podaj indentyfikator firmy: ");
                    removeCompany(companies, Integer.parseInt(console.nextLine())-1);

                    break;
                case "4":
                    System.out.print("Podaj nazwę: ");
                    searchCompany(companies, console.nextLine());
                    break;
                case "5":
                    System.out.print("Podaj identyfikator firmy: ");
                    companyId = Integer.parseInt(console.nextLine());
                    do{
                        System.out.println("PODMENU ODDZIAŁU\n-------------------------");
                        System.out.println("1) Pokaż oddziały");
                        System.out.println("2) Dodaj oddział");
                        System.out.println("3) Usuń oddział");
                        System.out.println("4) Znajdź oddział po nazwie");
                        System.out.println("5) Zarządzaj oddziałem");
                        System.out.println("6) Cofnij");
                        choice2 = Integer.parseInt(console.nextLine());
                        switch(choice2){
                            case 1:
                                showBranches(companies, companyId);
                                break;
                            case 2:
                                addBranch(companies, companyId);
                                break;
                            case 3:
                                System.out.print("Podaj indentyfikator oddziału: ");
                                removeBranch(companies, Integer.parseInt(console.nextLine())-1);
                                break;
                            case 4:
                                System.out.print("Podaj nazwę: ");
                                searchBranch(companies, console.nextLine(), companyId);
                                break;
                            case 5:
                                System.out.print("Podaj identyfikator oddziału: ");
                                branchId = Integer.parseInt(console.nextLine());
                                do{
                                    System.out.println("PODMENU DZIAŁU\n-------------------------");
                                    System.out.println("1) Pokaż działy");
                                    System.out.println("2) Dodaj dział");
                                    System.out.println("3) Usuń dział");
                                    System.out.println("4) Znajdź dział po nazwie");
                                    System.out.println("5) Zarządzaj działem");
                                    System.out.println("6) Cofnij");
                                    choice2 = Integer.parseInt(console.nextLine());
                                    switch(choice2){
                                        case 1:
                                            showDepartments(companies, companyId, branchId);
                                            break;
                                        case 2:
                                            addDepartment(companies, companyId, branchId);
                                            break;
                                        case 3:
                                            System.out.print("Podaj indentyfikator oddziału: ");
                                            //removeDepartment(companies, Integer.parseInt(console.nextLine())-1);
                                            break;
                                        case 4:
                                            System.out.print("Podaj nazwę: ");
                                            //searchDepartment(companies, console.nextLine(), companyId, branchId);
                                            break;
                                        case 5:
                                            System.out.print("Podaj identyfikator oddziału: ");
                                            departmentId = Integer.parseInt(console.nextLine());
                                            do{
                                                System.out.println("PODMENU DZIAŁU\n-------------------------");
                                                System.out.println("1) Pokaż pracowników");
                                                System.out.println("2) Dodaj pracownika");
                                                System.out.println("3) Usuń pracownika");
                                                System.out.println("4) Znajdź pracownika po imieniu lub nazwisku");
                                                System.out.println("5) Zarządzaj pracownikiem");
                                                System.out.println("6) Cofnij");
                                                choice2 = Integer.parseInt(console.nextLine());
                                                switch(choice2){
                                                    case 1:
                                                        showWorkers(companies, companyId, branchId, departmentId);
                                                        break;
                                                    case 2:
                                                        addWorker(companies, companyId, branchId, departmentId);
                                                        break;
                                                    case 3:
                                                        System.out.print("Podaj indentyfikator oddziału: ");
                                                        //removeDepartment(companies, Integer.parseInt(console.nextLine())-1);
                                                        break;
                                                    case 4:
                                                        System.out.print("Podaj nazwę: ");
                                                        //searchDepartment(companies, console.nextLine(), companyId, branchId);
                                                        break;
                                                    case 5:
                                                        System.out.print("Podaj identyfikator oddziału: ");
                                                        departmentId = Integer.parseInt(console.nextLine());


                                                        break;
                                                }
                                            }while(!choice2.equals(6));

                                            break;
                                    }
                                }while(!choice2.equals(6));

                                break;
                        }
                    }while(!choice2.equals(6));

                    break;
                case "6":
                    System.out.println("Do widzenia");
                    break;
            }
        } while(!choice.equals("6"));
    }
    public static void showCompanies(List<Project> list){
        for (Project m : list)
        {
            if(m.getBranch() == null)
                System.out.println(m.getCompanyId()+". "+m.getName());
        }
    }
    public static void showBranches(List<Project> list, int companyId){
        String company = list.get(companyId).getName();
        for (Project m : list)
        {
            if(m.getName().equals(company) && m.getBranch() != null && m.getDepartment() == null){
                System.out.println(m.getCompanyId()+". "+m.getName()+", "+m.getBranch());
            }
        }
    }
    public static void showDepartments(List<Project> list, int companyId, int branchId){
        String company = list.get(companyId).getName();
        String branch = list.get(branchId).getBranch();
        for (Project m : list)
        {
            if(m.getBranch() != null && m.getDepartment() != null && m.getName().equals(company) && m.getBranch().equals(branch) && m.getWorker() == null){
                System.out.println(m.getCompanyId()+". "+m.getName()+", "+m.getBranch()+", "+m.getDepartment());
            }
        }
    }
    public static void showWorkers(List<Project> list, int companyId, int branchId, int departmentId){
        String company = list.get(companyId).getName();
        String branch = list.get(branchId).getBranch();
        String department = list.get(departmentId).getDepartment();
        for (Project m : list)
        {
            if(m.getBranch() != null && m.getDepartment() != null && m.getWorker() != null && m.getName().equals(company) && m.getBranch().equals(branch) && m.getDepartment().equals(department) && m.getProject() == null){
                System.out.println(m.getCompanyId()+". "+m.getName()+", "+m.getBranch()+", "+m.getDepartment()+", "+m.getWorker());
            }
        }
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
    public static void searchBranch(List<Project> list, String name, int companyId){
        String company = list.get(companyId).getName();
        for (Project m : list)
            if(m.getBranch() != null && m.getDepartment() == null && m.getName().equals(company) && m.getBranch().contains(name))
                System.out.println(m.getCompanyId()+". "+m.getName()+", "+m.getBranch());
    }
    public static void removeBranch(List<Project> list, int companyId){
        list.remove(companyId);// powinny być usuwane wszystkie po nazwie
    }

    public static void addCompany(List<Project> list, String company){
        int flag = 0;
        for(Project item : list)
            if(item.getName().contains(company))
                flag = 1;
        if(flag == 0)
            list.add(new Project(company));
        else
            System.out.println("Podana firma już istnieje");
    }
    public static void addBranch(List<Project> list, int companyId){
        Scanner console2 = new Scanner(System.in);
        String company = list.get(companyId).getName();
        list.add(new Project(company, console2.nextLine()));
    }
    public static void addDepartment(List<Project> list, int companyId, int branchId){
        Scanner console2 = new Scanner(System.in);
        String company = list.get(companyId).getName();
        String branch = list.get(branchId).getBranch();
        list.add(new Project(company, branch, console2.nextLine()));
    }
    public static void addWorker(List<Project> list, int companyId, int branchId, int departmentId){
        Scanner console2 = new Scanner(System.in);
        String company = list.get(companyId).getName();
        String branch = list.get(branchId).getBranch();
        String department = list.get(departmentId).getDepartment();
        list.add(new Project(company, branch, department, console2.nextLine()));
    }
}
//Prawdopodobnie będzie zawsze dodawanie jednego elementu z klasy (głównego), a jak usuwanie to wszystkiego