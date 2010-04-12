inherit autotools gpe pkgconfig

PR = "r0"
LICENSE = "GPL"
DEPENDS = "libgpewidget gpe-icons gpe-conf"
RRECOMMENDS = "gpe-conf"
SECTION = "gpe"

DESCRIPTION = "GPE network connection checker"

SRC_URI = "${GPE_MIRROR}/${PN}-${PV}.tar.bz2"

FILES_${PN} = " ${bindir} ${datadir}/pixmaps ${datadir}/applications"
FILES_${PN} += " ${datadir}/gpe/pixmaps"

SRC_URI[md5sum] = "5630b45b1862f4032dd3a177c2b74402"
SRC_URI[sha256sum] = "980320814b23cc51303436afb110397b15b950896f7f229484005f81d5cb6346"
