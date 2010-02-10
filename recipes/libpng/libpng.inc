DESCRIPTION = "PNG Library"
HOMEPAGE = "http://www.libpng.org/"
LICENSE = "libpng"
SECTION = "libs"
PRIORITY = "required"
DEPENDS = "zlib"

INC_PR = "r2"

SRC_URI = "${SOURCEFORGE_MIRROR}/libpng/libpng-${PV}.tar.bz2;name=tarball"
S = "${WORKDIR}/libpng-${PV}"

inherit autotools pkgconfig binconfig

PACKAGES =+ "libpng3 libpng12"

FILES_libpng3 = "${libdir}/libpng.so.*"
FILES_libpng12 = "${libdir}/libpng12.so.*"
FILES_${PN}-dev = "${includedir} ${libdir}/lib*.so ${libdir}/*.la \
		${libdir}/*.a ${libdir}/pkgconfig \
		${datadir}/aclocal ${bindir} ${sbindir}"
