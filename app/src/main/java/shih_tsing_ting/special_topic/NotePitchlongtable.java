package shih_tsing_ting.special_topic;

import java.io.Serializable;

public class NotePitchlongtable implements Serializable {

    //基準音符
    private String benchmarkNote;

    private double benchmarkNoteTime;
    int speed;
    private double SEC=60;

    //全音符長度
    private double fullNoteTime;
    //二分音符長度
    private double halfNoteTime;
    //四分音符長度
    private double quarterNoteTime;
    //八分音符長度
    private double eighthNoteTime;
    //十六分音符長度
    private double sixteenthNoteTime;
    //三十二分音符長度
    private double thirtysecondNoteTime;
    //附點二分音符長度
    private double attachedhalfNoteTime;
    //附點四分音符長度
    private double attachedquarterNoteTime;
    //附點八分音符長度
    private double attachedeighthNoteTime;
    //附點十六分音符長度
    private double attachedsixteenthNoteTime;
    //附點三十二分音符長度
    private double attachedthirtysecondNoteTime;

    public NotePitchlongtable(String benchmarkNote, int speed) {
        this.benchmarkNote = benchmarkNote;
        switch (this.benchmarkNote)
        {
            case "二分音符":
                this.benchmarkNoteTime=((double)SEC/speed)*1000.0;
                this.halfNoteTime=this.benchmarkNoteTime;
                this.fullNoteTime=this.halfNoteTime*2.0;
                this.quarterNoteTime=this.halfNoteTime/2.0;
                this.eighthNoteTime=this.quarterNoteTime/2.0;
                this.sixteenthNoteTime=this.eighthNoteTime/2.0;
                this.thirtysecondNoteTime =this.sixteenthNoteTime/2.0;

                this.attachedquarterNoteTime=this.quarterNoteTime+this.eighthNoteTime;
                this.attachedhalfNoteTime=this.halfNoteTime+this.quarterNoteTime;
                this.attachedeighthNoteTime=this.eighthNoteTime+this.sixteenthNoteTime;
                this.attachedsixteenthNoteTime=this.sixteenthNoteTime+this.thirtysecondNoteTime;
                this.attachedthirtysecondNoteTime =this.thirtysecondNoteTime +this.thirtysecondNoteTime /2.0;
                break;
            case "四分音符":
                this.benchmarkNoteTime=((double)SEC/speed)*1000.0;
                this.quarterNoteTime=this.benchmarkNoteTime;

                this.halfNoteTime=this.quarterNoteTime*2.0;
                this.fullNoteTime=this.halfNoteTime*2.0;

                this.eighthNoteTime=this.quarterNoteTime/2.0;
                this.sixteenthNoteTime=this.eighthNoteTime/2.0;
                this.thirtysecondNoteTime =this.sixteenthNoteTime/2.0;

                this.attachedquarterNoteTime=this.quarterNoteTime+this.eighthNoteTime;
                this.attachedhalfNoteTime=this.halfNoteTime+this.quarterNoteTime;
                this.attachedeighthNoteTime=this.eighthNoteTime+this.sixteenthNoteTime;
                this.attachedsixteenthNoteTime=this.sixteenthNoteTime+this.thirtysecondNoteTime;
                this.attachedthirtysecondNoteTime =this.thirtysecondNoteTime +this.thirtysecondNoteTime /2.0;
                break;
            case "八分音符":
                this.benchmarkNoteTime=((double)SEC/speed)*1000.0;
                this.eighthNoteTime=this.benchmarkNoteTime;

                this.quarterNoteTime=this.eighthNoteTime*2.0;
                this.halfNoteTime=this.quarterNoteTime*2.0;
                this.fullNoteTime=this.halfNoteTime*2.0;

                this.attachedquarterNoteTime=this.quarterNoteTime+this.eighthNoteTime;
                this.attachedhalfNoteTime=this.halfNoteTime+this.quarterNoteTime;
                this.attachedeighthNoteTime=this.eighthNoteTime+this.sixteenthNoteTime;
                this.attachedsixteenthNoteTime=this.sixteenthNoteTime+this.thirtysecondNoteTime;
                this.attachedthirtysecondNoteTime =this.thirtysecondNoteTime +this.thirtysecondNoteTime /2.0;
                break;
        }
    }

    public String getBenchmarkNote() {
        return benchmarkNote;
    }

    public void setBenchmarkNote(String benchmarkNote) {
        this.benchmarkNote = benchmarkNote;

    }

    public double getFullNoteTime() {
        return fullNoteTime;
    }

    public double getHalfNoteTime() {
        return halfNoteTime;
    }

    public double getQuarterNoteTime() {
        return quarterNoteTime;
    }

    public double getEighthNoteTime() {
        return eighthNoteTime;
    }

    public double getSixteenthNoteTime() {
        return sixteenthNoteTime;
    }

    public double getThirtysecondNoteTime() {
        return thirtysecondNoteTime;
    }

    public double getAttachedhalfNoteTime() {
        return attachedhalfNoteTime;
    }

    public double getAttachedquarterNoteTime() {
        return attachedquarterNoteTime;
    }

    public double getAttachedeighthNoteTime() {
        return attachedeighthNoteTime;
    }

    public double getAttachedsixteenthNoteTime() {
        return attachedsixteenthNoteTime;
    }

    public double getAttachedthirtysecondNoteTime() {
        return attachedthirtysecondNoteTime;
    }

    public double getBenchmarkNoteTime() {
        return benchmarkNoteTime;
    }

}
