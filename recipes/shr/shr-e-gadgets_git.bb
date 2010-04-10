DESCRIPTION = "An e17 module for a lot of needed shr-gadgets"
HOMEPAGE = "http://shr-project.org"
LICENSE = "BSD"
DEPENDS = "e-wm"
RDEPENDS = "e-wm"
SECTION = "x11/application"

SRCREV = "c23dda5f81ed3c6d785617696fb009adb5594a55"
PV = "0.0.0+gitr${SRCPV}"

inherit autotools

SRC_URI = "git://git.shr-project.org/repo/shr-e-gadgets.git;protocol=http;branch=master"
S = "${WORKDIR}/git"

FILES_${PN} += "\
	${libdir}/enlightenment/modules/*/*.* \
	${libdir}/enlightenment/modules/*/*/* \
"
