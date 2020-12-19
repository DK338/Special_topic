package shih_tsing_ting.special_topic;

import android.content.Context;
import android.media.midi.MidiManager;
import android.media.midi.MidiReceiver;
import android.util.Log;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import shih_tsing_ting.special_topic.midi.MidiConstants;
import shih_tsing_ting.special_topic.midi.MidiInputPortSelector;

import static android.content.Context.MIDI_SERVICE;

public class PlayerThread extends Thread {
    String TAG="";
    Context mContext;
    Notation notation;
    private MidiManager mMidiManager;
    private MidiInputPortSelector mKeyboardReceiverSelector;
    ArrayList<HashMap<String,Note>> allnoteData=new ArrayList<>();
    private static final int DEFAULT_VELOCITY = 64;
    //mKeyboardReceiverSelector = new MidiInputPortSelector(mMidiManager,this, R.id.spinner);
    private byte[] mByteBuffer = new byte[3];
    public PlayerThread(Context context,Notation notation,MidiManager midiManager,MidiInputPortSelector midiInputPortSelector)
    {
        this.mContext=context;
        this.notation=notation;
        this.mMidiManager=midiManager;
        this.mKeyboardReceiverSelector=midiInputPortSelector;

        for (int i=0;i<notation.getMeasureArray().size();i++)
        {
            for (int j=0;j<notation.getMeasureArray().get(i).getNotelist().size();j++)
            {
                this.allnoteData.add(notation.getMeasureArray().get(i).getNotelist().get(j));
            }
        }
    }

    @Override
    public void run(){
        for (int i=0;i<allnoteData.size();i++)
        {
            if (allnoteData.get(i).get("Note").Type==0)
            {
                try {
                    PlayerThread.sleep((long)allnoteData.get(i).get("Note").getInterval());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //Log.d("OOOO","休止符");
            }
            else
            {
                noteOn(0,allnoteData.get(i).get("Note").getPitch(),DEFAULT_VELOCITY);
                //Log.d("OOOO","音符");
                try {
                    PlayerThread.sleep((long)allnoteData.get(i).get("Note").getInterval());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                noteOff(0,allnoteData.get(i).get("Note").getPitch(),DEFAULT_VELOCITY);
            }
        }
    }




    private void noteOff(int channel, int pitch, int velocity) {
        midiCommand(MidiConstants.STATUS_NOTE_OFF + channel, pitch, velocity);
    }

    private void noteOn(int channel, int pitch, int velocity) {
        midiCommand(MidiConstants.STATUS_NOTE_ON + channel, pitch, velocity);
    }

    private void midiCommand(int status, int data1, int data2) {
        mByteBuffer[0] = (byte) status;
        mByteBuffer[1] = (byte) data1;
        mByteBuffer[2] = (byte) data2;
        long now = System.nanoTime();
        midiSend(mByteBuffer, 3, now);
    }

    private void midiCommand(int status, int data1) {
        mByteBuffer[0] = (byte) status;
        mByteBuffer[1] = (byte) data1;
        long now = System.nanoTime();
        midiSend(mByteBuffer, 2, now);
    }
    private void midiSend(byte[] buffer, int count, long timestamp) {
        if (mKeyboardReceiverSelector != null) {
            try {
                // send event immediately
                MidiReceiver receiver = mKeyboardReceiverSelector.getReceiver();
                if (receiver != null) {
                    receiver.send(buffer, 0, count, timestamp);
                }
            } catch (IOException e) {
                Log.e(TAG, "mKeyboardReceiverSelector.send() failed " + e);
            }
        }
    }
}
