PV = "0.0cvs${CVSDATE}"
SECTION = "x11/libs"
PRIORITY = "optional"
MAINTAINER = "Phil Blundell <pb@handhelds.org>"
DEPENDS = "x11 libsm"
DESCRIPTION = "X Toolkit Intrinsics"
LICENSE =  "X-MIT"
PR = "r1"
SRC_URI = "cvs://anoncvs:anoncvs@pdx.freedesktop.org/cvs/xlibs;module=Xt \
	   file://autofoo.patch;patch=1"
S = "${WORKDIR}/Xt"

inherit autotools pkgconfig 

do_stage () {
	oe_runmake install DESTDIR="" bindir=${STAGING_BINDIR} includedir=${STAGING_INCDIR} libdir=${STAGING_LIBDIR} prefix=${STAGING_DIR}
}
