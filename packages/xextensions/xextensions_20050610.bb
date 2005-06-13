PV = "1.0.3+cvs${FIXEDCVSDATE}"
FIXEDCVSDATE = "${@bb.data.getVar('FILE', d, 1).split('_')[-1].split('.')[0]}"

LICENSE= "BSD-X"
SECTION = "x11/libs"
MAINTAINER = "Greg Gilbert <greg@treke.net>"
DESCRIPTION = "various extension headers."

SRC_URI = "cvs://anoncvs:anoncvs@pdx.freedesktop.org/cvs/xlibs;module=XExtensions;date=${FIXEDCVSDATE}"
S = "${WORKDIR}/XExtensions"

inherit autotools pkgconfig

do_stage() {
	oe_runmake install prefix=${STAGING_DIR} \
	       bindir=${STAGING_BINDIR} \
	       includedir=${STAGING_INCDIR} \
	       libdir=${STAGING_LIBDIR} \
	       datadir=${STAGING_DATADIR}
}
