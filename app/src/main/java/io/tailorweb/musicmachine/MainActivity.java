package io.tailorweb.musicmachine;

import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import io.tailorweb.musicmachine.model.Playlist;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName() ;
    private Button mDownloadButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final DownloadThread downloadThread = new DownloadThread();
        downloadThread.setName("DownloadThread");
        downloadThread.start();

        mDownloadButton = (Button) findViewById(R.id.downloadButton);
        mDownloadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Downloading", Toast.LENGTH_SHORT).show();
                // Send Messages to Handler for processing
                for (String song : Playlist.songs) {
                    Message message = Message.obtain();
                    message.obj = song;
                    downloadThread.mHandler.sendMessage(message);
                }

            }
        });
    }

}
