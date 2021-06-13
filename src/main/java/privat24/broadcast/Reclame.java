package privat24;

public class Reclame extends PartBroadcast {
    String title;
    int price;
    int duration;

    public Reclame(String title, int duration) {
        this.title = title;
        this.duration = duration;
        this.price = AppConstants.PRICE_SEC_RECLAME;
    }

    @Override
    public boolean isPaidContent() {
        return true;
    }

    @Override
    public int getDuration() {
        return duration;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String getInfo() {
        return "Реклама{" +
                "title='" + title + '\'' +
                ", price=" + price +
                ", duration=" + duration +
                '}';
    }

    @Override
    public int getIncome() {
       return price*duration;
    }
}
