package privat24;

public class Song extends PartBroadcast {
    String song;
    String singer;
    int duration;

    public Song(String song, String singer, int duration) {
        this.song = song;
        this.singer = singer;
        this.duration = duration;
    }

    @Override
    public boolean isPaidContent() {
        return false;
    }

    @Override
    public int getDuration() {
        return duration;
    }

    public String getSong() {
        return song;
    }

    public void setSong(String song) {
        this.song = song;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    @Override
    public String getInfo() {
        return "Песня{" +
                "song='" + song + '\'' +
                ", singer='" + singer + '\'' +
                ", duration=" + duration +
                '}';
    }

    @Override
    public int getIncome() {
        return 0;
    }
}
