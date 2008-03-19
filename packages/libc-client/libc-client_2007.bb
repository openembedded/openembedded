DESCRIPTION = "UW c-client library for mail protocols"
SECTION = "devel"
PRIORITY = "optional"
LICENSE = "University of Washington's Free-Fork License"
DEPENDS = "libpam openssl"
PR = "r1"

SRC_URI = "ftp://ftp.cac.washington.edu/imap/c-client.tar.Z \
	   file://quote_cctype.patch;patch=1"

S = "${WORKDIR}/imap-2007"

EXTRA_OEMAKE = "CC='${CC}'"

HEADERS = "src/c-client/*.h src/osdep/unix/*.h c-client/auths.c c-client/linkage.c c-client/linkage.h c-client/osdep.h"

do_compile() {
	echo "SSLINCLUDE=${STAGING_INCDIR}/openssl SSLLIB=${STAGING_LIBDIR}" > ${S}/SPECIALS
	oe_runmake lnp
}

do_stage() {
	install -d ${STAGING_INCDIR}/c-client
	install ${HEADERS} ${STAGING_INCDIR}/c-client
	install c-client/c-client.a ${STAGING_LIBDIR}/libc-client.a
}

