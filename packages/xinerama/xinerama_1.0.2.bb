LICENSE = "MIT"
DESCRIPTION = "Xinerama library"
SECTION = "x11/libs"
PRIORITY = "optional"
MAINTAINER = "Phil Blundell <pb@handhelds.org>"
DEPENDS = "panoramixext xproto x11 xext"
PR = "r1"

SRC_URI = "${XLIBS_MIRROR}/libXinerama-${PV}.tar.bz2"
S = "${WORKDIR}/libXinerama-${PV}"

inherit autotools pkgconfig 

do_stage() {
	oe_runmake install prefix=${STAGING_DIR} \
	       bindir=${STAGING_BINDIR} \
	       includedir=${STAGING_INCDIR} \
	       libdir=${STAGING_LIBDIR} \
	       datadir=${STAGING_DATADIR} \
	       mandir=${STAGING_DIR}/man
}
