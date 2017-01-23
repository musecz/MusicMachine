package io.tailorweb.musicmachine;

import android.os.Looper;
import android.util.Log;

import io.tailorweb.musicmachine.model.Playlist;


public class DownloadThread extends Thread {
    private static final String TAG = DownloadThread.class.getSimpleName();
    public DownloadHandler mHandler;
    @Override
    public void run() {
        Looper.prepare();
        mHandler = new DownloadHandler();
        Looper.loop();
    }
}
