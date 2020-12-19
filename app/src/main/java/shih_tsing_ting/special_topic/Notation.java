package shih_tsing_ting.special_topic;

import java.io.Serializable;
import java.util.ArrayList;

public class Notation implements Serializable {

    private static final long serialVersionUID = -7060210544600464481L;
    //調性
    private String tone;

    //音長表
    private NotePitchlongtable notePitchlongtable;
    //簡譜名
    private String notation_name;
    //作者名
    private String author_name;
    //速度
    private int speed;
    //拍號
    private String timesignature;

    //基準音符
    private String benchmarkNote;
    //小節
    //一個小節的總時值
    private double measure_MAXtime;
    int measure_index;

    private ArrayList<Measure> measure=new ArrayList<>();


    public Notation(String notation_name, String work_name, int speed, String tone, String timesignature) {
        this.notation_name = notation_name;
        this.author_name = work_name;
        this.speed = speed;
        this.tone=tone;
        this.timesignature=timesignature;
        switch (this.timesignature)
        {
            case "2/2":
                this.benchmarkNote="二分音符";
                this.measure_MAXtime=(int)(2*((double)60/speed)*1000);
                break;
            case "2/4":
                this.benchmarkNote="四分音符";
                this.measure_MAXtime=(int)(2*((double)60/speed)*1000);
                break;
            case "3/4":
                this.benchmarkNote="四分音符";
                this.measure_MAXtime=(int)(3*((double)60/speed)*1000);
                break;
            case "4/4":
                this.benchmarkNote="四分音符";
                this.measure_MAXtime=(int)(4*((double)60/speed)*1000);
                break;
            case "3/8":
                this.benchmarkNote="八分音符";
                this.measure_MAXtime=(int)(3*((double)60/speed)*1000);
                break;
            case "6/8":
                this.benchmarkNote="八分音符";
                this.measure_MAXtime=(int)(6*((double)60/speed)*1000);
                break;
            case "9/8":
                this.benchmarkNote="八分音符";
                this.measure_MAXtime=(int)(9*((double)60/speed)*1000);
                break;
        }
        this.notePitchlongtable =new NotePitchlongtable(this.benchmarkNote,this.speed);
    }

    public String getNotation_name() {
        return notation_name;
    }

    public void setNotation_name(String notation_name) {
        this.notation_name = notation_name;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
        switch (this.timesignature)
        {
            case "2/2":
                this.benchmarkNote="二分音符";
                this.measure_MAXtime=(int)(2*(double)(60/speed)*1000);
                break;
            case "2/4":
                this.benchmarkNote="四分音符";
                this.measure_MAXtime=(int)(2*(double)(60/speed)*1000);
                break;
            case "3/4":
                this.benchmarkNote="四分音符";
                this.measure_MAXtime=(int)(3*(double)(60/speed)*1000);
                break;
            case "4/4":
                this.benchmarkNote="四分音符";
                this.measure_MAXtime=(int)(4*(double)(60/speed)*1000);
                break;
            case "3/8":
                this.benchmarkNote="八分音符";
                this.measure_MAXtime=(int)(3*(double)(60/speed)*1000);
                break;
            case "6/8":
                this.benchmarkNote="八分音符";
                this.measure_MAXtime=(int)(6*(double)(60/speed)*1000);
                break;
            case "9/8":
                this.benchmarkNote="八分音符";
                this.measure_MAXtime=(int)(8*(double)(60/speed)*1000);
                break;
        }
        this.notePitchlongtable =new NotePitchlongtable(this.benchmarkNote,this.speed);
    }

    public double getMeasure_MAXtime() {
        return measure_MAXtime;
    }

    public String getTimesignature() {
        return timesignature;
    }

    public void setTimesignature(String timesignature) {
        this.timesignature = timesignature;
        switch (this.timesignature)
        {
            case "2/2":
                this.benchmarkNote="二分音符";
                this.measure_MAXtime=(int)(2*(double)(60/speed)*1000);
                break;
            case "2/4":
                this.benchmarkNote="四分音符";
                this.measure_MAXtime=(int)(2*(double)(60/speed)*1000);
                break;
            case "3/4":
                this.benchmarkNote="四分音符";
                this.measure_MAXtime=(int)(3*(double)(60/speed)*1000);
                break;
            case "4/4":
                this.benchmarkNote="四分音符";
                this.measure_MAXtime=(int)(4*(double)(60/speed)*1000);
                break;
            case "3/8":
                this.benchmarkNote="八分音符";
                this.measure_MAXtime=(int)(3*(double)(60/speed)*1000);
                break;
            case "6/8":
                this.benchmarkNote="八分音符";
                this.measure_MAXtime=(int)(6*(double)(60/speed)*1000);
                break;
            case "9/8":
                this.benchmarkNote="八分音符";
                this.measure_MAXtime=(int)(8*(double)(60/speed)*1000);
                break;
        }
        this.notePitchlongtable =new NotePitchlongtable(this.benchmarkNote,this.speed);
    }

    public NotePitchlongtable getNotePitchtable() {
        return notePitchlongtable;
    }


    public ArrayList<Measure> getMeasureArray() {
        return measure;
    }

    public void setMeasureArray(ArrayList<Measure> measure) {
        this.measure = measure;
    }
    public String getTone() {
        return tone;
    }

    public void setTone(String tone) {
        this.tone = tone;
    }

    public String getBenchmarkNote() {
        return benchmarkNote;
    }

    public void setBenchmarkNote(String benchmarkNote) {
        this.benchmarkNote = benchmarkNote;
    }
}
