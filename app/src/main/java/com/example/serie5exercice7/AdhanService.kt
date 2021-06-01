package com.example.adhanapp

import android.app.Notification
import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.net.Uri
import android.os.IBinder
import androidx.core.app.NotificationCompat
import com.example.adhanapp.App.Companion.CHANNEL_ID
import com.example.serie5exercice7.MainActivity
import com.example.serie5exercice7.R

class AdhanService : Service() {
    override fun onCreate() {
        super.onCreate()

    }

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        val input = intent.getStringExtra("inputExtra")


        val notificationIntent = Intent(this, MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(
            this,
            0, notificationIntent, 0
        )
        val notification: Notification = NotificationCompat.Builder(this, CHANNEL_ID)
            .setDefaults(0)
            .setContentTitle("Example de Service")
            .setContentText(input)
            .setSound(Uri.parse("android.resource://$packageName/${R.raw.azan}"))
            .setSmallIcon(R.drawable.moon)
            .setContentIntent(pendingIntent)
            .build()


        startForeground(1, notification)

        //do heavy work on a background thread
        //stopSelf();
        return START_NOT_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()

    }

    override fun onBind(intent: Intent): IBinder? {
        return null
    }
}