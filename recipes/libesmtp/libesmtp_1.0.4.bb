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

FILES_libesmtp_append = " ${libdir}/esmtp-plugins/*.so"
FILES_${PN}-dbg += "${libdir}/esmtp-plugins/.debug/"

SRC_URI[md5sum] = "8b4e8a794adc46268f0c6a0b3fb79486"
SRC_URI[sha256sum] = "407ec85a4c3ce2c4045608d28c36a8e19f1cfbad02bf3de784f6b6fa83d15a56"
