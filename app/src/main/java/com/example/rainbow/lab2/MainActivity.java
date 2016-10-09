package com.example.rainbow.lab2;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.rainbow.lab1.R;

/**
 * Created by 123 on 2016/9/25.
 */
public class MainActivity extends AppCompatActivity {
    @Override

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);

        final EditText username = (EditText) findViewById(R.id.username);
        final EditText password = (EditText) findViewById(R.id.password);
        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        Button login = (Button) findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(username.getText().toString())) {
                    Toast.makeText(MainActivity.this, "用户名不能为空", Toast.LENGTH_LONG).show();
                }
                else if (TextUtils.isEmpty(password.getText().toString())) {
                    Toast.makeText(MainActivity.this, "密码不能为空", Toast.LENGTH_LONG).show();
                }
                else{
                    alertDialog.setTitle("提示").setMessage("Android".equals(username.getText().toString())&&"123456".equals(password.getText().toString())
                                                            ?"登陆成功":"登录失败").setPositiveButton("确定",
                            new DialogInterface.OnClickListener(){
                                @Override
                                public void onClick(DialogInterface dialog, int which){
                                    Toast.makeText(getApplicationContext(), "对话框“确定”按钮被点击", Toast.LENGTH_LONG).show();
                                }
                            }).setNegativeButton("取消",
                            new DialogInterface.OnClickListener(){
                                @Override
                                public void onClick(DialogInterface dialog, int which){
                                    Toast.makeText(getApplicationContext(), "对话框“取消”按钮被点击", Toast.LENGTH_LONG).show();
                                }
                            }).create().show();
                }
            }
        });



        RadioGroup radioGroup1 = (RadioGroup) findViewById(R.id.type);
        radioGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton type = (RadioButton) findViewById(checkedId);
                Toast.makeText(MainActivity.this, type.getText()+"身份被选中", Toast.LENGTH_LONG).show();
            }
        });

        final RadioGroup radioGroup = (RadioGroup) findViewById(R.id.type);
        Button register = (Button) findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i = 0; i < radioGroup.getChildCount(); i++){
                    RadioButton type = (RadioButton) radioGroup.getChildAt(i);
                    {
                        if(type.isChecked()){
                            Toast.makeText(MainActivity.this, type.getText()+"身份注册功能尚未开启", Toast.LENGTH_LONG).show();
                            break;
                        }
                    }
                }
            }
        });

    }

}
