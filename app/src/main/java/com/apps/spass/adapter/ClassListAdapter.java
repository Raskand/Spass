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
import com.apps.spass.model.ClassList;

import java.util.List;

import static com.apps.spass.activity.MainActivity.sellectedID;

public class ClassListAdapter extends RecyclerView.Adapter<ClassListAdapter.ViewHolder> {

    private List<ClassList> clasList;
    private Context context;

    public ClassListAdapter(Context applicationContext, List<ClassList> clasList) {
        this.context = applicationContext;
        this.clasList = clasList;
        notifyDataSetChanged();
    }


    @Override
    public ClassListAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_class, viewGroup, false);

        return new ClassListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ClassListAdapter.ViewHolder viewHolder, int i) {

        viewHolder.title.setText(clasList.get(i).getClassName());
        viewHolder.size.setText(clasList.get(i).getSize() + " Kişi");

        if(clasList.get(i).getSize().equals("0")){
            viewHolder.size.setVisibility(View.GONE);
        }

        else{
            viewHolder.size.setVisibility(View.VISIBLE);
        }

        if(Integer.parseInt(clasList.get(i).getSize())<20){
            viewHolder.size.setTextColor(Color.parseColor("#f70d0d"));
        }
        else if(Integer.parseInt(clasList.get(i).getSize())>=20 && Integer.parseInt(clasList.get(i).getSize()) <40){
            viewHolder.size.setTextColor(Color.parseColor("#f78a0d"));
        }
        else{
            viewHolder.size.setTextColor(Color.parseColor("#0FDDBB"));
        }

    }

    @Override
    public int getItemCount() {
        return clasList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView title, size;

        public ViewHolder(View view) {
            super(view);

            title = (TextView) view.findViewById(R.id.txt_title);
            size = (TextView) view.findViewById(R.id.txt_size);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View v) {
                    final int pos = getAdapterPosition();

                    if (pos != RecyclerView.NO_POSITION) {
                        ClassList clickedDataItem = clasList.get(pos);

                    }
                }
            });
        }
    }



}