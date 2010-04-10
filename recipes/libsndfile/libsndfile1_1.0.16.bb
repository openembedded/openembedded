DESCRIPTION = "An audio format Conversion library"
HOMEPAGE = "http://www.mega-nerd.com/libsndfile"
AUTHOR = "Erik de Castro Lopo"
SECTION = "libs/multimedia"
LICENSE = "LGPL"
PR = "r2"

SRC_URI = "http://www.mega-nerd.com/libsndfile/libsndfile-${PV}.tar.gz"
S = "${WORKDIR}/libsndfile-${PV}"

inherit autotools lib_package pkgconfig

do_stage() {
	oe_libinstall -a -so -C src libsndfile ${STAGING_LIBDIR}
	install -m 0644 ${S}/src/sndfile.h ${STAGING_INCDIR}/
}


SRC_URI[md5sum] = "773b6639672d39b6342030c7fd1e9719"
SRC_URI[sha256sum] = "79e305112a4d9598b93b614a7747604f9ef10d9a2dee52c5903b554bbeaedd7c"
