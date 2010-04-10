DESCRIPTION = "FLTK is a cross-platform C++ GUI toolkit"
HOMEPAGE = "http://www.fltk.org"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "LGPL"
DEPENDS = "jpeg libpng virtual/libgl zlib"
PR = "r2"

SRC_URI = "ftp://ftp-fourier.ujf-grenoble.fr/xcas/devel/sources/fltk-${PV}-device.tar.gz"

S = "${WORKDIR}/fltk-${PV}-Fl_Device"

inherit autotools binconfig lib_package

CXXFLAGS = ""

EXTRA_OECONF = "--enable-shared --enable-gl --x-includes=${STAGING_INCDIR} --x-libraries=${STAGING_LIBDIR}"

do_configure() {
        oe_runconf
}

do_install () {
	autotools_stage_all
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
                bb.data.setVar('PKG_${PN}', 'libfltk${PV}', d)
}

LEAD_SONAME = "libfltk.so"

SRC_URI[md5sum] = "826c6afa88c9c4da734fe7393ed59639"
SRC_URI[sha256sum] = "a0e31ad5088414aaee003586a23127a5ace7717ba4f8fb4e02cf56bb9a5c30f4"
