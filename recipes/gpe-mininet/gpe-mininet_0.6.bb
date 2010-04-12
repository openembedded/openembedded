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

SRC_URI[md5sum] = "4ac59b3a7718dea0e5eca05ee783a316"
SRC_URI[sha256sum] = "80586b5691b9f0173d9280387258e49ff6740a6ef3d5f4dbad237a5de79fc86d"
