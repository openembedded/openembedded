require bug-app.inc

DESCRIPTION = "GPSTestCases is a set of JUnit tests for the GPS module.  BlueBack or another test runner is required to execute the tests."
HOMEPAGE = "http://buglabs.net/applications/GPSTestCases"

DEPENDS += "service-tracker com.buglabs.app.blueback com.buglabs.nmea com.buglabs.common com.buglabs.bug.module.gps com.buglabs.osgi "

PV = "1"

SRC_LINK = "http://buglabs.net/program_version/download/598"

APIVERSION = ""

COMPATIBLE_MACHINE = "bug"
PACKAGE_ARCH = "${MACHINE_ARCH}"
