DESCRIPTION = "Zlib Compression Library"
SECTION = "libs"
PRIORITY = "required"
HOMEPAGE = "http://www.gzip.org/zlib/"
LICENSE = "zlib"
PR ="r5"

SRC_URI = "http://www.zlib.net/zlib-1.2.3.tar.bz2 \
		file://visibility.patch;patch=1 \
		file://autotools.patch;patch=1 "

S = "${WORKDIR}/zlib-${PV}"

DEPENDS = "libtool-cross"

inherit autotools

do_stage() {
	autotools_stage_all
}

SRC_URI[md5sum] = "dee233bf288ee795ac96a98cc2e369b6"
SRC_URI[sha256sum] = "e3b9950851a19904d642c4dec518623382cf4d2ac24f70a76510c944330d28ca"
