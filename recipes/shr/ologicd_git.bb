DESCRIPTION = ""
SECTION = "libs"
PV = "0.0.1+gitr${SRCREV}"
PR = "r0"

inherit autotools

SRC_URI = "git://shr.bearstech.com/repo/${PN}.git;protocol=http;branch=master"
S = "${WORKDIR}/git"
