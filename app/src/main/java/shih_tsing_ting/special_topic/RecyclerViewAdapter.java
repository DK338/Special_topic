package shih_tsing_ting.special_topic;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private Measure measure;
    Context mContext;
    int memeasure_position;

    RecyclerViewAdapter(Context context,Measure data,int memeasure_position) {
        this.measure = data;
        this.mContext=context;
        this.memeasure_position=memeasure_position;
    }

    // 建立ViewHolder
    class ViewHolder extends RecyclerView.ViewHolder{
        // 宣告元件
        private TextView note_item;
        Boolean backgroundType=false;

        ViewHolder(View itemView) {
            super(itemView);
            note_item = (TextView) itemView.findViewById(R.id.note_item);
            note_item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (backgroundType==false)
                    {
                        note_item.setBackgroundColor(Color.parseColor("#AAAAAA"));
                        backgroundType=true;
                    }
                    else
                    {
                        note_item.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        backgroundType=false;
                    }
                }
            });
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.note_item,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int i) {
        viewHolder.note_item.setText(measure.getNotelist().get(i).get("Note").getPicture());
        //viewHolder.note_item.setTypeface(Typeface.createFromAsset(mContext.getAssets(), "fonts/01SMN.ttf"));
        viewHolder.note_item.setTextSize(32);
        Typeface font=Typeface.createFromAsset(mContext.getAssets(), "fonts/01SMN.ttf");
        viewHolder.note_item.setTypeface(font);
        viewHolder.note_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (viewHolder.backgroundType==false)
                {
                    viewHolder.note_item.setBackgroundColor(Color.parseColor("#AAAAAA"));
                    viewHolder.backgroundType=true;
                }
                else
                {
                    viewHolder.note_item.setBackgroundColor(Color.parseColor("#FFFFFF"));
                    viewHolder.backgroundType=false;
                }
            }
        });

        viewHolder.note_item.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                removeItem(viewHolder.getAdapterPosition());
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return measure.getNotelist().size();
    }

    // 刪除項目
    public void removeItem(int position){
        measure.getNotelist().remove(position);
        notifyItemRemoved(position);
    }
}
