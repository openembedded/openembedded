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
