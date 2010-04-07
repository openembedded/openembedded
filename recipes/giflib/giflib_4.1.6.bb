DESCRIPTION = "shared library for GIF images"
SECTION = "libs"
LICENSE = "MIT"
PR = "r2"

SRC_URI = "${SOURCEFORGE_MIRROR}/giflib/${BP}.tar.bz2"

inherit autotools

PACKAGES += "${PN}-utils"
FILES_${PN} = "${libdir}/libgif.so.*"
FILES_${PN}-utils = "${bindir}"

BBCLASSEXTEND = "native"
