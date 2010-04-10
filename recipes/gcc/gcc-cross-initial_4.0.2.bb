require gcc-cross_${PV}.bb
require gcc-cross-initial.inc

EXTRA_OECONF += "--disable-multilib --disable-libssp --disable-libmudflap"

SRC_URI[md5sum] = "a659b8388cac9db2b13e056e574ceeb0"
SRC_URI[sha256sum] = "37b3286c2bfb68da9df983f60721f868e29897f7a426306748fee93b25c5fb61"
