package shih_tsing_ting.special_topic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Measure implements Serializable {


    //一個小節的總時值
    private double measure_MAXtime;
    private ArrayList<HashMap<String,Note>> notelist;
    private HashMap<String,Note> note;

    public Measure() {
        this.notelist=new ArrayList<>();
    }

    public double getMeasure_MAXtime() {
        return measure_MAXtime;
    }

    public void setMeasure_MAXtime(double measure_MAXtime) {
        this.measure_MAXtime = measure_MAXtime;
    }

    public ArrayList<HashMap<String, Note>> getNotelist() {
        return notelist;
    }

    public void setNotelist(ArrayList<HashMap<String, Note>> notelist) {
        this.notelist = notelist;
    }


}
