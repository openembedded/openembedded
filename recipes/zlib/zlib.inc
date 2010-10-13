DESCRIPTION = "Zlib Compression Library"
SECTION = "libs"
PRIORITY = "required"
HOMEPAGE = "http://www.gzip.org/zlib/"
LICENSE = "zlib"
INC_PR ="r7"

# Below option is added to overcome the GCC bug on ARM 
# see http://gcc.gnu.org/PR42981 for further details.
# We could potentially take it off when its fixed in gcc 4.5
CFLAGS += "${CFLAGS_EXTRA}"
CFLAGS_EXTRA_append_arm = " -fforward-propagate"
CFLAGS_EXTRA_virtclass-native = ""
CFLAGS_EXTRA_virtclass-sdk = ""

BBCLASSEXTEND = "native sdk"

SRC_URI = "http://www.zlib.net/zlib-${PV}.tar.bz2"

inherit autotools
