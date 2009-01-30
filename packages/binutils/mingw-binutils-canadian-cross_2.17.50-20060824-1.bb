require mingw-binutils_${PV}.bb
require binutils-canadian-cross.inc

DEFAULT_PREFERENCE_sdk-mingw32 = "1"
DEFAULT_PREFERENCE_sdk-mingw64 = "1"

require binutils-canadian-cross.inc

SRC_URI = "${SOURCEFORGE_MIRROR}/mingw/binutils-${PV}-src.tar.gz"

S = "${WORKDIR}/binutils-${PV}-src"
