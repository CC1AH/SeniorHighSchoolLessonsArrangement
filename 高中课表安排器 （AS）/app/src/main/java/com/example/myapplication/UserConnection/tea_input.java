package com.example.myapplication.UserConnection;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.myapplication.R;

public class tea_input extends AppCompatActivity {
    //要创建的老师对象的属性
    private String Name = "default name";
    private String Subject = "defualt subject";
    private String Id = "default id";
    private int TeaClass = -1;
    private String SEX = "none";
    //控件名和启动初始化
    private RadioGroup sexRadios;
    private RadioButton maleButton;
    private RadioButton femalebutton;
    private EditText nameInput;
    private EditText idInput;
    private EditText teaClassInput;
    private EditText teaSubInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tea_input);
        sexRadios = findViewById(R.id.radio_group);
        sexRadios.setOnCheckedChangeListener(onCheckedChangeOfSex);
        //注册事件监听器
        maleButton = findViewById(R.id.radioButton4);
        femalebutton = findViewById(R.id.radioButton3);
        nameInput = findViewById(R.id.tea_name_input);
        idInput = findViewById(R.id.tea_id_input);
        teaClassInput = findViewById(R.id.editText3);
        teaSubInput = findViewById(R.id.tea_subject);
    }

    //按钮组的监听事件
    private RadioGroup.OnCheckedChangeListener onCheckedChangeOfSex
            = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (group.getCheckedRadioButtonId()) {
                case R.id.radioButton3:
                    SEX = "female";
                    break;
                case R.id.radioButton4:
                    SEX = "male";
                default:
                    break;
            }
        }
    };

    //返回键
    public void back_main(View v) {
        Intent intent = new Intent(tea_input.this, MainActivity.class);
        startActivityForResult(intent, 0x02);
    }

    //登入与活动联系
    public void logIn(View v) {
        Name = nameInput.getText().toString();
        Id = idInput.getText().toString();
        TeaClass = Integer.parseInt(teaClassInput.getText().toString());
        Subject = teaSubInput.getText().toString();
        //在AS中传输数据而不传输对象以减小数据量和代码复杂性
        //向tea_table传输数据包
        Bundle bundle = new Bundle();
        bundle.putString("NAme",Name);
        bundle.putString("ID",Id);
        bundle.putString("SUbject",Subject);
        bundle.putString("SEx",SEX);
        bundle.putInt("TEaclass",TeaClass);
        Intent intent  = new Intent(tea_input.this,tea_table.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
