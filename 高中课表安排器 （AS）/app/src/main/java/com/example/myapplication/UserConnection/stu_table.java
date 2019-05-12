package com.example.myapplication.UserConnection;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.myapplication.CustomerHandle.Stu;
import com.example.myapplication.R;

public class stu_table extends AppCompatActivity{
private TextView t2;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stu_table);
        Bundle bundle = this.getIntent().getExtras();
        Stu stu = new Stu();
        try {
            stu = new Stu(bundle.getString("NAme"), bundle.getString("SEx"), bundle.getString("Id"), bundle.getInt("ADmiclass")
                    , bundle.getString("CHosensubs"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        t2 = findViewById(R.id.textView6);
        t2.setText(stu.showInfo());
         /*
        待填冲：
        stu利用上述信息被process调用获取课表填充界面:stu_table界面制作未完成
         */
    }
}
