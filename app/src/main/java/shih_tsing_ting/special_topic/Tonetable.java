package shih_tsing_ting.special_topic;

import java.io.Serializable;

//音調表
public class Tonetable implements Serializable {
    //音調
    private String tone;
    //音符音高類型
    private int notePicthNumber;

    //C3
    private int bass_Do;
    //D3
    private int bass_Re;
    //E3
    private int bass_Mi;
    //F3
    private int bass_Fa;
    //G3
    private int bass_Sol;
    //A3
    private int bass_La;
    //B3
    private int bass_Si;
    //C4
    private int mid_Do;
    //D4
    private int mid_Re;
    //E4
    private int mid_Mi;
    //F4
    private int mid_Fa;
    //G4
    private int mid_Sol;
    //A4
    private int mid_La;
    //B4
    private int mid_Si;
    //C5
    private int high_Do;
    //D5
    private int high_Re;
    //E5
    private int high_Mi;
    //F5
    private int high_Fa;
    //G5
    private int high_Sol;
    //A5
    private int high_La;
    //B5
    private int high_Si;

    //tone=Notation.getTone();
    public Tonetable(String tone,int notePicthNumber) {
        this.notePicthNumber=notePicthNumber;
        setTone(tone);
    }

    public int getBass_Do() {
        return bass_Do;
    }

    public int getBass_Re() {
        return bass_Re;
    }

    public int getBass_Mi() {
        return bass_Mi;
    }

    public int getBass_Fa() {
        return bass_Fa;
    }

    public int getBass_Sol() {
        return bass_Sol;
    }

    public int getBass_La() {
        return bass_La;
    }

    public int getBass_Si() {
        return bass_Si;
    }

    public int getMid_Do() {
        return mid_Do;
    }

    public int getMid_Re() {
        return mid_Re;
    }

    public int getMid_Mi() {
        return mid_Mi;
    }

    public int getMid_Fa() {
        return mid_Fa;
    }

    public int getMid_Sol() {
        return mid_Sol;
    }

    public int getMid_La() {
        return mid_La;
    }

    public int getMid_Si() {
        return mid_Si;
    }

    public int getHigh_Do() {
        return high_Do;
    }

    public int getHigh_Re() {
        return high_Re;
    }

    public int getHigh_Mi() {
        return high_Mi;
    }

    public int getHigh_Fa() {
        return high_Fa;
    }

    public int getHigh_Sol() {
        return high_Sol;
    }

    public int getHigh_La() {
        return high_La;
    }

    public int getHigh_Si() {
        return high_Si;
    }

    public String getTone() {
        return tone;
    }

    public void setTone(String tone) {
        this.tone = tone;
        switch (this.tone) {
            //C大調-a小調C-D-E-F-G-A-B
            case "C":
                this.bass_Do=48;
                this.bass_Re=50;
                this.bass_Mi=52;
                this.bass_Fa=53;
                this.bass_Sol=55;
                this.bass_La=57;
                this.bass_Si=59;
                this.mid_Do=60;
                this.mid_Re=62;
                this.mid_Mi=64;
                this.mid_Fa=65;
                this.mid_Sol=67;
                this.mid_La=69;
                this.mid_Si=71;
                this.high_Do=72;
                this.high_Re=74;
                this.high_Mi=76;
                this.high_Fa=77;
                this.high_Sol=79;
                this.high_La=81;
                this.high_Si=83;
                break;
            //G大調-e小調 C-D-E-F#-G-A-B
            case "G":
                this.bass_Do=48;
                this.bass_Re=50;
                this.bass_Mi=52;
                this.bass_Fa=53+1;
                this.bass_Sol=55;
                this.bass_La=57;
                this.bass_Si=59;
                this.mid_Do=60;
                this.mid_Re=62;
                this.mid_Mi=64;
                this.mid_Fa=65+1;
                this.mid_Sol=67;
                this.mid_La=69;
                this.mid_Si=71;
                this.high_Do=72;
                this.high_Re=74;
                this.high_Mi=76;
                this.high_Fa=77+1;
                this.high_Sol=79;
                this.high_La=81;
                this.high_Si=83;
                break;
            //D大調-b小調C#-D-E-F#-G-A-B
            case "D":
                this.bass_Do=48+1;
                this.bass_Re=50;
                this.bass_Mi=52;
                this.bass_Fa=53+1;
                this.bass_Sol=55;
                this.bass_La=57;
                this.bass_Si=59;
                this.mid_Do=60+1;
                this.mid_Re=62;
                this.mid_Mi=64;
                this.mid_Fa=65+1;
                this.mid_Sol=67;
                this.mid_La=69;
                this.mid_Si=71;
                this.high_Do=72+1;
                this.high_Re=74;
                this.high_Mi=76;
                this.high_Fa=77+1;
                this.high_Sol=79;
                this.high_La=81;
                this.high_Si=83;
                break;
            //A大調-F#小調C#-D-E-F#-G#-A-B
            case "A":
                this.bass_Do=48+1;
                this.bass_Re=50;
                this.bass_Mi=52;
                this.bass_Fa=53+1;
                this.bass_Sol=55+1;
                this.bass_La=57;
                this.bass_Si=59;
                this.mid_Do=60+1;
                this.mid_Re=62;
                this.mid_Mi=64;
                this.mid_Fa=65+1;
                this.mid_Sol=67+1;
                this.mid_La=69;
                this.mid_Si=71;
                this.high_Do=72+1;
                this.high_Re=74;
                this.high_Mi=76;
                this.high_Fa=77+1;
                this.high_Sol=79+1;
                this.high_La=81;
                this.high_Si=83;
                break;
            //E大調-C#小調C#-D#-E-F#-G#-A-B
            case "E":
                this.bass_Do=48+1;
                this.bass_Re=50+1;
                this.bass_Mi=52;
                this.bass_Fa=53+1;
                this.bass_Sol=55+1;
                this.bass_La=57;
                this.bass_Si=59;
                this.mid_Do=60+1;
                this.mid_Re=62+1;
                this.mid_Mi=64;
                this.mid_Fa=65+1;
                this.mid_Sol=67+1;
                this.mid_La=69;
                this.mid_Si=71;
                this.high_Do=72+1;
                this.high_Re=74+1;
                this.high_Mi=76;
                this.high_Fa=77+1;
                this.high_Sol=79+1;
                this.high_La=81;
                this.high_Si=83;
                break;
            //B大調-G#小調C#-D#-E-F#-G#-A#-B
            case "B":
                this.bass_Do=48+1;
                this.bass_Re=50+1;
                this.bass_Mi=52;
                this.bass_Fa=53+1;
                this.bass_Sol=55+1;
                this.bass_La=57+1;
                this.bass_Si=59;
                this.mid_Do=60+1;
                this.mid_Re=62+1;
                this.mid_Mi=64;
                this.mid_Fa=65+1;
                this.mid_Sol=67+1;
                this.mid_La=69+1;
                this.mid_Si=71;
                this.high_Do=72+1;
                this.high_Re=74+1;
                this.high_Mi=76;
                this.high_Fa=77+1;
                this.high_Sol=79+1;
                this.high_La=81+1;
                this.high_Si=83;
                break;
            //F#大調-d#小調Cb-Db-Eb-F-Gb-Ab-Bb
            case "F#":
                this.bass_Do=48-1;
                this.bass_Re=50-1;
                this.bass_Mi=52-1;
                this.bass_Fa=53;
                this.bass_Sol=55-1;
                this.bass_La=57-1;
                this.bass_Si=59-1;
                this.mid_Do=60-1;
                this.mid_Re=62-1;
                this.mid_Mi=64-1;
                this.mid_Fa=65;
                this.mid_Sol=67-1;
                this.mid_La=69-1;
                this.mid_Si=71-1;
                this.high_Do=72-1;
                this.high_Re=74-1;
                this.high_Mi=76-1;
                this.high_Fa=77;
                this.high_Sol=79-1;
                this.high_La=81-1;
                this.high_Si=83-1;
                break;
            //Db大調-bb小調C-Db-Eb-F-Gb-Ab-Bb
            case "Db":
                this.bass_Do=48;
                this.bass_Re=50-1;
                this.bass_Mi=52-1;
                this.bass_Fa=53;
                this.bass_Sol=55-1;
                this.bass_La=57-1;
                this.bass_Si=59-1;
                this.mid_Do=60;
                this.mid_Re=62-1;
                this.mid_Mi=64-1;
                this.mid_Fa=65;
                this.mid_Sol=67-1;
                this.mid_La=69-1;
                this.mid_Si=71-1;
                this.high_Do=72;
                this.high_Re=74-1;
                this.high_Mi=76-1;
                this.high_Fa=77;
                this.high_Sol=79-1;
                this.high_La=81-1;
                this.high_Si=83-1;
                break;
            //Ab大調-f小調C-Db-Eb-F-G-Ab-Bb
            case "Ab":
                this.bass_Do=48;
                this.bass_Re=50-1;
                this.bass_Mi=52-1;
                this.bass_Fa=53;
                this.bass_Sol=55;
                this.bass_La=57-1;
                this.bass_Si=59-1;
                this.mid_Do=60;
                this.mid_Re=62-1;
                this.mid_Mi=64-1;
                this.mid_Fa=65;
                this.mid_Sol=67;
                this.mid_La=69-1;
                this.mid_Si=71-1;
                this.high_Do=72;
                this.high_Re=74-1;
                this.high_Mi=76-1;
                this.high_Fa=77;
                this.high_Sol=79;
                this.high_La=81-1;
                this.high_Si=83-1;
                break;
            //Eb大調-C小調C-D-Eb-F-G-Ab-Bb
            case "Eb":
                this.bass_Do=48;
                this.bass_Re=50;
                this.bass_Mi=52-1;
                this.bass_Fa=53;
                this.bass_Sol=55;
                this.bass_La=57-1;
                this.bass_Si=59-1;
                this.mid_Do=60;
                this.mid_Re=62;
                this.mid_Mi=64-1;
                this.mid_Fa=65;
                this.mid_Sol=67;
                this.mid_La=69-1;
                this.mid_Si=71-1;
                this.high_Do=72;
                this.high_Re=74;
                this.high_Mi=76-1;
                this.high_Fa=77;
                this.high_Sol=79;
                this.high_La=81-1;
                this.high_Si=83-1;
                break;
            //Bb大調-g小調C-D-Eb-F-G-A-Bb
            case "Bb":
                this.bass_Do=48;
                this.bass_Re=50;
                this.bass_Mi=52-1;
                this.bass_Fa=53;
                this.bass_Sol=55;
                this.bass_La=57;
                this.bass_Si=59-1;
                this.mid_Do=60;
                this.mid_Re=62;
                this.mid_Mi=64-1;
                this.mid_Fa=65;
                this.mid_Sol=67;
                this.mid_La=69;
                this.mid_Si=71-1;
                this.high_Do=72;
                this.high_Re=74;
                this.high_Mi=76-1;
                this.high_Fa=77;
                this.high_Sol=79;
                this.high_La=81;
                this.high_Si=83-1;
                break;
            //F大調-d小調C-D-E-F-G-A-Bb
            case "F":
                this.bass_Do=48;
                this.bass_Re=50;
                this.bass_Mi=52;
                this.bass_Fa=53;
                this.bass_Sol=55;
                this.bass_La=57;
                this.bass_Si=59-1;
                this.mid_Do=60;
                this.mid_Re=62;
                this.mid_Mi=64;
                this.mid_Fa=65;
                this.mid_Sol=67;
                this.mid_La=69;
                this.mid_Si=71-1;
                this.high_Do=72;
                this.high_Re=74;
                this.high_Mi=76;
                this.high_Fa=77;
                this.high_Sol=79;
                this.high_La=81;
                this.high_Si=83-1;
                break;
        }
    }
    public int getNotePitchType() {
        return notePicthNumber;
    }
    public int resultnotePicth()
    {
        int resultnotePicth=0;
        if (getNotePitchType()==0)
            resultnotePicth=getBass_Do();
        else if(getNotePitchType()==1)
            resultnotePicth=getBass_Re();
        else if(getNotePitchType()==2)
            resultnotePicth=getBass_Mi();
        else if(getNotePitchType()==3)
            resultnotePicth=getBass_Fa();
        else if(getNotePitchType()==4)
            resultnotePicth=getBass_Sol();
        else if(getNotePitchType()==5)
            resultnotePicth=getBass_La();
        else if(getNotePitchType()==6)
            resultnotePicth=getBass_Si();
        else if (getNotePitchType()==7)
            resultnotePicth=getMid_Do();
        else if(getNotePitchType()==8)
            resultnotePicth=getMid_Re();
        else if(getNotePitchType()==9)
            resultnotePicth=getMid_Mi();
        else if(getNotePitchType()==10)
            resultnotePicth=getMid_Fa();
        else if(getNotePitchType()==11)
            resultnotePicth=getMid_Sol();
        else if(getNotePitchType()==12)
            resultnotePicth=getMid_La();
        else if(getNotePitchType()==13)
            resultnotePicth=getMid_Si();
        else if (getNotePitchType()==14)
            resultnotePicth=getHigh_Do();
        else if(getNotePitchType()==15)
            resultnotePicth=getHigh_Re();
        else if(getNotePitchType()==16)
            resultnotePicth=getHigh_Mi();
        else if(getNotePitchType()==17)
            resultnotePicth=getHigh_Fa();
        else if(getNotePitchType()==18)
            resultnotePicth=getHigh_Sol();
        else if(getNotePitchType()==19)
            resultnotePicth=getHigh_La();
        else if(getNotePitchType()==20)
            resultnotePicth=getHigh_Si();

        return resultnotePicth;
    }

    @Override
    public String toString() {
        return "Tonetable{" +
                "tone='" + tone + '\'' +
                '}';
    }

    //音調

    //還原記號調用的方法



}
