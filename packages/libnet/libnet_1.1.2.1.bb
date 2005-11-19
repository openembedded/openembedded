SECTION = "libs"
DESCRIPTION = "A packet dissection and creation library"
HOMEPAGE = "http://www.packetfactory.net/libnet/"
LICENSE = "BSD"
PRIORITY = "optional"
DEPENDS = "libpcap"
PR = "r0"

SRC_URI = "http://www.packetfactory.net/libnet/dist/libnet-${PV}.tar.gz \
	   file://support-uclibc.patch;patch=1 \
	   file://fix-endianess-test.patch;patch=1 \
	   file://configure.patch;patch=1"

S = "${WORKDIR}/libnet"

inherit autotools binconfig

CPPFLAGS_prepend = "-I${S}/libnet/include "

do_configure() {
	oe_runconf
}

do_stage () {
	oe_runmake -C src 'DESTDIR=${STAGING_LIBDIR}' 'libdir=' install-libLIBRARIES
	oe_runmake -C include 'DESTDIR=${STAGING_INCDIR}' 'includedir=' install-includeHEADERS
	oe_runmake -C include/libnet 'DESTDIR=${STAGING_INCDIR}' 'includedir=' install-libnetincludeHEADERS
}
