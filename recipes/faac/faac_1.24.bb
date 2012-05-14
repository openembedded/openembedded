DESCRIPTION = "Library for reading some sort of media format."
SECTION = "libs"
PRIORITY = "optional"
DEPENDS = ""
LICENSE = "LGPLv2 LGPLv2.1"

PR = "r2"

inherit autotools

SRC_URI = "${SOURCEFORGE_MIRROR}/faac/${PN}-${PV}.tar.gz"
S = "${WORKDIR}/${PN}"

PACKAGES =+ "lib${PN} lib${PN}-dev"

FILES_${PN} = " ${bindir}/faac "
FILES_lib${PN} = " ${libdir}/libfaac.so.*"
FILES_lib${PN}-dev = " ${includedir}/faac.h ${includedir}/faaccfg.h ${libdir}/libfaac.so ${libdir}/libfaac.la ${libdir}/libfaac.a "


SRC_URI[md5sum] = "e72dc74db17b42b06155613489077ad7"
SRC_URI[sha256sum] = "a5844ff3bce0d7c885af71f41da01395d3253dcfc33863306a027a78a7cfad9e"
