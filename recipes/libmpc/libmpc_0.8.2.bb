require libmpc.inc

DEPENDS = "gmp mpfr"
S = "${WORKDIR}/mpc-${PV}"
NATIVE_INSTALL_WORKS = "1"
BBCLASSEXTEND = "native"
PR = "r1"

SRC_URI = "http://www.multiprecision.org/mpc/download/mpc-${PV}.tar.gz"

EXTRA_OECONF_append_virtclass-native = " --enable-static"
SRC_URI[md5sum] = "e98267ebd5648a39f881d66797122fb6"
SRC_URI[sha256sum] = "ae79f8d41d8a86456b68607e9ca398d00f8b7342d1d83bcf4428178ac45380c7"
