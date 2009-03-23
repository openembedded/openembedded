DESCRIPTION = "FLTK is a cross-platform C++ GUI toolkit"
HOMEPAGE = "http://www.fltk.org"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "LGPL"
DEPENDS = "zlib jpeg libpng libxext libxft"
PR = "r2"

SRC_URI = "ftp://ftp.rz.tu-bs.de/pub/mirror/ftp.easysw.com/ftp/pub/fltk/${PV}/fltk-${PV}-source.tar.bz2"

S = "${WORKDIR}/fltk-${PV}"

inherit autotools binconfig

EXTRA_OECONF = "--enable-shared --enable-xdbe --enable-xft --enable-gl --x-includes=${STAGING_INCDIR} --x-libraries=${STAGING_LIBDIR}"

do_configure() {
        oe_runconf
}

do_stage() {
	autotools_stage_all
}

do_install () {
        oe_runmake install prefix="${D}${prefix}" \
                bindir="${D}${bindir}" \
                libdir="${D}${libdir}" \
                includedir="${D}${includedir}" \
                datadir="${STAGING_DATADIR}"
}

python populate_packages_prepend () {
        if (bb.data.getVar('DEBIAN_NAMES', d, 1)):
                bb.data.setVar('PKG_${PN}', 'libfltk${PV}', d)
}

LEAD_SONAME = "libfltk.so"
