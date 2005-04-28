DEFAULT_PREFERENCE = "1"
PR = "r4"

include uclibc.inc

SRC_URI += "http://www.uclibc.org/downloads/uClibc-${PV}.tar.bz2 \
            file://dyn-ldconfig.patch;patch=1 \
            file://nokernelheadercheck.patch;patch=1"
SRC_URI += " file://armeb-kernel-stat.h.patch;patch=1"
S = "${WORKDIR}/uClibc-${PV}"
