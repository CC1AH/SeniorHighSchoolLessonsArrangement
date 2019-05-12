package com.example.myapplication.UserConnection;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.Settings.*;

public class description extends AppCompatActivity {
    ListView listView;
    TextView textView;
    FragmentManager manager;
    ArrayAdapter<String> adapter;
    String name[] = {"使用方法","实现功能与背景","开发者与平台信息","联系我们"};
    String content[] = {"作为老师或者学生，您应该在确认您学校的管理者统一录入信息完成后通过主界面的老师或学生入口进入，填写详细信息获得课表，如果这不是您的第一次登陆，您可以通过" +
            "从系统获得的快捷登陆的序列号从主界面登陆,在您学校的管理员录入信息完成前您被要求或未被要求而提交的信息，系统不会立刻给出反馈\n\n作为管理者，本移动端将会在\n1.您于管理员" +
            "入口提交您的基本信息\n2.您确保所有师生提交完成信息\n3.您确认可能的修改与增删完成的情况下" +"生成全校所有师生的课表并且确保\n1.您在点击“查看总表”后可以看到统筹的安排\n" +
            "2.所有师生和您可以看到各自管理的课程安排的细节",
            "本移动端实现了课表的统筹安排，新高考改革要求/*  */",

            "本项目的版权信息：本项目是一个开源性质的项目\n"+ RightInformation.getRightInformation().getInformation(),

            "1.开发者的项目在github上线，试用版可以在以下网址下载：\n2.对于项目的意见和建议随时欢迎发到开发者的邮箱："};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.description);
        listView = findViewById(R.id.de_list);
        textView = findViewById(R.id.de_fra_text);
        adapter = new ArrayAdapter<String>(description.this,R.layout.description_item,name);
        listView.setAdapter(adapter);
        manager = getSupportFragmentManager();
        description_fragment desfra = (description_fragment) manager.findFragmentById(R.id.fragment1);
        //强制类型转换是必须的
        final TextView textView = desfra.getView().findViewById(R.id.de_fra_text);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                textView.setText(content[position]);
            }
        });
    }
}
