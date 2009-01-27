PR = "r1"

require binutils.inc

DESCRIPTION = "A GNU collection of binary utilities - MinGW port"
HOMEPAGE = "http://www.mingw.org/"

SRC_URI = "${SOURCEFORGE_MIRROR}/mingw/binutils-${PV}-src.tar.gz"

S = "${WORKDIR}/binutils-${PV}-src"

DEFAULT_PREFERENCE = "0"
