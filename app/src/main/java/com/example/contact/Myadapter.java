package com.example.contact;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class Myadapter extends RecyclerView.Adapter<Myadapter.Myholder> {
    ArrayList<String> S1,S2;
    Context ct;
    public Myadapter(Context ct, ArrayList<String> S1, ArrayList<String> S2) {
        this.ct = ct;
        this.S1 = S1;
        this.S2 = S2;
    }
    @NonNull
    @Override
    public Myholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater myInflater = LayoutInflater.from(ct);
        View view = myInflater.inflate(R.layout.item_contains,viewGroup,false);

        return new Myholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Myholder myholder, int i) {
        myholder.t1.setText(S1.get(i));
        myholder.t2.setText(S2.get(i));
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class Myholder extends RecyclerView.ViewHolder {
        TextView t1,t2;
        public Myholder(@NonNull View itemView) {
            super(itemView);
            t1 = (TextView) itemView.findViewById(R.id.etName);
            t2 = (TextView) itemView.findViewById(R.id.etPhone);
        }
    }
}
