package com.example.myapplication.UserConnection;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.myapplication.CustomerHandle.Admin;
import com.example.myapplication.CustomerHandle.Stu;
import com.example.myapplication.CustomerHandle.Teacher;
import com.example.myapplication.R;

import java.util.ArrayList;

public class admin_table extends AppCompatActivity {
    private ArrayList<Stu> STUS = new ArrayList<Stu>();
    private ArrayList<Teacher> TEAS = new ArrayList<Teacher>();
    private String FILE;
    private TextView t3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_table);
        Bundle bundle = this.getIntent().getExtras();
        FILE = bundle.getString("FIle");
        Admin admin = new Admin(bundle.getString("Id"),bundle.getInt("ADminclassnum"),
                STUS,TEAS);

        /*待填写：根据文件填写STUS和TEAS信息 并调用admin的process方法生成课表*/
        t3 = findViewById(R.id.textView7);
        t3.setText(admin.showInfo());
    }
}
