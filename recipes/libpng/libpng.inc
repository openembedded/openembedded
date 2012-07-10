DESCRIPTION = "PNG Library"
HOMEPAGE = "http://www.libpng.org/"
LICENSE = "libpng"
SECTION = "libs"
PRIORITY = "required"

DEPENDS = "zlib"

INC_PR = "r3"

BBCLASSEXTEND = "native"

RPROVIDES += "libpng3"

SRC_URI = "ftp://ftp.simplesystems.org/pub/libpng/png/src/history/libpng12/libpng-${PV}.tar.bz2;name=libpng"
S = "${WORKDIR}/libpng-${PV}"

inherit autotools pkgconfig binconfig


PACKAGES =+ "${PN}12-dbg ${PN}12 ${PN}12-dev"

FILES_${PN}12-dbg = "${libdir}/.debug/libpng12*"
FILES_${PN}12 = "${libdir}/libpng12.so.*"
FILES_${PN}12-dev = "${libdir}/libpng12.* ${includedir}/libpng12 ${libdir}/pkgconfig/libpng12.pc"
FILES_${PN} = "${libdir}/lib*.so.*"
FILES_${PN}-dev += " ${bindir} ${sbindir}"
