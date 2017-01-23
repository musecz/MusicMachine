package io.tailorweb.musicmachine;

import android.os.Message;
import android.util.Log;

import android.os.Handler;
import java.util.logging.LogRecord;


public class DownloadHandler extends Handler {
    private static final String TAG = DownloadHandler.class.getSimpleName();

    @Override
    public void handleMessage(Message msg) {
        downloadSong(msg.obj.toString());
    }

    private void downloadSong(String song) {
        // Adding 10 sec to the current time
        long endTime = System.currentTimeMillis() + 3 * 1000;
        while (System.currentTimeMillis() < endTime) {
            try {
                // Wait 1 sec between each loop
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Log.d(TAG,song + "Song imported");

    }

}
