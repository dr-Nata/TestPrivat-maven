package com.privat24;

import java.util.List;

public class RadioHost {
    private String name;
    private int experience;
    private List<Broadcast> broadcastList;
    private boolean mainTime;
    private String resume;

    public RadioHost(String name, List<Broadcast> broadcastList, boolean mainTime, int experience) {
        this.name = name;
        this.experience = experience;
        this.broadcastList = broadcastList;
        this.mainTime = mainTime;
    }

    public RadioHost(String name, List<Broadcast> broadcastList, boolean mainTime, String resume) {
        this.name = name;
        this.broadcastList = broadcastList;
        this.mainTime = mainTime;
        this.resume = resume;
        this.experience = -1;//Стаж не указан
    }

    public RadioHost() {
    }

    public boolean isMainTime() {
        return mainTime;
    }

    public void setMainTime(boolean mainTime) {
        this.mainTime = mainTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public List<Broadcast> getBroadcastList() {
        return broadcastList;
    }

    public void setBroadcastList(List<Broadcast> broadcastList) {
        this.broadcastList = broadcastList;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }
}
