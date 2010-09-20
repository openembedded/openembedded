require libmpc.inc

DEPENDS = "gmp mpfr"
S = "${WORKDIR}/mpc-${PV}"
NATIVE_INSTALL_WORKS = "1"
BBCLASSEXTEND = "native"
PR = "r2"

SRC_URI = "http://www.multiprecision.org/mpc/download/mpc-${PV}.tar.gz"

EXTRA_OECONF_append_virtclass-native = " --enable-static"

SRC_URI[md5sum] = "5b34aa804d514cc295414a963aedb6bf"
SRC_URI[sha256sum] = "e664603757251fd8a352848276497a4c79b7f8b21fd8aedd5cc0598a38fee3e4"
