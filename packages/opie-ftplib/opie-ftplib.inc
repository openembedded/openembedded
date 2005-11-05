DESCRIPTION = "Opie FTP Library"
SECTION = "opie/libs"
MAINTAINER = "Team Opie <opie@handhelds.org>"
PRIORITY = "optional"
LICENSE = "GPL"
PROVIDES = "libftplib1"
I18N_FILES = "libftplib.ts"
APPNAME = "opie-ftplib"

S = "${WORKDIR}/ftplib"

inherit opie

do_stage () {
	install -m 0664 ${S}/ftplib.h ${STAGING_INCDIR}/
	oe_libinstall -so libftplib ${STAGING_LIBDIR}
}

do_install() {
	oe_libinstall -so libftplib ${D}${palmtopdir}/lib
}
