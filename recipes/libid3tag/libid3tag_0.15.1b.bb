DESCRIPTION = "Library for interacting with ID3 tags"
SECTION = "libs/multimedia"
PRIORITY = "optional"
LICENSE = "GPLv2+"
DEPENDS = "zlib"
PR = "r4"

SRC_URI = "ftp://ftp.mars.org/pub/mpeg/libid3tag-${PV}.tar.gz \
           file://libid3tag-pkg-config.patch"
SRC_URI[md5sum] = "e5808ad997ba32c498803822078748c3"
SRC_URI[sha256sum] = "63da4f6e7997278f8a3fef4c6a372d342f705051d1eeb6a46a86b03610e26151"

inherit autotools pkgconfig

EXTRA_OECONF = "-enable-speed"
