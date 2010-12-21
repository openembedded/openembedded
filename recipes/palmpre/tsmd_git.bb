DESCRIPTION = "Touchscreen management daemon - manages the touchscreen of the palm pre machine"
HOMEPAGE = "http://www.freesmartphone.org"
AUTHOR = "Valéry Febvre <vfebvre@easter-eggs.com>
SECTION = "base"
LICENSE = "GPL"

DEPENDS = "tslib"

PR = "r1"
PV = "1.0.0+gitr${SRCPV}"

SRCREV = "704b7965ad1936bf935b576d4663590bdaab09b1"
SRC_URI = " \
 ${FREESMARTPHONE_GIT}/utilities.git;protocol=git;branch=master \
"

S = "${WORKDIR}/git/palmpre/tsmd"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit autotools
