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
