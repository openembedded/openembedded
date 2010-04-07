DESCRIPTION = ""
SECTION = "libs"
SRCREV = "4a32af91a9479ebd4d1d39057354ac9904d74cbb"
PV = "0.0.1+gitr${SRCREV}"
PR = "r0"

inherit autotools

SRC_URI = "git://shr.bearstech.com/repo/${PN}.git;protocol=http;branch=master"
S = "${WORKDIR}/git"
