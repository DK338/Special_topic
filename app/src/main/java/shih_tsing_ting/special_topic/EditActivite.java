package shih_tsing_ting.special_topic;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.media.midi.MidiManager;
import android.media.midi.MidiReceiver;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import android.graphics.Typeface;

import org.w3c.dom.Text;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import shih_tsing_ting.special_topic.midi.MidiConstants;
import shih_tsing_ting.special_topic.midi.MidiInputPortSelector;

public class EditActivite extends AppCompatActivity {
    private TextView tv_Notation_name,tv_tone,tv_Author_name;
    private String notation_name,tone,tone_text, author_name;
    private int speed,timesignature_top,timesignature_down,tone_text_id;
    private ListView listView;

    private Spinner spinner;
    private ViewPager noteviewPager,markviewPager;
    private View notepage1,notepage2,notepage3,markpage1,markpage2;
    private List<View> listnotepage,listmarkpage;
    private PagerAdapter notePagerAdapter,markPagerAdapter;

    private SQLiteDatabase mSQLiteDatabase= null;
    private static final String DATABASE_NAME = "w.db";

    private MidiManager mMidiManager;
    private MidiInputPortSelector mKeyboardReceiverSelector;

    private byte[] mByteBuffer = new byte[3];

    String TAG="Notation";
    //樂譜
    private Notation notation;
    private String notation_Database_ID;
    private ArrayList<ArrayList<HashMap<String,Note>>> measure;
    private ArrayList<HashMap<String,Note>> noteList;
    private HashMap<String,Note> note;
    //音程計算
    //音高
    private int pitch;
    //音符種類

    private int noteTextTypeNumber;
    //音程
    private double interval;
    private double firstinterval;
    //Double interval;
    private Button[] bt_downNoteArray=new Button[8];
    private Button[] bt_midNoteArray=new Button[8];
    private Button[] bt_upNoteArray=new Button[8];
    private Button[] bt_markOneArray=new Button[8];

    boolean[]bt_markoneBoolean=new boolean[8];

    PlayerThread playerThread;
    private GridView gridView;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_edit, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.action_settings) {
            Intent intent=new Intent();
            Bundle bundle=new Bundle();
            //將該頁面的資料傳到設定畫面
            bundle.putSerializable("Notation",notation);
            intent.putExtras(bundle);
            intent.setClass(EditActivite.this,SettingActivity.class);
            startActivityForResult(intent,1);
            return false;
        }
        if (id==R.id.action_play)
        {
            playerThread=new PlayerThread(EditActivite.this,notation,mMidiManager,mKeyboardReceiverSelector);
            playerThread.run();
        }
        if (id==R.id.action_delete)
        {

        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_edit_activite);

        mSQLiteDatabase = this.openOrCreateDatabase(DATABASE_NAME,MODE_PRIVATE, null);
        setupMidi();
        spinner=(Spinner)findViewById(R.id.spinner);
        spinner.setSelection(1);
        noteList=new ArrayList<HashMap<String,Note>>();
        measure=new ArrayList<ArrayList<HashMap<String,Note>>>();

        gridView=(GridView)findViewById(R.id.GridView);

        initialize();
        firstinterval=notation.getNotePitchtable().getQuarterNoteTime();
        interval=firstinterval;

        initnoteView();
        initmarkView();



    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        spinner.setSelection(0);
        ArrayList<HashMap<String,Note>> allnoteData=new ArrayList<>();
        for (int i=0;i<notation.getMeasureArray().size();i++)
        {
            for (int j=0;j<notation.getMeasureArray().get(i).getNotelist().size();j++)
            {
                allnoteData.add(notation.getMeasureArray().get(i).getNotelist().get(j));
            }
        }
        int note_id=Integer.valueOf(notation_Database_ID);
        String DELETE_DATA="Delete From Note_table where note_id="+note_id;
        mSQLiteDatabase.execSQL(DELETE_DATA);
        for (int i=0;i<allnoteData.size();i++)
        {
            int note_seq=i;
            int notetype=allnoteData.get(i).get("Note").Type;
            int notetexttypenumber=allnoteData.get(i).get("Note").getNoteTextTypeNumber();
            int notepicthnumber=allnoteData.get(i).get("Note").getnotePicthNumber();
            double interval=allnoteData.get(i).get("Note").getInterval();
            int upmark=0;
            int downmark=0;
            int restoremark=0;
            if (allnoteData.get(i).get("Note").getUpmark()==false)
                upmark=0;
            else
                upmark=1;
            if (allnoteData.get(i).get("Note").getDownmark()==false)
                downmark=0;
            else
                downmark=1;
            if (allnoteData.get(i).get("Note").getRestoremark()==false)
                restoremark=0;
            else
                restoremark=1;

            String INSERT_DATE="INSERT INTO Note_table (note_id, note_seq, notetype, notetexttypenumber, notepicthnumber, interval, upmark, downmark, restoremark) " +
                    "VALUES ("+note_id+","+note_seq+","+notetype+",'"+notetexttypenumber+"','"+notepicthnumber+"',"+interval+","+upmark+","+downmark+","+restoremark+")";
            mSQLiteDatabase.execSQL(INSERT_DATE);
            Log.d("note","note_id="+note_id+"\tnote_seq="+note_seq+"\tnotetype="+notetype+"\tnotetexttypenumber="+notetexttypenumber+"\tnotePitch="+notepicthnumber+"\tinterval="+interval+"\tupmark="+upmark+"\tdownmark="+downmark+"\trestoremark="+restoremark);
        }
        String UPDATE_DATE="UPDATE Notation_table SET notation_name='"+notation.getNotation_name()+"',author_name='"+notation.getAuthor_name()+"',speed="+notation.getSpeed()+",tone='"+notation.getTone()+"',timesignture='"+notation.getTimesignature()+"' where index_id="+note_id;
        mSQLiteDatabase.execSQL(UPDATE_DATE);
        Log.d("UPDATE_DATE",UPDATE_DATE);
        //finish();

    }

    private void setupMidi() {
        mMidiManager = (MidiManager) getSystemService(MIDI_SERVICE);
        if (mMidiManager == null) {
            /*Toast.makeText(this, "MidiManager is null!", Toast.LENGTH_LONG)
                    .show();*/
            return;
        }

        mKeyboardReceiverSelector = new MidiInputPortSelector(mMidiManager,
                this, R.id.spinner);

    }


    void initialize()
    {
        Bundle mainToeditbndle=getIntent().getExtras();
        tv_Notation_name =(TextView)findViewById(R.id.tv_musicname);
        tv_tone=(TextView)findViewById(R.id.tv_tone);
        tv_Author_name=(TextView)findViewById(R.id.tv_workname);
        notation= (Notation)mainToeditbndle.getSerializable("Notation");
        //設定初始簡譜名
        tv_Notation_name.setText(notation.getNotation_name());
        tv_Author_name.setText(notation.getAuthor_name());
        tv_tone.setText("1="+notation.getTone()+"\t"+notation.getTimesignature()+"\t"+notation.getSpeed());
        notation_Database_ID=mainToeditbndle.getString("Notatiom_index_id");
        notation.getMeasureArray().clear();
        if (notation.getMeasureArray().isEmpty())
        {
            notation.getMeasureArray().add(new Measure());
        }
        else
        {
            Log.d("desk","不是空的");
        }
        Cursor cursor=mSQLiteDatabase.rawQuery("SELECT*FROM Note_table WHERE note_id="+notation_Database_ID+" order by note_seq ASC",null);
        cursor.moveToFirst();
        ArrayList<HashMap<String,Note>> allnoteData=new ArrayList<>();
        while (!cursor.isAfterLast())
        {
            int measurelastindex=notation.getMeasureArray().size()-1;
            int notesindex=0;
            double thismeasureAllInterval=0;
            if (cursor.getInt(3)==0)
            {
                //addnote((cursor.getInt(4)),cursor.getDouble(6));
                Note note=new Note(cursor.getInt(4),cursor.getDouble(6));
                HashMap<String,Note> notes=new HashMap<>();
                notes.put("Note",note);
                if (notation.getMeasureArray().get(measurelastindex).getNotelist().isEmpty())
                {
                    notation.getMeasureArray().get(measurelastindex).getNotelist().add(notes);
                }
                else
                {

                    for (int i=0;i<notation.getMeasureArray().get(measurelastindex).getNotelist().size();i++)
                    {
                        thismeasureAllInterval=thismeasureAllInterval+notation.getMeasureArray().get(measurelastindex).getNotelist().get(i).get("Note").getInterval();
                    }
                    if (thismeasureAllInterval+note.getInterval()==notation.getMeasure_MAXtime())
                    {
                        notation.getMeasureArray().get(measurelastindex).getNotelist().add(notes);
                        notation.getMeasureArray().add(new Measure());
                    }
                    else if (thismeasureAllInterval+note.getInterval()<notation.getMeasure_MAXtime())
                    {
                        notation.getMeasureArray().get(measurelastindex).getNotelist().add(notes);
                    }
                }

            }
            else
            {
                Boolean upmark,downmark,restoremark;
                if (cursor.getInt(7)==0)
                    upmark=false;
                else
                    upmark=true;
                if (cursor.getInt(8)==0)
                    downmark=false;
                else
                    downmark=true;
                if (cursor.getInt(9)==0)
                    restoremark=false;
                else
                    restoremark=true;
                //addnote(notation.getTone(),cursor.getInt(4),cursor.getInt(5),cursor.getDouble(6),upmark,downmark,restoremark);
                Note note=new Note(notation.getTone(),cursor.getInt(4),cursor.getInt(5),cursor.getDouble(6),upmark,downmark,restoremark);
                HashMap<String,Note> notes=new HashMap<>();
                notes.put("Note",note);
                if (notation.getMeasureArray().get(measurelastindex).getNotelist().isEmpty())
                {
                    notation.getMeasureArray().get(measurelastindex).getNotelist().add(notes);
                }
                else
                {

                    for (int i=0;i<notation.getMeasureArray().get(measurelastindex).getNotelist().size();i++)
                    {
                        thismeasureAllInterval=thismeasureAllInterval+notation.getMeasureArray().get(measurelastindex).getNotelist().get(i).get("Note").getInterval();
                    }
                    if (thismeasureAllInterval+note.getInterval()==notation.getMeasure_MAXtime())
                    {
                        notation.getMeasureArray().get(measurelastindex).getNotelist().add(notes);
                        notation.getMeasureArray().add(new Measure());
                    }
                    else if (thismeasureAllInterval+note.getInterval()<notation.getMeasure_MAXtime())
                    {
                        notation.getMeasureArray().get(measurelastindex).getNotelist().add(notes);
                    }
                }
                /*Log.d("why0?",cursor.getInt(4)+"\t"+cursor.getInt(5)+"\t"+cursor.getDouble(6));
                Note note=new Note(notation.getTone(),cursor.getInt(4),cursor.getInt(5),cursor.getDouble(6),upmark,downmark,restoremark);
                Log.d("why1?","種類文字:"+note.getPicture()+"\t音高:"+note.getPitch());*/
              //  Log.d("why1?","種類文字:"+note.getNoteType()+"\t音高:"+note.getNotePitchType());*/
                /*Note note2=new Note(notation.getTone(),s,"bass_Do",cursor.getDouble(6),upmark,downmark,restoremark);
                Log.d("why2?","種類文字:"+note2.getPicture()+"\t音高:"+note2.getPitch());
                Log.d("why2?","種類文字:"+note2.getNoteType()+"\t音高:"+note2.getNotePitchType());*/
               /* HashMap<String,Note> notes=new HashMap<>();
                notes.put("Note",note);
                allnoteData.add(notes);*/
            }

            cursor.moveToNext();
        }
       /* for (int i=0;i<allnoteData.size();i++)
        {
            Note note=allnoteData.get(i).get("Note");
            //Log.d("notec", String.valueOf(note.Type)+"\t"+note.getPicture()+"\t"+note.getPitch()+"\t"+note.getNoteTextTypeNumber()+"\t"+note.getnotePicthNumber()+"\t"+note.getUpmark()+"\t"+note.getDownmark()+"\t"+note.getRestoremark());
            if (note.Type==0)
            {
                addnote(note.getNoteTextTypeNumber(),note.getInterval());
            }
            else
            {
                addnote(notation.getTone(),note.getNoteTextTypeNumber(),note.getnotePicthNumber(),note.getInterval(),note.getUpmark(),note.getDownmark(),note.getRestoremark());
            }
        }*/
        reDraw();

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            Bundle bundleResult = data.getExtras();
            notation=(Notation)bundleResult.getSerializable("Notation");

            tv_Notation_name.setText(notation.getNotation_name());
            tv_Author_name.setText(notation.getAuthor_name());
            tv_tone.setText("1="+notation.getTone()+"\t"+notation.getTimesignature()+"\t"+notation.getSpeed());
            reDraw();
        }
    }


    void initnoteView()
    {
        noteviewPager=(ViewPager)findViewById(R.id.viewPager_note);
        LayoutInflater noteInflater=getLayoutInflater();
        notepage1=noteInflater.inflate(R.layout.notepage1,null);
        notepage2=noteInflater.inflate(R.layout.notepage2,null);
        notepage3=noteInflater.inflate(R.layout.notepage3,null);

        listnotepage=new ArrayList<View>();
        listnotepage.add(notepage1);
        listnotepage.add(notepage2);
        listnotepage.add(notepage3);

        notePagerAdapter = new PagerAdapter() {
            @Override
            public int getCount() {
                return listnotepage.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object)
            {
                return view == object;
            }

            @Override
            public Object instantiateItem(ViewGroup container, final int position) {
                container.addView(listnotepage.get(position));
                return listnotepage.get(position);
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object)
            {
                container.removeView(listnotepage.get(position));
            }
        };
        noteviewPager.setAdapter(notePagerAdapter);

        bt_downNoteArray[0] = (Button)notepage1.findViewById(R.id.bt_down0);
        bt_downNoteArray[1] = (Button)notepage1.findViewById(R.id.bt_down1);
        bt_downNoteArray[2] = (Button)notepage1.findViewById(R.id.bt_down2);
        bt_downNoteArray[3] = (Button)notepage1.findViewById(R.id.bt_down3);
        bt_downNoteArray[4] = (Button)notepage1.findViewById(R.id.bt_down4);
        bt_downNoteArray[5] = (Button)notepage1.findViewById(R.id.bt_down5);
        bt_downNoteArray[6] = (Button)notepage1.findViewById(R.id.bt_down6);
        bt_downNoteArray[7] = (Button)notepage1.findViewById(R.id.bt_down7);

        bt_midNoteArray[0]=(Button)notepage2.findViewById(R.id.bt_mid0);
        bt_midNoteArray[1]=(Button)notepage2.findViewById(R.id.bt_mid1);
        bt_midNoteArray[2]=(Button)notepage2.findViewById(R.id.bt_mid2);
        bt_midNoteArray[3]=(Button)notepage2.findViewById(R.id.bt_mid3);
        bt_midNoteArray[4]=(Button)notepage2.findViewById(R.id.bt_mid4);
        bt_midNoteArray[5]=(Button)notepage2.findViewById(R.id.bt_mid5);
        bt_midNoteArray[6]=(Button)notepage2.findViewById(R.id.bt_mid6);
        bt_midNoteArray[7]=(Button)notepage2.findViewById(R.id.bt_mid7);

        bt_upNoteArray[0]=(Button)notepage3.findViewById(R.id.bt_up0);
        bt_upNoteArray[1]=(Button)notepage3.findViewById(R.id.bt_up1);
        bt_upNoteArray[2]=(Button)notepage3.findViewById(R.id.bt_up2);
        bt_upNoteArray[3]=(Button)notepage3.findViewById(R.id.bt_up3);
        bt_upNoteArray[4]=(Button)notepage3.findViewById(R.id.bt_up4);
        bt_upNoteArray[5]=(Button)notepage3.findViewById(R.id.bt_up5);
        bt_upNoteArray[6]=(Button)notepage3.findViewById(R.id.bt_up6);
        bt_upNoteArray[7]=(Button)notepage3.findViewById(R.id.bt_up7);
        Typeface font=Typeface.createFromAsset(getAssets(), "fonts/01SMN.ttf");

        for (int i=0;i<bt_downNoteArray.length;i++)
            bt_downNoteArray[i].setTypeface(font);

        for (int i=0;i<bt_midNoteArray.length;i++)
            bt_midNoteArray[i].setTypeface(font);

        for (int i=0;i<bt_upNoteArray.length;i++)
            bt_upNoteArray[i].setTypeface(font);

        //////////////////////////////////////////////////////////////////////////////////////////
        downnotebuttonClick();
        midnotebuttonClick();
        upnotebuttonClick();

    }

    void initmarkView() {
        markviewPager=(ViewPager)findViewById(R.id.viewPager_mark);
        LayoutInflater markInflater=getLayoutInflater();
        markpage1=markInflater.inflate(R.layout.markpage1,null);
        //markpage2=markInflater.inflate(R.layout.markpage2,null);


        listmarkpage=new ArrayList<View>();
        listmarkpage.add(markpage1);
        //listmarkpage.add(markpage2);


        markPagerAdapter = new PagerAdapter() {
            @Override
            public int getCount() {
                return listmarkpage.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object)
            {
                return view == object;
            }

            @Override
            public Object instantiateItem(ViewGroup container, final int position) {
                //Toast.makeText(MainActivity.this,Integer.toString(container.getChildCount())+","+Integer.toString(position),Toast.LENGTH_SHORT).show();
                container.addView(listmarkpage.get(position));
                return listmarkpage.get(position);
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object)
            {

                container.removeView(listmarkpage.get(position));

            }
        };
        markviewPager.setAdapter(markPagerAdapter);

        //////////////////////////////////////////////////////////
        markonebutton();

    }

    void downnotebuttonClick(){
        bt_downNoteArray[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNoteDatainit();
                addnote(noteTextTypeNumber,interval);
                reDraw();
                Log.d("desk", String.valueOf(notation.getMeasureArray().isEmpty()));

            }
        });

        bt_downNoteArray[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNoteDatainit();
                int notePitchTypeNumber=0;
                addnote(notation.getTone(),noteTextTypeNumber,notePitchTypeNumber,interval,bt_markoneBoolean[5],bt_markoneBoolean[6],bt_markoneBoolean[7]);
                reDraw();
                /*Log.d("desl",noteTextTypeNumber);
                Log.d("desl1",String.valueOf(bt_markoneBoolean[5]));
                Log.d("desl2",String.valueOf(bt_markoneBoolean[6]));
                Log.d("desl3",String.valueOf(bt_markoneBoolean[7]));*/


            }
        });
        bt_downNoteArray[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNoteDatainit();
                int notePitchTypeNumber=1;
                addnote(notation.getTone(),noteTextTypeNumber,notePitchTypeNumber,interval,bt_markoneBoolean[5],bt_markoneBoolean[6],bt_markoneBoolean[7]);
                reDraw();
            }
        });
        bt_downNoteArray[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNoteDatainit();
                int notePitchTypeNumber=2;
                addnote(notation.getTone(),noteTextTypeNumber,notePitchTypeNumber,interval,bt_markoneBoolean[5],bt_markoneBoolean[6],bt_markoneBoolean[7]);
                reDraw();
            }
        });
        bt_downNoteArray[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNoteDatainit();
                int notePitchTypeNumber=3;
                addnote(notation.getTone(),noteTextTypeNumber,notePitchTypeNumber,interval,bt_markoneBoolean[5],bt_markoneBoolean[6],bt_markoneBoolean[7]);
                reDraw();
            }
        });
        bt_downNoteArray[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNoteDatainit();
                int notePitchTypeNumber=4;
                addnote(notation.getTone(),noteTextTypeNumber,notePitchTypeNumber,interval,bt_markoneBoolean[5],bt_markoneBoolean[6],bt_markoneBoolean[7]);
                reDraw();
            }
        });
        bt_downNoteArray[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNoteDatainit();
                int notePitchTypeNumber=5;
                addnote(notation.getTone(),noteTextTypeNumber,notePitchTypeNumber,interval,bt_markoneBoolean[5],bt_markoneBoolean[6],bt_markoneBoolean[7]);
                reDraw();
            }
        });
        bt_downNoteArray[7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNoteDatainit();
                int notePitchTypeNumber=6;
                addnote(notation.getTone(),noteTextTypeNumber,notePitchTypeNumber,interval,bt_markoneBoolean[5],bt_markoneBoolean[6],bt_markoneBoolean[7]);
                reDraw();

            }
        });

    }




    void midnotebuttonClick()
    {
        bt_midNoteArray[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNoteDatainit();
                addnote(noteTextTypeNumber,interval);
                reDraw();
            }
        });
        bt_midNoteArray[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNoteDatainit();
                int notePitchTypeNumber=7;
                addnote(notation.getTone(),noteTextTypeNumber,notePitchTypeNumber,interval,bt_markoneBoolean[5],bt_markoneBoolean[6],bt_markoneBoolean[7]);
                reDraw();
            }
        });
        bt_midNoteArray[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNoteDatainit();
                int notePitchTypeNumber=8;
                addnote(notation.getTone(),noteTextTypeNumber,notePitchTypeNumber,interval,bt_markoneBoolean[5],bt_markoneBoolean[6],bt_markoneBoolean[7]);
                reDraw();
            }
        });
        bt_midNoteArray[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNoteDatainit();
                int notePitchTypeNumber=9;
                addnote(notation.getTone(),noteTextTypeNumber,notePitchTypeNumber,interval,bt_markoneBoolean[5],bt_markoneBoolean[6],bt_markoneBoolean[7]);
                reDraw();
            }
        });
        bt_midNoteArray[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNoteDatainit();
                int notePitchTypeNumber=10;
                addnote(notation.getTone(),noteTextTypeNumber,notePitchTypeNumber,interval,bt_markoneBoolean[5],bt_markoneBoolean[6],bt_markoneBoolean[7]);
                reDraw();
            }
        });
        bt_midNoteArray[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNoteDatainit();
                int notePitchTypeNumber=11;
                addnote(notation.getTone(),noteTextTypeNumber,notePitchTypeNumber,interval,bt_markoneBoolean[5],bt_markoneBoolean[6],bt_markoneBoolean[7]);
                reDraw();
            }
        });
        bt_midNoteArray[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNoteDatainit();
                int notePitchTypeNumber=12;
                addnote(notation.getTone(),noteTextTypeNumber,notePitchTypeNumber,interval,bt_markoneBoolean[5],bt_markoneBoolean[6],bt_markoneBoolean[7]);
                reDraw();
            }
        });
        bt_midNoteArray[7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNoteDatainit();
                int notePitchTypeNumber=13;
                addnote(notation.getTone(),noteTextTypeNumber,notePitchTypeNumber,interval,bt_markoneBoolean[5],bt_markoneBoolean[6],bt_markoneBoolean[7]);
                reDraw();
            }
        });
    }
    void upnotebuttonClick()
    {
        bt_upNoteArray[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNoteDatainit();
                addnote(noteTextTypeNumber,interval);
                reDraw();
            }
        });
        bt_upNoteArray[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNoteDatainit();
                int notePitchTypeNumber=14;
                addnote(notation.getTone(),noteTextTypeNumber,notePitchTypeNumber,interval,bt_markoneBoolean[5],bt_markoneBoolean[6],bt_markoneBoolean[7]);
                reDraw();
            }
        });
        bt_upNoteArray[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNoteDatainit();
                int notePitchTypeNumber=15;
                addnote(notation.getTone(),noteTextTypeNumber,notePitchTypeNumber,interval,bt_markoneBoolean[5],bt_markoneBoolean[6],bt_markoneBoolean[7]);
                reDraw();
            }
        });
        bt_upNoteArray[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNoteDatainit();
                int notePitchTypeNumber=16;
                addnote(notation.getTone(),noteTextTypeNumber,notePitchTypeNumber,interval,bt_markoneBoolean[5],bt_markoneBoolean[6],bt_markoneBoolean[7]);
                reDraw();
            }
        });
        bt_upNoteArray[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNoteDatainit();
                int notePitchTypeNumber=17;
                addnote(notation.getTone(),noteTextTypeNumber,notePitchTypeNumber,interval,bt_markoneBoolean[5],bt_markoneBoolean[6],bt_markoneBoolean[7]);
                reDraw();
            }
        });
        bt_upNoteArray[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNoteDatainit();
                int notePitchTypeNumber=18;
                addnote(notation.getTone(),noteTextTypeNumber,notePitchTypeNumber,interval,bt_markoneBoolean[5],bt_markoneBoolean[6],bt_markoneBoolean[7]);
                reDraw();
            }
        });
        bt_upNoteArray[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNoteDatainit();
                int notePitchTypeNumber=19;
                addnote(notation.getTone(),noteTextTypeNumber,notePitchTypeNumber,interval,bt_markoneBoolean[5],bt_markoneBoolean[6],bt_markoneBoolean[7]);
                reDraw();
            }
        });
        bt_upNoteArray[7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNoteDatainit();
                int notePitchTypeNumber=20;
                addnote(notation.getTone(),noteTextTypeNumber,notePitchTypeNumber,interval,bt_markoneBoolean[5],bt_markoneBoolean[6],bt_markoneBoolean[7]);
                reDraw();
            }
        });
    }
    void markonebutton()
    {
        bt_markOneArray[0]=(Button)markpage1.findViewById(R.id.bt_mark);
        bt_markOneArray[1]=(Button)markpage1.findViewById(R.id.bt_mark1);
        bt_markOneArray[2]=(Button)markpage1.findViewById(R.id.bt_mark2);
        bt_markOneArray[3]=(Button)markpage1.findViewById(R.id.bt_mark3);
        bt_markOneArray[4]=(Button)markpage1.findViewById(R.id.bt_mark4);
        bt_markOneArray[5]=(Button)markpage1.findViewById(R.id.bt_mark5);
        bt_markOneArray[6]=(Button)markpage1.findViewById(R.id.bt_mark6);
        bt_markOneArray[7]=(Button)markpage1.findViewById(R.id.bt_mark7);
        final Typeface font=Typeface.createFromAsset(getAssets(), "fonts/01SMN.ttf");

        bt_markOneArray[0].setTypeface(font);
        bt_markOneArray[1].setTypeface(font);
        bt_markOneArray[4].setTypeface(font);
        bt_markOneArray[5].setTypeface(font);
        bt_markOneArray[6].setTypeface(font);
        bt_markOneArray[7].setTypeface(font);
        for (int i=0;i<bt_markoneBoolean.length;i++)
        {
            bt_markoneBoolean[i]=false;
            bt_markOneArray[i].setBackgroundColor(Color.parseColor("#BBFFEE"));
        }


        bt_markOneArray[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (bt_markoneBoolean[0]!=false)
                {

                   // interval=notation.getNotePitchtable().getEighthNoteTime();
                    bt_markoneBoolean[0]=false;
                    bt_markoneBoolean[1]=false;
                    bt_markoneBoolean[2]=false;
                    bt_markoneBoolean[3]=false;
                    bt_markoneBoolean[4]=false;
                    Log.d("color2",String.valueOf(interval));
                }
                else {

                   // interval=firstinterval;
                    bt_markoneBoolean[0]=true;
                    bt_markoneBoolean[1]=false;
                    bt_markoneBoolean[2]=false;
                    bt_markoneBoolean[3]=false;
                    bt_markoneBoolean[4]=false;

                    Log.d("color1",String.valueOf(interval));
                }

                for (int i=0;i<5;i++)
                {
                    if (bt_markoneBoolean[i]!=false)
                        bt_markOneArray[i].setBackgroundColor(Color.parseColor("#00DD77"));
                    else
                        bt_markOneArray[i].setBackgroundColor(Color.parseColor("#BBFFEE"));
                }
            }
        });
        bt_markOneArray[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bt_markoneBoolean[1]!=false)
                {

                    //interval=notation.getNotePitchtable().getSixteenthNoteTime();
                    bt_markoneBoolean[0]=false;
                    bt_markoneBoolean[1]=false;
                    bt_markoneBoolean[2]=false;
                    bt_markoneBoolean[3]=false;
                    bt_markoneBoolean[4]=false;
                    Log.d("color2",String.valueOf(interval));
                }
                else {

                   // interval=firstinterval;
                    bt_markoneBoolean[0]=false;
                    bt_markoneBoolean[1]=true;
                    bt_markoneBoolean[2]=false;
                    bt_markoneBoolean[3]=false;
                    bt_markoneBoolean[4]=false;

                    Log.d("color1",String.valueOf(interval));
                }

                for (int i=0;i<5;i++)
                {
                    if (bt_markoneBoolean[i]!=false)
                        bt_markOneArray[i].setBackgroundColor(Color.parseColor("#00DD77"));
                    else
                        bt_markOneArray[i].setBackgroundColor(Color.parseColor("#BBFFEE"));
                }
            }
        });
        bt_markOneArray[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bt_markoneBoolean[2]!=false)
                {

                   // interval=notation.getNotePitchtable().getHalfNoteTime();
                    bt_markoneBoolean[0]=false;
                    bt_markoneBoolean[1]=false;
                    bt_markoneBoolean[2]=false;
                    bt_markoneBoolean[3]=false;
                    bt_markoneBoolean[4]=false;
                    Log.d("color2",String.valueOf(interval));
                }
                else {

                   // interval=firstinterval;
                    bt_markoneBoolean[0]=false;
                    bt_markoneBoolean[1]=false;
                    bt_markoneBoolean[2]=true;
                    bt_markoneBoolean[3]=false;
                    bt_markoneBoolean[4]=false;

                    Log.d("color1",String.valueOf(interval));
                }

                for (int i=0;i<5;i++)
                {
                    if (bt_markoneBoolean[i]!=false)
                        bt_markOneArray[i].setBackgroundColor(Color.parseColor("#00DD77"));
                    else
                        bt_markOneArray[i].setBackgroundColor(Color.parseColor("#BBFFEE"));
                }
            }
        });
        bt_markOneArray[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bt_markoneBoolean[3]!=false)
                {

                  //  interval=notation.getNotePitchtable().getFullNoteTime();
                    bt_markoneBoolean[0]=false;
                    bt_markoneBoolean[1]=false;
                    bt_markoneBoolean[2]=false;
                    bt_markoneBoolean[3]=false;
                    bt_markoneBoolean[4]=false;
                    Log.d("color2",String.valueOf(interval));
                }
                else {

                   // interval=firstinterval;
                    bt_markoneBoolean[0]=false;
                    bt_markoneBoolean[1]=false;
                    bt_markoneBoolean[2]=false;
                    bt_markoneBoolean[3]=true;
                    bt_markoneBoolean[4]=false;

                    Log.d("color1",String.valueOf(interval));
                }

                for (int i=0;i<5;i++)
                {
                    if (bt_markoneBoolean[i]!=false)
                        bt_markOneArray[i].setBackgroundColor(Color.parseColor("#00DD77"));
                    else
                        bt_markOneArray[i].setBackgroundColor(Color.parseColor("#BBFFEE"));
                }
            }
        });
        bt_markOneArray[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bt_markoneBoolean[4]!=false)
                {
                    bt_markoneBoolean[4]=false;
                    //Log.d("color2",String.valueOf(interval));
                }
                else if (bt_markoneBoolean[3]==true&&bt_markoneBoolean[4]==false)
                {
                    bt_markoneBoolean[4]=false;
                }
                else {
                    bt_markoneBoolean[4]=true;
                    //Log.d("color1",String.valueOf(interval));
                }

                if (bt_markoneBoolean[4]!=false)
                    bt_markOneArray[4].setBackgroundColor(Color.parseColor("#00DD77"));
                else
                    bt_markOneArray[4].setBackgroundColor(Color.parseColor("#BBFFEE"));
            }
        });
        bt_markOneArray[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bt_markoneBoolean[5]!=false)
                {
                    bt_markoneBoolean[5]=false;
                    bt_markoneBoolean[6]=false;
                    bt_markoneBoolean[7]=false;
                    //Log.d("color2",String.valueOf(interval));
                }
                else {
                    bt_markoneBoolean[5]=true;
                    bt_markoneBoolean[6]=false;
                    bt_markoneBoolean[7]=false;
                    //Log.d("color1",String.valueOf(interval));
                }
                for (int i=5;i<8;i++)
                {
                    if (bt_markoneBoolean[i]!=false)
                        bt_markOneArray[i].setBackgroundColor(Color.parseColor("#00DD77"));
                    else
                        bt_markOneArray[i].setBackgroundColor(Color.parseColor("#BBFFEE"));
                }
            }
        });

        bt_markOneArray[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bt_markoneBoolean[6]!=false)
                {
                    bt_markoneBoolean[5]=false;
                    bt_markoneBoolean[6]=false;
                    bt_markoneBoolean[7]=false;
                    //Log.d("color2",String.valueOf(interval));
                }
                else {
                    bt_markoneBoolean[5]=false;
                    bt_markoneBoolean[6]=true;
                    bt_markoneBoolean[7]=false;
                    //Log.d("color1",String.valueOf(interval));
                }
                for (int i=5;i<8;i++)
                {
                    if (bt_markoneBoolean[i]!=false)
                        bt_markOneArray[i].setBackgroundColor(Color.parseColor("#00DD77"));
                    else
                        bt_markOneArray[i].setBackgroundColor(Color.parseColor("#BBFFEE"));
                }
            }
        });
        bt_markOneArray[7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bt_markoneBoolean[7]!=false)
                {
                    bt_markoneBoolean[5]=false;
                    bt_markoneBoolean[6]=false;
                    bt_markoneBoolean[7]=false;
                    //Log.d("color2",String.valueOf(interval));
                }
                else {
                    bt_markoneBoolean[5]=false;
                    bt_markoneBoolean[6]=false;
                    bt_markoneBoolean[7]=true;
                    //Log.d("color1",String.valueOf(interval));
                }
                for (int i=5;i<8;i++)
                {
                    if (bt_markoneBoolean[i]!=false)
                        bt_markOneArray[i].setBackgroundColor(Color.parseColor("#00DD77"));
                    else
                        bt_markOneArray[i].setBackgroundColor(Color.parseColor("#BBFFEE"));
                }
            }
        });
    }

    void setNoteDatainit(){
        if (bt_markoneBoolean[0]==true&&bt_markoneBoolean[4]==true)
        {
            //附點八分音符
            noteTextTypeNumber=8;
            interval=notation.getNotePitchtable().getAttachedeighthNoteTime();
        }
        else if (bt_markoneBoolean[1]==true&&bt_markoneBoolean[4]==true)
        {
            //附點十六分音符
            noteTextTypeNumber=9;
            interval=notation.getNotePitchtable().getAttachedsixteenthNoteTime();
        }
        else if (bt_markoneBoolean[2]==true&&bt_markoneBoolean[4]==true)
        {
            //附點二分音符
            noteTextTypeNumber=6;
            interval=notation.getNotePitchtable().getAttachedhalfNoteTime();
        }
        else if (bt_markoneBoolean[0]==true)
        {
            //八分音符
            noteTextTypeNumber=3;
            interval=notation.getNotePitchtable().getEighthNoteTime();
        }
        else  if (bt_markoneBoolean[1]==true)
        {
            //十六分音符
            noteTextTypeNumber=4;
            interval=notation.getNotePitchtable().getSixteenthNoteTime();
        }
        else if (bt_markoneBoolean[2]==true)
        {
            //二分音符
            noteTextTypeNumber=1;
            interval=notation.getNotePitchtable().getHalfNoteTime();
        }
        else if(bt_markoneBoolean[3]==true)
        {
            //全音符
            noteTextTypeNumber=0;
            interval=notation.getNotePitchtable().getFullNoteTime();
        }
        else if (bt_markoneBoolean[4]==true)
        {
            //附點四分音符
            noteTextTypeNumber=7;
            interval=notation.getNotePitchtable().getAttachedquarterNoteTime();
        }
        else
        {
            //四分音符
            noteTextTypeNumber=2;
            interval=notation.getNotePitchtable().getQuarterNoteTime();
        }


        Log.d(TAG,String.valueOf(interval));
    }
    private void addnote(int noteTextTypeNumber, double interval) {

        Note note=new Note(noteTextTypeNumber,interval);
        HashMap<String,Note> notes=new HashMap<>();
        //Log.d("notec", String.valueOf(note.Type)+"\t"+note.getPicture()+"\t"+note.getPitch()+"\t"+note.getNoteTextTypeNumber()+"\t"+note.getnotePicthNumber()+"\t"+note.getUpmark()+"\t"+note.getDownmark()+"\t"+note.getRestoremark());
        notes.put("Note",note);
        int measurelastindex=notation.getMeasureArray().size()-1;
        Log.d("desk",String.valueOf(measurelastindex));
        double thismeasureAllInterval=0;
        if (notation.getMeasureArray().get(measurelastindex).getNotelist().isEmpty())
        {
            notation.getMeasureArray().get(measurelastindex).getNotelist().add(notes);
            for (int i=0;i<notation.getMeasureArray().get(measurelastindex).getNotelist().size();i++)
            {
                double noteInterval=notation.getMeasureArray().get(measurelastindex).getNotelist().get(i).get("Note").getInterval();
                thismeasureAllInterval=thismeasureAllInterval+noteInterval;
            }
            if (thismeasureAllInterval==notation.getMeasure_MAXtime())
            {
                notation.getMeasureArray().add(new Measure());
            }
        }
        else
        {
            for (int i=0;i<notation.getMeasureArray().get(measurelastindex).getNotelist().size();i++)
            {
                double noteInterval=notation.getMeasureArray().get(measurelastindex).getNotelist().get(i).get("Note").getInterval();
                thismeasureAllInterval=thismeasureAllInterval+noteInterval;
            }
            if (thismeasureAllInterval+note.getInterval()==notation.getMeasure_MAXtime())
            {
                notation.getMeasureArray().get(measurelastindex).getNotelist().add(notes);
                notation.getMeasureArray().add(new Measure());
                //measurelastindex=notation.getMeasureArray().size()-1;
                //notation.getMeasureArray().get(measurelastindex).getNotelist().add(notes);
            }
            else if (thismeasureAllInterval+note.getInterval()<notation.getMeasure_MAXtime())
            {
                notation.getMeasureArray().get(measurelastindex).getNotelist().add(notes);
            }
        }

    }
    void addnote(String tone, int noteTextTypeNumber,int notePitchTypeNumber, double interval,Boolean upmark,Boolean downmark,Boolean restoremark) {


        Note note=new Note(tone,noteTextTypeNumber,notePitchTypeNumber,interval,upmark,downmark,restoremark);
        //Log.d("notec", String.valueOf(note.Type)+"\t"+note.getPicture()+"\t"+note.getPitch()+"\t"+note.getNoteTextTypeNumber()+"\t"+note.getnotePicthNumber()+"\t"+note.getUpmark()+"\t"+note.getDownmark()+"\t"+note.getRestoremark());
        Log.d("dest",note.getPicture());
        HashMap<String,Note> notes=new HashMap<>();
        notes.put("Note",note);
        int measurelastindex=notation.getMeasureArray().size()-1;
        Log.d("desk",String.valueOf(measurelastindex));
        double thismeasureAllInterval=0;
        if (notation.getMeasureArray().get(measurelastindex).getNotelist().isEmpty())
        {
            notation.getMeasureArray().get(measurelastindex).getNotelist().add(notes);
            for (int i=0;i<notation.getMeasureArray().get(measurelastindex).getNotelist().size();i++)
            {
                double noteInterval=notation.getMeasureArray().get(measurelastindex).getNotelist().get(i).get("Note").getInterval();
                thismeasureAllInterval=thismeasureAllInterval+noteInterval;
            }
            if (thismeasureAllInterval==notation.getMeasure_MAXtime())
            {
                notation.getMeasureArray().add(new Measure());
            }

        }
        else
        {
            for (int i=0;i<notation.getMeasureArray().get(measurelastindex).getNotelist().size();i++)
            {
                double noteInterval=notation.getMeasureArray().get(measurelastindex).getNotelist().get(i).get("Note").getInterval();
                thismeasureAllInterval=thismeasureAllInterval+noteInterval;
            }
            if (thismeasureAllInterval+note.getInterval()==notation.getMeasure_MAXtime())
            {
                notation.getMeasureArray().get(measurelastindex).getNotelist().add(notes);
                notation.getMeasureArray().add(new Measure());
                //measurelastindex=notation.getMeasureArray().size()-1;
                //notation.getMeasureArray().get(measurelastindex).getNotelist().add(notes);
            }
            else if (thismeasureAllInterval+note.getInterval()<notation.getMeasure_MAXtime())
            {
                notation.getMeasureArray().get(measurelastindex).getNotelist().add(notes);
            }
        }
    }
    void reDraw()
    {
        GridViewAdapter gridViewAdapter=new GridViewAdapter(EditActivite.this,notation.getMeasureArray());
        gridView.setAdapter(gridViewAdapter);
    }





}
