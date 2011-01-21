DESCRIPTION = "GNU ddrescue is a data recovery tool"
AUTHOR = "Antonio Diaz Diaz"
HOMEPAGE = "http://www.gnu.org/software/ddrescue/ddrescue.html"
SECTION = "console"
PRIORITY = "optional"
LICENSE = "GPLv3+"

SRC_URI = "${GNU_MIRROR}/${PN}/${P}.tar.gz"
SRC_URI[md5sum] = "d6f6cc63df9ad352bc6e43b65c975af5"
SRC_URI[sha256sum] = "cd17b92d64d68ecdef5a61ae17741d45c856a8c5f49e44fbf1f4381d29aaa906"

inherit autotools

EXTRA_OECONF = "'CXX=${CXX}' 'CPPFLAGS=${CPPFLAGS}' 'CXXFLAGS=${CXXFLAGS}' 'LDFLAGS=${LDFLAGS}'"
