DESCRIPTION = "ologicd is a logic deamon. It is meant to run software agents. \
	Those agents may interact with external software through DBus"
SECTION = "libs"
SRCREV = "4a32af91a9479ebd4d1d39057354ac9904d74cbb"
PE = "1"
PV = "0.0.1+gitr${SRCPV}"
PR = "r0"

inherit autotools

SRC_URI = "git://git.shr-project.org/repo/${PN}.git;protocol=http;branch=master"
S = "${WORKDIR}/git"
