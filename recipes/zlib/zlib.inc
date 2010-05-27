DESCRIPTION = "Zlib Compression Library"
SECTION = "libs"
PRIORITY = "required"
HOMEPAGE = "http://www.gzip.org/zlib/"
LICENSE = "zlib"
INC_PR ="r6"

BBCLASSEXTEND = "native sdk"

SRC_URI = "http://www.zlib.net/zlib-${PV}.tar.bz2"

inherit autotools

DEPENDS = "libtool-cross"
