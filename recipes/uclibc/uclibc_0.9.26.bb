PR = "r12"

require uclibc.inc

SRC_URI += "file://26headers.patch;patch=1 \
            file://nokernelheadercheck.patch;patch=1 \
	    file://dyn-ldconfig.patch;patch=1 \
           "

S = "${WORKDIR}/uClibc-${PV}"
