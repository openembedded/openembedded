SECTION = "console/network"
DEPENDS = "openssl"
DESCRIPTION = "Socat is a relay for bidirectional data \
transfer between two independent data channels."
LICENSE = "GPL"
PR = "r1"

SRC_URI = "http://www.dest-unreach.org/socat/download/socat-${PV}.tar.bz2 \
           file://xioopen.patch;patch=1 \
           file://ldflags.patch;patch=1 \
           file://xioinitialize.patch;patch=1"

S = "${WORKDIR}/socat-1.3"

inherit autotools

do_install_prepend () {
        mkdir -p ${D}${bindir}
	install -d ${D}${bindir} ${D}${mandir}/man1
}
