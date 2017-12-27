package com.ppc.phicuong.chung_firebase1;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.CountDownTimer;
import android.renderscript.Sampler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import org.w3c.dom.Text;

import static java.lang.String.valueOf;

public class MainActivity extends AppCompatActivity {
    TextView TextDEN1, TextPWM1, TextDEN2, TextPWM2, TextDEN3, TextPWM3, TextDEN4, TextPWM4;
    ImageView imageDEN1, imageDEN2, imageDEN3, imageDEN4;
    Switch swOnOff1, swOnOff2, swOnOff3, swOnOff4;
    SeekBar seekBar1, seekBar2, seekBar3, seekBar4;
    Button btnThoat;
    WebView wv;
    EditText et_name, et_pass;
    private static final int PERMISSIONS_REQUEST_CODE_ACCESS_COARSE_LOCATION = 1001;
    Firebase myFirebase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (!isConnected(MainActivity.this)) buildDialog(MainActivity.this).show();
        else {
            Toast.makeText(MainActivity.this, "Chào Mừng Đến Với Chúng Tôi", Toast.LENGTH_SHORT).show();
        }
        swOnOff1 = (Switch) findViewById(R.id.swOnOff1);
        swOnOff2 = (Switch) findViewById(R.id.swOnOff2);
        swOnOff3 = (Switch) findViewById(R.id.swOnOff3);
        swOnOff4 = (Switch) findViewById(R.id.swOnOff4);
        seekBar1 = (SeekBar) findViewById(R.id.seekBar1);
        seekBar2 = (SeekBar) findViewById(R.id.seekBar2);
        seekBar3 = (SeekBar) findViewById(R.id.seekBar3);
        seekBar4 = (SeekBar) findViewById(R.id.seekBar4);
        TextDEN1 = (TextView) findViewById(R.id.textDEN1);
        TextDEN2 = (TextView) findViewById(R.id.textDEN2);
        TextDEN3 = (TextView) findViewById(R.id.textDEN3);
        TextDEN4 = (TextView) findViewById(R.id.textDEN4);
        TextPWM1 = (TextView) findViewById(R.id.textPWM1);
        TextPWM2 = (TextView) findViewById(R.id.textPWM2);
        TextPWM3 = (TextView) findViewById(R.id.textPWM3);
        TextPWM4 = (TextView) findViewById(R.id.textPWM4);
        imageDEN1 = (ImageView) findViewById(R.id.imageDEN1);
        imageDEN2 = (ImageView) findViewById(R.id.imageDEN2);
        imageDEN3 = (ImageView) findViewById(R.id.imageDEN3);
        imageDEN4 = (ImageView) findViewById(R.id.imageDEN4);
        btnThoat  = (Button)     findViewById(R.id.buttonThoat);

        try {
            Firebase.setAndroidContext(this);
            myFirebase = new Firebase("https://savevalueonfirebase.firebaseio.com");
        } catch (Exception e1) {
            Toast.makeText(MainActivity.this, e1.toString(), Toast.LENGTH_SHORT).show();
        }

        //*********************************************************************************************************
        //*******************TEXTVIEW UPDATE TRẠNG THÁI ĐÈN********************************************************
        // ******************************************************************************************************
        myFirebase.child("DEN 1").child("STATE").child("TRANG THAI").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.getValue().equals("SANG")) {
                    imageDEN1.setImageResource(R.drawable.hinh1);
                    swOnOff1.setChecked(true);
                    Toast.makeText(MainActivity.this, "Đã Cập Nhật", Toast.LENGTH_SHORT).show();

                } else if (dataSnapshot.getValue().equals("TAT")) {
                    imageDEN1.setImageResource(R.drawable.hinh2);
                    swOnOff1.setChecked(false);
                    Toast.makeText(MainActivity.this, "Đã Cập Nhật", Toast.LENGTH_SHORT).show();
                }
                TextDEN1.setText(dataSnapshot.getValue().toString());
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        myFirebase.child("DEN 2").child("STATE").child("TRANG THAI").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.getValue().equals("SANG")) {
                    imageDEN2.setImageResource(R.drawable.hinh1);
                    swOnOff2.setChecked(true);
                    Toast.makeText(MainActivity.this, "Đã Cập Nhật", Toast.LENGTH_SHORT).show();

                } else if (dataSnapshot.getValue().equals("TAT")) {
                    imageDEN2.setImageResource(R.drawable.hinh2);
                    swOnOff2.setChecked(false);
                    Toast.makeText(MainActivity.this, "Đã Cập Nhật", Toast.LENGTH_SHORT).show();
                }
                TextDEN2.setText(dataSnapshot.getValue().toString());
            }
            @Override
            public void onCancelled(FirebaseError firebaseError) {
            }
        });
        myFirebase.child("DEN 3").child("STATE").child("TRANG THAI").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.getValue().equals("SANG")) {
                    imageDEN3.setImageResource(R.drawable.hinh1);
                    swOnOff3.setChecked(true);
                    Toast.makeText(MainActivity.this, "Đã Cập Nhật", Toast.LENGTH_SHORT).show();

                } else if (dataSnapshot.getValue().equals("TAT")) {
                    imageDEN3.setImageResource(R.drawable.hinh2);
                    swOnOff3.setChecked(false);
                    Toast.makeText(MainActivity.this, "Đã Cập Nhật", Toast.LENGTH_SHORT).show();
                }
                TextDEN3.setText(dataSnapshot.getValue().toString());
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        myFirebase.child("DEN 4").child("STATE").child("TRANG THAI").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.getValue().equals("SANG")) {
                    imageDEN4.setImageResource(R.drawable.hinh1);
                    swOnOff4.setChecked(true);
                    Toast.makeText(MainActivity.this, "Đã Cập Nhật", Toast.LENGTH_SHORT).show();

                } else if (dataSnapshot.getValue().equals("TAT")) {
                    imageDEN4.setImageResource(R.drawable.hinh2);
                    swOnOff4.setChecked(false);
                    Toast.makeText(MainActivity.this, "Đã Cập Nhật", Toast.LENGTH_SHORT).show();
                }
                TextDEN4.setText(dataSnapshot.getValue().toString());
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        //*********************************************************************************************************
        //*******************TEXTVIEW UPDATE ĐỘ SÁNG ĐÈN*********************************************************
        // ******************************************************************************************************
        myFirebase.child("DEN 1").child("STATE").child("DO SANG").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                TextPWM1.setText(dataSnapshot.getValue().toString());

            }
            @Override
            public void onCancelled(FirebaseError firebaseError) {
            }
        });


        myFirebase.child("DEN 2").child("STATE").child("DO SANG").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                TextPWM2.setText(dataSnapshot.getValue().toString());

            }
            @Override
            public void onCancelled(FirebaseError firebaseError) {
            }
        });
        myFirebase.child("DEN 3").child("STATE").child("DO SANG").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                TextPWM3.setText(dataSnapshot.getValue().toString());

            }
            @Override
            public void onCancelled(FirebaseError firebaseError) {
            }
        });
        myFirebase.child("DEN 4").child("STATE").child("DO SANG").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                TextPWM4.setText(dataSnapshot.getValue().toString());

            }
            @Override
            public void onCancelled(FirebaseError firebaseError) {
            }
        });
        //*********************************************************************************************************
        //*******************seek bar UPDATE ĐỘ SÁNG ĐÈN**********************************************************
        // *******************************************************************************************************
        myFirebase.child("DEN 1").child("STATE").child("DO SANG").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                seekBar1.setProgress(Integer.valueOf(dataSnapshot.getValue().toString()));
            }
            @Override
            public void onCancelled(FirebaseError firebaseError) {
            }
        });
        myFirebase.child("DEN 2").child("STATE").child("DO SANG").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                seekBar2.setProgress(Integer.valueOf(dataSnapshot.getValue().toString()));
            }
            @Override
            public void onCancelled(FirebaseError firebaseError) {
            }
        });
        myFirebase.child("DEN 3").child("STATE").child("DO SANG").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                seekBar3.setProgress(Integer.valueOf(dataSnapshot.getValue().toString()));
            }
            @Override
            public void onCancelled(FirebaseError firebaseError) {
            }
        });
        myFirebase.child("DEN 4").child("STATE").child("DO SANG").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                seekBar4.setProgress(Integer.valueOf(dataSnapshot.getValue().toString()));
            }
            @Override
            public void onCancelled(FirebaseError firebaseError) {
            }
        });
        //*****************************************************************************************************
        //*******************SWITCH BẬT TẮT ĐÈN****************************************************************
        // ****************************************************************************************************
        swOnOff1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    myFirebase.child("DEN 1").child("STATE").child("TRANG THAI").setValue("SANG");
                } else {
                    myFirebase.child("DEN 1").child("STATE").child("TRANG THAI").setValue("TAT");
                }
            }
        });
        swOnOff2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    myFirebase.child("DEN 2").child("STATE").child("TRANG THAI").setValue("SANG");
                } else {
                    myFirebase.child("DEN 2").child("STATE").child("TRANG THAI").setValue("TAT");
                }
            }
        });
        swOnOff3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    myFirebase.child("DEN 3").child("STATE").child("TRANG THAI").setValue("SANG");
                } else {
                    myFirebase.child("DEN 3").child("STATE").child("TRANG THAI").setValue("TAT");
                }
            }
        });
        swOnOff4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    myFirebase.child("DEN 4").child("STATE").child("TRANG THAI").setValue("SANG");
                    imageDEN4.setImageResource(R.drawable.hinh1);
                } else {
                    myFirebase.child("DEN 4").child("STATE").child("TRANG THAI").setValue("TAT");
                }
            }
        });
        //*********************************************************************************************************
        //*******************THANH ĐIỀU CHỈNH ĐỘ SÁNG ĐÈN DÙNG SEEKBAR*********************************************
        //*********************************************************************************************************
        seekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progress_value1;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progress_value1 = progress;
                myFirebase.child("DEN 1").child("STATE").child("DO SANG").setValue(valueOf((seekBar1.getProgress())));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this, "Độ Sáng Thiết Lập Đèn 1: " + progress_value1, Toast.LENGTH_SHORT).show();
            }
        });
        seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progress_value2;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progress_value2 = progress;
                myFirebase.child("DEN 2").child("STATE").child("DO SANG").setValue(valueOf((seekBar2.getProgress())));
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this, "Độ Sáng Thiết Lập Đèn 2: " + progress_value2, Toast.LENGTH_SHORT).show();
            }
        });
        seekBar3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progress_value3;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progress_value3 = progress;
                myFirebase.child("DEN 3").child("STATE").child("DO SANG").setValue(valueOf((seekBar3.getProgress())));
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this, "Độ Sáng Thiết Lập Đèn 3: " + progress_value3, Toast.LENGTH_SHORT).show();
            }
        });
        seekBar4.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progress_value4;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progress_value4 = progress;
                myFirebase.child("DEN 4").child("STATE").child("DO SANG").setValue(valueOf((seekBar4.getProgress())));
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this, "Độ Sáng Thiết Lập Đèn 4: " + progress_value4, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void esp8266(){
        final Dialog dialogled = new Dialog(this);
        dialogled.setContentView(R.layout.esp8266);
        dialogled.setTitle("CÀI ĐẶT WIFI CHO ĐÈN");
        Button bt_setting = dialogled.findViewById(R.id.button);
        et_name= dialogled.findViewById(R.id.editText_SSID);
        et_pass= dialogled.findViewById(R.id.editText2_PASS);
        wv= dialogled.findViewById(R.id.wv);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && checkSelfPermission(android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{android.Manifest.permission.ACCESS_COARSE_LOCATION}, PERMISSIONS_REQUEST_CODE_ACCESS_COARSE_LOCATION);
        }
        bt_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (et_name.getText().toString().equalsIgnoreCase(""))
                    Toast.makeText(MainActivity.this, "Vui lòng nhập tên mạng WiFi", Toast.LENGTH_SHORT).show();
                else {
                    try{
                        wv.getSettings().setJavaScriptEnabled(true);
                        wv.loadUrl("http://192.168.4.1:80/HHssid:" + et_name.getText().toString() + "[()]bssid:" + et_pass.getText().toString() + "[()]fn");
                        Toast.makeText(MainActivity.this, "Đã tến hành cài đặt", Toast.LENGTH_SHORT).show();
                    }catch (Exception e1)
                    {
                        Toast.makeText(MainActivity.this, e1.toString(), Toast.LENGTH_SHORT).show();
                    }
                }
            }

        });
        dialogled.show();
    }
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == PERMISSIONS_REQUEST_CODE_ACCESS_COARSE_LOCATION
                && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(MainActivity.this, "xin quyen", Toast.LENGTH_SHORT).show();
        }
    }
    // *******************************************************************************************************
    //*************************NÚT THOÁT CHƯƠNG TRÌNH*******************************************
    // *******************************************************************************************************
    public void clickExit(View v) {
        moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
    }
    // *******************************************************************************************************
    //*****************SỰ KIỆN KIỂM TRA HOẠT ĐỘNG KẾT NỐI VÀ NÚT OK*****************************************
    // *******************************************************************************************************
    public boolean isConnected(Context context) {

        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netinfo = cm.getActiveNetworkInfo();

        if (netinfo != null && netinfo.isConnectedOrConnecting()) {
            android.net.NetworkInfo wifi = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
            android.net.NetworkInfo mobile = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

            if ((mobile != null && mobile.isConnectedOrConnecting()) || (wifi != null && wifi.isConnectedOrConnecting()))
                return true;
            else return false;
        } else
            return false;
    }
    public AlertDialog.Builder buildDialog(Context c) {

        AlertDialog.Builder builder = new AlertDialog.Builder(c);
        try{
            builder.setTitle("No Internet Connection");
            builder.setMessage("Bạn hãy kết nối Wifi hoặc 3G, Nhấn OK để thoát");
            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            return builder;
        }catch (Exception e5){Toast.makeText(MainActivity.this,e5.toString(), Toast.LENGTH_SHORT).show();
            return builder;
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
// Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.esp8266, menu);//Menu Resource, Menu
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.esp8266:
                esp8266();
               // Toast.makeText(getApplicationContext(),"Item 2 Selected",Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}