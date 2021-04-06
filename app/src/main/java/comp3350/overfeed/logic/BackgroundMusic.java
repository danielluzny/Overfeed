package comp3350.overfeed.logic;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import androidx.annotation.Nullable;

import java.io.IOException;

import comp3350.overfeed.R;

public class BackgroundMusic extends Service
{

    MediaPlayer mediaPlayer;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {return null;}

    @Override
    public void onCreate()
    {
        super.onCreate();
        mediaPlayer = MediaPlayer.create(this, R.raw.restaurant_audio);
        mediaPlayer.setLooping(true); // Set looping
        mediaPlayer.setVolume(100, 100);
    }

    public int onStartCommand(Intent intent, int flags, int startId)
    {
        mediaPlayer.prepareAsync();
        return startId;
    }

    public void onStart(Intent intent, int startId) {}

    @Override
    public void onDestroy()
    {
        mediaPlayer.stop();
        mediaPlayer.release();
    }

    @Override
    public void onLowMemory() {}
}
