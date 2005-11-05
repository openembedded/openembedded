PV = "0.6.2svn${CVSDATE}"
LICENSE = "GPL"
SECTION = "x11/utils"
PR = "r0"
MAINTAINER = "Johan Bilien <jobi@via.ecp.fr>"

DESCRIPTION = "SIP user agent, with focus on security"
DEPENDS = "libglademm libmsip0 libmikey0"
SRC_URI = "svn://svn.minisip.org/var/svn/minisip/trunk;module=minisip"
S = ${WORKDIR}/${PN}

DEFAULT_PREFERENCE=-1

FILES_${PN} += "${datadir}/minisip"

inherit autotools

EXTRA_OECONF = "--enable-ipaq"

# do_configure_prepend() {
#	./bootstrap
#}

do_install_append () {
	install -d ${D}${datadir}/pixmaps
	install -d ${D}${datadir}/applications
	install -m 0644 share/minisip.png ${D}${datadir}/pixmaps/minisip.png
	install -m 0644 share/minisip.desktop ${D}${datadir}/applications/minisip.desktop
}
