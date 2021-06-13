package privat24;

import java.util.List;

public class Broadcast {
    int durationMin; //min
    List<PartBroadcast> partBroadcastList;

    public Broadcast(int durationMin, List<PartBroadcast> partBroadcastList) {
        this.durationMin = durationMin;
        this.partBroadcastList = partBroadcastList;
    }

    public int getDurationMin() {
        return durationMin;
    }

    public void setDurationMin(int durationMin) {
        this.durationMin = durationMin;
    }

    public List<PartBroadcast> getPartBroadcastList() {
        return partBroadcastList;
    }

    public void setPartBroadcastList(List<PartBroadcast> partBroadcastList) {
        this.partBroadcastList = partBroadcastList;
    }

    public int getSumDuration() {
       return partBroadcastList.stream().mapToInt(PartBroadcast::getDuration).sum();
    }

    public int getDurationPaidContent() {
        int sum = 0;
        for (PartBroadcast partBroadcast : partBroadcastList) {
            if (partBroadcast.isPaidContent)
                sum += partBroadcast.getDuration();
        }
        return sum;
    }

    public int getIncome() {
        int sumIncome = 0;
        for (PartBroadcast partBroadcast : partBroadcastList) {
            sumIncome += partBroadcast.getIncome();
        }
        return sumIncome;
    }
}
