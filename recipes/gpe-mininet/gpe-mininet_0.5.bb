inherit gpe pkgconfig

PR = "r0"
LICENSE = "GPL"
DEPENDS = "libgpewidget gpe-icons gpe-conf matchbox-panel"
SECTION = "gpe"

DESCRIPTION = "GPE network connection checker"

SRC_URI = "${GPE_MIRROR}/${PN}-${PV}.tar.gz \
	   file://makefile-fix.patch;patch=1"

FILES_${PN} = " ${bindir} ${datadir}/pixmaps ${datadir}/applications"
FILES_${PN} += " ${datadir}/gpe/pixmaps"

export CVSBUILD="no"

SRC_URI[md5sum] = "4d199db47e91da9c89817e8bfbc2cded"
SRC_URI[sha256sum] = "288d2470e6c8febb717ed0affa1f55484a0d0a4cdb8a331fae08d56d298a5653"
