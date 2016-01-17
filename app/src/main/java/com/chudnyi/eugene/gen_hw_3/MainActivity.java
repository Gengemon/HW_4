package com.chudnyi.eugene.gen_hw_3;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String[] data;// = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15"};
    //String[] dataB = {"01b", "02b", "03b"};

    GridView gvMain;
    ArrayAdapter<String> adapter;

//    Button btnCall;
//    Button btnProgram;
//    Button btnGo;

    //GridView gvMainB;
    //ArrayAdapter<String> adapterB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //тулбар
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //this.setActionBar(toolbar);

        //таблица
        data = new String[ 1200 ];
        for (int i = 0; i < data.length; i++) {
            data[i] = "" + (i + 1);
        }
        adapter = new ArrayAdapter<String>(this, R.layout.layout_grid_01, R.id.textGreed, data);
        gvMain = (GridView) findViewById(R.id.grid01);
        gvMain.setAdapter(adapter);


        // найдем View-элементы
//        btnCall = (Button) findViewById(R.id.button_call);
//        //btnProgram = (Button) findViewById(R.id.button_program);
//        //btnGo = (Button) findViewById(R.id.button_go);
//
//        // создаем обработчик нажатия
//        OnClickListener oclBtnCall = new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Меняем текст в TextView (tvOut)
//                Toast.makeText(getApplicationContext(),"Звонок",Toast.LENGTH_SHORT).show();
//            }
//        };
//
//        // присвоим обработчик кнопке OK (btnOk)
//        btnCall.setOnClickListener(oclBtnCall);

        //нижние кнопки
//        adapterB = new ArrayAdapter<String>(this, R.layout.layout_bottom_01, R.id.tvTextB, dataB);
//        gvMainB = (GridView) findViewById(R.id.grid02button);
//        gvMainB.setAdapter(adapterB);


        adjustGridView();
    }

    public void button_call_click(View v){
        Toast.makeText(getApplicationContext(),"Звонок",Toast.LENGTH_SHORT).show();

        Intent intentCall = new Intent(Intent.ACTION_DIAL);
        //intentCall.setData(Uri.parse("tel:" + "777777"));
        //Intent intCall = new Intent(Intent.ACTION_CALL);
        startActivity(intentCall);
    }
    public void button_program_click(View v){
        Toast.makeText(getApplicationContext(),"Приложения",Toast.LENGTH_SHORT).show();
    }
    public void button_go_click(View v){
        Toast.makeText(getApplicationContext(),"Запуск",Toast.LENGTH_SHORT).show();

        Intent intentGo = new Intent(Intent.ACTION_SENDTO);
        intentGo.setData(Uri.parse("smsto:"+""));
        //Intent intCall = new Intent(Intent.ACTION_CALL);
        startActivity(intentGo);
    }


    private void adjustGridView() {
        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT)
            gvMain.setNumColumns(3);
        else
            gvMain.setNumColumns(5);
        gvMain.setVerticalSpacing(2);
        gvMain.setHorizontalSpacing(2);
//        gvMainB.setNumColumns(3);
//        gvMainB.setVerticalSpacing(2);
//        gvMainB.setHorizontalSpacing(2);
        //Toast.makeText(this, "Создание Таблицы", Toast.LENGTH_LONG).show();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        if (id == R.id.action_settings1){
            //Toast.makeText(this, "Открывается пустое активити", Toast.LENGTH_LONG).show();// на девайсе всплывающее уведомление внизу
            Intent intent01 = new Intent(MainActivity.this, null_activity.class);
            startActivity(intent01);
            //setContentView(R.layout.layout_null_01);
        }

        if (id == R.id.action_settings2){
            //Toast.makeText(this, "Открывается пустое активити", Toast.LENGTH_LONG).show();// на девайсе всплывающее уведомление внизу
            String settings =  Settings.ACTION_SETTINGS;
            Intent intentSettings = new Intent(settings);
            //Intent intCall = new Intent(Intent.ACTION_CALL);
            startActivity(intentSettings);
        }

        return super.onOptionsItemSelected(item);
    }


}
