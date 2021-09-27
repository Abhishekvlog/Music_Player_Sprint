package com.example.music_player_sprint

import android.app.Notification
import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.Binder
import android.os.IBinder
import android.app.NotificationManager

import android.app.NotificationChannel

import android.os.Build

import androidx.core.app.NotificationCompat
import java.util.*


class MusicService : Service() {
    var mediaPlayer : MediaPlayer?= null
    var isPlaying : Boolean = false


    override fun onCreate() {
        super.onCreate()

    }

    override fun onBind(intent: Intent): IBinder {
        return ServiceBinder()
    }
    public fun play(){
        if(mediaPlayer != null){
            isPlaying =true
            mediaPlayer!!.start()
            showNotificationAndStartForeGround()
        }

    }
    public fun pause(){
        if(mediaPlayer != null){
            isPlaying =false
            mediaPlayer!!.stop()
            showNotificationAndStartForeGround()
        }

    }
    public fun delete(){
        if (mediaPlayer != null){
            isPlaying = false
        }
    }

    inner fun ServiceBinder : Binder() {
        fun getMusicService() : MusicService{
            return this
        }
    }



    private fun showNotificationAndStartForeGround() {
        createChannel()
        var notificationBuilder: NotificationCompat.Builder? = null
        notificationBuilder = NotificationCompat.Builder(this, "CHANNEL_ID")
            .setContentTitle("Service is running : yaay")
            .setContentText("name is android")
            .setPriority(NotificationCompat.PRIORITY_HIGH)
        var notification: Notification? = null
        notification = notificationBuilder.build()
        startForeground(1, notification)
    }


    /*
Create noticiation channel if OS version is greater than or eqaul to Oreo
*/
    fun createChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel =
                NotificationChannel("CHANNEL_ID", "Song", NotificationManager.IMPORTANCE_HIGH)
            channel.description = "Notifications"
            Objects.requireNonNull(this.getSystemService(NotificationManager::class.java))
                .createNotificationChannel(channel)
        }
    }
}