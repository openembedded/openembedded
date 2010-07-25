SRC_URI = "${GNU_MIRROR}/ncurses/ncurses-${PV}.tar.gz \
           file://makefile_tweak.patch \
           file://use_ldflags.patch \
           file://visibility.patch"
S = "${WORKDIR}/ncurses-${PV}"

require ncurses.inc
PR = "${INC_PR}.0"

LEAD_SONAME = "libncurses.so.5"

SRC_URI[md5sum] = "069c8880072060373290a4fefff43520"
SRC_URI[sha256sum] = "5abce063cf431790f4e6a801a96c7eea0b33a41ecd0970f6312f52575c083b36"

CFLAGS += "${CFLAGS_EXTRA}"
BBCLASSEXTEND = "native nativesdk sdk"
CFLAGS_EXTRA_virtclass-native = ""
CFLAGS_EXTRA_virtclass-sdk = ""
DEPENDS_virtclass-native = ""
EXTRA_OEMAKE_virtclass-native = '"BUILD_CCFLAGS=${BUILD_CCFLAGS}"'
EXTRA_OEMAKE_virtclass-sdk = '"BUILD_CCFLAGS=${BUILD_CCFLAGS}"'
