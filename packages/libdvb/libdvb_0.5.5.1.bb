LICENSE = "GPL"
DESCRIPTION = "Linux Digital Video Broadcast library"
DESCRIPTION_libdvb-dev = "Headers for libdvb development"
HOMEPAGE = "http://www.metzlerbros.org/dvb/index.html"
MAINTAINER = "Oyvind Repvik <nail@nslu2-linux.org"
SECTION = "libs"
PRIORITY = "optional"
PR = "r2"

SRC_URI = "http://www.metzlerbros.org/dvb/${PN}-${PV}.tar.gz \
	  file://topf2ps.patch;patch=1"

S = "${WORKDIR}/${PN}-${PV}"

inherit autotools pkgconfig

do_configure() {
	grep -v ^PREFIX ${S}/config.mk > ${S}/config.mk.new
	echo "PREFIX=${prefix}" >> ${S}/config.mk.new
	mv ${S}/config.mk.new ${S}/config.mk
}


do_stage() {
	install -d ${STAGING_INCDIR}/dvb
	install -m 0644 ${S}/include/*.h ${STAGING_INCDIR}/dvb
	oe_libinstall -a -C libdvb libdvb ${STAGING_LIBDIR}
}

