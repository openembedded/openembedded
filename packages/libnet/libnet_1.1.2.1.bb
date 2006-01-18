SECTION = "libs"
DESCRIPTION = "A packet dissection and creation library"
HOMEPAGE = "http://www.packetfactory.net/libnet/"
LICENSE = "BSD"
PRIORITY = "optional"
DEPENDS = "libpcap"
PR = "r0"

# There are major API changes beween libnet v1.0 and libnet v1.1
PROVIDES = "libnet-1.1"

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

do_install_append () {
    install -d ${D}${datadir}/man/man3/
    install -d ${D}${bindir}
    install -m 0644 ${S}/doc/man/man3/*.3 ${D}${datadir}/man/man3/
    install -m 0755 ${S}/libnet-config ${D}${bindir}
}

PACKAGES = "${PN}-dev ${PN}-doc"
FILES_${PN}-dev += "${bindir}/libnet-config"
