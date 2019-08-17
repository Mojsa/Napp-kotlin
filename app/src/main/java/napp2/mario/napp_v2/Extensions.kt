package napp2.mario.napp_v2

import android.content.Context
import android.content.Intent
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Build
import android.provider.AlarmClock
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.joda.time.DateTime
import java.util.*
import java.util.concurrent.ThreadLocalRandom

/**
 * Created by mariofil on 26/10/2017.
 */
fun ViewGroup.inflate(layoutRes: Int): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, false)
}

fun calculateInSampleSize(options: BitmapFactory.Options, reqWidth: Int, reqHeight: Int) : Int {
    val height = options.outHeight
    val width = options.outWidth
    var inSampleSize = 1
    if (height > reqHeight || width > reqWidth) {
        val halfHeight = height /2
        val halfWidth = width / 2
        while ((halfHeight / inSampleSize) >= reqHeight && (halfWidth / inSampleSize) >= reqWidth) {
            inSampleSize *=2
        }
    }
    return inSampleSize
}

fun decodeSampledBitmapFromResource(res: Resources, resId: Int, reqWidth: Int, reqHeight: Int) : Bitmap? {
    val options = BitmapFactory.Options()
    options.inJustDecodeBounds = true
    BitmapFactory.decodeResource(res, resId, options)
    options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight)
    options.inJustDecodeBounds = false
    return BitmapFactory.decodeResource(res, resId, options)
}

fun createAlarmIntent(context: Context, ni: NapInfo) : Intent{
    val i = Intent(AlarmClock.ACTION_SET_ALARM)
    val dateTime = DateTime.now()
    var alarmDateTime = dateTime
    when (ni.duration) {
        context.resources.getString(R.string.nap_1_duration) -> alarmDateTime = dateTime.plusMinutes(randInt(10,20))
        context.resources.getString(R.string.nap_2_duration) -> alarmDateTime = dateTime.plusMinutes(randInt(20,30))
        context.resources.getString(R.string.nap_3_duration) -> alarmDateTime = dateTime.plusMinutes(randInt(30,60))
        context.resources.getString(R.string.nap_4_duration) -> alarmDateTime = dateTime.plusMinutes(randInt(60,90))
        context.resources.getString(R.string.nap_5_duration) -> alarmDateTime = dateTime.plusMinutes(randInt(90,120))
    }
    i.putExtra(AlarmClock.EXTRA_MESSAGE, ni.name)
    i.putExtra(AlarmClock.EXTRA_HOUR, alarmDateTime.hourOfDay)
    i.putExtra(AlarmClock.EXTRA_MINUTES, alarmDateTime.minuteOfHour)
    i.putExtra(AlarmClock.EXTRA_SKIP_UI, true)
    return i

}


fun randInt(min: Int, max: Int): Int {
    val rand = Random(245)
    val currentApiVersion = Build.VERSION.SDK_INT
    if (currentApiVersion >= Build.VERSION_CODES.LOLLIPOP) {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            ThreadLocalRandom.current().nextInt(min, max + 1)
        } else {
            return rand.nextInt((max - min) + 1) + min
        }
    } else {
        return rand.nextInt((max - min) + 1) + min
    }
}