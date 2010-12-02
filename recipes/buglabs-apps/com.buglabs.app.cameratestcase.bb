require bug-app.inc

DESCRIPTION = "A set of test cases for the Camera module. Works with Blueback  test runner."
HOMEPAGE = "http://buglabs.net/applications/CameraTestCase"

DEPENDS += "com.buglabs.app.blueback com.buglabs.bug.menu com.buglabs.bug.module.camera com.buglabs.common "

PV = "7"

SRC_LINK = "http://buglabs.net/program_version/download/610"

APIVERSION = ""

COMPATIBLE_MACHINE = "bug"
PACKAGE_ARCH = "${MACHINE_ARCH}"
