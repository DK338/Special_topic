package shih_tsing_ting.special_topic;

import java.io.Serializable;

public class Note extends Object implements Serializable {

    private int noteTextTypeNumber;
    private int notePicthNumber;
    //Type=0是休止符=1是音符
    int Type;
    //顯示圖示
    private String picture;
    //音高
    private int pitch;
    //音程
    private double interval;
    //音調
    private String tone;
    //升記號
    private Boolean upmark;
    //降記號
    private Boolean downmark;
    //還原記號
    private Boolean restoremark;
    //休止符的建構式
    public Note(int noteTextTypeNumber,double interval) {
        this.noteTextTypeNumber=noteTextTypeNumber;
        Notetable notetable=new Notetable(this.noteTextTypeNumber);
        this.picture=notetable.resultnoteText(this.noteTextTypeNumber);
        this.interval = interval;
        this.upmark=false;
        this.downmark=false;
        this.restoremark=false;
        this.Type=0;
    }
    //音符建構式(tone=Notation.getTone)
    public Note(String tone, int noteTextTypeNumber,int notePicthNumber, double interval,Boolean upmark,Boolean downmark,Boolean restoremark) {
        this.noteTextTypeNumber=noteTextTypeNumber;
        this.notePicthNumber=notePicthNumber;
        this.tone=tone;
        this.Type=1;
        Notetable notetable=new Notetable(noteTextTypeNumber,notePicthNumber);
        Tonetable tonetable=new Tonetable(tone,notePicthNumber);
        this.upmark=upmark;
        this.downmark=downmark;
        this.restoremark=restoremark;
        this.picture=notetable.resultnoteText(noteTextTypeNumber,notePicthNumber);
        this.pitch = tonetable.resultnotePicth();
        if (this.upmark==true)
        {
            this.picture="P"+notetable.resultnoteText(noteTextTypeNumber,notePicthNumber);
            this.pitch = tonetable.resultnotePicth()+1;
        }
        if (this.downmark==true)
        {
            this.picture=":"+notetable.resultnoteText(noteTextTypeNumber,notePicthNumber);
            this.pitch = tonetable.resultnotePicth()-1;
        }
        if(this.restoremark==true)
        {
            tonetable=new Tonetable("C",notePicthNumber);
            this.picture="L"+notetable.resultnoteText(noteTextTypeNumber,notePicthNumber);
            this.pitch=tonetable.resultnotePicth();
        }



        this.interval = interval;
    }


    public int getPitch() {
        return pitch;
    }

    public void setPitch(int pitch) {
        this.pitch = pitch;
    }

    public double getInterval() {
        return interval;
    }

    public void setInterval(double interval) {
        this.interval = interval;
    }

    public String getTone() {
        return tone;
    }

    public void setTone(String tone) {
        this.tone = tone;
    }

    public Boolean getUpmark() {
        return upmark;
    }

    public void setUpmark(Boolean upmark) {
        this.upmark = upmark;
    }

    public Boolean getDownmark() {
        return downmark;
    }

    public void setDownmark(Boolean downmark) {
        this.downmark = downmark;
    }

    public Boolean getRestoremark() {
        return restoremark;
    }

    public void setRestoremark(Boolean restoremark) {
        this.restoremark = restoremark;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public int getNoteTextTypeNumber() {
        return noteTextTypeNumber;
    }

    public void setNoteTextTypeNumber(int noteTextTypeNumber) {
        this.noteTextTypeNumber = noteTextTypeNumber;
    }

    public int getnotePicthNumber() {
        return notePicthNumber;
    }

    public void setnotePicthNumber(int notePicthNumber) {
        this.notePicthNumber = notePicthNumber;
    }
}
