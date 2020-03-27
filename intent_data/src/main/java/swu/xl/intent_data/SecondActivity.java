package swu.xl.intent_data;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.lang.reflect.AnnotatedElement;

public class SecondActivity extends AppCompatActivity {

    EditText name_edit;
    EditText major_edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //找到控件
        name_edit = findViewById(R.id.edit_name);
        major_edit = findViewById(R.id.edit_major);

        //找到传递的信息，不管是方法一还是方法二传递的信息，用下面那种方法都可以
        //方法一
        Intent intent = this.getIntent();
        String account = intent.getStringExtra("account");
        //方法二
        //Bundle bundle = intent.getExtras();
        //String account = bundle.getString("account");

        //显示传递的信息
        TextView accountText = findViewById(R.id.account_text);
        accountText.setText(account);

        //回传信息
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                close();
            }
        });
    }

    /**
     * 关闭当前界面
     */
    private void close() {
        Intent intent = new Intent();
        intent.putExtra("name", name_edit.getText().toString());
        intent.putExtra("major", major_edit.getText().toString());
        this.setResult(RESULT_OK, intent); // 设置结果数据
        this.finish();                     // 关闭Activity
    }
}
