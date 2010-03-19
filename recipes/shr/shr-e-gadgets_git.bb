DESCRIPTION = "An e17 module for a lot of needed shr-gadgets"
HOMEPAGE = "http://shr-project.org"
LICENSE = "BSD"
DEPENDS = "e-wm"
RDEPENDS = "e-wm"
SECTION = "x11/application"

SRCREV = "273576014a79823bd45f7cd9c4e0314bb001b762"
PV = "0.0.0+gitr${SRCREV}"

inherit autotools

SRC_URI = "git://git.shr-project.org/repo/shr-e-gadgets.git;protocol=http;branch=master"
S = "${WORKDIR}/git"

FILES_${PN} += "\
	${libdir}/enlightenment/modules/*/*.* \
	${libdir}/enlightenment/modules/*/*/* \
"
