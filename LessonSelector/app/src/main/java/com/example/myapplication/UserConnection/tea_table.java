package com.example.myapplication.UserConnection;

import android.content.SharedPreferences;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.myapplication.R;

import com.example.myapplication.CustomerHandle.Teacher;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class tea_table extends AppCompatActivity {
    private TabLayout tableLayout;
    private ViewPager viewPager;
    private List<Fragment> tea_table_fragments;
    private String[] showingInfo = new String[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tea_table);
        tableLayout = findViewById(R.id.tea_table_tablayout);
        viewPager = findViewById(R.id.tea_table_viewpager);

        //初始化viewPager结构
        tea_table_fragments = new ArrayList<Fragment>();
        tea_table_fragments.add(new teacher_information_fragment());
        tea_table_fragments.add(new teacher_table_fragment());
        viewPager.setAdapter(new adapter(getSupportFragmentManager(), tea_table_fragments));
        tableLayout.setupWithViewPager(viewPager);
        //在setupwithviewpager后需要手动添加标题
        tableLayout.getTabAt(0).setText("确认信息");
        tableLayout.getTabAt(1).setText("教师课表");

        //数据传输与检查处理
        Bundle bundle = this.getIntent().getExtras();
        Teacher tea = new Teacher(bundle.getString("NAme"), bundle.getString("SUbject"), bundle.getString("ID"), bundle.getInt("TEaclass"),
                bundle.getString("SEx"));
        //存储用于在tea_infor_fragment中显示的信息
        showingInfo[0] = "姓名： " + tea.getName();
        showingInfo[1] = "ID： " + tea.getId();
        showingInfo[2] = "性别： " + tea.getSex();
        showingInfo[3] = "所教班与科目： " + tea.getTeaClass() + " " + tea.getSubject();
        showingInfo[4] = "综合确认：\n " + tea.showInfo();
        //使用SharedPreference保存数据
        SharedPreferences mSharedPreferences = getSharedPreferences("tea", MainActivity.MODE_PRIVATE);
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString("0", showingInfo[0]);
        editor.putString("1", showingInfo[1]);
        editor.putString("2", showingInfo[2]);
        editor.putString("3", showingInfo[3]);
        editor.putString("4", showingInfo[4]);
        editor.apply();
    }

    public class adapter extends FragmentPagerAdapter {
        private List<Fragment> list;

        public adapter(FragmentManager fm, List<Fragment> list) {
            super(fm);
            this.list = list;
        }

        @Override
        public Fragment getItem(int i) {
            return list.get(i);
        }

        @Override
        public int getCount() {
            return list.size();
        }
    }
}
