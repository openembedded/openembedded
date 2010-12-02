require bug-app.inc

DESCRIPTION = "A set of test cases to be used with BlueBack."
HOMEPAGE = "http://buglabs.net/applications/MotionTestCase"

DEPENDS += "com.buglabs.app.blueback com.buglabs.bug.menu com.buglabs.bug.module.motion com.buglabs.common "

PV = "1"

SRC_LINK = "http://buglabs.net/program_version/download/612"

APIVERSION = ""

COMPATIBLE_MACHINE = "bug"
PACKAGE_ARCH = "${MACHINE_ARCH}"
