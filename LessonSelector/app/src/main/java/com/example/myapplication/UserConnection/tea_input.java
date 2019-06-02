package com.example.myapplication.UserConnection;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.Settings.Choose;

import static com.example.myapplication.UserConnection.stu_input.*;//需要使用里面的isInteger方法
public class tea_input extends AppCompatActivity {
    //要创建的老师对象的属性
    private String Name = "default name";
    private String Subject = "defualt subject";
    private String Id = "default id";
    private int TeaClass = -1;
    private String SEX = "none";
    //控件名和启动初始化
    private RadioGroup sexRadios;
    private EditText nameInput;
    private EditText idInput;
    private TextInputLayout teaClass;
    private TextInputEditText teaClassInput;
    private TextInputLayout teaSub;
    private TextInputEditText teaSubInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tea_input);
        sexRadios = findViewById(R.id.radio_group);
        sexRadios.setOnCheckedChangeListener(onCheckedChangeOfSex);
        //注册事件监听器
        nameInput = findViewById(R.id.tea_name_input);
        idInput = findViewById(R.id.tea_id_input);
        teaClassInput = findViewById(R.id.tea_cla_input);
        teaClass = findViewById(R.id.tea_cla);
        teaSubInput = findViewById(R.id.tea_sub_input);
        teaSub = findViewById(R.id.tea_sub);
        check();
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

    //监听文本输入

    //判断是否输入的科目是正确的
    private boolean isSub(String s){
        if(s.equals(Choose.physics.toString())||s.equals(Choose.chemistry.toString())||s.equals(Choose.biology.toString())
                ||s.equals(Choose.history.toString())||s.equals(Choose.geography.toString())||s.equals(Choose.politics.toString())||
                s.equals(Choose.math.toString())||s.equals(Choose.chinese.toString())||s.equals(Choose.english.toString())
                ||s.equals(Choose.music.toString())||s.equals(Choose.drawing.toString())||s.equals(Choose.PE.toString())){
            return true;
        }
        return false;
    }

    private void check(){
        teaClassInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(!isInteger(teaClassInput.getText().toString())){
                    teaClass.setError("请确认你这里输入一个数字");
                }
                if(!isSub(teaSubInput.getText().toString())){
                    teaSub.setError("请你确认输入了正确的科目：\n ");
                }
            }
        });
    }

    //返回键
    public void back_main(View v) {
        Intent intent = new Intent(tea_input.this, MainActivity.class);
        startActivityForResult(intent, 0x02);
    }

    //登入与活动联系
    public void logIn(View v) {
        Name = nameInput.getText().toString();
        Id = idInput.getText().toString();
        if(!isInteger(teaClassInput.getText().toString())){
            Toast.makeText(tea_input.this,"请检查班级数输入是否符合提示",Toast.LENGTH_LONG).show();
            return;
        }
        if(!isSub(teaSubInput.getText().toString())){
            Toast.makeText(tea_input.this,"请检查科目输入是否符合提示",Toast.LENGTH_LONG).show();
            return;
        }
        Subject = teaSubInput.getText().toString();
        TeaClass = Integer.parseInt(teaClassInput.getText().toString());
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
