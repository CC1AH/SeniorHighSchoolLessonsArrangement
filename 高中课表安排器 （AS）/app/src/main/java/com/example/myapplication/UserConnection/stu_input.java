package com.example.myapplication.UserConnection;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.myapplication.CustomerHandle.Stu;
import com.example.myapplication.R;

public class stu_input extends AppCompatActivity {
    //要建立的STU对象的属性
    private String NAME = "default name";
    private String ID = "default id";
    private int ADMICLASS = -1;
    private String SEX = "none";
    private String CHOSENSUBS = "";
    //控件属性与启动
    private RadioGroup sexRadios;
    private RadioButton maleButton;
    private RadioButton femalebutton;
    private EditText nameInput;
    private EditText idInput;
    private EditText stuClassInput;
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

        maleButton = findViewById(R.id.radioButton);
        femalebutton = findViewById(R.id.radioButton2);
        nameInput = findViewById(R.id.stu_name_input);
        idInput = findViewById(R.id.stu_id_input);
        stuClassInput = findViewById(R.id.editText2);
        CheckPhysicsChx = findViewById(R.id.physics);
        CheckChemistryChx = findViewById(R.id.chemistry);
        CheckBiologyChx = findViewById(R.id.biology);
        CheckHistoryChx = findViewById(R.id.history);
        CheckGeographyChx = findViewById(R.id.geography);
        CheckPoliticsChx = findViewById(R.id.politics);
    }

    //返回键
    public void back_main(View v) {
        Intent intent = new Intent(stu_input.this, MainActivity.class);
        startActivityForResult(intent, 0x02);
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

    public void StuLogIn(View v) throws Exception {
        NAME = nameInput.getText().toString();
        ID = idInput.getText().toString();
        ADMICLASS = Integer.parseInt(stuClassInput.getText().toString());

        //复选就直接进行定义了
        if(CheckPhysicsChx.isChecked())
            CHOSENSUBS += "physics ";
        if(CheckBiologyChx.isChecked())
            CHOSENSUBS += "biology ";
        if(CheckChemistryChx.isChecked())
            CHOSENSUBS += "chemistry ";
        if(CheckGeographyChx.isChecked())
            CHOSENSUBS += "geography ";
        if(CheckHistoryChx.isChecked())
            CHOSENSUBS += "history ";
        if(CheckPoliticsChx.isChecked())
            CHOSENSUBS += "politics ";
        CHOSENSUBS.substring(0,CHOSENSUBS.length()-2);

        Bundle bundle = new Bundle();
        bundle.putString("NAme",NAME);
        bundle.putString("Id",ID);
        bundle.putString("SEx",SEX);
        bundle.putInt("ADmiclass",ADMICLASS);
        bundle.putString("CHosensubs",CHOSENSUBS);
        Intent intent = new Intent(stu_input.this,stu_table.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}