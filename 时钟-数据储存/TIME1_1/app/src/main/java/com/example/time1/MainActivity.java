package com.example.time1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;
import java.io.BufferedWriter;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;


public class MainActivity extends AppCompatActivity{
    RecyclerView recyclerView;
    ArrayList<TimeModel>timeList=new ArrayList<>();
    int HTTP=0;
    SharedPreferences mySharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView   (R.layout.activity_main);
        TextView time = (TextView) findViewById(R.id.time);
        View btn=(Button)findViewById(R.id.btn);
        Timer timer = new Timer();

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");// HH:mm:ss
                //获取当前时间
                Date date = new Date(System.currentTimeMillis());
                if(HTTP==0){time.setText(simpleDateFormat.format(date));}
            }
        };
        timer.schedule(task, 1000, 1000);
        recyclerView=findViewById(R.id.recycler);

        RecyclerViewAdapter recyclerViewAdapter=new RecyclerViewAdapter(MainActivity.this,timeList);
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        Toast.makeText(MainActivity.this,"正在尝试获取数据",Toast.LENGTH_SHORT).show();
        mySharedPreferences=getSharedPreferences("timeinfo", Context.MODE_PRIVATE);
        String timedata=mySharedPreferences.getString("time","");
        int size = mySharedPreferences.getInt("NUM", 0);
        for(int s=1;s<=size;s++)
        {
            timeList.add(new TimeModel(mySharedPreferences.getString("Status_" + s, null)));
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        Toast.makeText(MainActivity.this,"成功获取数据，当前储存了"+size+"个时间",Toast.LENGTH_SHORT).show();
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String LogTime=time.getText().toString();
                timeList.add(new TimeModel(LogTime));
                int i=timeList.size();
                mySharedPreferences=getSharedPreferences("timeinfo",Context.MODE_PRIVATE);
                SharedPreferences.Editor editor=mySharedPreferences.edit();
                editor.putInt("NUM",i);
                editor.putString("Status_"+i,LogTime);
                editor.commit();
                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

                Toast.makeText(MainActivity.this,"成功添加数据，当前储存了"+i+"个时间",Toast.LENGTH_SHORT).show();
            }

        });
    }
}