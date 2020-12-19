package shih_tsing_ting.special_topic;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private ListView list_Musicscope;
    private SQLiteDatabase mSQLiteDatabase= null;
    private static final String DATABASE_NAME = "w.db";

    private EditText ed_Notation_name,ed_Author_name,ed_measure,ed_speed;
    private Spinner sp_tone,sp_timesignature;
    private Button bt_setting_save,bt_setting_back;
    private String tone_text,timesignature_text;
    private int tone_text_id,timesignature_id;

    ArrayList<HashMap<String,Object>> list;


    @Override
    protected void onResume() {
        super.onResume();
        list.clear();
        Cursor cursor=mSQLiteDatabase.rawQuery("SELECT*FROM Notation_table WHERE 1",null);

        //Toast.makeText(MainActivity.this,Integer.toString(cursor.getCount()),Toast.LENGTH_LONG).show();

        cursor.moveToFirst();
        while (!cursor.isAfterLast())
        {
            HashMap<String,Object> item=new HashMap<String, Object>();

            item.put("index_id",cursor.getString(0));
            item.put("Notatiom_name",cursor.getString(1));
            item.put("Author_name",cursor.getString(2));
            item.put("Notation_speed",cursor.getInt(3));
            item.put("Notation_tone",cursor.getString(4));
            item.put("Notation_timesignture",cursor.getString(5));

            list.add(item);

            cursor.moveToNext();
        }
        final SimpleAdapter adapter=new SimpleAdapter(MainActivity.this,list,R.layout.notation_item,
                new String [] {"Notatiom_name","Author_name"},
                new int [] {R.id.notation_item_name,R.id.Author_item_name});
        list_Musicscope.setAdapter(adapter);

        list_Musicscope.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                HashMap<String,Object> item=list.get(position);
                //資料庫index_id
                final String delete_id=(String)item.get("index_id");
                //listView位置ID
                final int delete_location=position;

                AlertDialog.Builder ab=new AlertDialog.Builder(MainActivity.this);
                ab.setTitle("是否刪除此樂譜");
                ab.setPositiveButton("是", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String DELETE_ITEM="Delete From Notation_table where index_id="+delete_id;
                        mSQLiteDatabase.execSQL(DELETE_ITEM);

                        list.remove(delete_location);
                        list_Musicscope.setAdapter(adapter);
                    }
                });
                ab.show();
                return false;
            }
        });
       // Toast.makeText(this, "onResume", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_main);
        list_Musicscope=(ListView)findViewById(R.id.List_Musicscope);
        mSQLiteDatabase = this.openOrCreateDatabase(DATABASE_NAME,MODE_PRIVATE, null);

        String CREATE_NOTATION_TABLE = "CREATE TABLE  IF NOT EXISTS Notation_table (index_id INTEGER PRIMARY KEY AUTOINCREMENT, notation_name TEXT, author_name TEXT, speed INTEGER, tone TEXT, timesignture TEXT)";
        mSQLiteDatabase.execSQL(CREATE_NOTATION_TABLE);

        String CREATE_NOTE_TABLE = "CREATE TABLE  IF NOT EXISTS Note_table (index_id INTEGER PRIMARY KEY AUTOINCREMENT, note_id INTEGER, note_seq INTEGER, notetype INTEGER, notetexttypenumber INTEGER, notepicthnumber INTEGER, interval DOUBLE, upmark INTEGER, downmark INTEGER, restoremark INTEGER)";
        mSQLiteDatabase.execSQL(CREATE_NOTE_TABLE);
        list=new ArrayList<HashMap<String, Object>>();



        Cursor cursor=mSQLiteDatabase.rawQuery("SELECT*FROM Notation_table WHERE 1",null);

        //Toast.makeText(MainActivity.this,Integer.toString(cursor.getCount()),Toast.LENGTH_LONG).show();

        cursor.moveToFirst();
        while (!cursor.isAfterLast())
        {
            HashMap<String,Object> item=new HashMap<String, Object>();

            item.put("index_id",cursor.getString(0));
            item.put("Notatiom_name",cursor.getString(1));
            item.put("Author_name",cursor.getString(2));
            item.put("Notation_speed",cursor.getInt(3));
            item.put("Notation_tone",cursor.getString(4));
            item.put("Notation_timesignture",cursor.getString(5));

            list.add(item);

            cursor.moveToNext();
        }


        final SimpleAdapter adapter=new SimpleAdapter(MainActivity.this,list,R.layout.notation_item,
                new String [] {"Notatiom_name","Author_name"},
                new int [] {R.id.notation_item_name,R.id.Author_item_name});
        list_Musicscope.setAdapter(adapter);

        list_Musicscope.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                HashMap<String,Object> item=list.get(position);
                //資料庫index_id
                final String delete_id=(String)item.get("index_id");
                //listView位置ID
                final int delete_location=position;

                AlertDialog.Builder ab=new AlertDialog.Builder(MainActivity.this);
                ab.setTitle("是否刪除此樂譜");
                ab.setPositiveButton("是", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String DELETE_ITEM="Delete From Notation_table where index_id="+delete_id;
                        mSQLiteDatabase.execSQL(DELETE_ITEM);

                        list.remove(delete_location);
                        list_Musicscope.setAdapter(adapter);
                    }
                });
                ab.show();
                return false;
            }
        });


        list_Musicscope.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {
                HashMap<String,Object> item=list.get(i);
                //資料庫index_id
                final String get_id=(String)item.get("index_id");
                final String get_Notatiom_name=(String)item.get("Notatiom_name");
                final String get_Author_name=(String)item.get("Author_name");
                final int  get_speed=(int)item.get("Notation_speed");
                final String get_tone=(String)item.get("Notation_tone");
                final String get_timesignture=(String)item.get("Notation_timesignture");
                //listView位置ID
                final int delete_location=i;
                Notation notation=new Notation(get_Notatiom_name,get_Author_name,get_speed,get_tone,get_timesignture);
                Intent intent = new Intent();
                //創建一個Bundle，傳值之用
                Bundle bundle = new Bundle();
                bundle.putString("Notatiom_index_id",get_id);
                bundle.putSerializable("Notation",notation);
                intent.putExtras(bundle);
                intent.setClass(MainActivity.this,EditActivite.class);
                startActivity(intent);


            }
        });


    }


   /* void setmSQLiteDatabase()
    {
        mSQLiteDatabase = this.openOrCreateDatabase(DATABASE_NAME,MODE_PRIVATE, null);
        String CREATE_SCORE_TABLE = "CREATE TABLE  IF NOT EXISTS score " +
                "(index_id INTEGER PRIMARY KEY AUTOINCREMENT, user_name TEXT, user_score INTEGER)";
        mSQLiteDatabase.execSQL(CREATE_SCORE_TABLE);
    }*/

     void setMyAlertDialog() {
        final AlertDialog.Builder  builder = new AlertDialog.Builder(MainActivity.this);
        // Get the layout inflater
        final View item = LayoutInflater.from(MainActivity.this).inflate(R.layout.dialog_layout, null);
        builder.setTitle("初始設定");
        builder.setView(item);
        builder.setPositiveButton("儲存", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String notation_name,author_name;
                //簡譜名
                notation_name=ed_Notation_name.getText().toString();
                //作者名
                author_name=ed_Author_name.getText().toString();
                //速度
                int speed;
                if (ed_speed.getText().toString().isEmpty())
                    speed=120;
                else
                    speed=Integer.valueOf(ed_speed.getText().toString());



                //建立樂譜
                Notation notation=new Notation(notation_name,author_name,speed,tone_text,timesignature_text);
                //填入資料庫
                String INSERT_DATE="INSERT INTO Notation_table (notation_name,author_name,speed,tone,timesignture) VALUES ('"+notation.getNotation_name()+"','"+notation.getAuthor_name()+"',"+notation.getSpeed()+",'"+notation.getTone()+"','"+notation.getTimesignature()+"')";
                mSQLiteDatabase.execSQL(INSERT_DATE);
                Cursor cursor=mSQLiteDatabase.rawQuery("SELECT*FROM Notation_table WHERE 1",null);
                cursor.moveToLast();
                final String get_id=cursor.getString(0);
                //創建一個Intent，聯繫Activity之用
                Intent intent = new Intent();
                //創建一個Bundle，傳值之用
                Bundle bundle = new Bundle();
                bundle.putSerializable("Notation",notation);
                bundle.putString("Notatiom_index_id",get_id);
                intent.putExtras(bundle);
                intent.setClass(MainActivity.this,EditActivite.class);
                startActivity(intent);
                dialog.cancel();
            }
        });
        builder.setNegativeButton("返回", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialogViewinit(item);
        setSpinner();


        builder.show();

    }

     void AlertDialogViewinit(View view){
        ed_Notation_name=(EditText) view.findViewById(R.id.ed_Notation_name);
        ed_Author_name=(EditText)view.findViewById(R.id.ed_Author_name);
        ed_speed=(EditText)view.findViewById(R.id.ed_speed);
        int speed=120;
        ed_speed.setText(String.valueOf(speed));

        sp_tone=(Spinner)view.findViewById(R.id.sp_tone);
        sp_timesignature=(Spinner)view.findViewById(R.id.sp_timesignature);

        bt_setting_save=(Button)view.findViewById(R.id.bt_setting_save);
        bt_setting_back=(Button)view.findViewById(R.id.bt_setting_back);
    }

    void setSpinner(){
        sp_tone.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tone_text=sp_tone.getSelectedItem().toString();
                //tone_text_id=sp_tone.getId();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        sp_timesignature.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                timesignature_text=sp_timesignature.getSelectedItem().toString();
                //timesignature_id=sp_timesignature.getId();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        Log.d("Add click","click");
        int id = item.getItemId();
        Log.d("Add ID",id+" "+R.id.action_add);
        if (id == R.id.action_add) {
            setMyAlertDialog();
            return false;
        }

        return super.onOptionsItemSelected(item);
    }


}
