package com.example.bg.mybooks;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.Toolbar;

import java.util.ArrayList;

public class myFile extends AppCompatActivity {

    Spinner spinner1,spinner2,spinner3;
   ArrayAdapter<CharSequence> adapter;
   RecyclerView recyclerView;
   RecyclerView.Adapter adapter1;
   RecyclerView.LayoutManager layoutManager;
   ArrayList<Album> arrayList= new ArrayList<>();
   int [] img_id = {R.drawable.sample_0,R.drawable.sample_1,R.drawable.sample_2,R.drawable.sample_3,R.drawable.sample_4,R.drawable.sample_5,R.drawable.sample_6,R.drawable.sample_7};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_file);
        recyclerView  = (RecyclerView)findViewById(R.id.recyclerview);
       spinner1=(Spinner) findViewById(R.id.spBranch);
        spinner2=(Spinner) findViewById(R.id.spSem);
       spinner3=(Spinner) findViewById(R.id.spSub);

      /* android.support.v7.widget.Toolbar toolbar=(android.support.v7.widget.Toolbar)findViewById(R.id.toolbar);
       setSupportActionBar(toolbar);
       if (getSupportActionBar() !=null)
           getSupportActionBar().setDisplayHomeAsUpEnabled(true);*/


        adapter=ArrayAdapter.createFromResource(this,R.array.branchs,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner1.setAdapter(adapter);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        adapter=ArrayAdapter.createFromResource(this,R.array.sems,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner2.setAdapter(adapter);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        adapter=ArrayAdapter.createFromResource(this,R.array.sub4,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner3.setAdapter(adapter);
        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    layoutManager=new GridLayoutManager(this,2);
    recyclerView.setLayoutManager(layoutManager);
    recyclerView.setHasFixedSize(true);

    for (int id : img_id)
    {
        arrayList.add(new Album(id));
    }

    adapter1=new RecyclerAdapter(arrayList);
    recyclerView.setAdapter(adapter1);
    }


}


