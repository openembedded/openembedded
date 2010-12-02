require bug-app.inc

DESCRIPTION = "This BUGapp tests the menubar and statusbar."
HOMEPAGE = "http://buglabs.net/applications/MenuSBTestCase"

DEPENDS += "com.buglabs.app.blueback com.buglabs.bug.menu com.buglabs.common "

PV = "2"

SRC_LINK = "http://buglabs.net/program_version/download/552"

APIVERSION = ""

COMPATIBLE_MACHINE = "bug"
PACKAGE_ARCH = "${MACHINE_ARCH}"
