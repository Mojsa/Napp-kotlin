package napp2.mario.napp_v2.models

import org.joda.time.DateTime
import java.util.*

/**
 * Created by mariossd on 24/01/2018.
 */
open class Nap  {


    var id: String = UUID.randomUUID().toString()
    var name: String = ""

    var time: Date? = null

}