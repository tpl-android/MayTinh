package com.ygaps.maytinh;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int so_tt;
    private TextView tv_so;
    private Button b_PhanTram;
    private Double toantu1;
    private int pheptoan;//1 cong, 2 tru, 3 nhan, 4 chia

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_so = (TextView) findViewById(R.id.tv_number);
        b_PhanTram = (Button) findViewById(R.id.b_PhanTram);
        b_PhanTram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    //B1: lấy chuỗi từ giao diện
                    String str = tv_so.getText().toString();
                    //B2: chuyển chuỗi thành dữ liệu và xử lý
                    double d = Double.parseDouble(str);
                    d = d / 100;
                    //B3: chuyển dữ liệu thành chuỗi và hiển thị
                    str = String.valueOf(d);
                    //xoa số .0 nếu là trường 12.0
                    int leng = str.length();
                    if (leng > 0 &&
                            str.charAt(leng - 1) == '0' &&
                            str.charAt(leng - 2) == '.') {

                        str = str.substring(0, leng - 2);
                    }
                    tv_so.setText(str);
                } catch (Exception ex) {
                }
            }
        });


        so_tt = SO_TRANG_THAI.TRANG_THAI_1;
    }

    public void on_click_phep_cong(View v){
        String str = tv_so.getText().toString();
        toantu1 = Double.parseDouble(str);
        so_tt = SO_TRANG_THAI.TRANG_THAI_2;
        pheptoan = 1;
    }

    public void on_click_phep_chia(View v){
        String str = tv_so.getText().toString();
        toantu1 = Double.parseDouble(str);
        so_tt = SO_TRANG_THAI.TRANG_THAI_2;
        pheptoan = 4;
    }

    public void on_click_bang(View v){
        if(toantu1 != null && pheptoan >= 1 && pheptoan <= 4){
            String str = tv_so.getText().toString();
            Double toantu2 = Double.parseDouble(str);
            if(pheptoan == 1){
                Double kq = toantu1 + toantu2;
                str = String.valueOf(kq);
                int leng = str.length();
                if (leng > 0 &&
                        str.charAt(leng - 1) == '0' &&
                        str.charAt(leng - 2) == '.') {

                    str = str.substring(0, leng - 2);
                }
                tv_so.setText(str);
            }else if(pheptoan == 4){
                if(toantu2 == 0){
                    Toast.makeText(MainActivity.this, "Not a number", Toast.LENGTH_SHORT).show();
                    //tv_so.setText("Not a number");
                    so_tt = SO_TRANG_THAI.TRANG_THAI_2;
                    return;
                }
                Double kq = toantu1 / toantu2;
                str = String.valueOf(kq);
                int leng = str.length();
                if (leng > 0 &&
                        str.charAt(leng - 1) == '0' &&
                        str.charAt(leng - 2) == '.') {

                    str = str.substring(0, leng - 2);
                }
                tv_so.setText(str);
            }
        }
    }

    public void on_click_so(View v){
        Button b = (Button) v;
        if(so_tt == SO_TRANG_THAI.TRANG_THAI_1){
            String str = String.format("%s%s", tv_so.getText(), b.getText());
            double d;
            boolean kiemtraso;
            try {
                d = Double.parseDouble(str);//chuyen chuoi thanh so
                kiemtraso = true;//chuyen thanh so thanh cong
            } catch (Exception ex){
                d = 0;
                kiemtraso = false;//chuyen thanh so bi loi
            }
//            if(str.equals("x.")){//kiem tra dinh dang (kiem tra so dien thoai ...)
//
//            }else
            if(kiemtraso == true){
                //lay gia tri moi
                //str = String.valueOf(d);
                if(str.charAt(0) == '0'){
                    if(str.charAt(1) != '.') {
                        //xoa chu so 0 tai dau
                        str = str.substring(1);
                    }
                }
            }else{
                //giu gia tri cua textbox
                str = tv_so.getText().toString();
            }
            tv_so.setText(str);
        }else if(so_tt == SO_TRANG_THAI.TRANG_THAI_2){
            tv_so.setText(b.getText());
            so_tt = SO_TRANG_THAI.TRANG_THAI_1;
            
        }
    }

    public void on_click_ac(View v){
        tv_so.setText("0");
    }

    public void on_click_am_duong(View v){
        try {
            String str = tv_so.getText().toString();
            double d = Double.parseDouble(str);
            if(d > 0){
                str = "-" + str;
            }else if(d == 0){

            }else{
                str = str.substring(1);
            }
            tv_so.setText(str);
        } catch (Exception ex){
        }
    }

    public static class SO_TRANG_THAI{
        public static int TRANG_THAI_1 = 1;//khi nhan thi cong tv voi gia tri nut nhan
        public static int TRANG_THAI_2 = 2;//khi nhan thi gan gia tri tv bang gia tri nut nhan => chuyen ve trang thai 1 lai
    }
}















