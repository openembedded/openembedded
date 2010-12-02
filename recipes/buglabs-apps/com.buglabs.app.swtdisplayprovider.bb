require bug-app.inc

DESCRIPTION = "This app controls the SWT Display device on the BUG so that you can use multiple applications on one screen (SWT allows only one Display instance per device). \
See the How-To and 'libSWT(libSWT)':http://buglabs.net/applications/SWTDisplayProvider for more info"
HOMEPAGE = "http://buglabs.net/applications/SWTDisplayProvider"

DEPENDS += "com.buglabs.osgi com.buglabs.common service-tracker com.buglabs.app.libswt com.buglabs.bug.module.lcd "

PV = "2"

SRC_LINK = "http://buglabs.net/program_version/download/874"

APIVERSION = ""

BROKEN = "1"
