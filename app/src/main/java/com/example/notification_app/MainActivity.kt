package com.example.notification_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class MainActivity : AppCompatActivity() {

    companion object {
        const val NOTIFICATION_FIRST_ID = 101;
        const val CHANNEL_FIRST_ID = "channelFirstId"

        const val NOTIFICATION_SECOND_ID = 102;
        const val CHANNEL_SECOND_ID = "channelSecondId"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonFirst: Button = findViewById(R.id.buttonFirst)
        var channelFirstValue: Int = 0
        val buttonSecond: Button = findViewById(R.id.buttonSecond)
        var channelSecondValue: Int = 0

        buttonFirst.setOnClickListener {
            channelFirstValue += 1
            if (channelFirstValue < 3) {
                val builder = NotificationCompat.Builder(this, CHANNEL_FIRST_ID)
                    .setContentTitle("Очень важно")
                    .setContentText("Помыть пол")
                    .setAutoCancel(true)
                    .setPriority(NotificationCompat.PRIORITY_HIGH)

                with(NotificationManagerCompat.from(this)) {
                    notify(NOTIFICATION_FIRST_ID, builder.build())
                }
            } else {
                val builderAll = NotificationCompat.Builder(this, CHANNEL_FIRST_ID)
                    .setContentTitle("Очень важно 1")
                    .setContentText("Вы пропустили уже " + channelFirstValue + "уведомлений")
                    .setAutoCancel(true)
                    .setPriority(NotificationCompat.PRIORITY_HIGH)

                with(NotificationManagerCompat.from(this)) {
                    notify(NOTIFICATION_FIRST_ID, builderAll.build())
                }
            }
        }

        buttonSecond.setOnClickListener {
            channelSecondValue += 1
            if (channelSecondValue < 3) {
                val builder = NotificationCompat.Builder(this, CHANNEL_SECOND_ID)
                    .setContentTitle("Очень важно")
                    .setContentText("Помыть посуду")
                    .setAutoCancel(true)
                    .setPriority(NotificationCompat.PRIORITY_HIGH)

                with(NotificationManagerCompat.from(this)) {
                    notify(NOTIFICATION_SECOND_ID, builder.build())
                }
            } else {
                val builderAll = NotificationCompat.Builder(this, CHANNEL_SECOND_ID)
                    .setContentTitle("Очень важно 2")
                    .setContentText("Вы пропустили уже " + channelSecondValue + "уведомлений")
                    .setAutoCancel(true)
                    .setPriority(NotificationCompat.PRIORITY_HIGH)

                with(NotificationManagerCompat.from(this)) {
                    notify(NOTIFICATION_SECOND_ID, builderAll.build())
                }
            }
        }
    }
}