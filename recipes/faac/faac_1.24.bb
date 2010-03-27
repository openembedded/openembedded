DESCRIPTION = "Library for reading some sort of media format."
SECTION = "libs"
PRIORITY = "optional"
DEPENDS = ""
LICENSE = "LGPL"

PR = "r1"

inherit autotools

SRC_URI = "${SOURCEFORGE_MIRROR}/faac/${PN}-${PV}.tar.gz"
S = "${WORKDIR}/${PN}"

PACKAGES =+ "lib${PN} lib${PN}-dev"

FILES_${PN} = " ${bindir}/faac "
FILES_lib${PN} = " ${libdir}/libfaac.so.*"
FILES_lib${PN}-dev = " ${includedir}/faac.h ${includedir}/faaccfg.h ${libdir}/libfaac.so ${libdir}/libfaac.la ${libdir}/libfaac.a "

