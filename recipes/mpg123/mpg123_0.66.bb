DESCRIPTION = "mpg123 is a fast and free console based real time MPEG Audio Player \
for Layer 1, 2 and 3. It uses floating point math (unlike libmad)."
LICENSE = "LGPL"
DESCRIPTION = "multimedia"
HOMEPAGE = "http://www.mpg123.de"
RCONFLICTS_${PN} = "mpg321"
RREPLACES_${PN} = "mpg321"
PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/mpg123/mpg123-${PV}.tar.bz2"

inherit autotools

SRC_URI[md5sum] = "6753c7ce5bb35bd65c535b2b6322a9aa"
SRC_URI[sha256sum] = "2cdcb3b78412034f787ae52e213d04455132f6c94c8b7f3f4b21c21c38d9afa5"
