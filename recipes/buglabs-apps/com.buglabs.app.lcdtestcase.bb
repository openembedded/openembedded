require bug-app.inc

DESCRIPTION = "A set of test cases for the LCD module. Works with BlueBack test runner."
HOMEPAGE = "http://buglabs.net/applications/LcdTestCase"

DEPENDS += "com.buglabs.app.blueback com.buglabs.bug.menu com.buglabs.bug.module.lcd com.buglabs.common "

PV = "1"

SRC_LINK = "http://buglabs.net/program_version/download/596"

APIVERSION = ""

COMPATIBLE_MACHINE = "bug"
PACKAGE_ARCH = "${MACHINE_ARCH}"
