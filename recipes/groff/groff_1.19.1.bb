DESCRIPTION = "GNU roff"
SECTION = "base"
LICENSE = "GPL"
PR = "r3"

SRC_URI = "http://ftp.gnu.org/gnu/groff/groff-${PV}.tar.gz \
	           file://groff.patch;patch=1"

PARALLEL_MAKE = ""
# prefix and exec-prefix are broken and the .in file is broken too
# and can't be autoreconf'ed, so specify every dir
EXTRA_OECONF="--without-x --prefix=${D} --exec-prefix=${D} --bindir=${D}${bindir} --datadir=${D}${datadir} --mandir=${D}${datadir}/man --infodir=${D}${datadir}/info"

inherit autotools

do_configure () {
	oe_runconf
}

#do_install() {
#	oe_runmake 'PREFIX=${D}' install
#}


SRC_URI[md5sum] = "57d155378640c12a80642664dfdfc892"
SRC_URI[sha256sum] = "e07c495a18679b79c7c6f6f475689a33ab2a8ee5af4783e915f08134d1f546d2"
