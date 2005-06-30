LICENSE = "LGPL"
DESCRIPTION = "GPE program launcher library"
SECTION = "libs"
MAINTAINER = "Philip Blundell <pb@handhelds.org>"
DEPENDS = "gtk+ startup-notification"

inherit autotools pkgconfig

SRC_URI = "${GPE_MIRROR}/${PN}-${PV}.tar.bz2"

do_stage() {
	oe_runmake install prefix=${STAGING_DIR} \
	       bindir=${STAGING_BINDIR} \
	       includedir=${STAGING_INCDIR} \
	       libdir=${STAGING_LIBDIR} \
	       datadir=${STAGING_DATADIR}
}
