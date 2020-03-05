package be.ehb.oefthreading;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import java.util.Random;

import be.ehb.oefthreading.util.ProgressHandler;

public class MainActivity extends AppCompatActivity {

    private ProgressBar pb1;
    private ProgressBar pb2;
    private ProgressBar pb3;
    private Button btnStart;
    private boolean isRunning = false;
    private ProgressHandler mHandler;
    private ProgressHandler mHandler2;
    private ProgressHandler mHandler3;
    private View.OnClickListener startListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (!isRunning)
            startThread();

            if (!isRunning)
            startThread2();

            if (!isRunning)
            startThread3();

        }
    };

    private void startThread3() {
        int min = 50;
        int max = 100;
        final int random = new Random().nextInt((max- min)+1) + min;
        Thread bgThread =  new Thread(new Runnable() {
            @Override
            public void run() {

                isRunning = true;

                for (int i = 0; i <= 20; i++){
                    try {
                        Thread.sleep(random);
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    Message msg = new Message();
                    msg.arg1 = i;

                    mHandler3.sendMessage(msg);
                }
                isRunning = false;

            }
        });
        bgThread.start();
    }

    private void startThread2() {
        int min = 50;
        int max = 100;
        final int random = new Random().nextInt((max- min)+1) + min;
        Thread bgThread =  new Thread(new Runnable() {
            @Override
            public void run() {

                isRunning = true;

                for (int i = 0; i <= 20; i++){
                    try {
                        Thread.sleep(random);
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    Message msg = new Message();
                    msg.arg1 = i;

                    mHandler2.sendMessage(msg);
                }
                isRunning = false;

            }
        });
        bgThread.start();
    }

    private void startThread() {
        int min = 50;
        int max = 100;
        final int random = new Random().nextInt((max- min)+1) + min;
        Thread bgThread =  new Thread(new Runnable() {
            @Override
            public void run() {

                isRunning = true;

                for (int i = 0; i <= 20; i++){
                    try {
                        Thread.sleep(random);
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    Message msg = new Message();
                    msg.arg1 = i;

                    mHandler.sendMessage(msg);
                }
                isRunning = false;

            }
        });
        bgThread.start();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pb1 = findViewById(R.id.pb_kameel1);
        pb2 = findViewById(R.id.pb_kameel2);
        pb3 = findViewById(R.id.pb_kameel3);
        btnStart = findViewById(R.id.btn_start);

        mHandler = new ProgressHandler(pb1);
        mHandler2 = new ProgressHandler(pb2);
        mHandler3 = new ProgressHandler(pb3);
        btnStart.setOnClickListener(startListener);
    }
}
