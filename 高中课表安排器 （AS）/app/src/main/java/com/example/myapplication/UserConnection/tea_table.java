package com.example.myapplication.UserConnection;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.myapplication.R;

import com.example.myapplication.CustomerHandle.Teacher;
/**
 *
 *
 */
public class tea_table extends AppCompatActivity {
private TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tea_table);
        Bundle bundle = this.getIntent().getExtras();
        Teacher tea = new Teacher(bundle.getString("NAme"),bundle.getString("SUbject"),bundle.getString("ID"),bundle.getInt("TEaclass"),
        bundle.getString("SEx"));

        t1 = findViewById(R.id.textView4);
        t1.setText(tea.showInfo());
        /*
        待填冲：
        tea利用上述信息被process调用获取课表填充界面
         */

    }
}
