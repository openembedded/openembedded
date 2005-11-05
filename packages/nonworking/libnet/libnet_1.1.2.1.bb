#FIXME: Does not compile against linux-libc-headers 2.6
BROKEN = "1"
DESCRIPTION = "A packet dissection and creation library"
SRC_URI = "http://www.packetfactory.net/libnet/dist/libnet.tar.gz \
           file://configure.patch;patch=1 \
           file://compile-fix.patch;patch=1"
S = "${WORKDIR}/libnet"

inherit autotools

CPPFLAGS_prepend = "-I${S}/libnet/include "

do_configure() {
	oe_runconf
}

do_stage () {
	install -m 0755 libnet-config ${STAGING_BINDIR}/
	oe_runmake -C src 'DESTDIR=${STAGING_DIR}/target' \
			  'libdir=/lib' install-libLIBRARIES
	oe_runmake -C include 'DESTDIR=${STAGING_DIR}/target' \
			      'includedir=/include' install-includeHEADERS
	oe_runmake -C include/libnet 'DESTDIR=${STAGING_DIR}/target' \
			      'includedir=/include' install-libnetincludeHEADERS
}
