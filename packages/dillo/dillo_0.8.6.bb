SECTION = "x11/network"
DESCRIPTION = "Lightweight gtk+ browser, enhanced version, with support for SSL, frames, tabs and much more..."
LICENSE = "GPL"
PR = "r1"
DEPENDS = "gtk+-1.2 libpng openssl"
SRC_URI="http://www.dillo.org/download/dillo-${PV}.tar.bz2 \
         file://dillo-i18n.diff;patch=1 \
         file://dillo.desktop \
         file://dillo.png"
	 

PRIORITY = "optional"

RCONFLICTS = "dillo2"

S = "${WORKDIR}/dillo-${PV}/"

inherit autotools pkgconfig

FILES_${PN} += " /usr/lib/dillo/ /usr/bin/dpid /usr/bin/dpidc "

export PNG_CONFIG = "${STAGING_BINDIR_CROSS}/libpng-config"

EXTRA_OECONF = "--disable-dlgui --disable-anti-alias"

do_install_append() {
        install -d ${D}${datadir}/applications
        install -d ${D}${datadir}/pixmaps
        install -m 0644 ${WORKDIR}/dillo.desktop ${D}${datadir}/applications/dillo.desktop
        install -m 0644 ${WORKDIR}/dillo.png ${D}${datadir}/pixmaps/dillo.png
}
