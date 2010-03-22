SECTION = "console/network"
DEPENDS = "openssl"
DESCRIPTION = "Socat is a relay for bidirectional data \
transfer between two independent data channels."
LICENSE = "GPL"
PR = "r0"

SRC_URI = "http://www.dest-unreach.org/socat/download/socat-${PV}.tar.bz2;name=src \
           file://compile.patch;patch=1"
SRC_URI[src.md5sum] = "9c0c5e83ce665f38d4d3aababad275eb"
SRC_URI[src.sha256sum] = "f7395b154914bdaa49805603aac2a90fb3d60255f95691d7779ab4680615e167"
EXTRA_OECONF = " --disable-termios "

inherit autotools

do_install_prepend () {
        mkdir -p ${D}${bindir}
	install -d ${D}${bindir} ${D}${mandir}/man1
}
