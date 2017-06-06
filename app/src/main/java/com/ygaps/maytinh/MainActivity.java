package com.ygaps.maytinh;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int so_tt;
    private TextView tv_so;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_so = (TextView) findViewById(R.id.tv_number);
        so_tt = SO_TRANG_THAI.TRANG_THAI_1;
    }

    public void on_click_so(View v){
        Button b = (Button) v;
        if(so_tt == SO_TRANG_THAI.TRANG_THAI_1){
            String str = String.format("%s%s", tv_so.getText(), b.getText());
            tv_so.setText(str);
        }else if(so_tt == SO_TRANG_THAI.TRANG_THAI_2){

            tv_so.setText(b.getText());
            so_tt = SO_TRANG_THAI.TRANG_THAI_1;
            
        }
    }

    public static class SO_TRANG_THAI{
        public static int TRANG_THAI_1 = 1;//khi nhan thi cong tv voi gia tri nut nhan
        public static int TRANG_THAI_2 = 2;//khi nhan thi gan gia tri tv bang gia tri nut nhan => chuyen ve trang thai 1 lai
    }
}
