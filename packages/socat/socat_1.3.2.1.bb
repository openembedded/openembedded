SECTION = "console/network"
DEPENDS = "openssl"
DESCRIPTION = "Socat is a relay for bidirectional data \
transfer between two independent data channels."
LICENSE = "GPL"
SRC_URI = "http://www.dest-unreach.org/socat/download/socat-${PV}.tar.bz2 \
	   file://ldflags.patch;patch=1"
S = "${WORKDIR}/socat-1.3"

inherit autotools

do_install_prepend () {
	install -d ${D}${bindir} ${D}${mandir}/man1
}
