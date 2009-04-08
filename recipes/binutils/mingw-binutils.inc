DESCRIPTION = "A GNU collection of binary utilities - MinGW port"
HOMEPAGE = "http://www.mingw.org/"

require binutils.inc

SRC_URI = "${SOURCEFORGE_MIRROR}/mingw/binutils-${PV}-src.tar.gz"

S = "${WORKDIR}/binutils-${PV}"

DEFAULT_PREFERENCE = "-1"
