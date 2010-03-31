DESCRIPTION = "A packet dissection and creation library"
HOMEPAGE = "http://www.packetfactory.net/libnet/"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "BSD"
DEPENDS = "libpcap"
# There are major API changes beween libnet v1.0 and libnet v1.1
PROVIDES = "libnet-1.1"
PR = "r4"

SRC_URI = "${DEBIAN_MIRROR}/main/libn/libnet/libnet_${PV}.orig.tar.gz \
           file://support-uclibc.patch;patch=1 \
           file://fix-endianess-test.patch;patch=1 \
           file://new-autotools.patch;patch=1"

S = "${WORKDIR}/libnet"

inherit autotools binconfig

do_configure_prepend() {
        rm -f aclocal.m4 Makefile.am ltmain.sh
}

do_install_append () {
        oe_runmake -C src 'DESTDIR=${D}${libdir}/' 'libdir=' install-libLIBRARIES
        oe_runmake -C include 'DESTDIR=${D}${includedir}/' 'includedir=' install-includeHEADERS
        oe_runmake -C include/libnet 'DESTDIR=${D}${includedir}/' 'includedir=' install-libnetincludeHEADERS
        install -d ${D}${datadir}/man/man3/
        install -d ${D}${bindir}
        install -m 0644 ${S}/doc/man/man3/*.3 ${D}${datadir}/man/man3/
        install -m 0755 ${S}/libnet-config ${D}${bindir}
}

#static build
FILES_${PN} = ""
FILES_${PN}-dev += "${bindir}/libnet-config"

CPPFLAGS_prepend = "-I${S}/libnet/include "
