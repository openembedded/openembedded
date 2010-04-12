DESCRIPTION = "FLTK is a cross-platform C++ GUI toolkit"
HOMEPAGE = "http://www.fltk.org"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "LGPL"
DEPENDS = "alsa-lib zlib jpeg libpng libxext libxft"
PR = "r1"

SRC_URI = "ftp://ftp.rz.tu-bs.de/pub/mirror/ftp.easysw.com/ftp/pub/fltk/${PV}/fltk-${PV}-source.tar.bz2 \
	   file://disable_test.patch;patch=1 \
	  "

S = "${WORKDIR}/fltk-${PV}"

inherit lib_package autotools_stage binconfig

TARGET_CC_ARCH += "${LDFLAGS}"

EXTRA_OECONF = "--enable-shared \
		--enable-threads \
		--enable-xdbe --enable-xft --enable-gl \
		--x-includes=${STAGING_INCDIR} --x-libraries=${STAGING_LIBDIR}"

do_configure() {
        oe_runconf
}

python populate_packages_prepend () {
        if (bb.data.getVar('DEBIAN_NAMES', d, 1)):
                bb.data.setVar('PKG_${PN}', 'libfltk${PV}', d)
}

LEAD_SONAME = "libfltk.so"

SRC_URI[md5sum] = "e146fd264e1001b1313acfd41ef75552"
SRC_URI[sha256sum] = "facba5a97a20ca92b32504174474775c6b12fb67a6f646fa0de18db709c3edde"
