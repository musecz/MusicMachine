package io.tailorweb.musicmachine;

import android.util.Log;

import io.tailorweb.musicmachine.model.Playlist;


public class DownloadThread extends Thread {
    private static final String TAG = DownloadThread.class.getSimpleName();
    @Override
    public void run() {
        for (String song : Playlist.songs)
        downloadSong();
    }
    private void downloadSong() {
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
        Log.d(TAG, "Song imported");

    }
}
