SECTION = "x11/network"
DESCRIPTION = "Lightweight gtk+ browser."
LICENSE = "GPL"
DEPENDS = "gtk+-1.2"
SRC_URI="http://www.dillo.org/download/dillo-${PV}.tar.bz2 \
         file://font.patch;patch=1 \
	 file://dpi.patch;patch=1 \
	 file://dpid.patch;patch=1 \
	 file://dillo.desktop \
	 file://dillo.png"
	 

MAINTAINER = "Graeme Gregory <dp@xora.org.uk>"
PRIORITY = "optional"

RCONFLICTS = "dillo2"

S = "${WORKDIR}/dillo-${PV}/"

inherit autotools pkgconfig

FILES_${PN} += " /usr/lib/dillo/ /usr/bin/dpid /usr/bin/dpidc "

do_install_append() {
        install -d ${D}${datadir}/applications
        install -d ${D}${datadir}/pixmaps
        install -m 0644 ${WORKDIR}/dillo.desktop ${D}${datadir}/applications/dillo.desktop
        install -m 0644 ${WORKDIR}/dillo.png ${D}${datadir}/pixmaps/dillo.png
}
