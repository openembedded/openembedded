DESCRIPTION = "Neuros qt-plugins"
LICENSE = "GPL"

PV = "0.0+${PR}+gitr${SRCREV}"
PR = "r3"

DEPENDS = "qt-embedded"

inherit qtopia4core

SRCREV = "e00c2fe1c5be9f4bb94512363e1b21e07ba5c55d"
SRC_URI = "git://git.neurostechnology.com/git/lib-widgets;protocol=git"
S = "${WORKDIR}/git/"

do_install() {
	install -d ${D}/${libdir}/
	install -m 0755 ${S}/build/lib* ${D}/${libdir}
}

do_stage() {
	install -d ${STAGING_LIBDIR}
	install -m 0755 ${S}/build/lib* ${STAGING_LIBDIR}	
}
