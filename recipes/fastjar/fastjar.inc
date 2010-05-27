DESCRIPTION = "jar replacement written in C."
HOMEPAGE = "http://savannah.nongnu.org/projects/fastjar/"
SECTION = "devel"
PRIORITY = "optional"
LICENSE = "GPLv2"

DEPENDS = "zlib"

INC_PR = "r4"

BBCLASSEXTEND = "native"

SRC_URI = "http://download.savannah.nongnu.org/releases/fastjar/fastjar-${PV}.tar.gz"

inherit autotools

PACKAGES = "${PN}-grepjar ${PN} ${PN}-dbg ${PN}-doc"
FILES_${PN}-grepjar = "${bindir}/grepjar"
