require bug-app.inc

DESCRIPTION = "h3. Version 1 \
* Displays the battery charge in the status bar. \
* Register a service call IBatteryInfoProvider. Just remeber to Import simplebatteymanager.pub in the Manifest file\
* Register a web service that show the battery charge.   *http://10.10.10.10/BatteryInfo*\
*NOTE*: This app does NOT work on the VirtualBug. It's intended to be use only in the real Bug."
HOMEPAGE = "http://buglabs.net/applications/SimpleBatteryManager"

DEPENDS += "service-tracker com.buglabs.osgi.http com.sun.javax.servlet com.buglabs.common com.buglabs.bug.base com.buglabs.osgi "

PV = "4"

SRC_LINK = "http://buglabs.net/program_version/download/767"

APIVERSION = ""
