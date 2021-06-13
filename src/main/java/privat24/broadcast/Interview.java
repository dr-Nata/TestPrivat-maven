package privat24;

public class Interview extends PartBroadcast {
    String name;
    int price;
    int duration;

    public Interview() {
    }

    public Interview(String name, int duration) {
        this.name = name;
        this.price = AppConstants.PRICE_MIN_INTERVIEW;
        this.duration = duration;
    }

    @Override
    public boolean isPaidContent() {
        return true;
    }

    @Override
    public int getDuration() {
        return duration;
    }

    @Override
    public String getInfo() {
        return "Интервью{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", duration=" + duration +
                '}';
    }

    @Override
    public int getIncome() {
        return price/60*duration;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
