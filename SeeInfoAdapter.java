package com.example.attendenceapplication;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class SeeInfoAdapter extends FirebaseRecyclerAdapter<SeeInfoModule,SeeInfoAdapter.SeeInfoViewHolder> {
    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public SeeInfoAdapter(@NonNull FirebaseRecyclerOptions<SeeInfoModule> options) {
        super(options);
    }



    @Override
    protected void onBindViewHolder(@NonNull SeeInfoViewHolder holder, int position, @NonNull SeeInfoModule model) {
        holder.tvId.setText(model.getId());
        /*Long present = Long.parseLong(model.getPresent());
        Long leave = Long.parseLong(model.getLeaves());
        long absent = 30-(present+leave);*/
        String present = ""+model.getPresentCont();
        holder.tvName.setText(model.getName());
        holder.tvPresent.setText(model.getPresentCont());
        holder.tvLeave.setText(model.getMobile());
        holder.tvAbsent.setText(""+model.getAbsentCount());
        Log.d("Firebase Test", "onBindViewHolder: "+model.getName());
        Log.d("Firebase Test", "onBindViewHolder: "+model.getPresentCont());
    }

    @NonNull
    @Override
    public SeeInfoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_layout_linear_2,parent,false);
        return new SeeInfoViewHolder(view);
    }

    public static class SeeInfoViewHolder extends RecyclerView.ViewHolder {
        TextView tvName,tvId,tvLeave,tvAbsent,tvPresent;
        public SeeInfoViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName=itemView.findViewById(R.id.tvCname);
            tvId=itemView.findViewById(R.id.tvCid);
            tvPresent=itemView.findViewById(R.id.tvCpresent);
            tvAbsent=itemView.findViewById(R.id.tvCabsent);
            tvLeave=itemView.findViewById(R.id.tvCleave);

        }
    }
}
