require bug-app.inc

DESCRIPTION = "The app is designed to allow configuration of a wireless network from the statusbar.  This should be especially useful for fast field configuration of a bug without the full-size LCD screen.\
STILL A WORK IN PROGRESS!\
Requires the API change shown here:\
http://bugcommunity.com/wiki/index.php/Bug_menu"
HOMEPAGE = "http://buglabs.net/applications/MenuWifi"

DEPENDS += "com.buglabs.bug.menu com.buglabs.common com.buglabs.osgi service-tracker "

PV = "1"

SRC_LINK = "http://buglabs.net/program_version/download/1171"

APIVERSION = "1.4.3"
