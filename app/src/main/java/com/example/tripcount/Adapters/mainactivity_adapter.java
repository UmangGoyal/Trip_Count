package com.example.tripcount.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tripcount.Entity.Trip;
import com.example.tripcount.R;

public class mainactivity_adapter extends RecyclerView.Adapter<mainactivity_adapter.mainactivity_ViewHolder> {
    private Trip[] data ;
    onClickListener onClickListener;
    public mainactivity_adapter(Trip[] data ,onClickListener onClickListener)
    {
        this.data = data;
        this.onClickListener=onClickListener;
    }

    public mainactivity_adapter() {

    }

    @NonNull
    @Override
    public mainactivity_ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.main_activity_cardview,parent,false);
        return new mainactivity_ViewHolder(v,onClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull mainactivity_ViewHolder holder, int position) {
        Trip dt= data[position];
        holder.tripname.setText(Trip.getTrip_Name());
        holder.no_of_people.setText(Trip.getNo_of_people());
    }


    @Override
    public int getItemCount() {
        return data.length;
    }

    public static class mainactivity_ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tripname;
        TextView no_of_people;
        onClickListener onClickListener;
        public mainactivity_ViewHolder(@NonNull View itemView , onClickListener onClickListener) {
            super(itemView);
            tripname = (TextView) itemView.findViewById(R.id.Trip_name_card);
            no_of_people =(TextView)  itemView.findViewById(R.id.no_of_people_card_main);
            this.onClickListener = onClickListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onClickListener.onClick(getAdapterPosition());
        }
    }
    public interface onClickListener
    {
        void onClick(int position);
    }

}
