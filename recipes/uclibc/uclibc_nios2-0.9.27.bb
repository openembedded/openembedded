DEFAULT_PREFERENCE = "1"
PR = "r1"

require uclibc.inc

SRC_URI += "http://127.0.0.1/uClibc-${PV}.tar.bz2"
S = "${WORKDIR}/uClibc"

#SRC_URI += "http://127.0.0.1/uClibc-${PV}.tar.bz2"
#S = "${WORKDIR}/git"
