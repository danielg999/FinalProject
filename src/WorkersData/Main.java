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
                    Company.showCompanies(companies);
                    break;
                case "2":

                    Company.addCompany(companies, console.nextLine());
                    //companies.add(new Company("Druga"));
                    break;
                case "3":
                    System.out.print("Podaj indentyfikator firmy: ");
                    Company.removeCompany(companies, Integer.parseInt(console.nextLine())-1);

                    break;
                case "4":
                    System.out.print("Podaj nazwę: ");
                    Company.searchCompany(companies, console.nextLine());
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
                                Branch.showBranches(companies, companyId);
                                break;
                            case 2:
                                Branch.addBranch(companies, companyId);
                                break;
                            case 3:
                                System.out.print("Podaj indentyfikator oddziału: ");
                                Branch.removeBranch(companies, Integer.parseInt(console.nextLine())-1);
                                break;
                            case 4:
                                System.out.print("Podaj nazwę: ");
                                Branch.searchBranch(companies, console.nextLine(), companyId);
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
                                            Department.showDepartments(companies, companyId, branchId);
                                            break;
                                        case 2:
                                            Department.addDepartment(companies, companyId, branchId);
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
                                                        Worker.showWorkers(companies, companyId, branchId, departmentId);
                                                        break;
                                                    case 2:
                                                        Worker.addWorker(companies, companyId, branchId, departmentId);
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
}
//Prawdopodobnie będzie zawsze dodawanie jednego elementu z klasy (głównego), a jak usuwanie to wszystkiego