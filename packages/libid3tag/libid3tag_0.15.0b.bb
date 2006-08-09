SECTION = "libs"
PRIORITY = "optional"
MAINTAINER = "Greg Gilbert <greg@treke.net>"
DEPENDS = "zlib"
DESCRIPTION = "Library for interacting with ID3 tags."
LICENSE = "GPL"
PR = "r2"

PR = "r1"

SRC_URI = "ftp://ftp.mars.org/pub/mpeg/libid3tag-${PV}.tar.gz \
    file://pkgconfig.patch;patch=1;pnum=1"

S = "${WORKDIR}/libid3tag-${PV}"

inherit autotools pkgconfig

EXTRA_OECONF = "-enable-speed"

do_stage() {
	oe_libinstall -so libid3tag ${STAGING_LIBDIR}
        install -m 0644 id3tag.h ${STAGING_INCDIR}
}
