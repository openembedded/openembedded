DESCRIPTION = "mpg123 is a fast and free console based real time MPEG Audio Player \
for Layer 1, 2 and 3. It uses floating point math (unlike libmad)."
LICENSE = "LGPL"
DESCRIPTION = "multimedia"
HOMEPAGE = "http://www.mpg123.de"
RCONFLICTS = "mpg321"
RREPLACES = "mpg321"

SRC_URI = "${SOURCEFORGE_MIRROR}/mpg123/mpg123-${PV}.tar.bz2"

inherit autotools
