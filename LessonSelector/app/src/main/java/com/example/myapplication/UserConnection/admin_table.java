package com.example.myapplication.UserConnection;

import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.myapplication.CustomerHandle.Admin;
import com.example.myapplication.CustomerHandle.Stu;
import com.example.myapplication.CustomerHandle.Teacher;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class admin_table extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    private ViewPager viewPager;
    MenuItem menuItem;//辅助底部导航实现拖动改变效果
    private List<Fragment> list = new ArrayList<Fragment>();
    private ArrayList<Stu> STUS = new ArrayList<Stu>(5);
    private ArrayList<Teacher> TEAS = new ArrayList<Teacher>(5);
    String FILE;
    private String showingInfo[] = new String[3];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_table);
        bottomNavigationView = findViewById(R.id.admin_table_bottomnavigationview);
        viewPager = findViewById(R.id.admin_table_viewpager);

        //声明BNV结构
        list.add(new admin_information_fragment());
        list.add(new admin_table_fragment());
        viewPager.setAdapter(new adapter(getSupportFragmentManager(),list));
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.item_info:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.item_table:
                        viewPager.setCurrentItem(1);
                        break;

                }
                return true;
            }
        });
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
               if(menuItem!=null){

               }
               else {
                   menuItem = bottomNavigationView.getMenu().getItem(0);
                   menuItem.setChecked(true);
               }
               menuItem = bottomNavigationView.getMenu().getItem(i);
               menuItem.setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

        //接受数据并处理数据给fragment
        Bundle bundle = this.getIntent().getExtras();
        FILE = bundle.getString("FIle");
        Admin admin = new Admin(bundle.getString("Id"),bundle.getInt("ADminclassnum"),
                STUS,TEAS);
        //存储用于在stu_infor_fragment中显示的信息
        showingInfo[0] = "ID： " + admin.getId();
        showingInfo[1] = "班级数目： " + bundle.getInt("ADminclassnum");
        showingInfo[2] = "生总数: " + admin.getStuNum() + "师总数： " + admin.getTeaNum();
        SharedPreferences myshare = getSharedPreferences("adm",MainActivity.MODE_PRIVATE);
        SharedPreferences.Editor editor = myshare.edit();
        editor.putString("0",showingInfo[0]);
        editor.putString("1",showingInfo[1]);
        editor.putString("2",showingInfo[2]);
        editor.apply();
    }

    //BNV适配器
    public class adapter extends FragmentPagerAdapter{
        private List<Fragment> list;
        public adapter(FragmentManager fm,List<Fragment> list) {
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
