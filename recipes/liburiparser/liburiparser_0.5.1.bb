DESCRIPTION = "uriparser is a strictly RFC 3986 compliant URI parsing library."
HOMEPAGE = "http://uriparser.sf.net"
SECTION = "libs"
LICENSE = "BSD"

SRC_URI = "${SOURCEFORGE_MIRROR}/uriparser/uriparser-${PV}.tar.bz2 \
           file://autofoo.patch;patch=1"
S = "${WORKDIR}/uriparser-${PV}"

inherit autotools pkgconfig

do_stage() {
	autotools_stage_all
}


SRC_URI[md5sum] = "faf561c6260e1b580cba2509f410a29f"
SRC_URI[sha256sum] = "5a664f5c8f404c1148f661499866f1fe8df8debef2adc55c630ac83e6d57a98c"
