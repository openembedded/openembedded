PV = "0.0cvs${CVSDATE}"
LICENSE = "Xorg"
SECTION = "x11/libs"
MAINTAINER = "Phil Blundell <pb@nexus.co.uk>"
DESCRIPTION = "Xxf86dga extension headers"

SRC_URI = "cvs://anoncvs:anoncvs@pdx.freedesktop.org/cvs/xlibs;module=XF86DGAExt"
S = "${WORKDIR}/XF86DGAExt"

inherit autotools pkgconfig

do_stage() {
	oe_runmake install prefix=${STAGING_DIR} \
	       bindir=${STAGING_BINDIR} \
	       includedir=${STAGING_INCDIR} \
	       libdir=${STAGING_LIBDIR} \
	       datadir=${STAGING_DATADIR}
}
