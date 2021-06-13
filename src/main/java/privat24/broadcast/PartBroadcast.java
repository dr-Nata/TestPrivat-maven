package privat24;

public abstract class PartBroadcast {
    int duration;
    String info;
    boolean isPaidContent;

    public abstract boolean isPaidContent();

    public abstract int getDuration();

    public abstract String getInfo();

    public abstract int getIncome();
}
