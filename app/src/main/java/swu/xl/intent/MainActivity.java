package swu.xl.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img = findViewById(R.id.img);
    }

    public void jump(View view) {
        Intent intent = new Intent("android.intent.action.SECOND");
        startActivity(intent);
    }

    public void call(View view) {
        Uri uri = Uri.parse("tel:10010");
        Intent intent = new Intent(Intent.ACTION_DIAL, uri);
        startActivity(intent);
    }

    public void send_message(View view) {
        Uri uri = Uri.parse("smsto:10010");
        Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
        intent.putExtra("sms_body", "Hello");
        startActivity(intent);
    }

    public void online(View view) {
        // 打开百度主页
        Uri uri = Uri.parse("https://www.baidu.com");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void send_emil(View view) {
        // 给someone@domain.com发邮件
        Uri uri = Uri.parse("mailto:someone@domain.com");
        Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
        startActivity(intent);
    }

    public void map(View view) {
        // 打开Google地图中国北京位置（北纬39.9，东经116.3）
        Uri uri = Uri.parse("geo:39.9,116.3");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void setting(View view) {
        // 进入系统设置界面
        Intent intent = new Intent(android.provider.Settings.ACTION_SETTINGS);
        startActivity(intent);
    }

    public void choosePic(View view) {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        startActivityForResult(intent, 2);
    }

    public void shexiangtou(View view) {
        // 打开拍照程序
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, 1);

        // 取出照片数据
        Bundle extras = intent.getExtras();
        //Bitmap bitmap = (Bitmap) extras.get("data");

        //img.setImageBitmap(bitmap);
    }
}
