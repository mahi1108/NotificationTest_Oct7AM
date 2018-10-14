package cubex.mahesh.notificationtest_oct7am

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.NotificationCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var count = 0;
        button.setOnClickListener {
            var nManager = getSystemService(
                    Context.NOTIFICATION_SERVICE) as NotificationManager
            var notification:NotificationCompat.Builder =
                                NotificationCompat.Builder(
                                this@MainActivity,"and7am")
            notification.setTicker("sample notification")
            notification.setSmallIcon(R.drawable.ic_beach_access_black_24dp)
            var bmp = BitmapFactory.decodeResource(resources,
                                                  R.drawable.ic_beach_access_black_24dp)
            notification.setLargeIcon(bmp)
            notification.setContentTitle("Sample notification @ Oct7AM")
            notification.setContentText("Sample notification for demo .....")
            notification.setAutoCancel(true)
            var  i =Intent(this@MainActivity ,
                    MainActivity::class.java)
            var pIntent = PendingIntent.getActivity(this@MainActivity,
                    0,i,0)
            notification.setContentIntent(pIntent)
            nManager.notify(++count,notification.build())
        }
    }
}
