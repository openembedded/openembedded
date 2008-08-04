DESCRIPTION = "Neuros lib-gui"
LICENSE = "GPL"

PV = "0.0+${PR}+gitr${SRCREV}"
PR = "r0"

DEPENDS = "qt-embedded"

inherit qtopia4core

SRCREV = "bac10d263a4bb9e01db16d7dd356de315a3ffed7"
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
