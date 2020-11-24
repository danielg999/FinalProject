package WorkersData;

public enum Positions {
    teamManager("Team Manager"),
    teamLeader("Team Leader"),
    seniorDeveloper("Senior Developer"),
    junior("Junior"),
    seniorTester("Senior Tester");

    private final String toString;

    private Positions(String toString) {
        this.toString = toString;
    }

    public String toString() {
        return toString;
    }
}