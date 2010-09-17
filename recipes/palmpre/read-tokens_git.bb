DESCRIPTION = "Little utility to read 'tokens' from internal flash and store them in a smartkeyfile; specific for palmpre machine"
HOMEPAGE = "http://www.freesmartphone.org"
AUTHOR = "Simon Busch <morphis@gravedo.de>
SECTION = "console/utils"
LICENSE = "GPL"
PR = "r0"
PV = "1.0.0+gitr${SRCPV}"

SRCREV = "93a640dafa8ebebdb1a03f051cb1b566629b227c"
SRC_URI = "${FREESMARTPHONE_GIT}/utilities.git;protocol=git;branch=master"
S = "${WORKDIR}/git/palmpre/read_tokens"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit autotools
