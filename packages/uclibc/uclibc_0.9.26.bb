PR = "r7"

include uclibc.inc

SRC_URI += "http://www.uclibc.org/downloads/uClibc-${PV}.tar.bz2 \
           file://26headers.patch;patch=1 \
           file://nokernelheadercheck.patch;patch=1 \
	   file://dyn-ldconfig.patch;patch=1"
S = "${WORKDIR}/uClibc-${PV}"
