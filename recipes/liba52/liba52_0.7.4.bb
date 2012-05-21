DESCRIPTION = "Library for reading some sort of media format."
LICENSE = "GPLv2+"
SECTION = "libs"
PRIORITY = "optional"
PR = "r4"

inherit autotools

SRC_URI = "http://liba52.sourceforge.net/files/a52dec-${PV}.tar.gz \
           file://01-enable-pic.diff"
S = "${WORKDIR}/a52dec-${PV}"

EXTRA_OECONF = " --enable-shared "

PACKAGES =+ "a52dec a52dec-dbg a52dec-doc"

FILES_${PN} = " ${libdir}/liba52.so.0 ${libdir}/liba52.so.0.0.0 " 
FILES_${PN}-dev = " ${includedir}/a52dec/*.h ${libdir}/liba52.so ${libdir}/liba52.la ${libdir}/liba52.a "
FILES_${PN}-dbg += " ${libdir}/.debug/*"
FILES_a52dec = " ${bindir}/* "
FILES_a52dec-dbg += " ${bindir}/.debug/* "
FILES_a52dec-doc = " ${mandir}/man1/* "

SRC_URI[md5sum] = "caa9f5bc44232dc8aeea773fea56be80"
SRC_URI[sha256sum] = "a21d724ab3b3933330194353687df82c475b5dfb997513eef4c25de6c865ec33"
