DESCRIPTION = "Gnuchess is a chess playing engine."
HOMEPAGE = "http://www.gnu.org/software/chess/"
SECTION = "console"
PRIORITY = "optional"
LICENSE = "GPL"

SRC_URI = "${GNU_MIRROR}/chess/${PN}-${PV}.tar.gz"
S = "${WORKDIR}/chess"

inherit autotools
