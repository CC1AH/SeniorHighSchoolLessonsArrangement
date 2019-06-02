package com.example.myapplication.UserConnection;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.myapplication.R;

import java.util.regex.Pattern;

public class stu_input extends AppCompatActivity {
    //要建立的STU对象的属性
    private String NAME = "default name";
    private String ID = "default id";
    private int ADMICLASS = -1;
    private String SEX = "none";
    private String CHOSENSUBS = "";
    //控件属性与启动
    private RadioGroup sexRadios;
    private EditText nameInput;
    private EditText idInput;
    private TextInputLayout stuClass;
    private TextInputEditText stuClassInput;
    private CheckBox CheckPhysicsChx;
    private CheckBox CheckChemistryChx;
    private CheckBox CheckBiologyChx;
    private CheckBox CheckHistoryChx;
    private CheckBox CheckGeographyChx;
    private CheckBox CheckPoliticsChx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stu_input);
        sexRadios = findViewById(R.id.radioGroup);
        //注册单选事件监听器
        sexRadios.setOnCheckedChangeListener(onCheckedChangeOfSex);

        nameInput = findViewById(R.id.stu_name_input);
        idInput = findViewById(R.id.stu_id_input);
        stuClassInput = findViewById(R.id.stu_cla_input);
        stuClass = findViewById(R.id.stu_cla);
        CheckPhysicsChx = findViewById(R.id.physics);
        CheckChemistryChx = findViewById(R.id.chemistry);
        CheckBiologyChx = findViewById(R.id.biology);
        CheckHistoryChx = findViewById(R.id.history);
        CheckGeographyChx = findViewById(R.id.geography);
        CheckPoliticsChx = findViewById(R.id.politics);

        check();//检查输入是否符合规范
    }

    //返回键
    public void back_main(View v) {
        Intent intent = new Intent(stu_input.this, MainActivity.class);
        startActivityForResult(intent, 0x02);
    }

    //判断一个数字是否为整形
    public static boolean isInteger(String s) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(s).matches();
    }

    //检查数据的输入是否符合规范
    public void check() {
        stuClassInput.addTextChangedListener(new TextWatcher() {//注意方法名字不一样
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }//即使是空的也必须 TextWatcher是虚类

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!isInteger(stuClassInput.getText().toString())) {
                    stuClass.setError("请确认你这里输入一个数字");
                }
            }
        });
    }

    //单选框监听器
    private RadioGroup.OnCheckedChangeListener onCheckedChangeOfSex = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (group.getCheckedRadioButtonId()) {
                case R.id.radioButton2:
                    SEX = "female";
                    break;
                case R.id.radioButton:
                    SEX = "male";
                default:
                    break;
            }
        }
    };

    //登陆按钮
   public void StuLogIn(View v) throws Exception {
        NAME = nameInput.getText().toString();
        ID = idInput.getText().toString();

        //复选就直接进行定义了
        if (CheckPhysicsChx.isChecked())
            CHOSENSUBS += "physics ";
        if (CheckBiologyChx.isChecked())
            CHOSENSUBS += "biology ";
        if (CheckChemistryChx.isChecked())
            CHOSENSUBS += "chemistry ";
        if (CheckGeographyChx.isChecked())
            CHOSENSUBS += "geography ";
        if (CheckHistoryChx.isChecked())
            CHOSENSUBS += "history ";
        if (CheckPoliticsChx.isChecked())
            CHOSENSUBS += "politics ";
        if(CHOSENSUBS.split(" ").length!=3){
            Toast.makeText(stu_input.this,"请确认你选课三门",Toast.LENGTH_LONG).show();
            CHOSENSUBS = "";//置空 重要 否则再来一次的时候会重复加
            return;
        };
        if(!isInteger(stuClassInput.getText().toString())){
            Toast.makeText(stu_input.this,"请确认你的输入符合提示信息",Toast.LENGTH_LONG).show();
            CHOSENSUBS = "";//置空 重要 否则再来一次的时候会重复加
            return;
        }
        ADMICLASS = Integer.parseInt(stuClassInput.getText().toString());
        CHOSENSUBS.substring(0, CHOSENSUBS.length() - 2);

        //在Activity之间传值:只是一个演示 stu_information_fragment和stu_table中传值使用了sharedPreference,在不追求效率者应该是首选的方式（比较清晰）
        Bundle bundle = new Bundle();
        bundle.putString("NAme", NAME);
        bundle.putString("Id", ID);
        bundle.putString("SEx", SEX);
        bundle.putInt("ADmiclass", ADMICLASS);
        bundle.putString("CHosensubs", CHOSENSUBS);
        Intent intent = new Intent(stu_input.this, stu_table.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}