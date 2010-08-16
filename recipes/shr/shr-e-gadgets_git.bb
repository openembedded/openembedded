DESCRIPTION = "An e17 module for a lot of needed shr-gadgets"
HOMEPAGE = "http://shr-project.org"
LICENSE = "BSD"
DEPENDS = "e-wm"
RDEPENDS_${PN} = "e-wm"
SECTION = "x11/application"

SRCREV = "4f94c139bd50935dbfb6524e8525d0c35200380b"
PV = "0.0.0+gitr${SRCPV}"
PR = "r6"

inherit autotools

SRC_URI = "git://git.shr-project.org/repo/shr-e-gadgets.git;protocol=http;branch=master"
S = "${WORKDIR}/git"

FILES_${PN} += "\
	${datadir}/shr_elm_softkey \
	${libdir}/enlightenment/modules/*/*.desktop \
	${libdir}/enlightenment/modules/*/*.edj \
	${libdir}/enlightenment/modules/*/*/*.so \
"
FILES_${PN}-static += "${libdir}/enlightenment/modules/*/*/*.a"
FILES_${PN}-dev += "${libdir}/enlightenment/modules/*/*/*.la"
FILES_${PN}-dbg += "${libdir}/enlightenment/modules/*/*/.debug"

