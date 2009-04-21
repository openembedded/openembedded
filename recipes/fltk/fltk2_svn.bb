DESCRIPTION = "FLTK is a cross-platform C++ GUI toolkit"
HOMEPAGE = "http://www.fltk.org"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "LGPL"
DEPENDS = "zlib jpeg libpng libxext libxft"

SRC_URI = "http://ftp.easysw.com/pub/fltk/snapshots/fltk-2.0.x-r6671.tar.bz2"

#S = "${WORKDIR}/fltk-${PV}"
S = "${WORKDIR}/fltk-2.0.x-r6671"

inherit autotools binconfig

EXTRA_OECONF = "--enable-shared --enable-xdbe --enable-xft --enable-gl --x-includes=${STAGING_INCDIR} --x-libraries=${STAGING_LIBDIR}"

do_configure() {
        oe_runconf
}

do_stage() {
	autotools_stage_all
}

do_install () {
	sed -i "s|^STRIP.*=.*$|STRIP = ${STRIP}|" makeinclude
	sed -i "s|^bindir.*=.*$|bindir = ${D}${bindir}|" makeinclude
        oe_runmake install \
		prefix="${D}${prefix}" \
                bindir="${D}${bindir}" \
                libdir="${D}${libdir}" \
                includedir="${D}${includedir}" \
                datadir="${STAGING_DATADIR}"
}

python populate_packages_prepend () {
        if (bb.data.getVar('DEBIAN_NAMES', d, 1)):
                bb.data.setVar('PKG_${PN}', 'libfltk2${PV}', d)
}

LEAD_SONAME = "libfltk2.so"
