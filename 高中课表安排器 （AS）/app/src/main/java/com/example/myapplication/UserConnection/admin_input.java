package com.example.myapplication.UserConnection;

import android.content.Intent;
import android.support.annotation.ArrayRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.CustomerHandle.Admin;
import com.example.myapplication.CustomerHandle.Stu;
import com.example.myapplication.CustomerHandle.Teacher;
import com.example.myapplication.R;

import java.util.ArrayList;

public class admin_input extends AppCompatActivity {
    //要建立的admin对象的属性
    private String NAME;
    private String ID;
    private String FILE;
    private int AdmiClassNum;
    //控件属性和启动
    private EditText name_input;
    private EditText id_input;
    private EditText file_input;
    private EditText class_number_input;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_input);
        name_input = findViewById(R.id.admin_name_input);
        id_input = findViewById(R.id.admin_id_input);
        file_input = findViewById(R.id.file_input);
        class_number_input = findViewById(R.id.number_input);
    }
    public void back_main(View v){
        Intent intent = new Intent(admin_input.this, MainActivity.class);
        startActivity(intent);
    }
    public void goto_stu(View v){
        Intent intent = new Intent(admin_input.this,stu_input.class);
        startActivity(intent);
    }
    public void goto_tea(View v){
        Intent intent = new Intent(admin_input.this,tea_input.class);
        startActivity(intent);
    }
    public void admin_login(View v){
        NAME = name_input.getText().toString();
        ID = id_input.getText().toString();
        AdmiClassNum = Integer.parseInt(class_number_input.getText().toString());
        FILE = file_input.getText().toString();

       //STUS以及TEAS的信息在admin_table中进行处理
        Bundle bundle = new Bundle();
        bundle.putString("NAme",NAME);
        bundle.putString("Id",ID);
        bundle.putInt("ADminclassnum",AdmiClassNum);
        bundle.putString("FIle",FILE);
        Intent intent = new Intent(admin_input.this,admin_table.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
