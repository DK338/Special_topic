package shih_tsing_ting.special_topic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class SettingActivity extends AppCompatActivity {
    private static String TAG="Notation";

    private EditText ed_Notation_name,ed_Author_name,ed_timesignature_top,ed_timesignature_down,ed_measure,ed_speed;
    private Spinner sp_tone,sp_timesignature;
    private Button bt_setting_save,bt_setting_back;
    private String tone_text,timesignature_text;
    private int speed;
    //int tone_text_ID= 3;
    int tone_text_ID= 0 ,timesignature_text_ID;
    //樂譜
    private Notation notation;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        initialize();
        setButtonClick();
        setSpinner();
        /*sp_tone.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                tone_text=parent.getItemAtPosition(position).toString();
                Log.d("tone",tone_text);
            }
        });*/



    }
    private void initialize(){
        ed_Notation_name=(EditText) findViewById(R.id.ed_Notation_name);
        ed_Author_name=(EditText) findViewById(R.id.ed_Author_name);
        ed_speed=(EditText)findViewById(R.id.ed_speed);

        sp_tone=(Spinner)findViewById(R.id.sp_tone);
        sp_timesignature=(Spinner)findViewById(R.id.sp_timesignature);
        sp_timesignature.setSelection(2);

        bt_setting_save=(Button)findViewById(R.id.bt_setting_save);
        bt_setting_back=(Button)findViewById(R.id.bt_setting_back);

        Bundle editTosettingbndle=getIntent().getExtras();
        notation= (Notation)editTosettingbndle.getSerializable("Notation");

        ed_Notation_name.setText(notation.getNotation_name());
        ed_Author_name.setText(notation.getAuthor_name());
        ed_speed.setText(String.valueOf(notation.getSpeed()));


        Log.d(TAG,notation.getTimesignature());
        Log.d(TAG,notation.getTone());

        switch (notation.getTimesignature())
        {
            case "2/2":
                sp_timesignature.setSelection(0);
            break;
            case "2/4":
                sp_timesignature.setSelection(1);
            break;
            case "3/4":
                sp_timesignature.setSelection(2);
            break;
            case "4/4":
                sp_timesignature.setSelection(3);
            break;
            case "3/8":
                sp_timesignature.setSelection(4);
            break;
            case "6/8":
                sp_timesignature.setSelection(5);
            break;
            case "9/8":
                sp_timesignature.setSelection(6);
            break;
        }
        switch (String.valueOf(notation.getTone()))
        {
            case "C":
                sp_tone.setSelection(0);
            break;
            case "G":
                sp_tone.setSelection(1);
            break;
            case "D":
                sp_tone.setSelection(2);
            break;
            case "A":
                sp_tone.setSelection(3);
            break;
            case "E":
                sp_tone.setSelection(4);
            break;
            case "B":
                sp_tone.setSelection(5);
            break;
            case "F#":
                sp_tone.setSelection(6);
            break;
            case "Db":
                sp_tone.setSelection(7);
            break;
            case "Ab":
                sp_tone.setSelection(8);
            break;
            case "Eb":
                sp_tone.setSelection(9);
            break;
            case "Bb":
                sp_tone.setSelection(10);
            break;
            case "F":
                sp_tone.setSelection(11);
            break;
        }
    }


    private void setSpinner(){
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

    private void setButtonClick(){
        bt_setting_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String notation_name,author_name;
                //簡譜名
                notation_name=ed_Notation_name.getText().toString();
                //作者名
                author_name=ed_Author_name.getText().toString();
                //速度
                int speed=Integer.valueOf(ed_speed.getText().toString());
                notation.setNotation_name(notation_name);
                notation.setAuthor_name(author_name);
                notation.setSpeed(speed);
                notation.setTimesignature(timesignature_text);
                notation.setTone(tone_text);

                Intent intent = new Intent();       //創建一個Intent，聯繫Activity之用
                Bundle bundleBack = new Bundle();//創建一個Bundle，傳值之用
                bundleBack.putSerializable("Notation",notation);
                intent.putExtras(bundleBack);
                setResult(RESULT_OK, intent);       //回傳給A_1，RESULT_OK為回傳狀態
                finish();

            }
        });
        bt_setting_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
