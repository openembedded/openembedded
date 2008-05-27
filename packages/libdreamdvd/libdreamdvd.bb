# libdreamdvd.bb build file
DESCRIPTION="libdvdnav wrapper for dream multimedia stbs"
LICENSE = "GPL"
DEPENDS = "libdvdnav"
RDEPENDS = "libdvdnav"

PR = "r0"
PV = "1.0cvs${SRCDATE}"
SRCDATE = "20080526"
SRC_URI="cvs://anonymous@cvs.schwerkraft.elitedvb.net/cvsroot/libdreamdvd;module=libdreamdvd;method=pserver"

S = "${WORKDIR}/libdreamdvd"

inherit autotools pkgconfig

do_stage_append() {
	oe_runmake install prefix=${STAGING_DIR} \
		bindir=${STAGING_BINDIR} \
		includedir=${STAGING_INCDIR} \
		libdir=${STAGING_LIBDIR} \
		datadir=${STAGING_DATADIR}
}
