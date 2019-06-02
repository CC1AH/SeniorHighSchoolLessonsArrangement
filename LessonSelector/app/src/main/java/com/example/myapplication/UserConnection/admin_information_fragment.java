package com.example.myapplication.UserConnection;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.myapplication.R;

public class admin_information_fragment extends Fragment {
    private String[] infor = new String[3];//一定要是3...坚决不能向ArrayAdapter传递空指针
    private ListView listView;
    private Button relog;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.admin_information_fragment,container,false);
       relog = view.findViewById(R.id.relog);
       listView = view.findViewById(R.id.adm_info_list);
       relog.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(getActivity(),admin_input.class);
               startActivity(intent);
           }
       });
        SharedPreferences mSharedPreferences = getActivity().getSharedPreferences("adm",MainActivity.MODE_PRIVATE);
        infor[0] = mSharedPreferences.getString("0", "");
        Log.d("0",infor[0]);
        infor[1] = mSharedPreferences.getString("1", "");
        Log.d("1",infor[1]);
        infor[2] = mSharedPreferences.getString("2", "");
        Log.d("2",infor[2]);
        ArrayAdapter<String> listViewArrayAdapter = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                infor
        );
        listView.setAdapter(listViewArrayAdapter);
        return view;
    }
}
