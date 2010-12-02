require bug-app.inc

DESCRIPTION = "BlueBack is a JUnit test runner that loads tests in the OSGi service registry and allows user to execute tests via the Base LCD menu and statusbar.  To use, select 'Run Tests' from menu after loading test apps, such as AudioTestCase, into BUG."
HOMEPAGE = "http://buglabs.net/applications/BlueBack"

DEPENDS += "com.buglabs.bug.base com.buglabs.bug.menu com.buglabs.common com.buglabs.osgi service-tracker "

PV = "3"

SRC_LINK = "http://buglabs.net/program_version/download/550"

APIVERSION = ""

COMPATIBLE_MACHINE = "bug"
PACKAGE_ARCH = "${MACHINE_ARCH}"
