require bug-app.inc

DESCRIPTION = "This is a notification service.  It can blink lights and make the LCD screen change color.  It's intented for use in demos when an action or event should be shown to user or audience.  There is an OSGi service and web service.  The WS example from a browser:\
http://bug/service/notify?duration=10&style=flash+modules+yellow+base+lcd\
Style tags are :\
		 base \
		 mods \
		 sound \
		 flash\
		 red \
		 green \
		 lcd \
		 yellow \
Sound is currenlty not implemented."
HOMEPAGE = "http://buglabs.net/applications/DemoNotificationServer"

DEPENDS += "com.buglabs.bug.base com.buglabs.bug.module.audio com.buglabs.bug.audio.common com.buglabs.bug.module.lcd com.buglabs.common com.buglabs.osgi.http service-tracker "

PV = "7"

SRC_LINK = "http://buglabs.net/program_version/download/591"

APIVERSION = ""
