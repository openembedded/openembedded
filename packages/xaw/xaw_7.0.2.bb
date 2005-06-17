SECTION = "x11/libs"
LICENSE = "MIT"
PRIORITY = "optional"
MAINTAINER = "Phil Blundell <pb@handhelds.org>"
DEPENDS = "xproto x11 xt xmu xpm"
DESCRIPTION = "X Athena Widgets library"

SRC_URI = "${XLIBS_MIRROR}/libXaw-${PV}.tar.bz2 \
	   file://auxdir.patch;patch=1"

S = "${WORKDIR}/libXaw-${PV}"

inherit autotools pkgconfig 

# FIXME: libXaw needs a full x11, not diet
BROKEN = "1"

do_stage () {
	oe_runmake install DESTDIR="" mandir=${STAGING_DATADIR}/man bindir=${STAGING_BINDIR} includedir=${STAGING_INCDIR} libdir=${STAGING_LIBDIR} prefix=${STAGING_DIR}
}
