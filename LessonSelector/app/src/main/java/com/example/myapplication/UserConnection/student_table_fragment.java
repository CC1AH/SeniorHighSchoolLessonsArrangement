package com.example.myapplication.UserConnection;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myapplication.CustomerHandle.Stu;
import com.example.myapplication.R;
import com.example.myapplication.Settings.Cla;
import com.example.myapplication.SystemHandle.StuTable;

import static com.example.myapplication.SystemHandle.Table.*;
import com.example.myapplication.SystemHandle.StuTable.*;

public class student_table_fragment extends Fragment {
    TextView[][] classViews;

    public static TextView ClassViewAdapter(TextView txt, Cla cla){
        if(cla == null)
            return null;
        txt.setText(cla.getSub()+"\n");
        txt.append(cla.getStartTime() + "to" + cla.getEndTime() + "\n");
        txt.append(cla.getWhere()+"\n");
        txt.setTextSize(17);
        txt.setTextColor(Color.RED);
        return txt;
    }

    @Nullable
    @Override
    public View onCreateView (@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //初始化引用视图和组件
        View view = inflater.inflate(R.layout.student_table_fragment,container,false);
        classViews = new TextView[5][getACN()+getMCN()];
        classViews[0][0] = view.findViewById(R.id.textViewm2);classViews[0][1] = view.findViewById(R.id.textViewm3);classViews[0][2] = view.findViewById(R.id.textViewm4);classViews[0][3] = view.findViewById(R.id.textViewm5);classViews[0][4] = view.findViewById(R.id.textViewm6);
        classViews[0][5] = view.findViewById(R.id.textViewm7);classViews[0][6] = view.findViewById(R.id.textViewm8);classViews[0][7] = view.findViewById(R.id.textViewm9);classViews[0][8] = view.findViewById(R.id.textViewm10);
        classViews[1][0] = view.findViewById(R.id.textViewt2);classViews[1][1] = view.findViewById(R.id.textViewt3);classViews[1][2] = view.findViewById(R.id.textViewt4);classViews[1][3] = view.findViewById(R.id.textViewt5);classViews[1][4] = view.findViewById(R.id.textViewt6);
        classViews[1][5] = view.findViewById(R.id.textViewt7);classViews[1][6] = view.findViewById(R.id.textViewt8);classViews[1][7] = view.findViewById(R.id.textViewt9);classViews[1][8] = view.findViewById(R.id.textViewt10);
        classViews[2][0] = view.findViewById(R.id.textVieww2);classViews[2][1] = view.findViewById(R.id.textVieww3);classViews[2][2] = view.findViewById(R.id.textVieww4);classViews[2][3] = view.findViewById(R.id.textVieww5);classViews[2][4] = view.findViewById(R.id.textVieww6);
        classViews[2][5] = view.findViewById(R.id.textVieww7);classViews[2][6] = view.findViewById(R.id.textVieww8);classViews[2][7] = view.findViewById(R.id.textVieww9);classViews[2][8] = view.findViewById(R.id.textVieww10);
        classViews[3][0] = view.findViewById(R.id.textViewh2);classViews[3][1] = view.findViewById(R.id.textViewh3);classViews[3][2] = view.findViewById(R.id.textViewh4);classViews[3][3] = view.findViewById(R.id.textViewh5);classViews[3][4] = view.findViewById(R.id.textViewh6);
        classViews[3][5] = view.findViewById(R.id.textViewh7);classViews[3][6] = view.findViewById(R.id.textViewh8);classViews[3][7] = view.findViewById(R.id.textViewh9);classViews[3][8] = view.findViewById(R.id.textViewh10);
        classViews[4][0] = view.findViewById(R.id.textViewf2);classViews[4][1] = view.findViewById(R.id.textViewf3);classViews[4][2] = view.findViewById(R.id.textViewf4);classViews[4][3] = view.findViewById(R.id.textViewf5);classViews[4][4] = view.findViewById(R.id.textViewf6);
        classViews[4][5] = view.findViewById(R.id.textViewf7);classViews[4][6] = view.findViewById(R.id.textViewf8);classViews[4][7] = view.findViewById(R.id.textViewf9);classViews[4][8] = view.findViewById(R.id.textViewf10);

        /**
         * 1.根据mSharedReference中的信息建立stu对象
         * 2.引用
         * 3.使用ClassViewAdapter来适配StuTable对象到用户界面
         */
        SharedPreferences mSharedPreferences = getActivity().getSharedPreferences("stu", Context.MODE_PRIVATE);
        try {
            Stu stu = new Stu(mSharedPreferences.getString("0", ""), mSharedPreferences.getString("2", ""), mSharedPreferences.getString("1", ""),
                    Integer.parseInt(mSharedPreferences.getString("3", "")), mSharedPreferences.getString("5", ""));
            StuTable myTable = new StuTable("myTable");
            myTable = (StuTable) myTable.process((Stu)stu);
            for(int i=0;i<5;++i){
                for(int j=0;j<getMCN()+getACN();++j){
                    if(myTable.cla[i][j]!=null)
                    classViews[i][j] = ClassViewAdapter(classViews[i][j],myTable.cla[i][j]);
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return view;
    }
}
