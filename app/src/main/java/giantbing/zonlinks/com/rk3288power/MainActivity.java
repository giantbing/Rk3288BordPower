package giantbing.zonlinks.com.rk3288power;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;

import giantbing.zonlinks.com.datepowerlibrary.Bean.PowerBean;
import giantbing.zonlinks.com.datepowerlibrary.Util.*;

public class MainActivity extends AppCompatActivity {

    private TextView powerTextview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        powerTextview = (TextView) findViewById(R.id.main_powerbtn);
        powerTextview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent();
//                Toast.makeText(MainActivity.this,"关机",Toast.LENGTH_LONG).show();
//                String data= "<timer index=\"1\" onTime=\"01:00\" offTime=\"11:40\" />";
//                intent.setAction("com.mjk.timer");
//                intent.putExtra("data", data);
////                sendBroadcast(intent);
                Date date = new Date();
                int[] dateArray = DateUtil.getDateArray(date);
                Log.d("2333", "onClick: "+dateArray[0]+"/"+""+dateArray[1]+"/"+dateArray[2]);
                PowerBean pb = new PowerBean(18,40,10,0,true);
                HradvareUtil.setThisWeekPower(MainActivity.this,pb,false);
                Toast.makeText(MainActivity.this,"设置成功！",Toast.LENGTH_SHORT).show();
               // ((TextView)view).setText(dateArray[0]+dateArray[1]+dateArray[2]);
            }
        });
    }


}
