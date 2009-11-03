DESCRIPTION = "jar replacement written in C."
HOMEPAGE = "http://savannah.nongnu.org/projects/fastjar/"
SECTION = "devel"
PRIORITY = "optional"
LICENSE = "GPL"

DEPENDS = "zlib"

INC_PR = "r3"

SRC_URI = "http://download.savannah.nongnu.org/releases/fastjar/fastjar-${PV}.tar.gz"

inherit autotools

PACKAGES =+ "${PN}-grepjar"
FILES_${PN}-grepjar = "${bindir}/grepjar"
