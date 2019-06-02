package com.example.myapplication.UserConnection;

import android.content.SharedPreferences;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.myapplication.CustomerHandle.Stu;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class stu_table extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private String[] showingInfo = new String[5];//勿忘初始化

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stu_table);
        tabLayout = findViewById(R.id.stut_tabl);
        viewPager = findViewById(R.id.infor_vp);

        //初始化viewPager结构
        List<Fragment> fragmentList = new ArrayList<Fragment>();
        fragmentList.add(new student_information_fragment());
        fragmentList.add(new student_table_fragment());
        adapter stuTableAAdapter = new adapter(getSupportFragmentManager(), fragmentList);
        viewPager.setAdapter(stuTableAAdapter);
        tabLayout.setupWithViewPager(viewPager);
        //在setupwithviewpager后需要手动添加标题
        tabLayout.getTabAt(0).setText("确认信息");
        tabLayout.getTabAt(1).setText("学生课表");

        //数据传输检查与处理
        Bundle bundle = this.getIntent().getExtras();
        Stu stu;
        String choose = "null choose";
        try {
            stu = new Stu(bundle.getString("NAme"), bundle.getString("SEx"), bundle.getString("Id"), bundle.getInt("ADmiclass")
                    , bundle.getString("CHosensubs"));//从stu_input中接受包并创建stu对象

            //存储用于在stu_infor_fragment中显示的信息
            showingInfo[0] =stu.getName();
            showingInfo[1] =stu.getID();
            showingInfo[2] = stu.getSex().toString();
            showingInfo[3] = Integer.toString(stu.getAdmiClass());
            showingInfo[4] = stu.showInfo();
             choose = stu.getChosen();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //使用SharedPreferences保存数据
        //1.获取SharedPreferences对象
        SharedPreferences mSharedPreferences = getSharedPreferences("stu", MainActivity.MODE_PRIVATE);
        //2.获取SharedPreferences.Editor对象
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        //3.使用putXXX方法保存键值对
        editor.putString("0", showingInfo[0]);
        editor.putString("1", showingInfo[1]);
        editor.putString("2", showingInfo[2]);
        editor.putString("3", showingInfo[3]);
        editor.putString("4", showingInfo[4]);
        editor.putString("5",choose);
        //4.将数据保存在文件中
        editor.apply();
    }

    public class adapter extends FragmentPagerAdapter {
        private List<Fragment> list;

        public adapter(FragmentManager fm, List<Fragment> list) {
            super(fm);
            this.list = list;
        }

        @Override
        public Fragment getItem(int position) {
            return list.get(position);
        }

        @Override
        public int getCount() {
            return list.size();
        }
    }

}
