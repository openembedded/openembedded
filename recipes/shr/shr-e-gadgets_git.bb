DESCRIPTION = "An e17 module for a lot of needed shr-gadgets"
HOMEPAGE = "http://shr-project.org"
LICENSE = "BSD"
DEPENDS = "e-wm"
RDEPENDS = "e-wm"
SECTION = "x11/application"

SRCREV = "548a0a1f42c4e09f03db85509ad5c92ef491f9ca"
PV = "0.0.0+gitr${SRCREV}"

inherit autotools

SRC_URI = "git://git.shr-project.org/repo/shr-e-gadgets.git;protocol=http;branch=master"
S = "${WORKDIR}/git"

FILES_${PN} += "\
	${libdir}/enlightenment/modules/*/*.* \
	${libdir}/enlightenment/modules/*/*/* \
"
