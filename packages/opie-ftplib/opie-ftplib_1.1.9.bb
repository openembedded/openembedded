DESCRIPTION = "Opie FTP Library"
SECTION = "opie/libs"
MAINTAINER = "Team Opie <opie@handhelds.org>"
PRIORITY = "optional"
LICENSE = "GPL"
PROVIDES = "libftplib1 opie-ftplib"
I18N_FILES = "libftplib.ts"

APPNAME = "opie-ftplib"

PR="r1"


SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/noncore/net/ftplib"
S = "${WORKDIR}/ftplib"

inherit palmtop



EXTRA_QMAKEVARS_POST = "DESTDIR=${S}"

do_stage () {
	install -m 0664 ${S}/ftplib.h ${STAGING_INCDIR}/
	oe_libinstall -so libftplib ${STAGING_LIBDIR}
}

do_install() {
	oe_libinstall -so libftplib ${D}/${palmtopdir}/lib
}
