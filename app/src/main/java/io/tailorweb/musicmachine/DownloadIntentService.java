package io.tailorweb.musicmachine;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

public class DownloadIntentService extends IntentService {
    private static final String TAG = DownloadIntentService.class.getSimpleName() ;

    public DownloadIntentService() {
        super("DownloadIntentService");
        // By default it's sticky
        setIntentRedelivery(true);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        String song = intent.getStringExtra(MainActivity.KEY_SONG);
        downloadSong(song);
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
