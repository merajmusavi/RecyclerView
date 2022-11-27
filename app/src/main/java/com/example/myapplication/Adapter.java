package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter  extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private ArrayList<String> contacts = new ArrayList<>();
    private ItemListener itemListener;

    public Adapter(ItemListener itemListener){
        this.itemListener = itemListener;
        contacts.add("Ruthann Trustrie");
        contacts.add("Peadar Dawtrey");
        contacts.add("Felipe Bradtke");
        contacts.add("Claude Crissil");
        contacts.add("Jacky Girardeau");
        contacts.add("Rubia Dominguez");
        contacts.add("Michaela Churchley");
        contacts.add("Harvey Pentelow");
        contacts.add("Neilla Langton");
        contacts.add("Marco Greaves");
        contacts.add("Liz Batchley");
        contacts.add("Lamond Littlepage");
        contacts.add("Malina Weir");
        contacts.add("Tomlin Lenchenko");
        contacts.add("Hy Pavelin");
        contacts.add("Jenelle Palin");
        contacts.add("Damon Knewstubb");
        contacts.add("Alex Ivanusyev");
        contacts.add("Hamil Callery");
        contacts.add("Karol Syer");
    }
    public void addContact(String name){
        contacts.add(0,name);
        notifyItemInserted(0);
    }
    public void update(String fullname,int position){
        contacts.set(position,fullname);
        notifyItemChanged(position);
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
 holder.bindcontact(contacts.get(position));
    }

    @Override
    public int getItemCount() {
        return contacts.size();
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
                 itemListener.OnItemClicked(Fname.getText().toString(),getAdapterPosition());
                }
            });
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    contacts.remove(getAdapterPosition());
                    notifyItemRemoved(getAdapterPosition());
                    return false;
                }
            });
        }

    }
    public interface ItemListener{
        public void OnItemClicked(String fullname,int position);
    }
}
