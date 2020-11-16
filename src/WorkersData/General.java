package WorkersData;

abstract public class General{
    private static int counter = 1;
    private int counterId;

    public static int getCounter() {
        return counter;
    }

    public int getCounterId() {
        return counterId;
    }

    public void setCounterId(int counter) {
        this.counterId = counter;
    }
    General(int counterId){
        this.setCounterId(counterId);
    }

    public static void setCounter(int counter) {
        General.counter = counter;
    }

    abstract public void incrementCounter();
}
