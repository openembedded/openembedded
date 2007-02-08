DESCRIPTION = "Electronic book library"
HOMEPAGE = "http://www.sra.co.jp/people/m-kasahr/eb"
SECTION = "libs"
LICENSE = "GPL"

SRC_URI = "ftp://ftp.sra.co.jp/pub/misc/eb/eb-${PV}.tar.bz2"

inherit autotools pkgconfig

do_stage () {
	install -d ${STAGING_INCDIR}/eb/
        install -m 0644 eb/*.h ${STAGING_INCDIR}/eb/
	install eb/.libs/libeb.so ${STAGING_LIBDIR}
}
