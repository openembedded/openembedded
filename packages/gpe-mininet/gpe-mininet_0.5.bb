inherit gpe pkgconfig

PR = "r0"
LICENSE = "GPL"
DEPENDS = "libgpewidget gpe-icons gpe-conf matchbox-panel"
SECTION = "gpe"

DESCRIPTION = "GPE network connection checker"

SRC_URI = "${GPE_MIRROR}/${PN}-${PV}.tar.gz"

FILES_${PN} = " ${bindir} ${datadir}/pixmaps ${datadir}/applications"
FILES_${PN} += " ${datadir}/gpe/pixmaps"

export CVSBUILD=no
