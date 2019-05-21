package com.apps.spass.adapter;


import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.apps.spass.R;
import com.apps.spass.activity.QrReaderActivity;
import com.apps.spass.activity.StudentListActivity;
import com.apps.spass.model.Lesson;

import java.util.List;

import static com.apps.spass.activity.MainActivity.sellectedID;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    private List<Lesson> lessonsList;
    private Context context;

    public ListAdapter(Context applicationContext, List<Lesson> lessonsList) {
        this.context = applicationContext;
        this.lessonsList = lessonsList;
        notifyDataSetChanged();
    }


    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_lesson, viewGroup, false);

        return new ListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ListAdapter.ViewHolder viewHolder, int i) {

        viewHolder.title.setText(lessonsList.get(i).getTitle());
        viewHolder.teacher.setText(lessonsList.get(i).getTeacher());
        viewHolder.size.setText(lessonsList.get(i).getSize() + " Kişi");

        if(lessonsList.get(i).getSize().equals("0")){
            viewHolder.size.setVisibility(View.GONE);
        }

        else{
            viewHolder.size.setVisibility(View.VISIBLE);
        }

        if(Integer.parseInt(lessonsList.get(i).getSize())<20){
            viewHolder.size.setTextColor(Color.parseColor("#f70d0d"));
        }
        else if(Integer.parseInt(lessonsList.get(i).getSize())>=20 && Integer.parseInt(lessonsList.get(i).getSize()) <40){
            viewHolder.size.setTextColor(Color.parseColor("#f78a0d"));
        }
        else{
            viewHolder.size.setTextColor(Color.parseColor("#0FDDBB"));
        }

    }

    @Override
    public int getItemCount() {
        return lessonsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView title, teacher, size;

        public ViewHolder(View view) {
            super(view);

            title = (TextView) view.findViewById(R.id.txt_title);
            teacher = (TextView) view.findViewById(R.id.txt_teacher);
            size = (TextView) view.findViewById(R.id.txt_size);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View v) {
                    final int pos = getAdapterPosition();

                    if (pos != RecyclerView.NO_POSITION) {
                        Lesson clickedDataItem = lessonsList.get(pos);

                        if(sellectedID==0){

                            Intent intent = new Intent(context, QrReaderActivity.class);
                            intent.putExtra("id", clickedDataItem.getId());
                            intent.putExtra("size",clickedDataItem.getSize());
                            intent.putExtra("itemID",clickedDataItem.getItemID());

                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            context.startActivity(intent);
                        }
                        else{
                            Intent intent = new Intent(context, StudentListActivity.class);
                            intent.putExtra("id", clickedDataItem.getId());
                            intent.putExtra("itemID", clickedDataItem.getItemID());
                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            context.startActivity(intent);


                        }



                    }
                }
            });
        }
    }



}