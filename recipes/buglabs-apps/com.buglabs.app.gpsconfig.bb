require bug-app.inc

DESCRIPTION = "GPSConfig installs a simple toggle menu on your Bug.  Once installed, you should find 'GPS Config' as a new top-level menu selection on your bug. Under that you will find either 'Use Int. Ant.' or 'Use Ext. Ant.', depending on which antenna is currently selected. Simple choose that item to toggle your antenna selection.\
This is another very simple application that illustrates registering a menu item; it's small enough that I didn't create an application class for it - all the work is just done in the GPSConfigServiceTracker.\
\
"
HOMEPAGE = "http://buglabs.net/applications/GPSConfig"

DEPENDS += "com.buglabs.bug.menu com.buglabs.bug.module.gps com.buglabs.common com.buglabs.osgi service-tracker "

PV = "4"

SRC_LINK = "http://buglabs.net/program_version/download/777"

APIVERSION = ""
