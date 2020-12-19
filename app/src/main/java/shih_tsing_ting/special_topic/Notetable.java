package shih_tsing_ting.special_topic;

import java.io.Serializable;

public class Notetable implements Serializable {
    //音符長度類型
    private int noteTextTypeNumber;
    //音符音高類型
    private int notePicthNumber;

    //休止符
    private String notestop_text;
    //C3
    private String bass_Do_text;
    //D3
    private String bass_Re_text;
    //E3
    private String bass_Mi_text;
    //F3
    private String bass_Fa_text;
    //G3
    private String bass_Sol_text;
    //A3
    private String bass_La_text;
    //B3
    private String bass_Si_text;
    //C4
    private String mid_Do_text;
    //D4
    private String mid_Re_text;
    //E4
    private String mid_Mi_text;
    //F4
    private String mid_Fa_text;
    //G4
    private String mid_Sol_text;
    //A4
    private String mid_La_text;
    //B4
    private String mid_Si_text;
    //C5
    private String high_Do_text;
    //D5
    private String high_Re_text;
    //E5
    private String high_Mi_text;
    //F5
    private String high_Fa_text;
    //G5
    private String high_Sol_text;
    //A5
    private String high_La_text;
    //B5
    private String high_Si_text;

    //休止符Text
    public Notetable(int noteTextTypeNumber)
    {
        this.noteTextTypeNumber=noteTextTypeNumber;
        switch (this.noteTextTypeNumber)
        {
            //全休止符=0
            case 0:
                this.notestop_text="`///";
                break;
                //二分休止符=1
            case 1:
                this.notestop_text="`/";
                break;
                //四分休止符=2
            case 2:
                this.notestop_text="`";
                break;
                //八分休止符=3
            case 3:
                this.notestop_text="p";
                break;
                //十六分休止符=4
            case 4:
                this.notestop_text=";";
                break;
                //三十二分休止符=5
            case 5:
                this.notestop_text=";,";
                break;
                //附點二分休止符=6
            case 6:
                this.notestop_text="`/.";
                break;
                //附點四分休止符=7
            case 7:
                this.notestop_text="`.";
                break;
                //附點八分休止符=8
            case 8:
                this.notestop_text="p.";
                break;
                //附點十六分休止符=9
            case 9:
                this.notestop_text=";.";
                break;
                //附點三十二分休止符=10
            case 10:
                this.notestop_text=";,.";
                break;
        }
    }

    //音符Text
    public Notetable(int noteTextTypeNumber,int notePicthNumber)
    {
        this.noteTextTypeNumber=noteTextTypeNumber;
        this.notePicthNumber=notePicthNumber;
        switch (this.noteTextTypeNumber)
        {
            //全音符=0
            case 0:
                this.notestop_text="`///";
                this.bass_Do_text="18///";
                this.bass_Re_text="28///";
                this.bass_Mi_text="38///";
                this.bass_Fa_text="48///";
                this.bass_Sol_text="58///";
                this.bass_La_text="68///";
                this.bass_Si_text="78///";
                this.mid_Do_text="1///";
                this.mid_Re_text="2///";
                this.mid_Mi_text="3///";
                this.mid_Fa_text="4///";
                this.mid_Sol_text="5///";
                this.mid_La_text="6///";
                this.mid_Si_text="7///";
                this.high_Do_text="!///";
                this.high_Re_text="@///";
                this.high_Mi_text="#///";
                this.high_Fa_text="$///";
                this.high_Sol_text="%///";
                this.high_La_text="^///";
                this.high_Si_text="&///";
                break;
                //二分音符=1
            case 1:
                this.notestop_text="`/";
                this.bass_Do_text="18/";
                this.bass_Re_text="28/";
                this.bass_Mi_text="38/";
                this.bass_Fa_text="48/";
                this.bass_Sol_text="58/";
                this.bass_La_text="68/";
                this.bass_Si_text="78/";
                this.mid_Do_text="1/";
                this.mid_Re_text="2/";
                this.mid_Mi_text="3/";
                this.mid_Fa_text="4/";
                this.mid_Sol_text="5/";
                this.mid_La_text="6/";
                this.mid_Si_text="7/";
                this.high_Do_text="!/";
                this.high_Re_text="@/";
                this.high_Mi_text="#/";
                this.high_Fa_text="$/";
                this.high_Sol_text="%/";
                this.high_La_text="^/";
                this.high_Si_text="&/";
                break;
                //四分音符=2
            case 2:
                this.notestop_text="`";
                this.bass_Do_text="18";
                this.bass_Re_text="28";
                this.bass_Mi_text="38";
                this.bass_Fa_text="48";
                this.bass_Sol_text="58";
                this.bass_La_text="68";
                this.bass_Si_text="78";
                this.mid_Do_text="1";
                this.mid_Re_text="2";
                this.mid_Mi_text="3";
                this.mid_Fa_text="4";
                this.mid_Sol_text="5";
                this.mid_La_text="6";
                this.mid_Si_text="7";
                this.high_Do_text="!";
                this.high_Re_text="@";
                this.high_Mi_text="#";
                this.high_Fa_text="$";
                this.high_Sol_text="%";
                this.high_La_text="^";
                this.high_Si_text="&";
                break;
                //八分音符=3
            case 3:
                this.notestop_text="p";
                this.bass_Do_text="qi";
                this.bass_Re_text="wi";
                this.bass_Mi_text="ei";
                this.bass_Fa_text="ri";
                this.bass_Sol_text="ti";
                this.bass_La_text="yi";
                this.bass_Si_text="ui";
                this.mid_Do_text="q";
                this.mid_Re_text="w";
                this.mid_Mi_text="e";
                this.mid_Fa_text="r";
                this.mid_Sol_text="t";
                this.mid_La_text="y";
                this.mid_Si_text="u";
                this.high_Do_text="Q";
                this.high_Re_text="W";
                this.high_Mi_text="E";
                this.high_Fa_text="R";
                this.high_Sol_text="T";
                this.high_La_text="Y";
                this.high_Si_text="U";
                break;
                //十六分音符=4
            case 4:
                this.notestop_text=";";
                this.bass_Do_text="ak";
                this.bass_Re_text="sk";
                this.bass_Mi_text="dk";
                this.bass_Fa_text="fk";
                this.bass_Sol_text="gk";
                this.bass_La_text="hk";
                this.bass_Si_text="jk";
                this.mid_Do_text="a";
                this.mid_Re_text="s";
                this.mid_Mi_text="d";
                this.mid_Fa_text="f";
                this.mid_Sol_text="g";
                this.mid_La_text="h";
                this.mid_Si_text="j";
                this.high_Do_text="A";
                this.high_Re_text="S";
                this.high_Mi_text="D";
                this.high_Fa_text="F";
                this.high_Sol_text="G";
                this.high_La_text="H";
                this.high_Si_text="J";
                break;
                //三十二分音符=5
            case 5:
                this.notestop_text=";,";
                this.bass_Do_text="z,";
                this.bass_Re_text="x,";
                this.bass_Mi_text="c,";
                this.bass_Fa_text="v,";
                this.bass_Sol_text="b,";
                this.bass_La_text="n,";
                this.bass_Si_text="m,";
                this.mid_Do_text="z";
                this.mid_Re_text="x";
                this.mid_Mi_text="c";
                this.mid_Fa_text="v";
                this.mid_Sol_text="b";
                this.mid_La_text="n";
                this.mid_Si_text="m";
                this.high_Do_text="Z";
                this.high_Re_text="X";
                this.high_Mi_text="C";
                this.high_Fa_text="V";
                this.high_Sol_text="B";
                this.high_La_text="N";
                this.high_Si_text="M";
                break;
                //附點二分音符=6
            case 6:
                this.notestop_text="`/.";
                this.bass_Do_text="18/.";
                this.bass_Re_text="28/.";
                this.bass_Mi_text="38/.";
                this.bass_Fa_text="48/.";
                this.bass_Sol_text="58/.";
                this.bass_La_text="68/.";
                this.bass_Si_text="78/.";
                this.mid_Do_text="1/.";
                this.mid_Re_text="2/.";
                this.mid_Mi_text="3/.";
                this.mid_Fa_text="4/.";
                this.mid_Sol_text="5/.";
                this.mid_La_text="6/.";
                this.mid_Si_text="7/.";
                this.high_Do_text="!/.";
                this.high_Re_text="@/.";
                this.high_Mi_text="#/.";
                this.high_Fa_text="$/.";
                this.high_Sol_text="%/.";
                this.high_La_text="^/.";
                this.high_Si_text="&/.";
                break;
                //附點四分音符=7
            case 7:
                this.notestop_text="`.";
                this.bass_Do_text="18.";
                this.bass_Re_text="28.";
                this.bass_Mi_text="38.";
                this.bass_Fa_text="48.";
                this.bass_Sol_text="58.";
                this.bass_La_text="68.";
                this.bass_Si_text="78.";
                this.mid_Do_text="1.";
                this.mid_Re_text="2.";
                this.mid_Mi_text="3.";
                this.mid_Fa_text="4.";
                this.mid_Sol_text="5.";
                this.mid_La_text="6.";
                this.mid_Si_text="7.";
                this.high_Do_text="!.";
                this.high_Re_text="@.";
                this.high_Mi_text="#.";
                this.high_Fa_text="$.";
                this.high_Sol_text="%.";
                this.high_La_text="^.";
                this.high_Si_text="&.";
                break;
                //附點八分音符=8
            case 8:
                this.notestop_text="p.";
                this.bass_Do_text="qi.";
                this.bass_Re_text="wi.";
                this.bass_Mi_text="ei.";
                this.bass_Fa_text="ri.";
                this.bass_Sol_text="ti.";
                this.bass_La_text="yi.";
                this.bass_Si_text="ui.";
                this.mid_Do_text="q.";
                this.mid_Re_text="w.";
                this.mid_Mi_text="e.";
                this.mid_Fa_text="r.";
                this.mid_Sol_text="t.";
                this.mid_La_text="y.";
                this.mid_Si_text="u.";
                this.high_Do_text="Q.";
                this.high_Re_text="W.";
                this.high_Mi_text="E.";
                this.high_Fa_text="R.";
                this.high_Sol_text="T.";
                this.high_La_text="Y.";
                this.high_Si_text="U.";
                break;
                //附點十六分音符=9
            case 9:
                this.notestop_text=";.";
                this.bass_Do_text="ak.";
                this.bass_Re_text="sk.";
                this.bass_Mi_text="dk.";
                this.bass_Fa_text="fk.";
                this.bass_Sol_text="gk.";
                this.bass_La_text="hk.";
                this.bass_Si_text="jk.";
                this.mid_Do_text="a.";
                this.mid_Re_text="s.";
                this.mid_Mi_text="d.";
                this.mid_Fa_text="f.";
                this.mid_Sol_text="g.";
                this.mid_La_text="h.";
                this.mid_Si_text="j.";
                this.high_Do_text="A.";
                this.high_Re_text="S.";
                this.high_Mi_text="D.";
                this.high_Fa_text="F.";
                this.high_Sol_text="G.";
                this.high_La_text="H.";
                this.high_Si_text="J.";
                break;
                //附點三十二分音符=10
            case 10:
                this.notestop_text=";,.";
                this.bass_Do_text="z,.";
                this.bass_Re_text="x,.";
                this.bass_Mi_text="c,.";
                this.bass_Fa_text="v,.";
                this.bass_Sol_text="b,.";
                this.bass_La_text="n,.";
                this.bass_Si_text="m,.";
                this.mid_Do_text="z.";
                this.mid_Re_text="x.";
                this.mid_Mi_text="c.";
                this.mid_Fa_text="v.";
                this.mid_Sol_text="b.";
                this.mid_La_text="n.";
                this.mid_Si_text="m.";
                this.high_Do_text="Z.";
                this.high_Re_text="X.";
                this.high_Mi_text="C.";
                this.high_Fa_text="V.";
                this.high_Sol_text="B.";
                this.high_La_text="N.";
                this.high_Si_text="M.";
                break;
        }
    }


    public String getNotestop_text() {
        return notestop_text;
    }

    public String getBass_Do_text() {
        return bass_Do_text;
    }

    public String getBass_Re_text() {
        return bass_Re_text;
    }

    public String getBass_Mi_text() {
        return bass_Mi_text;
    }

    public String getBass_Fa_text() {
        return bass_Fa_text;
    }

    public String getBass_Sol_text() {
        return bass_Sol_text;
    }

    public String getBass_La_text() {
        return bass_La_text;
    }

    public String getBass_Si_text() {
        return bass_Si_text;
    }

    public String getMid_Do_text() {
        return mid_Do_text;
    }

    public String getMid_Re_text() {
        return mid_Re_text;
    }

    public String getMid_Mi_text() {
        return mid_Mi_text;
    }

    public String getMid_Fa_text() {
        return mid_Fa_text;
    }

    public String getMid_Sol_text() {
        return mid_Sol_text;
    }

    public String getMid_La_text() {
        return mid_La_text;
    }

    public String getMid_Si_text() {
        return mid_Si_text;
    }

    public String getHigh_Do_text() {
        return high_Do_text;
    }

    public String getHigh_Re_text() {
        return high_Re_text;
    }

    public String getHigh_Mi_text() {
        return high_Mi_text;
    }

    public String getHigh_Fa_text() {
        return high_Fa_text;
    }

    public String getHigh_Sol_text() {
        return high_Sol_text;
    }

    public String getHigh_La_text() {
        return high_La_text;
    }

    public String getHigh_Si_text() {
        return high_Si_text;
    }
    public int getnoteTextTypeNumber() {
        return noteTextTypeNumber;
    }
    public int getnotePicthNumber() {
        return notePicthNumber;
    }

    public String resultnoteText(int noteTextTypeNumber)
    {
        String resultnotetext="";
        switch (noteTextTypeNumber)
        {
            case 0:
                resultnotetext=getNotestop_text();
                break;
            case 1:
                resultnotetext=getNotestop_text();
                break;
            case 2:
                resultnotetext=getNotestop_text();
                break;
            case 3:
                resultnotetext=getNotestop_text();
                break;
            case 4:
                resultnotetext=getNotestop_text();
                break;
            case 5:
                resultnotetext=getNotestop_text();
                break;
            case 6:
                resultnotetext=getNotestop_text();
                break;
            case 7:
                resultnotetext=getNotestop_text();
                break;
            case 8:
                resultnotetext=getNotestop_text();
                break;
            case 9:
                resultnotetext=getNotestop_text();
                break;
            case 10:
                resultnotetext=getNotestop_text();
                break;
        }
        return resultnotetext;
    }

    public String resultnoteText(int noteTextTypeNumber,int notePicthNumber)
    {
        String resultnotetext="";
        if (noteTextTypeNumber==0&&notePicthNumber==0)
            resultnotetext=getBass_Do_text();
        else if (noteTextTypeNumber==0&&notePicthNumber==1)
            resultnotetext=getBass_Re_text();
        else if (noteTextTypeNumber==0&&notePicthNumber==2)
            resultnotetext=getBass_Mi_text();
        else if (noteTextTypeNumber==0&&notePicthNumber==3)
            resultnotetext=getBass_Fa_text();
        else if (noteTextTypeNumber==0&&notePicthNumber==4)
            resultnotetext=getBass_Sol_text();
        else if (noteTextTypeNumber==0&&notePicthNumber==5)
            resultnotetext=getBass_La_text();
        else if (noteTextTypeNumber==0&&notePicthNumber==6)
            resultnotetext=getBass_Si_text();
        else if (noteTextTypeNumber==0&&notePicthNumber==7)
            resultnotetext=getMid_Do_text();
        else if (noteTextTypeNumber==0&&notePicthNumber==8)
            resultnotetext=getMid_Re_text();
        else if (noteTextTypeNumber==0&&notePicthNumber==9)
            resultnotetext=getMid_Mi_text();
        else if (noteTextTypeNumber==0&&notePicthNumber==10)
            resultnotetext=getMid_Fa_text();
        else if (noteTextTypeNumber==0&&notePicthNumber==11)
            resultnotetext=getMid_Sol_text();
        else if (noteTextTypeNumber==0&&notePicthNumber==12)
            resultnotetext=getMid_La_text();
        else if (noteTextTypeNumber==0&&notePicthNumber==13)
            resultnotetext=getMid_Si_text();
        else if (noteTextTypeNumber==0&&notePicthNumber==14)
            resultnotetext=getHigh_Do_text();
        else if (noteTextTypeNumber==0&&notePicthNumber==15)
            resultnotetext=getHigh_Re_text();
        else if (noteTextTypeNumber==0&&notePicthNumber==16)
            resultnotetext=getHigh_Mi_text();
        else if (noteTextTypeNumber==0&&notePicthNumber==17)
            resultnotetext=getHigh_Fa_text();
        else if (noteTextTypeNumber==0&&notePicthNumber==18)
            resultnotetext=getHigh_Sol_text();
        else if (noteTextTypeNumber==0&&notePicthNumber==19)
            resultnotetext=getHigh_La_text();
        else if (noteTextTypeNumber==0&&notePicthNumber==20)
            resultnotetext=getHigh_Si_text();
        else if (noteTextTypeNumber==1&&notePicthNumber==0)
            resultnotetext=getBass_Do_text();
        else if (noteTextTypeNumber==1&&notePicthNumber==1)
            resultnotetext=getBass_Re_text();
        else if (noteTextTypeNumber==1&&notePicthNumber==2)
            resultnotetext=getBass_Mi_text();
        else if (noteTextTypeNumber==1&&notePicthNumber==3)
            resultnotetext=getBass_Fa_text();
        else if (noteTextTypeNumber==1&&notePicthNumber==4)
            resultnotetext=getBass_Sol_text();
        else if (noteTextTypeNumber==1&&notePicthNumber==5)
            resultnotetext=getBass_La_text();
        else if (noteTextTypeNumber==1&&notePicthNumber==6)
            resultnotetext=getBass_Si_text();
        else if (noteTextTypeNumber==1&&notePicthNumber==7)
            resultnotetext=getMid_Do_text();
        else if (noteTextTypeNumber==1&&notePicthNumber==8)
            resultnotetext=getMid_Re_text();
        else if (noteTextTypeNumber==1&&notePicthNumber==9)
            resultnotetext=getMid_Mi_text();
        else if (noteTextTypeNumber==1&&notePicthNumber==10)
            resultnotetext=getMid_Fa_text();
        else if (noteTextTypeNumber==1&&notePicthNumber==11)
            resultnotetext=getMid_Sol_text();
        else if (noteTextTypeNumber==1&&notePicthNumber==12)
            resultnotetext=getMid_La_text();
        else if (noteTextTypeNumber==1&&notePicthNumber==13)
            resultnotetext=getMid_Si_text();
        else if (noteTextTypeNumber==1&&notePicthNumber==14)
            resultnotetext=getHigh_Do_text();
        else if (noteTextTypeNumber==1&&notePicthNumber==15)
            resultnotetext=getHigh_Re_text();
        else if (noteTextTypeNumber==1&&notePicthNumber==16)
            resultnotetext=getHigh_Mi_text();
        else if (noteTextTypeNumber==1&&notePicthNumber==17)
            resultnotetext=getHigh_Fa_text();
        else if (noteTextTypeNumber==1&&notePicthNumber==18)
            resultnotetext=getHigh_Sol_text();
        else if (noteTextTypeNumber==1&&notePicthNumber==19)
            resultnotetext=getHigh_La_text();
        else if (noteTextTypeNumber==1&&notePicthNumber==20)
            resultnotetext=getHigh_Si_text();
        else if (noteTextTypeNumber==2&&notePicthNumber==0)
            resultnotetext=getBass_Do_text();
        else if (noteTextTypeNumber==2&&notePicthNumber==1)
            resultnotetext=getBass_Re_text();
        else if (noteTextTypeNumber==2&&notePicthNumber==2)
            resultnotetext=getBass_Mi_text();
        else if (noteTextTypeNumber==2&&notePicthNumber==3)
            resultnotetext=getBass_Fa_text();
        else if (noteTextTypeNumber==2&&notePicthNumber==4)
            resultnotetext=getBass_Sol_text();
        else if (noteTextTypeNumber==2&&notePicthNumber==5)
            resultnotetext=getBass_La_text();
        else if (noteTextTypeNumber==2&&notePicthNumber==6)
            resultnotetext=getBass_Si_text();
        else if (noteTextTypeNumber==2&&notePicthNumber==7)
            resultnotetext=getMid_Do_text();
        else if (noteTextTypeNumber==2&&notePicthNumber==8)
            resultnotetext=getMid_Re_text();
        else if (noteTextTypeNumber==2&&notePicthNumber==9)
            resultnotetext=getMid_Mi_text();
        else if (noteTextTypeNumber==2&&notePicthNumber==10)
            resultnotetext=getMid_Fa_text();
        else if (noteTextTypeNumber==2&&notePicthNumber==11)
            resultnotetext=getMid_Sol_text();
        else if (noteTextTypeNumber==2&&notePicthNumber==12)
            resultnotetext=getMid_La_text();
        else if (noteTextTypeNumber==2&&notePicthNumber==13)
            resultnotetext=getMid_Si_text();
        else if (noteTextTypeNumber==2&&notePicthNumber==14)
            resultnotetext=getHigh_Do_text();
        else if (noteTextTypeNumber==2&&notePicthNumber==15)
            resultnotetext=getHigh_Re_text();
        else if (noteTextTypeNumber==2&&notePicthNumber==16)
            resultnotetext=getHigh_Mi_text();
        else if (noteTextTypeNumber==2&&notePicthNumber==17)
            resultnotetext=getHigh_Fa_text();
        else if (noteTextTypeNumber==2&&notePicthNumber==18)
            resultnotetext=getHigh_Sol_text();
        else if (noteTextTypeNumber==2&&notePicthNumber==19)
            resultnotetext=getHigh_La_text();
        else if (noteTextTypeNumber==2&&notePicthNumber==20)
            resultnotetext=getHigh_Si_text();
        else if (noteTextTypeNumber==3&&notePicthNumber==0)
            resultnotetext=getBass_Do_text();
        else if (noteTextTypeNumber==3&&notePicthNumber==1)
            resultnotetext=getBass_Re_text();
        else if (noteTextTypeNumber==3&&notePicthNumber==2)
            resultnotetext=getBass_Mi_text();
        else if (noteTextTypeNumber==3&&notePicthNumber==3)
            resultnotetext=getBass_Fa_text();
        else if (noteTextTypeNumber==3&&notePicthNumber==4)
            resultnotetext=getBass_Sol_text();
        else if (noteTextTypeNumber==3&&notePicthNumber==5)
            resultnotetext=getBass_La_text();
        else if (noteTextTypeNumber==3&&notePicthNumber==6)
            resultnotetext=getBass_Si_text();
        else if (noteTextTypeNumber==3&&notePicthNumber==7)
            resultnotetext=getMid_Do_text();
        else if (noteTextTypeNumber==3&&notePicthNumber==8)
            resultnotetext=getMid_Re_text();
        else if (noteTextTypeNumber==3&&notePicthNumber==9)
            resultnotetext=getMid_Mi_text();
        else if (noteTextTypeNumber==3&&notePicthNumber==10)
            resultnotetext=getMid_Fa_text();
        else if (noteTextTypeNumber==3&&notePicthNumber==11)
            resultnotetext=getMid_Sol_text();
        else if (noteTextTypeNumber==3&&notePicthNumber==12)
            resultnotetext=getMid_La_text();
        else if (noteTextTypeNumber==3&&notePicthNumber==13)
            resultnotetext=getMid_Si_text();
        else if (noteTextTypeNumber==3&&notePicthNumber==14)
            resultnotetext=getHigh_Do_text();
        else if (noteTextTypeNumber==3&&notePicthNumber==15)
            resultnotetext=getHigh_Re_text();
        else if (noteTextTypeNumber==3&&notePicthNumber==16)
            resultnotetext=getHigh_Mi_text();
        else if (noteTextTypeNumber==3&&notePicthNumber==17)
            resultnotetext=getHigh_Fa_text();
        else if (noteTextTypeNumber==3&&notePicthNumber==18)
            resultnotetext=getHigh_Sol_text();
        else if (noteTextTypeNumber==3&&notePicthNumber==19)
            resultnotetext=getHigh_La_text();
        else if (noteTextTypeNumber==3&&notePicthNumber==20)
            resultnotetext=getHigh_Si_text();
        else if (noteTextTypeNumber==4&&notePicthNumber==0)
            resultnotetext=getBass_Do_text();
        else if (noteTextTypeNumber==4&&notePicthNumber==1)
            resultnotetext=getBass_Re_text();
        else if (noteTextTypeNumber==4&&notePicthNumber==2)
            resultnotetext=getBass_Mi_text();
        else if (noteTextTypeNumber==4&&notePicthNumber==3)
            resultnotetext=getBass_Fa_text();
        else if (noteTextTypeNumber==4&&notePicthNumber==4)
            resultnotetext=getBass_Sol_text();
        else if (noteTextTypeNumber==4&&notePicthNumber==5)
            resultnotetext=getBass_La_text();
        else if (noteTextTypeNumber==4&&notePicthNumber==6)
            resultnotetext=getBass_Si_text();
        else if (noteTextTypeNumber==4&&notePicthNumber==7)
            resultnotetext=getMid_Do_text();
        else if (noteTextTypeNumber==4&&notePicthNumber==8)
            resultnotetext=getMid_Re_text();
        else if (noteTextTypeNumber==4&&notePicthNumber==9)
            resultnotetext=getMid_Mi_text();
        else if (noteTextTypeNumber==4&&notePicthNumber==10)
            resultnotetext=getMid_Fa_text();
        else if (noteTextTypeNumber==4&&notePicthNumber==11)
            resultnotetext=getMid_Sol_text();
        else if (noteTextTypeNumber==4&&notePicthNumber==12)
            resultnotetext=getMid_La_text();
        else if (noteTextTypeNumber==4&&notePicthNumber==13)
            resultnotetext=getMid_Si_text();
        else if (noteTextTypeNumber==4&&notePicthNumber==14)
            resultnotetext=getHigh_Do_text();
        else if (noteTextTypeNumber==4&&notePicthNumber==15)
            resultnotetext=getHigh_Re_text();
        else if (noteTextTypeNumber==4&&notePicthNumber==16)
            resultnotetext=getHigh_Mi_text();
        else if (noteTextTypeNumber==4&&notePicthNumber==17)
            resultnotetext=getHigh_Fa_text();
        else if (noteTextTypeNumber==4&&notePicthNumber==18)
            resultnotetext=getHigh_Sol_text();
        else if (noteTextTypeNumber==4&&notePicthNumber==19)
            resultnotetext=getHigh_La_text();
        else if (noteTextTypeNumber==4&&notePicthNumber==20)
            resultnotetext=getHigh_Si_text();
        else if (noteTextTypeNumber==5&&notePicthNumber==0)
            resultnotetext=getBass_Do_text();
        else if (noteTextTypeNumber==5&&notePicthNumber==1)
            resultnotetext=getBass_Re_text();
        else if (noteTextTypeNumber==5&&notePicthNumber==2)
            resultnotetext=getBass_Mi_text();
        else if (noteTextTypeNumber==5&&notePicthNumber==3)
            resultnotetext=getBass_Fa_text();
        else if (noteTextTypeNumber==5&&notePicthNumber==4)
            resultnotetext=getBass_Sol_text();
        else if (noteTextTypeNumber==5&&notePicthNumber==5)
            resultnotetext=getBass_La_text();
        else if (noteTextTypeNumber==5&&notePicthNumber==6)
            resultnotetext=getBass_Si_text();
        else if (noteTextTypeNumber==5&&notePicthNumber==7)
            resultnotetext=getMid_Do_text();
        else if (noteTextTypeNumber==5&&notePicthNumber==8)
            resultnotetext=getMid_Re_text();
        else if (noteTextTypeNumber==5&&notePicthNumber==9)
            resultnotetext=getMid_Mi_text();
        else if (noteTextTypeNumber==5&&notePicthNumber==10)
            resultnotetext=getMid_Fa_text();
        else if (noteTextTypeNumber==5&&notePicthNumber==11)
            resultnotetext=getMid_Sol_text();
        else if (noteTextTypeNumber==5&&notePicthNumber==12)
            resultnotetext=getMid_La_text();
        else if (noteTextTypeNumber==5&&notePicthNumber==13)
            resultnotetext=getMid_Si_text();
        else if (noteTextTypeNumber==5&&notePicthNumber==14)
            resultnotetext=getHigh_Do_text();
        else if (noteTextTypeNumber==5&&notePicthNumber==15)
            resultnotetext=getHigh_Re_text();
        else if (noteTextTypeNumber==5&&notePicthNumber==16)
            resultnotetext=getHigh_Mi_text();
        else if (noteTextTypeNumber==5&&notePicthNumber==17)
            resultnotetext=getHigh_Fa_text();
        else if (noteTextTypeNumber==5&&notePicthNumber==18)
            resultnotetext=getHigh_Sol_text();
        else if (noteTextTypeNumber==5&&notePicthNumber==19)
            resultnotetext=getHigh_La_text();
        else if (noteTextTypeNumber==5&&notePicthNumber==20)
            resultnotetext=getHigh_Si_text();
        else if (noteTextTypeNumber==6&&notePicthNumber==0)
            resultnotetext=getBass_Do_text();
        else if (noteTextTypeNumber==6&&notePicthNumber==1)
            resultnotetext=getBass_Re_text();
        else if (noteTextTypeNumber==6&&notePicthNumber==2)
            resultnotetext=getBass_Mi_text();
        else if (noteTextTypeNumber==6&&notePicthNumber==3)
            resultnotetext=getBass_Fa_text();
        else if (noteTextTypeNumber==6&&notePicthNumber==4)
            resultnotetext=getBass_Sol_text();
        else if (noteTextTypeNumber==6&&notePicthNumber==5)
            resultnotetext=getBass_La_text();
        else if (noteTextTypeNumber==6&&notePicthNumber==6)
            resultnotetext=getBass_Si_text();
        else if (noteTextTypeNumber==6&&notePicthNumber==7)
            resultnotetext=getMid_Do_text();
        else if (noteTextTypeNumber==6&&notePicthNumber==8)
            resultnotetext=getMid_Re_text();
        else if (noteTextTypeNumber==6&&notePicthNumber==9)
            resultnotetext=getMid_Mi_text();
        else if (noteTextTypeNumber==6&&notePicthNumber==10)
            resultnotetext=getMid_Fa_text();
        else if (noteTextTypeNumber==6&&notePicthNumber==11)
            resultnotetext=getMid_Sol_text();
        else if (noteTextTypeNumber==6&&notePicthNumber==12)
            resultnotetext=getMid_La_text();
        else if (noteTextTypeNumber==6&&notePicthNumber==13)
            resultnotetext=getMid_Si_text();
        else if (noteTextTypeNumber==6&&notePicthNumber==14)
            resultnotetext=getHigh_Do_text();
        else if (noteTextTypeNumber==6&&notePicthNumber==15)
            resultnotetext=getHigh_Re_text();
        else if (noteTextTypeNumber==6&&notePicthNumber==16)
            resultnotetext=getHigh_Mi_text();
        else if (noteTextTypeNumber==6&&notePicthNumber==17)
            resultnotetext=getHigh_Fa_text();
        else if (noteTextTypeNumber==6&&notePicthNumber==18)
            resultnotetext=getHigh_Sol_text();
        else if (noteTextTypeNumber==6&&notePicthNumber==19)
            resultnotetext=getHigh_La_text();
        else if (noteTextTypeNumber==6&&notePicthNumber==20)
            resultnotetext=getHigh_Si_text();
        else if (noteTextTypeNumber==7&&notePicthNumber==0)
            resultnotetext=getBass_Do_text();
        else if (noteTextTypeNumber==7&&notePicthNumber==1)
            resultnotetext=getBass_Re_text();
        else if (noteTextTypeNumber==7&&notePicthNumber==2)
            resultnotetext=getBass_Mi_text();
        else if (noteTextTypeNumber==7&&notePicthNumber==3)
            resultnotetext=getBass_Fa_text();
        else if (noteTextTypeNumber==7&&notePicthNumber==4)
            resultnotetext=getBass_Sol_text();
        else if (noteTextTypeNumber==7&&notePicthNumber==5)
            resultnotetext=getBass_La_text();
        else if (noteTextTypeNumber==7&&notePicthNumber==6)
            resultnotetext=getBass_Si_text();
        else if (noteTextTypeNumber==7&&notePicthNumber==7)
            resultnotetext=getMid_Do_text();
        else if (noteTextTypeNumber==7&&notePicthNumber==8)
            resultnotetext=getMid_Re_text();
        else if (noteTextTypeNumber==7&&notePicthNumber==9)
            resultnotetext=getMid_Mi_text();
        else if (noteTextTypeNumber==7&&notePicthNumber==10)
            resultnotetext=getMid_Fa_text();
        else if (noteTextTypeNumber==7&&notePicthNumber==11)
            resultnotetext=getMid_Sol_text();
        else if (noteTextTypeNumber==7&&notePicthNumber==12)
            resultnotetext=getMid_La_text();
        else if (noteTextTypeNumber==7&&notePicthNumber==13)
            resultnotetext=getMid_Si_text();
        else if (noteTextTypeNumber==7&&notePicthNumber==14)
            resultnotetext=getHigh_Do_text();
        else if (noteTextTypeNumber==7&&notePicthNumber==15)
            resultnotetext=getHigh_Re_text();
        else if (noteTextTypeNumber==7&&notePicthNumber==16)
            resultnotetext=getHigh_Mi_text();
        else if (noteTextTypeNumber==7&&notePicthNumber==17)
            resultnotetext=getHigh_Fa_text();
        else if (noteTextTypeNumber==7&&notePicthNumber==18)
            resultnotetext=getHigh_Sol_text();
        else if (noteTextTypeNumber==7&&notePicthNumber==19)
            resultnotetext=getHigh_La_text();
        else if (noteTextTypeNumber==7&&notePicthNumber==20)
            resultnotetext=getHigh_Si_text();
        else if (noteTextTypeNumber==8&&notePicthNumber==0)
            resultnotetext=getBass_Do_text();
        else if (noteTextTypeNumber==8&&notePicthNumber==1)
            resultnotetext=getBass_Re_text();
        else if (noteTextTypeNumber==8&&notePicthNumber==2)
            resultnotetext=getBass_Mi_text();
        else if (noteTextTypeNumber==8&&notePicthNumber==3)
            resultnotetext=getBass_Fa_text();
        else if (noteTextTypeNumber==8&&notePicthNumber==4)
            resultnotetext=getBass_Sol_text();
        else if (noteTextTypeNumber==8&&notePicthNumber==5)
            resultnotetext=getBass_La_text();
        else if (noteTextTypeNumber==8&&notePicthNumber==6)
            resultnotetext=getBass_Si_text();
        else if (noteTextTypeNumber==8&&notePicthNumber==7)
            resultnotetext=getMid_Do_text();
        else if (noteTextTypeNumber==8&&notePicthNumber==8)
            resultnotetext=getMid_Re_text();
        else if (noteTextTypeNumber==8&&notePicthNumber==9)
            resultnotetext=getMid_Mi_text();
        else if (noteTextTypeNumber==8&&notePicthNumber==10)
            resultnotetext=getMid_Fa_text();
        else if (noteTextTypeNumber==8&&notePicthNumber==11)
            resultnotetext=getMid_Sol_text();
        else if (noteTextTypeNumber==8&&notePicthNumber==12)
            resultnotetext=getMid_La_text();
        else if (noteTextTypeNumber==8&&notePicthNumber==13)
            resultnotetext=getMid_Si_text();
        else if (noteTextTypeNumber==8&&notePicthNumber==14)
            resultnotetext=getHigh_Do_text();
        else if (noteTextTypeNumber==8&&notePicthNumber==15)
            resultnotetext=getHigh_Re_text();
        else if (noteTextTypeNumber==8&&notePicthNumber==16)
            resultnotetext=getHigh_Mi_text();
        else if (noteTextTypeNumber==8&&notePicthNumber==17)
            resultnotetext=getHigh_Fa_text();
        else if (noteTextTypeNumber==8&&notePicthNumber==18)
            resultnotetext=getHigh_Sol_text();
        else if (noteTextTypeNumber==8&&notePicthNumber==19)
            resultnotetext=getHigh_La_text();
        else if (noteTextTypeNumber==8&&notePicthNumber==20)
            resultnotetext=getHigh_Si_text();
        else if (noteTextTypeNumber==9&&notePicthNumber==0)
            resultnotetext=getBass_Do_text();
        else if (noteTextTypeNumber==9&&notePicthNumber==1)
            resultnotetext=getBass_Re_text();
        else if (noteTextTypeNumber==9&&notePicthNumber==2)
            resultnotetext=getBass_Mi_text();
        else if (noteTextTypeNumber==9&&notePicthNumber==3)
            resultnotetext=getBass_Fa_text();
        else if (noteTextTypeNumber==9&&notePicthNumber==4)
            resultnotetext=getBass_Sol_text();
        else if (noteTextTypeNumber==9&&notePicthNumber==5)
            resultnotetext=getBass_La_text();
        else if (noteTextTypeNumber==9&&notePicthNumber==6)
            resultnotetext=getBass_Si_text();
        else if (noteTextTypeNumber==9&&notePicthNumber==7)
            resultnotetext=getMid_Do_text();
        else if (noteTextTypeNumber==9&&notePicthNumber==8)
            resultnotetext=getMid_Re_text();
        else if (noteTextTypeNumber==9&&notePicthNumber==9)
            resultnotetext=getMid_Mi_text();
        else if (noteTextTypeNumber==9&&notePicthNumber==10)
            resultnotetext=getMid_Fa_text();
        else if (noteTextTypeNumber==9&&notePicthNumber==11)
            resultnotetext=getMid_Sol_text();
        else if (noteTextTypeNumber==9&&notePicthNumber==12)
            resultnotetext=getMid_La_text();
        else if (noteTextTypeNumber==9&&notePicthNumber==13)
            resultnotetext=getMid_Si_text();
        else if (noteTextTypeNumber==9&&notePicthNumber==14)
            resultnotetext=getHigh_Do_text();
        else if (noteTextTypeNumber==9&&notePicthNumber==15)
            resultnotetext=getHigh_Re_text();
        else if (noteTextTypeNumber==9&&notePicthNumber==16)
            resultnotetext=getHigh_Mi_text();
        else if (noteTextTypeNumber==9&&notePicthNumber==17)
            resultnotetext=getHigh_Fa_text();
        else if (noteTextTypeNumber==9&&notePicthNumber==18)
            resultnotetext=getHigh_Sol_text();
        else if (noteTextTypeNumber==9&&notePicthNumber==19)
            resultnotetext=getHigh_La_text();
        else if (noteTextTypeNumber==9&&notePicthNumber==20)
            resultnotetext=getHigh_Si_text();
        else if (noteTextTypeNumber==10&&notePicthNumber==0)
            resultnotetext=getBass_Do_text();
        else if (noteTextTypeNumber==10&&notePicthNumber==1)
            resultnotetext=getBass_Re_text();
        else if (noteTextTypeNumber==10&&notePicthNumber==2)
            resultnotetext=getBass_Mi_text();
        else if (noteTextTypeNumber==10&&notePicthNumber==3)
            resultnotetext=getBass_Fa_text();
        else if (noteTextTypeNumber==10&&notePicthNumber==4)
            resultnotetext=getBass_Sol_text();
        else if (noteTextTypeNumber==10&&notePicthNumber==5)
            resultnotetext=getBass_La_text();
        else if (noteTextTypeNumber==10&&notePicthNumber==6)
            resultnotetext=getBass_Si_text();
        else if (noteTextTypeNumber==10&&notePicthNumber==7)
            resultnotetext=getMid_Do_text();
        else if (noteTextTypeNumber==10&&notePicthNumber==8)
            resultnotetext=getMid_Re_text();
        else if (noteTextTypeNumber==10&&notePicthNumber==9)
            resultnotetext=getMid_Mi_text();
        else if (noteTextTypeNumber==10&&notePicthNumber==10)
            resultnotetext=getMid_Fa_text();
        else if (noteTextTypeNumber==10&&notePicthNumber==11)
            resultnotetext=getMid_Sol_text();
        else if (noteTextTypeNumber==10&&notePicthNumber==12)
            resultnotetext=getMid_La_text();
        else if (noteTextTypeNumber==10&&notePicthNumber==13)
            resultnotetext=getMid_Si_text();
        else if (noteTextTypeNumber==10&&notePicthNumber==14)
            resultnotetext=getHigh_Do_text();
        else if (noteTextTypeNumber==10&&notePicthNumber==15)
            resultnotetext=getHigh_Re_text();
        else if (noteTextTypeNumber==10&&notePicthNumber==16)
            resultnotetext=getHigh_Mi_text();
        else if (noteTextTypeNumber==10&&notePicthNumber==17)
            resultnotetext=getHigh_Fa_text();
        else if (noteTextTypeNumber==10&&notePicthNumber==18)
            resultnotetext=getHigh_Sol_text();
        else if (noteTextTypeNumber==10&&notePicthNumber==19)
            resultnotetext=getHigh_La_text();
        else if (noteTextTypeNumber==10&&notePicthNumber==20)
            resultnotetext=getHigh_Si_text();
        return resultnotetext;
    }
}
