DESCRIPTION="The Asterisk open source software PBX"
HOMEPAGE="http://www.asterisk.org"
SECTION = "voip"
LICENSE="GPL"
#DEPENDS="asterisk"
PR = "r1"

SRC_URI="http://downloads.digium.com/pub/telephony/sounds/releases/asterisk-extra-sounds-en-alaw-${PV}.tar.gz"

do_install() {
	install -d ${D}${localstatedir}/lib/asterisk/sounds
	# HACK: moving the files in chunkes (too many of them)
	mv ${WORKDIR}/[a-d]*.alaw ${D}${localstatedir}/lib/asterisk/sounds/
	mv ${WORKDIR}/[e-l]*.alaw ${D}${localstatedir}/lib/asterisk/sounds/
	mv ${WORKDIR}/*.alaw ${D}${localstatedir}/lib/asterisk/sounds/
	#install -m 644 ${WORKDIR}/*.alaw ${D}${localstatedir}/lib/asterisk/sounds/

	#install -d ${D}${localstatedir}/lib/asterisk/sounds/ha
	#install -m 644 ${WORKDIR}/ha/* ${D}${localstatedir}/lib/asterisk/sounds/ha/
	mv ${WORKDIR}/ha ${D}${localstatedir}/lib/asterisk/sounds

	#install -d ${D}${localstatedir}/lib/asterisk/sounds/wx
	#install -m 644 ${WORKDIR}/wx/* ${D}${localstatedir}/lib/asterisk/sounds/wx/
	mv ${WORKDIR}/wx ${D}${localstatedir}/lib/asterisk/sounds
}

pkg_postinst_prepend() {
	chown -R asterisk:asterisk ${localstatedir}/lib/asterisk/sounds/
}



SRC_URI[md5sum] = "ecc50bd2b9b29d8237911272248c5d35"
SRC_URI[sha256sum] = "61ff59c7d1a180fbcbec2cf14965ad405fb10d90fc26310848a580bd99a1cf18"
