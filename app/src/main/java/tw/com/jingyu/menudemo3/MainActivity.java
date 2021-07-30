package tw.com.jingyu.menudemo3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private Button btn1;
    private ImageButton btnImg2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setCustomBar();
        findViews();
    }

    private void setCustomBar(){
        Toolbar toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        toolbar.setNavigationIcon(R.mipmap.backicon);

        //對icon做註冊監聽
        toolbar.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(),"返回上一頁",Toast.LENGTH_SHORT).show();
        });

        //在toolbar內載入mymenu
        toolbar.inflateMenu(R.menu.mymenu);

        toolbar.setOnMenuItemClickListener(item -> {

            if(item.getTitle().equals("設定")){

                Toast.makeText(getApplicationContext(),item.getTitle(),Toast.LENGTH_SHORT).show();

            }else {
                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent);
            }

            return true;

        });
    }

    private void findViews(){
        btn1 = findViewById(R.id.btnImg);
        btnImg2 = findViewById(R.id.btnImg2);

        //Button 做跳頁動作
        btn1.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this,MainActivity2.class);
            startActivity(intent);
        });

        //ImageButton 做彈出文字框動作
        btnImg2.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(),"你按了",Toast.LENGTH_SHORT).show();
        });

    }

    private void setSupportActionBar(Toolbar toolbar) {
    }
}