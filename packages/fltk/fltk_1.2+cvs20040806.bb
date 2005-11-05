DESCRIPTION = "FLTK is a cross-platform C++ GUI toolkit"
LICENSE ="LGPL"
HOMEPAGE = "http://www.fltk.org"
SECTION = "libs"
PRIORITY = "optional"
MAINTAINER = "Rene Wagner <rw@handhelds.org>"
DEPENDS = "jpeg libpng zlib"
PR = "r2"

SRC_URI = "cvs://anonymous:@cvs.sourceforge.net/cvsroot/fltk;module=fltk;method=pserver;tag=v1_2;date=${@bb.data.getVar('PV', d, 1)[7:]} \
	   file://makefiles.patch;patch=1 \
	   file://autotools.patch;patch=1"
S="${WORKDIR}/fltk"

inherit autotools binconfig

do_configure_prepend() {
	autoconf
}

FILES_${PN} = "${libdir}/lib*.so.*"
FILES_${PN}-dev += " ${bindir}/fltk-config"
LEAD_SONAME = "libfltk.so"

EXTRA_OECONF = "--enable-shared --disable-gl"

do_install () {
	oe_runmake prefix="${D}${prefix}" \
		bindir="${D}${bindir}" \
		libdir="${D}${libdir}" \
		includedir="${D}${includedir}" \
		install
}

do_stage() {
	oe_runmake install prefix=${STAGING_DIR} \
	       bindir=${STAGING_BINDIR} \
	       includedir=${STAGING_INCDIR} \
	       libdir=${STAGING_LIBDIR} \
	       datadir=${STAGING_DATADIR}
}

python populate_packages_prepend () {
        if (bb.data.getVar('DEBIAN_NAMES', d, 1)):
                bb.data.setVar('PKG_${PN}', 'libfltk1.2', d)
}
