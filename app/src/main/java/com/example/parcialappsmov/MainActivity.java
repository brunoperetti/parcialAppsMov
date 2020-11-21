package com.example.parcialappsmov;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    Button btn;
    EditText txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn =  findViewById(R.id.button);
        txt = findViewById(R.id.txt);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast toast=Toast. makeText(getApplicationContext(),"datos enviados",Toast. LENGTH_SHORT);
               toast.show();
                new TaskNotificacion().execute();

            }
        });

    }

    class TaskNotificacion extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... params) {
            //...
            try {
                //aca guardaria el contenido de la variable texto y el si/no del radiobutton
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }

            return null;


        }

        @Override
        protected void onPostExecute(String result) {
            AlarmManager alarmManager;

            Intent intent = new Intent(MainActivity.this, MyNotificationPublisher.class);

            alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
            PendingIntent pi = PendingIntent.getBroadcast(getApplicationContext(), 0, intent, 0);

            alarmManager.set(AlarmManager.RTC_WAKEUP, 0, pi);

        }


    }



}