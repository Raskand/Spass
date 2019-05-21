package com.apps.spass.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.apps.spass.R;
import com.apps.spass.model.Inspection;

import java.util.List;


public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder> {

    private List<Inspection> lessonsList;
    private Context context;

    public StudentAdapter(Context applicationContext, List<Inspection> lessonsList) {
        this.context = applicationContext;
        this.lessonsList = lessonsList;
        notifyDataSetChanged();
    }


    @Override
    public StudentAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_student, viewGroup, false);

        return new StudentAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(StudentAdapter.ViewHolder viewHolder, int i) {

        viewHolder.title.setText(lessonsList.get(i).getName());
        viewHolder.teacher.setText(lessonsList.get(i).getNo());
        viewHolder.size.setText(lessonsList.get(i).getDateTime());
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
                        Inspection clickedDataItem = lessonsList.get(pos);

                    }
                }
            });
        }
    }



}