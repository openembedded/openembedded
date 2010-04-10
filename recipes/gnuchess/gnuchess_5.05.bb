DESCRIPTION = "Gnuchess is a chess playing engine."
HOMEPAGE = "http://www.gnu.org/software/chess/"
SECTION = "console"
PRIORITY = "optional"
LICENSE = "GPL"

SRC_URI = "${GNU_MIRROR}/chess/${PN}-${PV}.tar.gz"
S = "${WORKDIR}/chess"

inherit autotools

SRC_URI[md5sum] = "008820142c414517512ab0ad3e036c8b"
SRC_URI[sha256sum] = "d97ee0f1c45e1bfa880305a33e7e0ef695927094adce100cc76a76a0f57ef789"
