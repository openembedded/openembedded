PR = "r2"
LICENSE = "GPL"

DESCRIPTION = "GTK PPP dialing tool"
DEPENDS = "virtual/libc gconf gtk+ libglade gettext"
MAINTAINER = "Florian Boor <florian.boor@kernelconcepts.de>"
SECTION = "gpe"
PRIORITY = "optional"

SRC_URI = "http://www.kernelconcepts.de/~fuchs/gkdial-${PV}.tar.gz \
	file://header.patch;patch=1 \
	file://gkdial.desktop \
	file://gkdial.png"
 
inherit autotools pkgconfig gettext

do_install_append () {
        mkdir -p  ${D}${datadir}/pixmaps
        install -m 0644 ${WORKDIR}/gkdial.png ${D}${datadir}/pixmaps/gkdial.png
        mkdir -p  ${D}${datadir}/applications
        install -m 0644 ${WORKDIR}/gkdial.desktop ${D}${datadir}/applications/gkdial.desktop
}
