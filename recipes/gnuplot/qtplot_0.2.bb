DESCRIPTION = "QT Gnuplot is a front end for Gnuplot. Install Opie-Embedded \
console to enable the Launch Gnuplot menu option."
HOMEPAGE = "http://www.mneuroth.de/privat/zaurus/gnuplot.html"
SECTION = "opie/applications"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "gnuplot"
RDEPDENDS_${PN} = "gnuplot"

PR = "r1"

SRC_URI  = "http://www.mneuroth.de/privat/zaurus/qtplot-${PV}.tar.gz"

APPTYPE    = "binary"
APPDESKTOP = "${S}"

inherit opie

do_install_prepend() {
	install -d ${D}${palmtopdir}/pics
        install -d ${D}${palmtopdir}/help/html

        install -m 644 Qtplot.png ${D}${palmtopdir}/pics/
        install -m 644 qtplot.html ${D}${palmtopdir}/help/html/
}

SRC_URI[md5sum] = "0a481885a496092c77eb4017540b5cf6"
SRC_URI[sha256sum] = "6df317183ff62cc82f3dcf88207a267cd6478cb5147f55d7530c94f1ad5f4132"
