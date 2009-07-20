# libdreamdvd.bb build file
DESCRIPTION="libdvdnav wrapper for dream multimedia stbs"
LICENSE = "GPL"
DEPENDS = "libdvdnav"
RDEPENDS = "libdvdnav"

PR = "r0"
PV = "1.0cvs${SRCDATE}"

SRCDATE = "20090718"
#no hw scaling support for 7025 yet.. so use old libdreamdvd
SRCDATE_dm7025 = "20090517"

SRC_URI="cvs://anonymous@cvs.schwerkraft.elitedvb.net/cvsroot/libdreamdvd;module=libdreamdvd;method=pserver"

CFLAGS_dm8000_append = " -DHARDWARE_SUPPORT_LPCM"
CFLAGS_dm800_append = " -DHARDWARE_SUPPORT_LPCM"
CFLAGS_dm500hd_append = " -DHARDWARE_SUPPORT_LPCM"

S = "${WORKDIR}/libdreamdvd"

inherit autotools pkgconfig

do_stage_append() {
	oe_runmake install prefix=${STAGING_DIR} \
		bindir=${STAGING_BINDIR} \
		includedir=${STAGING_INCDIR} \
		libdir=${STAGING_LIBDIR} \
		datadir=${STAGING_DATADIR}
}
