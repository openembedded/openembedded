DESCRIPTION = "Neuros lib-gui"
LICENSE = "GPL"

PV = "0.0+${PR}+gitr${SRCREV}"
PR = "r1"

DEPENDS = "qt-embedded"

inherit qtopia4core

SRCREV = "5421c6ec09deca54556c82675a96655f6b808d0e"
SRC_URI = "git://git.neurostechnology.com/git/lib-gui;protocol=git"
S = "${WORKDIR}/git/"

do_install() {
	install -d ${D}/${libdir}/
	install -m 0755 ${S}/build/lib* ${D}/${libdir}
}

do_stage() {
	install -d ${STAGING_LIBDIR}
	install -m 0755 ${S}/build/lib* ${STAGING_LIBDIR}	
}
