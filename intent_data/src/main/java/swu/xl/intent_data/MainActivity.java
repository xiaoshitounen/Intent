package swu.xl.intent_data;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText account_edit;
    EditText password_edit;

    TextView show_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //找到对应的控件
        account_edit = findViewById(R.id.edit_account);
        password_edit = findViewById(R.id.edit_password);
        show_text = findViewById(R.id.textView);

        //按钮
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jump();
            }
        });
    }

    /**
     * 跳转到下一个界面
     */
    private void jump() {
        Intent intent = new Intent(this,SecondActivity.class);

        //方法一
        intent.putExtra("account",account_edit.getText().toString());
        intent.putExtra("password",password_edit.getText().toString());

        //方法二
        //Bundle bundle = new Bundle();
        //bundle.putString("account",account_edit.getText().toString());
        //bundle.putString("password",password_edit.getText().toString());
        //intent.putExtras(bundle);

        startActivityForResult(intent,1);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 1 && resultCode == RESULT_OK){
            show_text.setText("学生昵称："+data.getStringExtra("name") + " "+"专业代码："+ data.getStringExtra("major"));
        }

        super.onActivityResult(requestCode, resultCode, data);
    }
}
