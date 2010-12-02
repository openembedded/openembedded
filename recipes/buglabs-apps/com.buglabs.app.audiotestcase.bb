require bug-app.inc

DESCRIPTION = "A set of test cases for the audio module.  Works with BlueBack test runner."
HOMEPAGE = "http://buglabs.net/applications/AudioTestCase"

DEPENDS += "com.buglabs.app.blueback com.buglabs.bug.audio.common com.buglabs.bug.module.audio com.buglabs.bug.audio.common com.buglabs.common com.buglabs.osgi service-tracker "

PV = "2"

SRC_LINK = "http://buglabs.net/program_version/download/551"

APIVERSION = ""

COMPATIBLE_MACHINE = "bug"
PACKAGE_ARCH = "${MACHINE_ARCH}"
