DESCRIPTION = "Qt-based class wrapper of libetpan"
SECTION = "opie/libs"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "LGPL"
DEPENDS = "libetpan"

S = "${WORKDIR}/libmailwrapper"

inherit opie

do_stage () {
	install -d ${STAGING_INCDIR}/libmailwrapper/
	install -m 0664 ${S}/maildefines.h ${STAGING_INCDIR}/libmailwrapper/
	install -m 0664 ${S}/settings.h ${STAGING_INCDIR}/libmailwrapper/
	install -m 0664 ${S}/statusmail.h ${STAGING_INCDIR}/libmailwrapper/
	install -m 0664 ${S}/abstractmail.h ${STAGING_INCDIR}/libmailwrapper/
	install -m 0664 ${S}/mailtypes.h ${STAGING_INCDIR}/libmailwrapper/
	oe_libinstall -so libmailwrapper ${STAGING_LIBDIR}
}

do_install() {
	oe_libinstall -so libmailwrapper ${D}${palmtopdir}/lib
}
