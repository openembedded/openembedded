PR = "r5"
MAINTAINER = "Oyvind Repvik <nail@nslu2-linux.org"

SRC_URI = "http://www.balabit.com/downloads/libol/0.3/${PN}-${PV}.tar.gz"

S = "${WORKDIR}/${PN}-${PV}"
inherit autotools

do_stage() {
	install -d ${STAGING_INCDIR}/libol
	install -m 0755 ${S}/libol-config ${STAGING_BINDIR}
	install -m 0755 ${S}/src/.libs/libol.so.0.0.0 ${STAGING_LIBDIR}
	ln -fs ${STAGING_LIBDIR}/libol.so.0.0.0 ${STAGING_LIBDIR}/libol.so.0
	install ${S}/src/*.h ${STAGING_INCDIR}/libol/
}
	
