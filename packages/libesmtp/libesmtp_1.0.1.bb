SECTION = "libs"
DEPENDS = "openssl"
DESCRIPTION = "LibESMTP is a library to manage posting \
(or submission of) electronic mail using SMTP to a \
preconfigured Mail Transport Agent (MTA) such as Exim."
FILES_libesmtp_append = " ${libdir}/esmtp-plugins"

SRC_URI = "http://www.stafford.uklinux.net/libesmtp/libesmtp-${PV}.tar.bz2  \
           file://configure.patch;patch=1"
LICENSE = "LGPL GPL"
inherit autotools 

EXTRA_OECONF = "--disable-isoc --with-openssl=${STAGING_LIBDIR}/.."

do_stage () {
	oe_libinstall -a -so libesmtp ${STAGING_LIBDIR}

        install -d ${STAGING_INCDIR}
	install -m 644 auth-client.h ${STAGING_INCDIR}
	install -m 644 auth-plugin.h ${STAGING_INCDIR}
	install -m 644 libesmtp.h ${STAGING_INCDIR}
}
