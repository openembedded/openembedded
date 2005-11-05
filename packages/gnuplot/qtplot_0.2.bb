DESCRIPTION = "QT Gnuplot is a front end for Gnuplot. Install Opie-Embedded \
console to enable the Launch Gnuplot menu option."
SECTION    = "opie/applications"
PRIORITY   = "optional"
MAINTAINER = "Philip Frampton"
LICENSE    = "GPL"
PRIORITY   = "optional"

DEPENDS    = "gnuplot"
RDEPDENDS  = "gnuplot"

HOMEPAGE = "http://www.mneuroth.de/privat/zaurus/gnuplot.html"
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
