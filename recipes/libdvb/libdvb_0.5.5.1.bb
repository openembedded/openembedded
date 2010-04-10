DESCRIPTION = "Linux Digital Video Broadcast library"
DESCRIPTION_libdvb-dev = "Headers for libdvb development"
HOMEPAGE = "http://www.metzlerbros.org/dvb/index.html"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "GPL"
PR = "r3"

SRC_URI = "http://www.metzlerbros.org/dvb/${P}.tar.gz \
          file://topf2ps.patch;patch=1 \
          file://gcc4.patch;patch=1 \
          file://ldflags.patch;patch=1"

S = "${WORKDIR}/${PN}-${PV}"

PARALLEL_MAKE = ""

inherit autotools pkgconfig

do_configure() {
        grep -v ^PREFIX ${S}/config.mk | grep -v ^CFLAGS > ${S}/config.mk.new
        echo "PREFIX=${prefix}" >> ${S}/config.mk.new
        mv ${S}/config.mk.new ${S}/config.mk
}

do_stage() {
        install -d ${STAGING_INCDIR}/dvb
        install -m 0644 ${S}/include/*.h ${STAGING_INCDIR}/dvb
        oe_libinstall -a -C libdvb libdvb ${STAGING_LIBDIR}
}

SRC_URI[md5sum] = "47612d2f8a4d4dee746a166d8b7f6f77"
SRC_URI[sha256sum] = "941e8020129111377652bd7253ea85e6c133fd1c23c66bd9fc0ca9eabab1385a"
