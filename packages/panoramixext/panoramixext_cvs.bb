PV = "0.0+cvs${SRCDATE}"
LICENSE= "MIT"
SECTION = "libs"
PRIORITY = "optional"
MAINTAINER = "Phil Blundell <pb@handhelds.org>"
DESCRIPTION = "PanoramiX extension headers"

SRC_URI = "${FREEDESKTOP_CVS}/xlibs;module=PanoramiXExt"
S = "${WORKDIR}/PanoramiXExt"

inherit autotools pkgconfig 

do_stage() {
	oe_runmake install prefix=${STAGING_DIR} \
	       bindir=${STAGING_BINDIR} \
	       includedir=${STAGING_INCDIR} \
	       libdir=${STAGING_LIBDIR} \
	       datadir=${STAGING_DATADIR} \
	       mandir=${STAGING_DIR}/man
}
