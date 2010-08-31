DESCRIPTION = "Important header and vapi files for some programs running on the palmpre machine"
HOMEPAGE = "http://www.freesmartphone.org"
AUTHOR = "Simon Busch <morphis@gravedo.de>
SECTION = "console/utils"
LICENSE = "GPL"
PR = "r0"

SRCREV = "93a640dafa8ebebdb1a03f051cb1b566629b227c"
SRC_URI = "${FREESMARTPHONE_GIT}/utilities.git;protocol=git;branch=master"
S = "${WORKDIR}/git/palmpre/palmpre-system-deps"

inherit autotools native pkgconfig
