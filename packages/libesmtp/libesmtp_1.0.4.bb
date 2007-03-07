DESCRIPTION = "LibESMTP is a library to manage posting \
(or submission of) electronic mail using SMTP to a \
preconfigured Mail Transport Agent (MTA) such as Exim or PostFix."
LICENSE = "GPL"
SECTION = "libs/network"
DEPENDS = "openssl"
PR = "r2"

SRC_URI = "http://www.stafford.uklinux.net/libesmtp/libesmtp-${PV}.tar.bz2"

inherit autotools binconfig

EXTRA_OECONF = "--disable-isoc --with-openssl=${STAGING_LIBDIR}/.."

do_stage() {
	autotools_stage_all
}

FILES_libesmtp_append = " ${libdir}/esmtp-plugins"
FILES_${PN}-dbg += "${libdir}/esmtp-plugins/.debug/"
