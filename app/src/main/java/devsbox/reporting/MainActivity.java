package devsbox.reporting;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    EditText name, place, report;
    Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText) findViewById(R.id.SecondNameEditText);
        place = (EditText) findViewById(R.id.SecondPlaceEditText);
        report = (EditText) findViewById(R.id.SecondPhonEditTextOne);

        send = (Button) findViewById(R.id.SecondSendButton);

        ///////////////For current time////////////
        Calendar time = Calendar.getInstance();
        SimpleDateFormat mdformat = new SimpleDateFormat("HH:mm:ss");
        final String strTime = mdformat.format(time.getTime());


        ///////////////For current Date////////////
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat mdformat_date = new SimpleDateFormat("dd / MM / yyyy ");
        final String strDate = mdformat_date.format(calendar.getTime());

     //   Toast.makeText(this, "Time" + strTime + "\n" + strDate, Toast.LENGTH_SHORT).show();

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String namedata = name.getText().toString();
                String placedata = place.getText().toString();
                String reportdata = report.getText().toString();

               String phoneOne = "01730012300";
               String phoneTwo = "01711526928";

                    Intent smsIntent = new Intent(Intent.ACTION_VIEW);
                    smsIntent.setType("vnd.android-dir/mms-sms");
                    smsIntent.putExtra("address", phoneOne+";"+phoneTwo);
                    smsIntent.putExtra("sms_body",placedata+", "+namedata+" : "+reportdata+"\n"+strDate+"\n"+strTime);
                    startActivity(smsIntent);

                    Toast.makeText(MainActivity.this, "Your Message is ready to send", Toast.LENGTH_LONG).show();
                    finish();
            }
        });
    }
}