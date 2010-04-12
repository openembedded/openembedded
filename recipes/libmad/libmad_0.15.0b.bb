DESCRIPTION = "MPEG Audio Decoder Library"
SECTION = "libs"
PRIORITY = "optional"
DEPENDS = "libid3tag"
LICENSE = "GPL"
PR = "r4"

SRC_URI = "ftp://ftp.mars.org/pub/mpeg/libmad-${PV}.tar.gz"
S = "${WORKDIR}/libmad-${PV}"

inherit autotools

EXTRA_OECONF = "-enable-speed --enable-shared"
# The ASO's don't take any account of thumb...
EXTRA_OECONF_append_thumb = " --disable-aso --enable-fpm=default"

do_configure_prepend () {
#	damn picky automake...
	touch NEWS AUTHORS ChangeLog
}


SRC_URI[md5sum] = "2e4487cdf922a6da2546bad74f643205"
SRC_URI[sha256sum] = "5666a1dec6956a9b9869aacc3b05a10222639651790be3a9c43772890eb49cd6"
