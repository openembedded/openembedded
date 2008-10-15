DESCRIPTION="The Asterisk open source software PBX"
HOMEPAGE="http://www.asterisk.org"
SECTION = "voip"
LICENSE="GPL"
#DEPENDS="asterisk"
PR = "r1"

SRC_URI="http://downloads.digium.com/pub/telephony/sounds/releases/asterisk-extra-sounds-en-gsm-${PV}.tar.gz"

do_install() {
	install -d ${D}${localstatedir}/lib/asterisk/sounds
	# HACK: moving the files in chunks (too many files)
	mv ${WORKDIR}/[a-d]*.gsm ${D}${localstatedir}/lib/asterisk/sounds/
	mv ${WORKDIR}/[e-l]*.gsm ${D}${localstatedir}/lib/asterisk/sounds/
	mv ${WORKDIR}/*.gsm ${D}${localstatedir}/lib/asterisk/sounds/
	#install -m 644 ${WORKDIR}/*.gsm ${D}${localstatedir}/lib/asterisk/sounds/

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


