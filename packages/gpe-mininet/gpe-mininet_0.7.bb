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
