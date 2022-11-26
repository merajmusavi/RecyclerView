package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
ImageView addCTC;
 EditText et_add_CTC;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Adapter adapter = new Adapter();
        addCTC = findViewById(R.id.iv_add_ctc);
        et_add_CTC = findViewById(R.id.ctc_f_name);

        RecyclerView recyclerView = findViewById(R.id.re);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));
        recyclerView.setAdapter(adapter);
        addCTC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
          if (et_add_CTC.length()>0){
              adapter.addContact(et_add_CTC.getText().toString());
              recyclerView.scrollToPosition(0);
          }else{
              Toast.makeText(MainActivity.this, "edit text cant be empty", Toast.LENGTH_SHORT).show();
          }
            }
        });
    }
}