LICENSE = "GPLv2"

inherit autotools pkgconfig gconf

PROVIDES = "galculator"
DESCRIPTION = "GTK Advanced Calculator"
DEPENDS = "virtual/libc gtk+ libglade gnome-desktop"
RDEPENDS_${PN} = "gnome-desktop"
SECTION = "gpe"
PRIORITY = "optional"
PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/project/${PN}/${PN}/${PV}/${PN}-${PV}.tar.bz2"

LDFLAGS += '-Wl,--export-dynamic'

do_install_append() {
       ln -s galculator.png ${D}${datadir}/pixmaps/galculator_48x48.png
}

FILES_${PN} += "${datadir}/pixmaps/galculator_48x48.png"

SRC_URI[md5sum] = "d30e6fbf5947bb1c873bc9d5a21046f1"
SRC_URI[sha256sum] = "9d6c6f13d9249719d1af71f45f97f64d70aefb959d3bfe2cd375e076d4c5943d"
