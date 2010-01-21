DESCRIPTION = "UW c-client library for mail protocols"
SECTION = "devel"
PRIORITY = "optional"
LICENSE = "University of Washingtons Free-Fork License"
DEPENDS = "libpam openssl libpam"

SRC_URI = "ftp://ftp.cac.washington.edu/imap/imap-${PV}.tar.Z \
	   file://quote_cctype.patch;patch=1"

S = "${WORKDIR}/imap-${PV}"

EXTRA_OEMAKE = "CC='${CC}'"

HEADERS = "src/c-client/*.h src/osdep/unix/*.h c-client/auths.c c-client/linkage.c c-client/linkage.h c-client/osdep.h"

do_compile() {
	echo "SSLINCLUDE=${STAGING_INCDIR}/openssl SSLLIB=${STAGING_LIBDIR}" > ${S}/SPECIALS
	oe_runmake lnp
}

do_install() {
        install -d ${D}${includedir}/c-client
        install ${HEADERS} ${D}${includedir}/c-client
	install -d ${D}${libdir}
        install c-client/c-client.a ${D}${libdir}/libc-client.a
}

