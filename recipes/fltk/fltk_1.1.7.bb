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

SRC_URI[md5sum] = "2e29319119adc9d63b2f26b72cae0a88"
SRC_URI[sha256sum] = "855a97e35da823f205253b865758715872cd2c7720e4dcf134a3b6dc18bfb96a"
