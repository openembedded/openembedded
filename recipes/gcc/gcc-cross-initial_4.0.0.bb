require gcc-cross_${PV}.bb
require gcc-cross-initial.inc

DEPENDS += "gmp-native mpfr-native"

EXTRA_OECONF += "--disable-multilib --disable-libssp --disable-libmudflap"

