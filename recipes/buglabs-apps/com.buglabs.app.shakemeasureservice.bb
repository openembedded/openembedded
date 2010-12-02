require bug-app.inc

DESCRIPTION = "*Description*\
This service measures the vibration on the bug.\
To use in your application download to your workspace and add  com.bug.accelerometer.util.pub to the Import-Package list in your applications manifest.\
\
Take a look at VibrationDemo to see how to use this. Download both this application and VibrationDemo to Dragonfly or your BUG.\
*Installing ShakeMeasureService into the Bug*\
If your planning to use this library with the bug, it's good idea to include it as a permanent service. \
* Download the application using Dragonfly.\
* Export it as OSGi Bundle.\
* Rename the bundle to ShakeMeasureService.jar\
* Copy th bundle into the Bug:  _*scp [location]/ShakeMeasureService.jar root@10.10.10.10:/usr/share/java/*_\
* At the end of the  _*/urs/share/java/init.xargs*_ file add the following line: _*-istart ShakeMeasureService.jar*_\
* Restart the bug. \
Now the ShakeMeasureService should be available.\
"
HOMEPAGE = "http://buglabs.net/applications/ShakeMeasureService"

DEPENDS += "com.buglabs.osgi com.buglabs.bug.jni.accelerometer com.buglabs.bug.module.motion service-tracker com.buglabs.common "

PV = "4"

SRC_LINK = "http://buglabs.net/program_version/download/706"

APIVERSION = ""
