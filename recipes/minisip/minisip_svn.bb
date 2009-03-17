DESCRIPTION = "SIP user agent, with focus on security"
HOMEPAGE = "http://www.minisip.org"
DEPENDS = "libglademm libmsip0 libmikey0"
LICENSE = "GPL"
SECTION = "x11/utils"
PV = "0.6.2+svn${SRCDATE}"

SRC_URI = "svn://svn.minisip.org/minisip/trunk;module=minisip"
S = "${WORKDIR}/${PN}"

inherit autotools

EXTRA_OECONF = "--enable-ipaq"

do_install_append () {
	install -d ${D}${datadir}/pixmaps
	install -d ${D}${datadir}/applications
	install -m 0644 share/minisip.png ${D}${datadir}/pixmaps/minisip.png
	install -m 0644 share/minisip.desktop ${D}${datadir}/applications/minisip.desktop
}

FILES_${PN} += "${datadir}/minisip"

