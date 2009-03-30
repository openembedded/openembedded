SECTION = "console/network"
DESCRIPTION = "Proof of concept Cisco Leap Cracker"
HOMEPAGE = "http://asleap.sourceforge.net - outdated"
LICENSE = "GPLv2"
DEPENDS = "libpcap openssl"

SRC_URI = "http://802.11ninja.net/~jwright/code/${PN}-${PV}.tgz \
           file://if.h.patch;patch=1 \
           "

S = "${WORKDIR}/${PN}-${PV}"

CFLAGS_append = " -D_LINUX -D_FILE_OFFSET_BITS=64 -D_LARGEFILE_SOURCE \
                  -D_OPENSSL_MD4 -L${STAGING_LIBDIR}"

do_install() {
        install -d ${D}/${sbindir}
        install -m 0755 asleap       ${D}/${sbindir}
	install -d ${D}/${bindir}
	install -m 0755 genkeys      ${D}/${bindir}
}

#
# Maintainer's note: I am currently not including the test dump file or the
# scripts directory due to size constraints and the fact that it seems
# pointless.  If someone requests it, I might add it as a seperate package.
#
