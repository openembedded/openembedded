require bug-app.inc

DESCRIPTION = "ByeBye will shut down a real bug if you press hotkey 4.\
This saves you from selecting Shutdown from the Settings.\
Note: This executes /sbin/shutdown so it's probably a bad move to do this on a VirtualBug.\
Thanks to howzey on Flickr for the image\
"
HOMEPAGE = "http://buglabs.net/applications/ByeBye"

DEPENDS += "com.buglabs.osgi service-tracker com.buglabs.common "

PV = "1"

SRC_LINK = "http://buglabs.net/program_version/download/212"

APIVERSION = ""
