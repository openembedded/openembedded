SECTION = "libs"
LICENSE = "MIT-X"
MAINTAINER = "Greg Gilbert <greg@treke.net>"
DEPENDS = "xextensions fixesext"
DESCRIPTION = "X Damage extension headers and specification"
PR = "r1"

SRC_URI = "${XLIBS_MIRROR}/damageext-${PV}.tar.bz2 \
	   file://autofoo.patch;patch=1"

inherit autotools pkgconfig

do_stage() {
	oe_runmake install prefix=${STAGING_DIR} \
	       bindir=${STAGING_BINDIR} \
	       includedir=${STAGING_INCDIR} \
	       libdir=${STAGING_LIBDIR} \
	       datadir=${STAGING_DATADIR}
}
