require bug-app.inc

DESCRIPTION = "For instructions on how to use autoBUG, please see the 'autoBUG wiki page(autoBUG wiki page)':http://bugcommunity.com/wiki/index.php/AutoBUG for full details.\
This application needs 'com.buglabs.emulator.rxtx(com.buglabs.emulator.rxtx)':http://www.buglabs.net/applications/com.buglabs.emulator.rxtx in your workspace to build.  To run on the BUG (r1.4.3), you need RxTx on the BUG.  You can find the package 'here(com.buglabs.bug.jni.rxtx.ja)':http://bugcommunity.com/downloads/com.buglabs.bug.jni.rxtx.jar - Put this in /usr/share/java and add the following line to /usr/shar/java/init.xargs: \
-istart com.buglabs.bug.jni.rxtx.jar then restart concierge to make it work."
HOMEPAGE = "http://buglabs.net/applications/autoBUG"

DEPENDS += "com.buglabs.bug.module.gps com.buglabs.bug.module.lcd com.buglabs.common com.buglabs.bug.jni.rxtx com.buglabs.nmea service-tracker "

PV = "5"

SRC_LINK = "http://buglabs.net/program_version/download/1123"

APIVERSION = ""
