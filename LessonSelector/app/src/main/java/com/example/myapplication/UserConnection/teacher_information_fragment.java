package com.example.myapplication.UserConnection;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.myapplication.R;

public class teacher_information_fragment extends Fragment {
    private ListView listView;
    private String[] infor = {
            "姓名", "ID", "性别", "所教班与科目", "综合确认"
    };
    private Button relog;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.teacher_information_fragment, container, false);
        //监听重新登陆按钮
        relog = view.findViewById(R.id.relog);
        relog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), tea_input.class);
                startActivity(intent);
            }
        });
        listView = (ListView) view.findViewById(R.id.tea_info_list);
        //获取引用
        SharedPreferences mSharedPreferences = getActivity().getSharedPreferences("tea", Activity.MODE_PRIVATE);
        infor[0] = mSharedPreferences.getString("0", "");
        infor[1] = mSharedPreferences.getString("1", "");
        infor[2] = mSharedPreferences.getString("2", "");
        infor[3] = mSharedPreferences.getString("3", "");
        infor[4] = mSharedPreferences.getString("4", "");
        //创建并应用listView适配器
        ArrayAdapter<String> listViewAdapter = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                infor
        );
        listView.setAdapter(listViewAdapter);
        return view;
    }
}
