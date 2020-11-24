package WorkersData;

import java.time.LocalDate;
import java.util.*;

public class Worker extends Department implements PromoteWorker{
    private static int workerAmount = 0;
    private int workerId;
    private String worker;
    private Positions position;
    Worker(int counterId, String partnerShipName, LocalDate creationDate, boolean internationality, int companyId, String name, int branchId, String branch, int departmentId, String department, int workerId, String worker, Positions position) {
        super(counterId, partnerShipName, creationDate, internationality, companyId, name, branchId, branch, departmentId, department);
        this.workerId = workerId;
        this.worker = worker;
        this.position = position;
    }
    Worker(int counterId, String partnerShipName, LocalDate creationDate, boolean internationality, int companyId, String name, int branchId, String branch, int departmentId, String department) {
        super(counterId, partnerShipName, creationDate, internationality, companyId, name, branchId, branch, departmentId, department);
    }
    Worker(int counterId, String partnerShipName, LocalDate creationDate, boolean internationality, int companyId, String name, int branchId, String branch) {
        super(counterId, partnerShipName, creationDate, internationality, companyId, name, branchId, branch);
    }
    Worker(int counterId, String partnerShipName, LocalDate creationDate, boolean internationality, int companyId, String name) {
        super(counterId, partnerShipName, creationDate, internationality, companyId, name);
    }

    public String getWorker() {
        return worker;
    }

    public void setWorker(String worker) {
        this.worker = worker;
    }

    public static void showWorkers(List<Project> list, int companyId, int branchId, int departmentId){
        for(int index=0; index<list.size(); index++){
            if(list.get(index).getCompanyId() == companyId && list.get(index).getBranchId() == branchId && list.get(index).getDepartmentId() == departmentId && list.get(index).getWorker() != null && list.get(index).getProject() == null){
                System.out.println(list.get(index).getWorkerId()+". "+list.get(index).getName()+", "+list.get(index).getBranch()+", "+list.get(index).getDepartment()+", "+list.get(index).getWorker());
            }
        }
    }
    public static void addWorker(List<Project> list, int companyId, int branchId, int departmentId){
        Scanner console2 = new Scanner(System.in);
        String company = "";
        String branch = "";
        String department = "";
        boolean isCompanyFound = false;
        boolean isBranchFound = false;
        boolean isDepartmentFound = false;
        for(int index=0; index<list.size(); index++){
            if(isCompanyFound == true && isBranchFound == true && isDepartmentFound == true)
                break;
            if(isCompanyFound == false && list.get(index).getCompanyId() == companyId && list.get(index).getBranch() == null){
                company = list.get(index).getName();
                isCompanyFound = true;
            }
            if(isBranchFound == false && list.get(index).getCompanyId() == companyId && list.get(index).getBranchId() == branchId && list.get(index).getDepartment() == null){
                branch = list.get(index).getBranch();
                isBranchFound = true;
            }
            if(isDepartmentFound == false && list.get(index).getCompanyId() == companyId && list.get(index).getBranchId() == branchId && list.get(index).getDepartmentId() == departmentId && list.get(index).getWorker() == null){
                department = list.get(index).getDepartment();
                isDepartmentFound = true;
            }
        }
        System.out.print("Podaj imie i nazwisko pracownika: ");
        String fullname = console2.nextLine();
        System.out.print("Podaj stanowisko pracownika z dostępnych: ");
        Positions position = Positions.valueOf(console2.nextLine());
        list.add(new Project(General.getCounter(), Partnership.getPartnerShipName(), Partnership.getCreationDate(), Partnership.getInternationality(), companyId, company, branchId, branch, departmentId, department, Worker.workerAmount, fullname, position));
    }

    public static void removeWorker(List<Project> list, int workerId){
        //list.remove(companyId);// powinny być usuwane wszystkie po nazwie
        List<Integer> indexesToRemoveWorker = new ArrayList<Integer>();
        //System.out.println(list.size());
        for(int index=0; index<list.size(); index++){
            if(list.get(index).getWorkerId() == workerId){
                indexesToRemoveWorker.add(index);
            }
            System.out.println("List contains: "+list.get(index).getWorkerId()+", "+index);
        }
        if(indexesToRemoveWorker.size() == 0) {
            System.out.println("Podany identyfikator nie zawiera działu");
        }
        Collections.sort(indexesToRemoveWorker, Collections.reverseOrder());
        for(int index2 = 0; index2<indexesToRemoveWorker.size(); index2++){
            System.out.println("Index: "+index2+", value: "+ indexesToRemoveWorker.get(index2));
            list.remove((int)indexesToRemoveWorker.get(index2));
        }
        for(int index3=0; index3<list.size(); index3++){
            System.out.println("List contains2: "+list.get(index3).getWorkerId()+", "+index3);
        }
        indexesToRemoveWorker.clear();
    }

    public static void searchWorker(List<Project> list, String name, int companyId, int branchId, int departmentId){
        for(int index=0; index<list.size(); index++){
            if(list.get(index).getCompanyId() == companyId && list.get(index).getBranchId() == branchId && list.get(index).getDepartmentId() == departmentId && list.get(index).getWorker() != null && list.get(index).getProject() == null && list.get(index).getWorker().contains(name)){
                System.out.println(list.get(index).getWorkerId()+". "+list.get(index).getName()+", "+list.get(index).getBranch()+", "+list.get(index).getDepartment()+", "+list.get(index).getWorker());
            }
        }
    }

    public void setWorkerId(int workerId) {
        workerAmount = workerId;
        this.workerId = workerAmount;
    }

        public static int getWorkerAmount() {
        return workerAmount;
    }

    public static void setWorkerAmount(int workerAmount) {
        Worker.workerAmount = workerAmount;
    }

    public int getWorkerId() {
        return workerId;
    }

    private void showWorkerPosition(List<Project> list, int companyId, int branchId, int departmentId, int workerId){
        for(int index=0; index<list.size(); index++){
            if(list.get(index).getCompanyId() == companyId && list.get(index).getBranchId() == branchId && list.get(index).getDepartmentId() == departmentId && list.get(index).getWorker() != null && list.get(index).getProject() == null){
                System.out.println(list.get(index).getWorkerId()+". "+list.get(index).getName()+", "+list.get(index).getBranch()+", "+list.get(index).getDepartment()+", "+list.get(index).getWorker());
            }
        }
    }
    @Override
    public void PromoteWorkerPosition(int workerId) {
        Scanner console2 = new Scanner(System.in);
        for (Positions item: Positions.values()) {
            System.out.println(item.ordinal()+". "+item);
        }
        System.out.println("Obecne stanowisko: ");
        System.out.print("Podaj identyfikator stanowiska na które awansować pracownika: ");
        int position = Integer.parseInt(console2.nextLine());

    }
}
