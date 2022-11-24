package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Adapter  extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private String[] contacts = new String[20];
    public Adapter(){
        contacts[0] = "Ruthann Trustrie";
        contacts[1] = "Peadar Dawtrey";
        contacts[2] = "Felipe Bradtke";
        contacts[3] = "Claude Crissil";
        contacts[4] = "Jacky Girardeau";
        contacts[5] = "Rubia Dominguez";
        contacts[6] = "Michaela Churchley";
        contacts[7] = "Harvey Pentelow";
        contacts[8] = "Neilla Langton";
        contacts[9] = "Marco Greaves";
        contacts[10] = "Liz Batchley";
        contacts[11] = "Lamond Littlepage";
        contacts[12] = "Malina Weir";
        contacts[13] = "Tomlin Lenchenko";
        contacts[14] = "Hy Pavelin";
        contacts[15] = "Jenelle Palin";
        contacts[16] = "Damon Knewstubb";
        contacts[17] = "Alex Ivanusyev";
        contacts[18] = "Hamil Callery";
        contacts[19] = "Karol Syer";
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
 holder.bindcontact(contacts[position]);
    }

    @Override
    public int getItemCount() {
        return contacts.length;
    }



    public class ViewHolder extends RecyclerView.ViewHolder{
    private TextView FirstChar;
    private TextView Fname;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            FirstChar = itemView.findViewById(R.id.tv_Fname);
            Fname = itemView.findViewById(R.id.fullcontanctname);
        }
        public void bindcontact(String name){
            Fname.setText(name);
            FirstChar.setText(name.substring(0,1));
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(view.getContext(),Fname.getText(),Toast.LENGTH_SHORT).show();
                }
            });
        }

    }
}
