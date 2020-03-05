package be.ehb.oefthreading.util;

import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;

public class ProgressHandler extends Handler {

    private ProgressBar pb1;

    public ProgressHandler(ProgressBar pb1) {
        this.pb1 = pb1;

    }

    @Override
    public void handleMessage(@NonNull Message msg) {
        super.handleMessage(msg);

        int value = msg.arg1;
        if (Build.VERSION.SDK_INT >= 25)
            pb1.setProgress(value, true);
        else
            pb1.setProgress(value);
    }

}
