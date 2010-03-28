SECTION = "libs"
PRIORITY = "optional"
DEPENDS = "zlib"
DESCRIPTION = "Library for interacting with ID3 tags."
LICENSE = "GPL"
PR = "r2"

SRC_URI = "ftp://ftp.mars.org/pub/mpeg/libid3tag-${PV}.tar.gz \
           file://id3tag.pc"

S = "${WORKDIR}/libid3tag-${PV}"

inherit autotools pkgconfig

EXTRA_OECONF = "-enable-speed"

do_configure_prepend() {
    install -m 0644 ${WORKDIR}/id3tag.pc ${S}
}
