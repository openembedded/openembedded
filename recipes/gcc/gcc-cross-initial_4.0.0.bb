require gcc-cross_${PV}.bb
require gcc-cross-initial.inc

DEPENDS += "gmp-native mpfr-native"

EXTRA_OECONF += "--disable-multilib --disable-libssp --disable-libmudflap"

SRC_URI[md5sum] = "55ee7df1b29f719138ec063c57b89db6"
SRC_URI[sha256sum] = "38a9a01e195000976dcd04ec854c398478ada839510b1de384ffbd5f99791bdc"
