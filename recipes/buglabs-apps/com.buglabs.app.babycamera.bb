require bug-app.inc

DESCRIPTION = "This BUGapp implements the same OSGi services as the (not shipping) camera module.  This allows for applications that require a camera module to be used without an actual camera.  Note that applications that use this bundles services will only get pictures of a baby!\
Base Hotkey 1 = shutter\
Base Hotkey 3= Zoom in\
Base Hotkey 4= Zoom out\
Also note this BUGapp doesn't do anything by itself.  It requires another app that needs camera services to do anything."
HOMEPAGE = "http://buglabs.net/applications/BabyCamera"

DEPENDS += "com.buglabs.bug.module.camera com.buglabs.osgi.http service-tracker com.buglabs.common "

PV = "1"

SRC_LINK = "http://buglabs.net/program_version/download/701"

APIVERSION = ""

BROKEN = "1"
