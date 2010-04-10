DESCRIPTION = "GNU units converts between different systems of units."
DEPENDS = "readline"
SECTION = "console/utils"
PR = "r1"

LICENSE = "GPL"
SRC_URI = "${GNU_MIRROR}/units/units-${PV}.tar.gz \
	   file://units.c.patch;patch=1 \
	   file://makefile.patch;patch=1"

inherit autotools

do_install_append() {
       install -d ${D}${datadir}
       install -m 0655 units.dat ${D}${datadir}
}

FILES_${PN} += "${datadir}/units.dat"

SRC_URI[md5sum] = "537f0e1fadc7715e1eb15c9aa33c8c64"
SRC_URI[sha256sum] = "f1dc3a6e929618a1799d95e014dcb072963d13128aa8108772538b8c3e1535f8"
